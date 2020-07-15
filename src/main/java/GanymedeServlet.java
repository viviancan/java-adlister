import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GanymedeServlet", urlPatterns = "/ganymede")
public class GanymedeServlet extends HttpServlet {

    //Overrides definition from parent class
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello Ganymede!</h1>");
    }
}


// we set the content type of the request
// get a reference to a PrintWriter object
// use that object to send some HTML as a response. You can think of this PrintWriter object like System.out.println, but for printing to the response that we send to the browser, as opposed to the console.