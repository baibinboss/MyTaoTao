package com.taotao.service;

import com.taotao.common.pojo.EUTreeNode;

import java.util.List;

/**
 * Created by ibm on 2016/11/16.
 */
public interface ContentCategoryService {
    List<EUTreeNode> list(long id);
}
