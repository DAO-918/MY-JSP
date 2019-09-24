package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/download_Servlet")
public class Download_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.根据参数获取文件名
        String fileName = request.getParameter("filename");
        //2.获取文件所在的真实路径
        String path = request.getServletContext().getRealPath("/img/" + fileName);
        System.out.println(path);
        //3.获取文件输入流
        FileInputStream inputStream = new FileInputStream(path);

        //解决乱码问题
        String userAgent = request.getHeader("user-agent");
        String fileName_new = DownLoadUtils.getFileName(userAgent,fileName);
        System.out.println("fileName_new:"+fileName_new);

        //4.设置响应头资源的打开方式
        //response.setHeader("content-disposition","attachment;filename"+fileName_new);
        //少了等于号 "=" 导致下载的文件名一直是download_Servlet (2)/注意中间有一个空格
        response.setHeader("content-disposition","attachment;filename="+fileName_new);
        //5.获取输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //6.从输入流拷贝到输出流
        byte[] buff = new byte[1024];//一个字节
        int length = 0;
        while ((length=inputStream.read(buff))!=-1){
            outputStream.write(buff,0,length);
        }
        outputStream.close();
        inputStream.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
