package ru.lesson.lessons;
import java.sql.*;

/**
 * Created by onotole on 09.05.16.
 */
public class DBManager {

    private Connection conn;

    private void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String databaseUrl = "jdbc:sqlite:velo.db";
        try {
            conn = DriverManager.getConnection(databaseUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void createVeloDB() {
        doUpdateRequest("CREATE TABLE IF NOT EXISTS VELOSTATIONS (date TEXT, address TEXT, " +
                "total_place INTEGER, total_electric_place INTEGER, total_ordinary_place INTEGER, " +
                "free_place INTEGER, free_electric_place INTEGER, free_ordinary_place INTEGER, ID STRING, " +
                "is_locked INTEGER, pos_lat REAL, pos_lon REAL);");
    }

    void addVeloStation(Velostation velostation, String date) {
        String request = String.format("INSERT INTO VELOSTATIONS (" +
                "date, " +
                "address, " +
                "total_place, " +
                "total_electric_place, " +
                "total_ordinary_place, " +
                "free_place, " +
                "free_electric_place, " +
                "free_ordinary_place, " +
                "ID, " +
                "is_locked, " +
                "pos_lat, " +
                "pos_lon) " +
                "VALUES (\"%s\", \"%s\", \"%d\", \"%d\", \"%d\", \"%d\", \"%d\", \"%d\", \"%s\", \"%d\", \"%f\", \"%f\");",
                date,
                velostation.Address,
                velostation.TotalPlaces,
                velostation.TotalElectricPlaces,
                velostation.TotalOrdinaryPlaces,
                velostation.FreePlaces,
                velostation.FreeElectricPlaces,
                velostation.FreeOrdinaryPlaces,
                velostation.Id,
                velostation.IsLocked ? 0 : 1,
                velostation.Position.get("Lat"),
                velostation.Position.get("Lon"));
//        System.out.println(request);
        doUpdateRequest(request);

    }

    public void clearDB() {
        doUpdateRequest("DELETE FROM VELOSTATIONS;");
    }

    public void dropDB() {
        doUpdateRequest("DROP TABLE VELOSTATIONS;");
    }

    private void doUpdateRequest(String request) {
        if (conn == null) connect();
        int  result = 0;
        try(Statement updateStmt = conn.createStatement()) {
            result = updateStmt.executeUpdate(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
