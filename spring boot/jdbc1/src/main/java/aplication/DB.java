package aplication; // classe para poder carregar as propriedades do db.properties e fazer a conexão com o Banco de dados

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;//metodos estaticos para conectar e desconectar com o banco de dados

public class DB {


    private static Connection conn = null; //escolher o connection do sql


        public static Connection getConnection() {
            if (conn == null) {
                try {
                    Properties props = LoadProperties();
                    String url = props.getProperty("dburl");
                    conn = DriverManager.getConnection(url, props);
                }
                catch (SQLException e) {
                    throw new dbException(e.getMessage());
                }
            }
            return conn;
        }

    public static void closeConnection(){
        if(conn !=null){
            try{
                conn.close();
            }
            catch (SQLException e) {
                throw new dbException(e.getMessage());
            }
        }
    }
    private static Properties LoadProperties() {// carregar os dados do db.properties e guardar em um objeto especifico
        try (FileInputStream fs = new FileInputStream("aplication/db.properties")){
            Properties props = new Properties();
            props.load(fs);//fez a leitura do arquivo properties e vai guardar dentro do objeto props
            return props;
        }
        catch (IOException e) {
            throw new dbException(e.getMessage());
        }

    }
}
