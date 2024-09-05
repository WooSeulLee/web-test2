package com.test.web.service;

import java.util.List;

import com.test.web.repository.MovieRepository;
import com.test.web.vo.MovieVO;

public class MovieService {
	private MovieRepository mr = new MovieRepository();
	
	public int insertMovie(MovieVO movie) {
		return mr.insertMovie(movie);
	}
	
	public int updateMovie(MovieVO movie) {
		return mr.updateMovie(movie);
	}
	
	public int deleteMovie(int miNum) {
		return mr.deleteMovie(miNum);
	}
	
	public List<MovieVO> selectMovies(){
		return mr.selectMovies();
	}
	
	public MovieVO selectMovie(int miNum) {
		return mr.selectMovie(miNum);
	}
}
