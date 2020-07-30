

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {

  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("user");
		String password=request.getParameter("pass");
		
		if(Login.validate(name,password))
		{
			RequestDispatcher rd=request.getRequestDispatcher("/servlet2");
			rd.forward(request, response);
		}
		else 
		{
			out.print("Please Enter valid user name and password");
			RequestDispatcher rd=request.getRequestDispatcher("HomeLogin.html");
			rd.include(request, response);
		}
		out.close();
	}

}
