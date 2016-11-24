package com.taotao.controller;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.service.ContentCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ibm on 2016/11/16.
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {
    public static void main(String[] args) {
        System.out.println(ContentCategoryController.class.getResource("classpath:resource/client.conf"));
    }
    @Resource
    private ContentCategoryService contentCategoryService;
    @RequestMapping("/list")
    @ResponseBody
    public List<EUTreeNode> list(@RequestParam(defaultValue = "0") long id) {
        return contentCategoryService.list(id);
    }
}
