package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.pojos.User;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String First_name= req.getParameter("first_name");
		String last_name= req.getParameter("last_name");
		String email= req.getParameter("email");
		String password= req.getParameter("password");
		String mobile= req.getParameter("mobile");
		String dob= req.getParameter("dob");
		
		User u = new User(First_name,last_name,email,password,mobile,dob);
		
		try(UserDao uDao= new UserDaoImpl()) {
			int count = uDao.save(u);
			if(count==1) {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Sign Up Succeeded</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h5>Successfully Signed Up</h5>");
				out.println("<a href = 'index.html'>Login</a>");
				out.println("</body>");
				out.println("</html>");
			}
			else {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Sign Up Failed</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h5>Something went wrong, please the details again</h5>");
				out.println("<h3>OR</h3>");
				out.println("<a href = 'index.html'>Login Again</a>");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	
	
}
