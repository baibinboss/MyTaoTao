package com.taotao.service.impl;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.service.ContentCategoryService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibm on 2016/11/16.
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    private Logger logger = Logger.getLogger(ContentCategoryServiceImpl.class);
    @Resource
    private TbContentCategoryMapper tbContentCategoryMapper;

    @Override
    public List<EUTreeNode> list(long id) {
        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(id);
        criteria.andStatusEqualTo(1);
        List<TbContentCategory> dataList =  tbContentCategoryMapper.selectByExample(example);
        List<EUTreeNode> nodes = new ArrayList<EUTreeNode>();
        for (TbContentCategory category : dataList) {
            EUTreeNode node = new EUTreeNode();
            node.setId(category.getId());
            node.setText(category.getName());
            if (category.getIsParent()) {
                node.setState("closed");
            }else {
                node.setState("open");
            }
            nodes.add(node);
        }
        return nodes;
    }
}
