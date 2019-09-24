package com.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@WebServlet("/upload_Servlet")
public class Upload_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //普通的参数使用request
        //要使用第三方工具解析文件
        /*try {
            upload_toLocal(request,response);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }*/

        try {
            upload_toService(request,response);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    public void upload_toLocal(HttpServletRequest request, HttpServletResponse response) throws FileUploadException, IOException {
        request.setCharacterEncoding("utf-8");
        //1.获取磁盘的工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2.
        ServletFileUpload upload = new ServletFileUpload(factory);
        //3.
        List<FileItem> list = upload.parseRequest(request);
        //4.
        for (FileItem fitem:list){
            System.out.println(fitem);
            //5.根据isFormField判断是否是上传的文件，是文件isFormField为false
            if (!fitem.isFormField()){
                //6.
                InputStream inputStream = fitem.getInputStream();
                //7.设置上传路径
                String uploadPath = "E:\\feiQdown\\"+fitem.getName();
                //8.创建一个输出流
                FileOutputStream outputStream = new FileOutputStream(uploadPath);
                //9.输入流到输出流
                //
                byte[] buff = new byte[1024];
                int length = 0;
                while ((length=inputStream.read(buff))!=-1){
                    outputStream.write(buff,0,length);
                    //outputStream.write(buff.length);???
                }
                outputStream.close();
                inputStream.close();
            }
        }
    }

    public void upload_toService(HttpServletRequest request, HttpServletResponse response) throws FileUploadException, IOException {
        //设置请求的编码方式，解决上传的文件名乱码问题
        request.setCharacterEncoding("utf-8");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> list = upload.parseRequest(request);
        for (FileItem fitem:list){
            if (!fitem.isFormField()){
                InputStream inputStream = fitem.getInputStream();
                ServletContext servletContextPath = request.getServletContext();
                //文件夹uploadFiles
                String uploadPath = servletContextPath.getRealPath("/uploadFiles");
                System.out.println(uploadPath);
                File file = new File(uploadPath);
                //如果目录不存在，要创建目录
                if (!file.exists()){
                    file.mkdir();//创建目录
                }
                //解决重名问题
                UUID uuid = UUID.randomUUID();
                System.out.println("uuid"+uuid);
                String fileName = uuid.toString()+"_"+fitem.getName();
                //不是file.getName();  file.getName()=uploadFiles
                //fitem.getName();获取文件的名称和后缀

                String filePath = uploadPath+File.separator+fileName;
                //String filePath = uploadPath+File.separator+fileName;
                //或
                //String filePath = uploadPath+"\\"+fileName;
                //创建输出流
                FileOutputStream outputStream = new FileOutputStream(filePath);
                //设置缓冲区
                /**
                 * public int write(byte [] b) throws IOException
                 * write(byte[] b)和 write(b,0,b.length)有完全相同的效果
                 * 所以具体的看write(byte [] b ,int off , int len)方法

                 * public int write(byte[] b,int off,int len) throws IOException
                 * 将字节数组b中的第off+1个元素开始的len个数据。顺序的写入此输出流中
                 * write()方法所写的数据并没有直接传到输出流相连中的外设上,而是先暂时的存放在流的缓冲区中,
                 * 等到缓冲区的数据积累到一定数量，再执行一次向外设的写操作把它们全部写到外设上
                * */
                /*byte[] buff = new byte[1024];
                int length = 0;
                while ((length=inputStream.read(buff))!=-1){
                    outputStream.write(buff,0,length);
                }*/
                //可以使用org.apache.commons.io.IOUtils下的copy静态方法
                IOUtils.copy(inputStream,outputStream);
                outputStream.close();
                inputStream.close();
            }
        }
    }
}


