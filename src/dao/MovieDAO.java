package dao;

import domain.Movie;

import java.sql.*;

public class MovieDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/java-projectDB";
    private static final String USER = "root";
    private static final String PW = "fpdlswj365";
    public boolean createMovie(Movie movie) {
        String sql = "INSERT INTO movie (title, seat_count) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PW);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, movie.getTitle());
            ps.setInt(2, movie.getSeatCount());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("영화 등록 실패: " + e.getMessage());
            return false;
        }
    }
}
