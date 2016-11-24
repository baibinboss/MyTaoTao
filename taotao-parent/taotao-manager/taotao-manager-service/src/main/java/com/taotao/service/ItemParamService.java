package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;

/**
 * Created by ibm on 2016/11/22.
 */
public interface ItemParamService {
    public EUDataGridResult list(Integer page, Integer rows);

    TaotaoResult getByItemCatId(Integer id);

    TaotaoResult save(TbItemParam param);
}
