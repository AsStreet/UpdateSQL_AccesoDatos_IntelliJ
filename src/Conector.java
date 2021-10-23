import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conector {
    public Conector(){}

    public static Connection conectar(String servidor, String base) {
        return conectar(servidor, base, null, null);
    }

    public static Connection conectar(String servidor, String base, String usuario, String password){
        Connection conexion = null;
        String ruta = "jdbc:sqlserver://";
        // Es que hay 2 parametros, entonces conexion integrada
        try{
            if(usuario == null)
                ruta += servidor + ";database=" + base + ";integratedSecurity=true";
            else
                ruta += servidor + ";database=" + base + ";user=" + usuario + ";password=" + password + ";";
            conexion = DriverManager.getConnection(ruta);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conexion;
    }
}