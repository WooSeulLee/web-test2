package com.test.web.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.web.vo.CarVO;
import com.test.web.vo.MovieVO;

import common.DBCon;

public class MovieRepository {
	
	public int insertMovie(MovieVO movie) {
		try(Connection con = DBCon.getCon();){
			String sql = "INSERT INTO MOVIE_INFO (MI_NAME, MI_DIRECTOR, MI_GENRE, MI_YEAR)\r\n"
					+ "VALUES (?, ?, ?, ?);";
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, movie.getMiName());
				ps.setString(2, movie.getMiDirector());
				ps.setString(3, movie.getMiGenre());
				ps.setString(4, movie.getMiYear());
				return ps.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateMovie(MovieVO movie) {
		try(Connection con = DBCon.getCon();){
			String sql = "UPDATE MOVIE_INFO\r\n"
					+ "SET MI_NAME = ?,\r\n"
					+ "MI_DIRECTOR = ?,\r\n"
					+ "MI_GENRE = ?,\r\n"
					+ "MI_YEAR = ?\r\n"
					+ " WHERE MI_NUM= ?";
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, movie.getMiName());
				ps.setString(2, movie.getMiDirector());
				ps.setString(3, movie.getMiGenre());
				ps.setString(4, movie.getMiYear());
				ps.setInt(5, movie.getMiNum());
				return ps.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteMovie(int miNum) {
		try(Connection con = DBCon.getCon();){
			String sql = "DELETE FROM MOVIE_INFO WHERE MI_NUM = ?";
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setInt(1, miNum);
				return ps.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<MovieVO> selectMovies(){
		List<MovieVO> movies =new ArrayList<>();
		try(Connection con = DBCon.getCon();){
			String sql = "SELECT MI_NUM, MI_NAME, MI_DIRECTOR, MI_GENRE, MI_YEAR\r\n"
					+ "FROM MOVIE_INFO;";
			try(PreparedStatement ps = con.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						MovieVO movie = new MovieVO();
						movie.setMiNum(rs.getInt("MI_NUM"));
						movie.setMiName(rs.getString("MI_NAME"));
						movie.setMiDirector(rs.getString("MI_DIRECTOR"));
						movie.setMiGenre(rs.getString("MI_GENRE"));
						movie.setMiYear(rs.getString("MI_YEAR"));
						movies.add(movie);
					}	
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return movies;
		}
	
	public MovieVO selectMovie(int miNum) {
		try(Connection con = DBCon.getCon();){
			String sql = "SELECT MI_NUM, MI_NAME, MI_DIRECTOR, MI_GENRE, MI_YEAR\r\n"
					+ "FROM MOVIE_INFO\r\n"
					+ "WHERE MI_NUM = ?";
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setInt(1, miNum);
				try(ResultSet rs = ps.executeQuery()){
					if(rs.next()) {
						MovieVO movie = new MovieVO();
						movie.setMiNum(rs.getInt("MI_NUM"));
						movie.setMiName(rs.getString("MI_NAME"));
						movie.setMiDirector(rs.getString("MI_DIRECTOR"));
						movie.setMiGenre(rs.getString("MI_GENRE"));
						movie.setMiYear(rs.getString("MI_YEAR"));
						return movie;
					}
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		MovieRepository mr = new MovieRepository();
		MovieVO vo = new MovieVO();
		vo.setMiNum(2);
		System.out.println(vo);
		
		List<MovieVO> vos = mr.selectMovies();
		for(MovieVO c : vos) {
			System.out.println(c);
		}
		MovieVO v = mr.selectMovie(2);
		System.out.println(v);
	}
	
}
