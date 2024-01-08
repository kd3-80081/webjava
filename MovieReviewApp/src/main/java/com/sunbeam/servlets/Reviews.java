package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

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

@WebServlet("/reviews")
public class Reviews extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		User curUser = (User) session.getAttribute("curUser");
		System.out.println(curUser);

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Reviews</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<hr></hr>");
		out.println("<h1>Reviews</h1>");
		out.println("<hr></hr>");
		out.println(
				"<a href='reviews?type=allreview'>All Reviews</a>   |   <a href='reviews?type=myReviews'>My Reviews</a>  |  <a href='reviews?type=sharedReviews' name='sharedreview'>Shared Reviews</a>");
		out.println("<hr></hr>");
		String type = req.getParameter("type");
		if (type.equals("allreview")) {
			out.println("<table border = '1'>");
			out.println("<thead>");
			out.println("<th>Review Id</th>");
			out.println("<th>Movie Title</th>");
			out.println("<th>Movie Id</th>");
			out.println("<th>Review</th>");
			out.println("<th>Rating</th>");
			out.println("<th>User Id</th>");
			out.println("<th>Modified</th>");
			out.println("</thead>");
			out.println("<tbody>");
			try (ReviewDao rDao = new ReviewDaoImpl()) {

				List<Review> list = rDao.findAll();
				try (MovieDao mDao = new MovieDaoImpl()) {

					for (Review r : list) {

						out.println("<tr>");
						out.printf("<td>%d</td>", r.getReviewId());
						out.printf("<td>%s</td>", mDao.findById((r.getMovieId())).getTitle());
						out.printf("<td>%d</td>", r.getMovieId());
						out.printf("<td>%s</td>", r.getReview());
						out.printf("<td>%d</td>", r.getRating());
						out.printf("<td>%d</td>", r.getUserId());
						out.printf("<td>%s</td>", r.getModified());
						out.println("</tr>");
					}

				} catch (Exception e) {
					e.printStackTrace();
					throw new ServletException(e);
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}

			out.println("</tbody>");

			out.println("</table>");
		} else if (type.equals("myReviews")) {
			
				out.println("<table border = '1'>");
				out.println("<thead>");
				out.println("<th>Review Id</th>");
				out.println("<th>Movie Title</th>");
				out.println("<th>Movie Id</th>");
				out.println("<th>Review</th>");
				out.println("<th>Rating</th>");
				out.println("<th>User Id</th>");
				out.println("<th>Modified</th>");
				out.println("</thead>");
				out.println("<tbody>");
				try (ReviewDao rDao = new ReviewDaoImpl()) {

					List<Review> list = rDao.findAll();
					try (MovieDao mDao = new MovieDaoImpl()) {

						for (Review r : list) {
						
							if (curUser.getUserId() == r.getUserId()) {
								
								out.println("<tr>");
								out.printf("<td>%d</td>", r.getReviewId());
								out.printf("<td>%s</td>", mDao.findById((r.getMovieId())).getTitle());
								out.printf("<td>%d</td>", r.getMovieId());
								out.printf("<td>%s</td>", r.getReview());
								out.printf("<td>%d</td>", r.getRating());
								out.printf("<td>%d</td>", r.getUserId());
								out.printf("<td>%s</td>", r.getModified());
								out.println("</tr>");
							}
						}

					}

				}

				catch (Exception e) {
					e.printStackTrace();
					throw new ServletException(e);
				}

				out.println("</tbody>");

				out.println("</table>");
			}
		else if (type.equals("sharedReviews")) {
			
			out.println("<table border = '1'>");
			out.println("<thead>");
			out.println("<th>Review Id</th>");
			out.println("<th>Movie Title</th>");
			out.println("<th>Movie Id</th>");
			out.println("<th>Review</th>");
			out.println("<th>Rating</th>");
			out.println("<th>User Id</th>");
			out.println("<th>Modified</th>");
			out.println("</thead>");
			out.println("<tbody>");
			try (ReviewDao rDao = new ReviewDaoImpl()) {

				List<Review> list = rDao.findAll();
				try (MovieDao mDao = new MovieDaoImpl()) {

					for (Review r : list) {
					
						if (curUser.getUserId() == r.getUserId()) {
							
							out.println("<tr>");
							out.printf("<td>%d</td>", r.getReviewId());
							out.printf("<td>%s</td>", mDao.findById((r.getMovieId())).getTitle());
							out.printf("<td>%d</td>", r.getMovieId());
							out.printf("<td>%s</td>", r.getReview());
							out.printf("<td>%d</td>", r.getRating());
							out.printf("<td>%d</td>", r.getUserId());
							out.printf("<td>%s</td>", r.getModified());
							out.println("</tr>");
						}
					}

				}

			}

			catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}

			out.println("</tbody>");

			out.println("</table>");
		}

			out.println("<br><br><br>");

			out.println("<a href='addReview'>Add Review</a>" + "  |  " + "<a href='signOut'>Sign Out</a>");

			out.println("</body>");
			out.println("</html>");

		}
	}

