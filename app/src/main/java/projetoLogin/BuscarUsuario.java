/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author GUSTAVOHENRIQUEDEOLI
 */
public class BuscarUsuario {
    public static boolean buscarUsuario(Connection conexao, String nome, String senha){
        String sql = "SELECT * FROM usuarios WHERE nome = ? ";

        
        // Tentando executar a consulta SQL
        try (PreparedStatement stmt = conexao.prepareStatement(sql)){
            
            stmt.setString(1, nome);
            
             ResultSet rs = stmt.executeQuery();
            
           if (rs.next()) {
           
               String senhaArmazenada = rs.getString("senha");
               
               if(senha.equals(senhaArmazenada)) {
                   System.out.println("Usuário encontrado");
                   return true;
               } else {
                   System.out.println("Senha incorreta");
               }
           
           } else {
            System.out.println("Usuário não encontrado.");
           }
            
           
        } catch (Exception e) {
            // Caso ocorra algum erro, adiciona a mensagem de erro na String
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }
        return false;
    }
        
}
