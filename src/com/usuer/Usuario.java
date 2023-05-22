package com.usuer;

import com.connection.JConexao;

import java.sql.*;

public class Usuario {
    public Usuario(){}

    Connection conexao = JConexao.getConectar();
    Statement recuperaDado = null;
    ResultSet resultado = null;
    PreparedStatement preparaDado = null;

    public void createUsuario() throws SQLException {
        try{
            String create = "INSERT INTO user (username,email,password) VALUES (?, ?, ?)";
            preparaDado = conexao.prepareStatement(create);

            preparaDado.setString(1,"João");
            preparaDado.setString(2,"jpk2015@gmail.com");
            preparaDado.setString(3,"HjkUytS5");

            int verificaAlteracao = preparaDado.executeUpdate();
            if(verificaAlteracao > 0) {
                System.out.println("\nInseriu " + verificaAlteracao);
            }

        }catch(SQLException e){
            System.err.println("Não inseriu");
            e.printStackTrace();
        }


    }
    public void readUsuarios(){

        try{
            recuperaDado = conexao.createStatement(); //statment
            resultado = recuperaDado.executeQuery("SELECT * FROM user LIMIT 10");

            while (resultado.next())
                System.out.println(
                        resultado.getString("id")+" | "
                        +resultado.getString("username")+" | "
                        +resultado.getString("email")+" | "
                        +resultado.getString("password"));

        }catch (SQLException e){
            System.err.println("Não consultou");
            e.printStackTrace();
        }
    }

    public void updateUsuario(){

        try{
            String update = "UPDATE user SET email = ? WHERE (username = ?)";
            preparaDado = conexao.prepareStatement(update);                   ;

            preparaDado.setString(1,"gmail@joao.com");
            preparaDado.setString(2,"João");

            int checaDado = preparaDado.executeUpdate();
            if(checaDado > 0) {
                System.out.println("\nAlterou " + checaDado);
            }



        }catch (SQLException e){
            System.out.println("Não atualizou");
            e.printStackTrace();
        }

    }

    public void deleteUsuario(){
        try{
            String delete = "DELETE FROM user WHERE id = ?";
            preparaDado = conexao.prepareStatement(delete);

            preparaDado.setInt(1,6);

            int verificaAlteracao = preparaDado.executeUpdate();
            if(verificaAlteracao > 0) {
                System.out.println("\nDeletou " + verificaAlteracao);
            }else{
                System.err.println("Não deletou");
            }

        }catch(SQLException e){
            System.err.println("Não inseriu");
            e.printStackTrace();
        }

    }


}
