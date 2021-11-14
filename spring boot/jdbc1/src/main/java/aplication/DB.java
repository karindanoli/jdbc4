package aplication; // classe para poder carregar as propriedades do db.properties e fazer a conexão com o Banco de dados

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
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
                    throw new DbException(e.getMessage());
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
                throw new DbException(e.getMessage());
            }
        }
    }
    private static Properties LoadProperties() {// carregar os dados do db.properties e guardar em um objeto especifico
        try (FileInputStream fs = new FileInputStream("C://Users/012188631/spring boot/jdbc1/src/main/java/aplication/db.properties")){
            Properties props = new Properties();
            props.load(fs);//fez a leitura do arquivo properties e vai guardar dentro do objeto props
            return props;
        }
        catch (IOException e) {
            throw new DbException(e.getMessage());
        }

    }

    public static void closeStatement(Statement st) {//o statement e o result tem q ser fechado manualmente usando finally no main, porém da exceçao entao fazer este metodo para referenciar lá no main
            if (st!= null){
                try {
                    st.close();}
                catch (SQLException e){
                    throw new DbException(e.getMessage());
                }}}

                public static void closeResult(ResultSet rs) {//o statement e o result tem q ser fechado manualmente usando finally no main, porém da exceçao entao fazer este metodo para referenciar lá no main
                    if (rs!= null){
                        try {
                            rs.close();
                        }
                        catch (SQLException e){
                            throw new DbException(e.getMessage());
                        }
            }
    }
}
