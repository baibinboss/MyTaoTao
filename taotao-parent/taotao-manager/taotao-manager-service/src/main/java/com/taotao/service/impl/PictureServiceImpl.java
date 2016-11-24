package com.taotao.service.impl;

import com.taotao.common.pojo.FastDFSClient;
import com.taotao.common.pojo.PictureResult;
import com.taotao.service.PictureService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ibm on 2016/11/17.
 */
@Service
public class PictureServiceImpl implements PictureService {
    @Value(value = "${PIC_SERVER_IP}")
    private String PIC_SERVER_IP;
    private Logger logger = Logger.getLogger(PictureServiceImpl.class);

    @Override
    public PictureResult uploadPic(MultipartFile picFile) {
        PictureResult result = new PictureResult();
        //判断图片是否为空
        if (picFile.isEmpty()) {
            result.setError(1);
            result.setMessage("图片为空");
            return result;
        }
        //上传到图片服务器
        try {
            //取图片扩展名
            String originalFilename = picFile.getOriginalFilename();
            //取扩展名不要“.”
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            FastDFSClient client = new FastDFSClient("resource/client.conf");
            String url = client.uploadFile(picFile.getBytes(), extName);
            //把url响应给客户端
            result.setError(0);
            result.setUrl(PIC_SERVER_IP + url);
        } catch (Exception e) {
            logger.error(e);
            result.setError(1);
            result.setMessage("图片上传失败");
        }
        return result;

    }
}
