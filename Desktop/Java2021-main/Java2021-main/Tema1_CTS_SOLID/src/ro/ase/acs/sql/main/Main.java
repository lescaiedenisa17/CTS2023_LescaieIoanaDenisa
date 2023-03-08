package ro.ase.acs.sql.main;
import ro.ase.acs.sql.classes.DataInserter;
import ro.ase.acs.sql.classes.DataInserterWithParams;
import ro.ase.acs.sql.classes.DataReader;
import ro.ase.acs.sql.classes.TableCreator;
import ro.ase.acs.sql.interfaces.Creator;
import ro.ase.acs.sql.interfaces.Insertor;
import ro.ase.acs.sql.interfaces.Reader;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            connection.setAutoCommit(false);

            Creator tableCreator = new TableCreator();
            tableCreator.createTable(connection);

            Insertor dataInserter = new DataInserter();
            dataInserter.insertData(connection);

            Insertor dataInserterWithParams = new DataInserterWithParams();
            dataInserterWithParams.insertData(connection);

            Reader dataReader = new DataReader();
            dataReader.readData(connection);

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}