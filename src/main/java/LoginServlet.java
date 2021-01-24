import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //check to see if something is there! redirect them to /profile
        if (request.getSession().getAttribute("isAdmin") != null) {
            response.sendRedirect("/profile");
            return;
        }

        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = (username.equals("admin") || username.equals("user")) && password.equals("password");

        HttpSession session = request.getSession(); //gets the current session on request object

        if (validAttempt && username.equals("admin")) {
            // Sets isAdmin attribute on the session
            // We can use this to perform additional logic
            session.setAttribute("isAdmin", true);
            response.sendRedirect("/admin");

        } else if (validAttempt && username.equals("user")){
            session.setAttribute("isAdmin", false);
            response.sendRedirect("/profile");

        } else {
            response.sendRedirect("/login");
        }
    }
}
