package dao;

import domain.Movie;

import java.sql.*;

public class MovieDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/java-projectDB";
    private static final String USER = "root";
    private static final String PW = "fpdlswj365";
    public boolean createMovie(Movie movie) {
        String sql = "INSERT INTO movie (title, time, senior_seat_count, pregnant_seat_count, general_seat_count, premium_seat_count ) VALUES (?, ?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PW);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getTime());
            ps.setInt(3, movie.getSeatCounts().get("노약좌석"));
            ps.setInt(4, movie.getSeatCounts().get("임산부석"));
            ps.setInt(5, movie.getSeatCounts().get("일반석"));
            ps.setInt(6, movie.getSeatCounts().get("프리미엄석"));

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("영화 등록 실패: " + e.getMessage());
            return false;
        }
    }
}
