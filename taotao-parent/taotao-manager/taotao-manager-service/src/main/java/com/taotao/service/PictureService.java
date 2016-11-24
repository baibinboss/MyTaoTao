package com.taotao.service;

import com.taotao.common.pojo.PictureResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ibm on 2016/11/17.
 */
public interface PictureService {
    PictureResult uploadPic(MultipartFile multipartFile);
}
