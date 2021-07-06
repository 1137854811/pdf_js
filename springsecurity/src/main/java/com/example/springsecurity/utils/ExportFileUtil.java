package com.example.springsecurity.utils;

import cn.hutool.log.StaticLog;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
/**
 * @author tianzhuang
 * @version 1.0
 * @date 2021/7/3 18:43
 */
public class ExportFileUtil {

    /**
     * 文件下载
     * @param response
     * @param filePath
     */
    public static void download(HttpServletResponse response, String filePath) {
        ServletOutputStream out;
        BufferedInputStream buf;
        try {
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName=" + filePath.substring(filePath.lastIndexOf("/") + 1));
            URL url = new URL(filePath);
            //使用输入读取缓冲流读取一个文件输入流
            buf = new BufferedInputStream(url.openStream());
            //利用response获取一个字节流输出对象
            out = response.getOutputStream();
            //定义个数组，由于读取缓冲流中的内容
            byte[] buffer = new byte[1024];
            int n;
            //while循环一直读取缓冲流中的内容到输出的对象中
            while ((n = buf.read(buffer)) != -1) {
                out.write(buffer, 0, n);
            }
            //写出到请求的地方
            out.flush();
            buf.close();
            out.close();
        } catch (IOException e) {
            StaticLog.error("ExportFileUtil.download() IOException", e);
        } catch (Exception e) {
            StaticLog.error("Exception", e);
        }
    }


    /**
     * 文件预览
     * @param response
     * @param filePath
     */
    public static void preview(HttpServletResponse response, String filePath) {
        ServletOutputStream out;
        BufferedInputStream buf;
        try {
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "inline;fileName=" + filePath.substring(filePath.lastIndexOf("/") + 1));
            URL url = new URL(filePath);
            //使用输入读取缓冲流读取一个文件输入流
            buf = new BufferedInputStream(url.openStream());
            //利用response获取一个字节流输出对象
            out = response.getOutputStream();
            //定义个数组，由于读取缓冲流中的内容
            byte[] buffer = new byte[1024];
            int n;
            //while循环一直读取缓冲流中的内容到输出的对象中
            while ((n = buf.read(buffer)) != -1) {
                out.write(buffer, 0, n);
            }
            //写出到请求的地方
            out.flush();
            buf.close();
            out.close();
        } catch (IOException e) {
            StaticLog.error("ExportFileUtil.download() IOException", e);
        } catch (Exception e) {
            StaticLog.error("Exception", e);
        }
    }


}
