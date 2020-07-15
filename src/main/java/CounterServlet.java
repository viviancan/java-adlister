import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CounterServlet", urlPatterns = "/counter")
public class CounterServlet extends HttpServlet {
    private int counter = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        counter += 1;
        response.getWriter().println("<h1>The count is " + counter + ".</h1>");
    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//        // if reset is true, then set counter to zero
//        String reset = request.getParameter("reset");
//        if(reset == null) {
//            counter += 1;
//        } else {
//            counter = 0;
//        }
//        response.getWriter().println("<h1>The count is " + counter + ".</h1>");
//    }


}
