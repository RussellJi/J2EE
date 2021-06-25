import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;


@WebServlet("/demo")
public class HttpServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("get:");

        // 获取请求方式
        System.out.println("请求方式："+req.getMethod());
        // 获取虚拟路径
        System.out.println("虚拟路径："+req.getContextPath());
        //获取Servlet路径
        System.out.println("Servlet路径："+req.getServletPath());
        //获取get方式请求参数
        System.out.println("请求参数："+req.getQueryString());
        // 获取URI
        System.out.println("URI："+req.getRequestURI());
        // 获取URL
        System.out.println("URL："+req.getRequestURL());
        // 获取协议版本
        System.out.println("协议版本："+req.getProtocol());
        // 获取客户机的IP地址
        System.out.println("客户机IP地址："+req.getRemoteAddr());
        Enumeration<String> enumeration = req.getHeaderNames();
        Iterator it = enumeration.asIterator();
//        while(it.hasNext()){
//            Object o = it.next();
//            System.out.print(o+":");
//            System.out.println(req.getHeader((String) o));
//        }

        BufferedReader reader = req.getReader();
        String data = null;
        while((data = reader.readLine())!=null){
            System.out.println(data);
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        System.out.println("post");
//        BufferedReader reader = req.getReader();
//        String data = null;
//        while((data = reader.readLine())!=null){
//            System.out.println(data);
//        }
        byte[] bytes = new byte[1024];
        int dataLen = 0;
        ServletInputStream is = req.getInputStream();
        while((dataLen = is.read())!=-1){
            System.out.println(new String(bytes,0,dataLen));
        }

    }
}
