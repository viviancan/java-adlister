import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ShowAdminPageServlet", urlPatterns = "/admin")
public class ShowAdminPageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			boolean isAdmin = (boolean) session.getAttribute("isAdmin");

			//have to add the return or have an else block
			//https://stackoverflow.com/questions/2123514/java-lang-illegalstateexception-cannot-forward-sendredirect-create-session
			if(isAdmin == false){
				resp.sendRedirect("/profile");
				return;
			}

			req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req,resp);
		}catch (Exception e){
			e.printStackTrace();
			resp.sendRedirect("/login");
		}
	}
}
