package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

/**
 * Created by ibm on 2016/10/31.
 */
public interface ItemService {
    TbItem getItemById(Long id);

    EUDataGridResult getItemList(Integer page, Integer rows);


    TaotaoResult createItem(TbItem item, String desc, String itemParams);
}
