package com.taotao.common.pojo;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.Loader;
import org.csource.fastdfs.*;

/**
 * Created by ibm on 2016/11/17.
 */
public class FastDFSClient {
    private Logger logger = Logger.getLogger(FastDFSClient.class);
    private TrackerClient trackerClient = null;
    private TrackerServer trackerServer = null;
    private StorageServer storageServer = null;
    //使用StorageClient1进行上传
    private StorageClient1 storageClient1 = null;

    public static void main(String[] args) {
        System.out.println(FastDFSClient.class.getResource("/").getFile());
    }

    public FastDFSClient(String conf) throws Exception {
        //获取classpath路径下配置文件"fdfs_client.conf"的路径
        //conf直接写相对于classpath的位置，不需要写classpath:
        ClientGlobal.init(Loader.getResource(conf).getFile());
        trackerClient = new TrackerClient();
        trackerServer = trackerClient.getConnection();
        storageServer = trackerClient.getStoreStorage(trackerServer);
        storageClient1 = new StorageClient1(trackerServer, storageServer);
    }

    public String uploadFile(byte[] file_buff, String file_ext_name) throws Exception {
        String result = storageClient1.upload_file1(file_buff, file_ext_name, null);
        return result;
    }

    public String uploadFile(String local_filename, String file_ext_name) throws Exception {
        String result = storageClient1.upload_file1(local_filename, file_ext_name, null);
        return result;
    }
}
