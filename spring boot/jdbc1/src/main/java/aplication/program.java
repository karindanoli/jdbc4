package aplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class program {

    public static void main(String[] args){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn =DB.getConnection();
            st = conn.createStatement();//vai criar uma recuperaçao dos dados
            rs = st.executeQuery("select + from department"); // executa a tabela
            while (rs.next()) {
                System.out.println(rs.getInt("Id" + ", " + rs.getString("Name")));

            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeResult(rs);
            DB.closeConnection();

        }
    }}
