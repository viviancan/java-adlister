package jupiter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DadJokeServletJupiter", urlPatterns = "/dadjoke")
public class DadJokeServletJupiter extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String passedJoke = request.getParameter("joke");

		if(passedJoke == null){
			passedJoke = "Hungry";
		}


		out.println("<h1>Hi " + passedJoke + ", I'm Dad!</h1>");
	}



}
