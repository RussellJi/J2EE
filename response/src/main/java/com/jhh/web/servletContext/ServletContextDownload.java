package com.jhh.web.servletContext;

import com.jhh.web.utils.DownLoadUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/download")
public class ServletContextDownload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // 获取文件的真实路径
        String img = this.getServletContext().getRealPath("/resource/排球.png");
        String text = this.getServletContext().getRealPath("/resource/1.txt");
        String fileName = req.getParameter("filename");
        //通过context对象获取文件的mime类型
        String mimeType = this.getServletContext().getMimeType(fileName);
        ServletOutputStream oos = resp.getOutputStream();
        FileInputStream fis;
        byte[] bytes = new byte[1024];
        int len = 0;
        switch(mimeType){
            case "image/png":
                System.out.println("图片");

                fis = new FileInputStream(new File(img));
                resp.setContentType(mimeType);
                String userAgent = req.getHeader("User-Agent");
                fileName = DownLoadUtils.getFileName(userAgent,fileName);
                resp.setHeader("content-disposition","attachment;filename="+fileName);
                //将文件加载进内存并输出
                while((len = fis.read(bytes))!=-1){
                    oos.write(bytes,0,len);
                }
                fis.close();
                break;
            case "text/plain":
                System.out.println("文件");
                fis = new FileInputStream(new File(text));
                resp.setContentType(mimeType);
                resp.setHeader("content-disposition","attachment;filename="+fileName);
                while((len = fis.read(bytes))!=-1){
                    oos.write(bytes,0,len);
                }
                fis.close();
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doGet(req, resp);
    }
}
