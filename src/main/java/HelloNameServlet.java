import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloNameServlet", urlPatterns = "/hello-name")
public class HelloNameServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageHtml = "<h1>Hello, World!</h1>";


        //VERSION TWO
        if(checkParameter(request, "name")){
            String name = getParameterValue(request, "name");

            if(!name.equals("")){
                pageHtml = "<h1>Hello, " + name + "!</h1>";
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(pageHtml);


        //VERSION ONE
        //checks to see if parameter of name exists
        /*
        if (request.getParameterMap().containsKey("name")) {

            //sets name to String name
            String name = request.getParameter("name");

            if(!name.equals("")){
                System.out.println(name);
                pageHtml = "<h1>Hello, " + name + "!</h1>";
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(pageHtml);
       */
    }


    public boolean checkParameter(HttpServletRequest request, String paramName){
        return request.getParameterMap().containsKey(paramName);
    }

    public String getParameterValue(HttpServletRequest request, String paramName){
        return  request.getParameter(paramName);
    }
}





