package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface Base<T>{

    default Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Instagram",
                    "postgres",
                    "02112000"
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    boolean add(T t);
    List<T> getList();
    T getById(UUID id);
}
