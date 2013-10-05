/**
 * slowlife.mobi.
 * Copyright (c) 2013 All Rights Reserved.
 */
package com.flyaway.common.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.alibaba.fastjson.JSONObject;
import com.flyaway.core.domain.SubCategoryModel;

/**
 *  excel操作服务
 * 
 * @author 156768892@qq.com
 * @version $Id: ExcelOperationService.java, v 0.1 2013年10月4日 上午10:16:23 eZhouyang Exp $
 */
public class ExcelOperationUtils {

    //    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelOperationUtils.class);

    public static SubCategoryModel readXls(String filePath) {

        SubCategoryModel subCategoryModel = new SubCategoryModel();

        try {

            InputStream inputStream = new FileInputStream(filePath);

            Workbook workbook = new XSSFWorkbook(inputStream);

            //            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);

            // 循环工作表Sheet
            for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {

                Sheet sheet = workbook.getSheetAt(numSheet);

                if (null == sheet) {
                    continue;
                }

                // 销售量
                List<Double> saleNums = new ArrayList<Double>();

                // 分配量
                List<Double> assignNums = new ArrayList<Double>();

                // 日期
                List<String> dateNums = new ArrayList<String>();

                // 循环行Row
                for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {

                    Row row = sheet.getRow(rowNum);

                    if (null == row) {
                        continue;
                    }

                    if (rowNum == 0) {
                        // TODO 暂时放过
                        continue;
                    }

                    Cell dateCell = row.getCell(0);
                    if (null == dateCell) {

                    } else {
                        dateNums.add(getValue(dateCell));
                    }

                    // 销售
                    Cell saleCell = row.getCell(1);

                    if (null == saleCell) {

                    } else {
                        saleNums.add(saleCell.getNumericCellValue());
                    }

                    // 分配
                    Cell assignCell = row.getCell(2);

                    if (null == assignCell) {

                    } else {
                        assignNums.add(assignCell.getNumericCellValue());
                    }

                }

                subCategoryModel.setAssigns(JSONObject.toJSONString(assignNums));
                subCategoryModel.setSales(JSONObject.toJSONString(saleNums));
                subCategoryModel.setDates(JSONObject.toJSONString(dateNums));

            }

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (Exception e) {

        }

        //        if (LOGGER.isInfoEnabled()) {
        //            LOGGER.info("子行业走势模型：" + ToStringBuilder.reflectionToString(subCategoryModel));
        //        }

        return subCategoryModel;
    }

    /**
     *  
     * 
     * @param cell
     * @return
     */
    private static String getValue(Cell cell) {

        if (cell.getCellType() == cell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
            if (HSSFDateUtil.isCellDateFormatted(cell)) { //判断是日期类型
                SimpleDateFormat dateformat = new SimpleDateFormat("yy/MM");
                Date dt = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());//获取成DATE类型   
                return dateformat.format(dt);
            }
            // 返回数值类型的值
            return String.valueOf(cell.getNumericCellValue());
        } else {
            // 返回字符串类型的值
            return String.valueOf(cell.getStringCellValue());
        }
    }

    public static void main(String[] args) {
        readXls("/Users/ocean/Downloads/new行业成交表.xlsx");

        List<Double> dats = new ArrayList<Double>();
        dats.add(12121.0);
        System.out.println(JSONObject.toJSONString(dats));
    }
}
