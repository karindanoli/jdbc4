package aplication;

import java.sql.Connection;

public class program {

    public static void main(String[] args){
        Connection conn = DB.getConnection();// conecta com o banco
        DB.closeConnection();//fechou a conexão
    }}
