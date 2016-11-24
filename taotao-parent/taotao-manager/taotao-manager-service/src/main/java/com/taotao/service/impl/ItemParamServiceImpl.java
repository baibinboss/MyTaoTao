package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ibm on 2016/11/22.
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {
    @Autowired
    private TbItemParamMapper tbItemParamMapper;

    @Override
    public TaotaoResult getByItemCatId(Integer id) {
        TbItemParamExample example = new TbItemParamExample();
        TbItemParamExample.Criteria criteria =  example.createCriteria();
        criteria.andItemCatIdEqualTo(Long.valueOf(id));
        List<TbItemParam> itemParams = tbItemParamMapper.selectByExampleWithBLOBs(example);
        if (itemParams != null && itemParams.size() > 0) {
            return TaotaoResult.ok(itemParams.get(0));
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult save(TbItemParam param) {
        tbItemParamMapper.insert(param);
        return new TaotaoResult(null);
    }

    @Override
    public EUDataGridResult list(Integer page, Integer rows) {
        TbItemParamExample example = new TbItemParamExample();
        PageHelper.startPage(page, rows);
        List<TbItemParam> resultList = tbItemParamMapper.selectByExampleWithBLOBsAndCatName(example);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(resultList);
        PageInfo<TbItemParam> paramPageInfo = new PageInfo<TbItemParam>(resultList);
        result.setTotal(paramPageInfo.getTotal());
        return result;
    }
}
