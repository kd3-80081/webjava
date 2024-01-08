package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.MovieDao;
import com.sunbeam.dao.MovieDaoImpl;
import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.ReviewDaoImpl;
import com.sunbeam.pojos.Movie;
import com.sunbeam.pojos.Review;
import com.sunbeam.pojos.User;

@WebServlet("/addReview")
public class AddReviewServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int count=0;
		int movieId= Integer.parseInt(req.getParameter("movieid"));
		String review=  req.getParameter("review");
		int rating= Integer.parseInt(req.getParameter("rating")) ;
		
		HttpSession session = req.getSession();
		User curUser = (User) session.getAttribute("curUser");
		System.out.println(curUser.toString());
		
		Review r= new Review();
		r.setMovieId(movieId);
		r.setReview(review);
		r.setRating(rating);
		r.setUserId(curUser.getUserId());
		try (ReviewDao rDao = new ReviewDaoImpl()) {
			
				count =rDao.save(r);
			}
		 catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		RequestDispatcher rd=req.getRequestDispatcher("reviews");
		rd.forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add Review</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Add Review</h1>");
		out.println("<form method='post' action='addReview' >");
		out.println("<label for='movie'>Select a Movie:</label>");
		out.println("<select name='movieid' id='movie'>");
		out.println("<option value='0'>Select</option>");
		try (MovieDao mDao = new MovieDaoImpl()) {
			List<Movie> list = mDao.findAll();
			for (Movie movie : list) {

				out.printf("<option value=%d>%s</option>\r\n", movie.getMovieId(), movie.getTitle());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		out.println("</select>");
		out.println("<br>");
		out.println("<br>");
		out.println("<label for='rating'>Enter Rating:</label>");
		out.println("<input type ='number' name='rating'>");
		out.println("<br>");
		out.println("<br>");
		out.println("<label for='review'>Write a Review:</label>");
		out.println("<br>");
		out.println("<br>");
		out.println("<textarea name='review' rows='3' cols='40'>");
		
		out.println("</textarea>");
		out.println("<br>");out.println("<br>");
		out.println("<input type='submit' value='Add Review'/>");

		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
}
