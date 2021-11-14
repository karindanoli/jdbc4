package aplication;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class program {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = DB.getConnection();
            st = conn.prepareStatement(
                    "UPDATE seller"
                    + "SET baseSalary = BaseSalary + ? " //O QUE VAI SER ADICIONADO
                    + "WHERE "//QUANDO FOR ATUALIZAR TEM Q COLOCAR O WHERE senão vc atualiza tudo
                    +"(DepartmentId = ? ");

            st.setDouble(1,200);
            st.setInt(2,2);

            int rowsAffected = st.executeUpdate();
            System.out.println("done rows affected: " + rowsAffected);
            )   ;
        }
            catch ( SQLException e){
            e.printStackTrace();
            }
            finally {
            DB.closeStatement(st);
            DB.getConnection();
        }
    }}