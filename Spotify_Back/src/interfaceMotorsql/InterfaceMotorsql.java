package interfaceMotorsql;

import java.sql.ResultSet;

public interface InterfaceMotorsql {
    public void connect();
    public int execute(String sql);
    public ResultSet executeQuery(String sql);
    public void disconnect();
}
