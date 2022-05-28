import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class GetCookies extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        Cookie c[] = req.getCookies();

        for (int i = 0; i < c.length; i++) {

            out.println(" cookie name:" + c[i].getName());
            out.println(" cookie value:" + c[i].getValue());
            out.println("<br>");
        }

        out.close();
    }

}
