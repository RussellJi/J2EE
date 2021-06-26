import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/demo1")
public class ParasHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取请求参数username的值
        System.out.println(req.getParameter("username"));
        // 2.获取复选框的参数
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        // 3.获取所有请求参数名
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String s = parameterNames.nextElement();
            System.out.println(s);
        }
        // 4.获取map
        Map<String, String[]> m =  req.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = m.entrySet();
        Iterator it1 = entries.iterator();
        while(it1.hasNext()){
            Map.Entry entry = (Map.Entry)it1.next();
            System.out.println(entry.getKey()+":"+ Arrays.toString((String[])entry.getValue()));
        }




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req,resp);
    }
}
