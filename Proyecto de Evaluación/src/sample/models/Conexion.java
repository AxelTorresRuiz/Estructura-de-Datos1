package sample.models;

import java.sql.*;

public class Conexion {
    private String usuario="root";
    private String password="";
    private String bd="covid";
    private String servidor="localhost";
public Connection conexion;
public Conexion(){
try {
conexion= DriverManager.getConnection("jdbc:mysql://"+servidor+":3306/"+ bd + "?useUnicode=true&useJDBCCompilantTimeZoneShift=useLegacyDatetimeCode&serverTimeZone=UTC",usuario,password);
    System.out.println("Conectado Exitosamente");
}catch (Exception e){
    System.out.println("No se pudo conectar"+ e.getMessage());
}

}//llaveconstructor

    public ResultSet consultar(String consulta){
    ResultSet resultado=null;
try {
    Statement st=conexion.createStatement();
    resultado= st.executeQuery(consulta);
}catch (Exception e){
    System.out.println("Error en la consulta"+e.getMessage());

}
return resultado;
    }
public void insmodel(String consulta){
    try {
        Statement sta=conexion.createStatement();
        sta.executeUpdate(consulta);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
