import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        String method = req.getMethod();
        String encoding =req.getCharacterEncoding();
        String contentType = req.getContentType();
        String url = req.getContextPath();

        PrintWriter writer = resp.getWriter();
        writer.println(String.format("<h1>method:%s</h1>",method));
        writer.println(String.format("<h1>encoding:%s</h1>",encoding));
        writer.println(String.format("<h1>contenttype:%s</h1>",contentType));
        writer.println(String.format("<h1>url:%s</h1>",url));
    }
}
