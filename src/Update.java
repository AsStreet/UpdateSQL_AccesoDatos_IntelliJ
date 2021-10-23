import java.io.Serializable;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

public class Update implements Serializable {

    public Update(){}

    //Sin parámetros, la conexión está abierta
    public static int ejecutar(Connection cnx, String sentencia) throws Exception {
        Statement stmt = cnx.createStatement();
        int filas = 0;
        if(! cnx.isClosed())
            filas = stmt.executeUpdate(sentencia);
        else
            filas = -1;
        return filas;
    }

    // Conexión abierta, sentencia con parámetros, el array incuye los parámetros 3 valores
    public static int ejecutar(Connection cnx, String sentencia, ArrayList args) throws Exception{
        int filas = 0;
        PreparedStatement pstmt = cnx.prepareStatement(sentencia);
        ParameterMetaData pmd = pstmt.getParameterMetaData();
        if(! cnx.isClosed()){
            if(pmd.getParameterCount() == args.size()){
                for(int i = 0; i < args.size(); i++)
                    pstmt.setObject((i + 1), args.get(i));
                filas = pstmt.executeUpdate();
            }else
                filas = -1;
        }
        return filas;
    }
}
