package com.ritchey.edusys.core.util;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

/**
 * @author Ritchey Huang
 * @version 1.0
 * @date 2017/4/18
 */
public class FtpUtils {
    private static Log log = LogFactory.getLog(FtpUtils.class);

    public static final String  FTPHOST = "192.168.0.49";

    public static final Integer PORT = 21;

    public static final String USERNAME = "ftpuser";

    public static final String PASSWORD = "root1234";

    public  FTPClient ftpClient = null;

    /**
     * 登录并初始化 FTPClient
     */
    public boolean loginFtpCilent(){
        ftpClient = new FTPClient();
        ftpClient.setControlEncoding("utf-8");
        // 划重点 主动模式 与被动模式
        //主动模式:就是指C(client)连接S(Server)的时候，告诉S，要进行通讯，数据交换。C申请开辟一个端口，专门用于两者的通信，
        //也即C端主动向S端发起的请求。
        //被动模式就是指，一开始服务一起来，S端变开启一个端口告诉C端，我们之间的通讯就在这个端口下。也就C端被动的接受S端。
        //开启被动模式
        ftpClient.enterLocalPassiveMode();
        try{
            log.info("Begin connect ftp server:"+FTPHOST);
            ftpClient.connect(FTPHOST,PORT.intValue());
            ftpClient.login(USERNAME,PASSWORD);
            int replyed = ftpClient.getReplyCode();
            if(!FTPReply.isPositiveCompletion(replyed)){
                log.error("Connect ftp server:"+FTPHOST+" Failed");
                return false;
            }else {
                log.info("Connect ftp server:"+FTPHOST+" Success");
                return true;
            }

        }catch (MalformedURLException e){
            e.printStackTrace();
            return false;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * ftpCilent 登出
     * @return
     */
    public boolean logoutFtpCilent(){
        try {
            int replyed = ftpClient.getReplyCode();
            if(!FTPReply.isPositiveCompletion(replyed)){
                return true;
            }else {
                //登出
                ftpClient.logout();
                //断开连接
                ftpClient.disconnect();
                return true;
            }
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * ftp w文件上传
     * @param remotePath 上传到ftp的文件路径
     * @param filename 上传到ftp 的文件名
     * @param inputStream 流
     * @return
     */
    public boolean uploadFtp(String remotePath, String filename, InputStream inputStream){
        boolean isFlag = false;
        if(filename==null || "".equals(filename)){
            return isFlag;
        }
        try{
            //设置 二进制流的文件传输方式
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            //获取成文件名以外的文件路径
            remotePath = remotePath.substring(0,remotePath.lastIndexOf(filename));
            if (remotePath != null && !"".equals(remotePath.trim())){
                //将文件目录切割,在ftp上创建文件目录
                String[] pathes = remotePath.split("/");

                for (String onePath:pathes){
                    if (onePath == null || "".equals(onePath.trim())){
                        continue;
                    }
                    //改变ftp的服务器目录  如果目录不存在 则创建
                    if (!ftpClient.changeWorkingDirectory(onePath)){
                        //如果不存在 则创建服务器目录
                        ftpClient.makeDirectory(onePath);
                        //改变ftp 服务器目录
                        ftpClient.changeWorkingDirectory(onePath);
                    }
                }
            }
            isFlag = ftpClient.storeFile(filename,inputStream);
        }catch(IOException e){
            e.printStackTrace();
        }
        return isFlag;
    }

    public InputStream downLoad(String remotePath,String filename){
        FTPFile[]  files = null;
        InputStream is = null;
        try{
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            //获取成文件名以外的文件路径
            remotePath = remotePath.substring(0,remotePath.lastIndexOf(filename));
            files = ftpClient.listFiles(remotePath);
            for (FTPFile file:files){
                //查找目标文件
                if (file.getName().equals(filename)){
                    is = ftpClient.retrieveFileStream(new String((remotePath+filename).getBytes("utf-8"),"iso-8859-1"));
                    //跳出循环
                    break;
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return is;
    }

    public boolean deleleFile(String remotePath){
        boolean isFlag = false;
        try{
            isFlag = ftpClient.deleteFile(remotePath);

        }catch (IOException e){
            e.printStackTrace();
        }

        return isFlag;
    }

    public static void main(String[] args){
        FtpUtils ftpUtils = new FtpUtils();
        ftpUtils.loginFtpCilent();
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\11.png");
            ftpUtils.uploadFtp("11.png","11.png",fileInputStream);
        }catch (IOException e){

        }


    }
}
