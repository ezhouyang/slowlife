/**
 * slowlife.mobi.
 * Copyright (c) 2013 All Rights Reserved.
 */
package com.flyaway.core.domain;

/**
 * 
 * @author 156768892@qq.com
 * @version $Id: ExcelBaseDo.java, v 0.1 2013年10月4日 上午10:55:12 eZhouyang Exp $
 */
public class ExcelBaseDo {

    /** 单元格 */
    private int      cellNum;

    /** 数据 */
    private Object[] datas;

    public int getCellNum() {
        return cellNum;
    }

    public void setCellNum(int cellNum) {
        this.cellNum = cellNum;
    }

    public Object[] getDatas() {
        return datas;
    }

    public void setDatas(Object[] datas) {
        this.datas = datas;
    }

}
