package com.taotao.common;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by ibm on 2016/11/1.
 */
public class FtpTest {
    public static void main(String[] args) throws Exception {
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect("192.168.25.200");
        ftpClient.login("ftpuser", "ftpuser");
        FileInputStream inputStream = new FileInputStream(new File("D:\\Documents\\Pictures\\pics\\21.jpg"));
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        ftpClient.storeFile("123.jpg", inputStream);
        inputStream.close();
        ftpClient.logout();
    }

}
