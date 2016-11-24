package com.taotao.service;

import com.taotao.common.pojo.EUTreeNode;

import java.util.List;

/**
 * Created by ibm on 2016/10/31.
 */
public interface ItemCatService {
    List<EUTreeNode> getTreeList(Long parentId);
}
