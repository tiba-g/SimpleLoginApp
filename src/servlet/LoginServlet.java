package servlet;

import java.io.IOException; 
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		if(!name.equals(session.getAttribute("name")))
			if(name.equals("Gabris") && password.equals("asdasd"))
			{
		        session.setAttribute("name",name);
	        	out.println("Welcome " + name + "! Have a nice day !");
				request.getRequestDispatcher("profile.html").include(request, response);
			}else
			{
				out.println("Bad username or password ! Permission denied");
				request.getRequestDispatcher("index.html").include(request, response); 
	//			rd=request.getRequestDispatcher("index.html");
	//	        rd.include(request,response);
			}
		else
        {
        	out.println("You are already login!");
        	request.getRequestDispatcher("profile.html").include(request, response);
        }
		//out.close();
	}

}
