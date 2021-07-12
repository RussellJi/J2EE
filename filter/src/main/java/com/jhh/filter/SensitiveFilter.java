package com.jhh.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "SensitiveFilter",urlPatterns="/*")
public class SensitiveFilter implements Filter {
    List<String> list;
    public void init(FilterConfig config) throws ServletException {

        String path = config.getServletContext().getRealPath("/WEB-INF/classes/sensitive.txt");
        System.out.println(path);
        BufferedReader br;
        list = new ArrayList<>();

        try {
            //加载文件
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
            String line;
            //读取文件
            while((line = br.readLine())!=null){
                //按行封装到List中
                list.add(line);
            }
//            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        chain.doFilter(request, response);
        req.setCharacterEncoding("utf-8");
//        System.out.println("dofilter");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        /*
        * 动态代理：Proxy.newProxyInstance
        * 参数1：ClassLoader
        * 参数2：Interfaces
        * 参数3：InvocationHandler
        *
        * 增强getParameter的返回值
        * */
        HttpServletRequest req_new = (HttpServletRequest)Proxy.newProxyInstance(request.getClass().getClassLoader(),
                request.getClass().getInterfaces(), (proxy, method, args) -> {
            String str = null;
            if(method.getName().equals("getParameter")){
                str = (String) method.invoke(request,args);
                for(String s : list){
                    if(str.contains(s)){
                        str = str.replaceAll(s,"***");
//                        System.out.println("filter");
                        System.out.println(str);
                    }
                }
                return str;
            }
            return method.invoke(request,args);
        });
        chain.doFilter(req_new, response);
    }
}
