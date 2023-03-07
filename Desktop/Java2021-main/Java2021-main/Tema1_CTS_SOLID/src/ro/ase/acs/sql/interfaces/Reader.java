package ro.ase.acs.sql.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface Reader {
    void readData(Connection connection) throws SQLException;
}
