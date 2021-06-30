package com.jhh.web.servletContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;


@WebServlet("/contextDemo2")
public class ServletContextDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取ServletContext对象
        ServletContext servletContext = this.getServletContext();
        //访问web目录下的b.txt
        String pathb = servletContext.getRealPath("/b.txt");
        String pathc = servletContext.getRealPath("/WEB-INF/c.txt");
        String patha = servletContext.getRealPath("/WEB-INF/classes/a.txt");
        //存在乱码
//        BufferedReader fr = new BufferedReader(new FileReader(pathc));
        // 转换流解决乱码，可以指定charset
        BufferedReader fr = new BufferedReader(new InputStreamReader(new FileInputStream(pathc), StandardCharsets.UTF_8));
        String data;
        System.out.println(pathc);
        while((data = fr.readLine())!=null){
            System.out.println(data);
        }
        fr.close();
        System.out.println(patha);
        fr = new BufferedReader(new InputStreamReader(new FileInputStream(patha), StandardCharsets.UTF_8));
        while((data = fr.readLine())!=null){
            System.out.println(data);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
