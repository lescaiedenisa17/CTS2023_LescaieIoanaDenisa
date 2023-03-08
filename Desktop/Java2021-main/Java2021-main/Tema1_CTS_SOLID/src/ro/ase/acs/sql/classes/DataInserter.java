package ro.ase.acs.sql.classes;

import ro.ase.acs.sql.interfaces.Insertor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataInserter implements Insertor {
    @Override
    public void insertData(Connection connection) throws SQLException {
        String sqlInsert = "INSERT INTO employees VALUES(1, 'Popescu Ion', 'Bucharest', 4000)";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlInsert);
        statement.close();
        connection.commit();
    }
}
