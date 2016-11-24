package com.taotao.controller;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by ibm on 2016/11/22.
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {
    @Autowired
    private ItemParamService itemParamService;
    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult list(Integer page, Integer rows) {
        return itemParamService.list(page,rows);
    }
    //
    @RequestMapping("/query/itemcatid/{id}")
    @ResponseBody
    public TaotaoResult getByItemCatId(@PathVariable Integer id) {
        return itemParamService.getByItemCatId(id);
    }
    @RequestMapping("/save/{id}")
    @ResponseBody
    public TaotaoResult save(@PathVariable Long id,String paramData) {
        TbItemParam param = new TbItemParam();
        Date date = new Date();
        param.setItemCatId(id);
        param.setParamData(paramData);
        param.setCreated(date);
        param.setUpdated(date);
        return itemParamService.save(param);
    }


}
