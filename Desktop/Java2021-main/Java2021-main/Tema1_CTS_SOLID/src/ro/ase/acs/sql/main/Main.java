package ro.ase.acs.sql.main;
import ro.ase.acs.sql.classes.DataInserter;
import ro.ase.acs.sql.classes.DataReader;
import ro.ase.acs.sql.classes.TableCreator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            connection.setAutoCommit(false);

            TableCreator tableCreator = new TableCreator();
            tableCreator.createTable(connection);

            DataInserter dataInserter = new DataInserter();
            dataInserter.insertData(connection);

            DataReader dataReader = new DataReader();
            dataReader.readData(connection);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}