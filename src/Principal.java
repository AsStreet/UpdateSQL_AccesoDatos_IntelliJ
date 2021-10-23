import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {
    public static void main(String[] args) throws SQLException, IOException {
        Conector c = new Conector();
        Connection cnx = c.conectar("localhost", "Bankline", "sa", "oretania");
        String sentenciaNormal = "UPDATE Clientes SET nombre=\"ANGEL\" WHERE doc=\"46100230L\"";
        String sentenciaParametros = "";

        up.ejecutar(cnx, sentenciaNormal);
        if(! cnx.isClosed()) {
            System.out.println("Conectado correctamente");
            Update up = new Update();
        }
    }
}
