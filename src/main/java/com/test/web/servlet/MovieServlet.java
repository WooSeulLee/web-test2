package com.test.web.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.web.service.MovieService;
import com.test.web.util.CmdUtil;
import com.test.web.vo.MovieVO;

public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieService ms = new MovieService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = CmdUtil.getCmd(uri);
		
		if("movie-list".equals(cmd)) {
			List<MovieVO> movies = ms.selectMovies();
			request.setAttribute("movies", movies);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views" + uri + ".jsp");
			rd.forward(request, response);
			
		}else if("movie-view".equals(cmd) || "movie-update".equals(cmd)) {
			int miNum = Integer.parseInt(request.getParameter("miNum"));
			System.out.println(miNum);
			MovieVO movie = ms.selectMovie(miNum);
			request.setAttribute("movie", movie);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views" + uri + ".jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String cmd = CmdUtil.getCmd(uri);
		MovieVO movie = new MovieVO();
		movie.setMiName(request.getParameter("miName"));
		movie.setMiDirector(request.getParameter("miDirector"));
		movie.setMiGenre(request.getParameter("miGenre"));
		movie.setMiYear(request.getParameter("miYear"));
		if("movie-insert".equals(cmd)) {
			int result = ms.insertMovie(movie);
			String msg = "영화등록에 실패했습니다";
			String url = "/views/movie/movie-insert";
			if(result==1) {
				msg = "영화 등록에 성공했습니다.";
				url = "/movie/movie-list";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
			return; 
		}else if("movie-update".equals(cmd)) {
			int miNum = Integer.parseInt(request.getParameter("miNum"));
			movie.setMiNum(miNum);
			int result = ms.updateMovie(movie);
			String msg = "영화 수정에 실패했습니다";
			String url = "/views/movie/movie-update?miNum="+miNum;
			if(result==1) {
				msg = "영화 수정에 성공했습니다.";
				url = "/movie/movie-view?miNum="+miNum;
			}
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
			return; 
		}else if("movie-delete".equals(cmd)) {
			int miNum = Integer.parseInt(request.getParameter("miNum"));
			movie.setMiNum(miNum);
			int result = ms.deleteMovie(miNum);
			String msg = "영화 삭제에 실패했습니다";
			String url = "/views/movie/movie-view?miNum="+miNum;
			if(result==1) {
				msg = "영화 삭제에 성공했습니다.";
				url = "/movie/movie-list";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
			return; 
		}
		
	}

}
