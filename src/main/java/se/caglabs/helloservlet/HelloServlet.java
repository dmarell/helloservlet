/*
 * Created by Daniel Marell 14-02-12 23:04
 */
package se.caglabs.helloservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/helloservlet")
public class HelloServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().print("<html><body>" +
                "<h3>Hello Servlet</h3>" +
                "<form name=\"input\" method=\"post\">\n" +
                "Hello value: <input type=\"text\" name=\"helloValue\">\n" +
                "<input type=\"submit\" value=\"Submit\">\n" +
                "</form>" +
                "<p><a href=\"foo.html\">foo link</a></p></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value = request.getParameter("helloValue");
        System.out.println("doPost,helloValue=" + value);
        response.setContentType("text/html");
        response.getWriter().print("<html><body>helloValue=" + value + "</body></html>");
    }
}