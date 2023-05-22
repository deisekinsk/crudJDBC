package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JConexao {

    public JConexao(){}

    public static final String Green = "\u001B[32m";
    public static final String RST = "\u001B[0m";
    public static Connection getConectar(){
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://127.0.0" +
                    ".1:3306/localbase","root","admin1234");
            System.out.println(Green +"Conexão realizada.\n"+RST );

        } catch (SQLException e){
            System.err.println("Não conectado");
            e.printStackTrace();
        }
        return conexao;
    }


}