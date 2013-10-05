/**
 * slowlife.mobi.
 * Copyright (c) 2013 All Rights Reserved.
 */
package com.slowlife.common.utils.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flyaway.common.utils.ExcelOperationUtils;
import com.flyaway.core.domain.SubCategoryModel;

/**
 *  数据控制器
 * 
 * @author 156768892@qq.com
 * @version $Id: FlyawayDataController.java, v 0.1 2013年10月3日 下午10:38:23 eZhouyang Exp $
 */
@Controller
@RequestMapping("/flyawaydata")
public class FlyawayDataController {

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(HttpServletRequest req, HttpServletResponse resp, Model model) {

        // 临时
        SubCategoryModel subCategoryModel = ExcelOperationUtils
            .readXls("/Users/ocean/Documents/new行业成交表.xlsx");
        model.addAttribute("dates", subCategoryModel.getDates());
        model.addAttribute("sales", subCategoryModel.getSales());
        model.addAttribute("assigns", subCategoryModel.getAssigns());
        return "flyaway";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpServletRequest req, HttpServletResponse resp, Model model) {
        // 临时
        SubCategoryModel subCategoryModel = ExcelOperationUtils
            .readXls("/Users/ocean/Documents/new行业成交表.xlsx");
        model.addAttribute("dates", subCategoryModel.getDates());
        model.addAttribute("sales", subCategoryModel.getSales());
        model.addAttribute("assigns", subCategoryModel.getAssigns());
        return "flyaway";
    }

}
