import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "PortfolioServlet", urlPatterns = "/portfolio")
public class PortfolioServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");


        String content = "<h1>Vivian's Portfolio</h1>";
        content += "<p>my awesome portfolio</p> <br><hr><br>";
        content += "<a href='/resume'>My Resume</a>";

        PrintWriter out = response.getWriter();
        out.println(content);
    }

}
