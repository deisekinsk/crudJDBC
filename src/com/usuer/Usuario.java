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
            String create = "INSERT INTO user_data (first_name,last_name,email,gender," +
                    "ip_address)" +
                    "VALUES (?,?,?,?,?)";
            preparaDado = conexao.prepareStatement(create);

            preparaDado.setString(1,"João");
            preparaDado.setString(2,"Caçula");
            preparaDado.setString(3,"jpk2015@gmail.com");
            preparaDado.setString(4,"male");
            preparaDado.setString(5,"000.122.122.1");

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
            resultado = recuperaDado.executeQuery("SELECT * FROM user_data LIMIT 10");

            while (resultado.next())
                System.out.println(
                        resultado.getString("id")+" | "
                        +resultado.getString("first_name") +" "
                        +resultado.getString("last_name")+" | "
                        +resultado.getString("email"));

        }catch (SQLException e){
            System.err.println("Não consultou");
            e.printStackTrace();
        }
    }

    public void updateUsuario(){

        try{
            String update = "UPDATE user_data SET email = ? WHERE (id = ?)";
            preparaDado = conexao.prepareStatement(update);                   ;

            preparaDado.setString(1,"gmail@joao.com");
            preparaDado.setInt(2,1001);

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
            String delete = "DELETE FROM user_data WHERE id = ?";
            preparaDado = conexao.prepareStatement(delete);

            preparaDado.setInt(1,1);

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
