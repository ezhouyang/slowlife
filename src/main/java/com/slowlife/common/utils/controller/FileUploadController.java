/**
 * slowlife.mobi.
 * Copyright (c) 2013 All Rights Reserved.
 */
package com.slowlife.common.utils.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.flyaway.common.utils.ExcelOperationUtils;
import com.flyaway.core.domain.SubCategoryModel;

/**
 * 
 *  文件上传
 * 
 * @author 156768892@qq.com
 * @version $Id: FileUploadController.java, v 0.1 2013年9月19日 下午3:43:53 eZhouyang Exp $
 */
@Controller
@RequestMapping("/upload")
public class FileUploadController {

    @RequestMapping(method = RequestMethod.GET)
    public String provideUploadInfo() {
        return "upload";
    }

    //    @RequestMapping(method = RequestMethod.POST)
    //    public @ResponseBody
    //    String handleFileUpload(@RequestParam("name") String name,
    //                            @RequestParam("file") MultipartFile file) {
    //        if (!file.isEmpty()) {
    //            try {
    //                byte[] bytes = file.getBytes();
    //                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
    //                    new File(name + "-uploaded")));
    //                stream.write(bytes);
    //                stream.close();
    //                return "You successfully uploaded " + name + " into " + name + "-uploaded !";
    //            } catch (Exception e) {
    //                return "You failed to upload " + name + " => " + e.getMessage();
    //            }
    //        } else {
    //            return "You failed to upload " + name + " because the file was empty.";
    //        }
    //    }

    @ModelAttribute
    public void ajaxAttribute(WebRequest request, Model model) {
        model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
    }

    //    @RequestMapping(method = RequestMethod.GET)
    //    public void fileUploadForm() {
    //    }

    @RequestMapping(method = RequestMethod.POST)
    public String processUpload(@RequestParam MultipartFile file, Model model,
                                RedirectAttributes redirectAttrs) throws IOException {
        model.addAttribute("message", "File '" + file.getOriginalFilename()
                                      + "' uploaded successfully");
        file.transferTo(new File("/Users/ocean/Documents/" + file.getOriginalFilename()));
        // 临时
        SubCategoryModel subCategoryModel = ExcelOperationUtils.readXls("/Users/ocean/Documents/"
                                                                        + file
                                                                            .getOriginalFilename());
        model.addAttribute("dates", subCategoryModel.getDates());
        model.addAttribute("sales", subCategoryModel.getSales());
        model.addAttribute("assigns", subCategoryModel.getAssigns());

        return "redirect:/flyawaydata";
    }
}
