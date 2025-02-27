/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author GUSTAVOHENRIQUEDEOLI
 */
public class InserirUsuario {
    public static void inserirUsuario(Connection conexao, String nome, String senha) throws SQLException{
        String sql = "INSERT INTO usuarios (nome, senha) VALUES (?, ?)";
        
        try(PreparedStatement pstmt = conexao.prepareStatement(sql)){
            pstmt.setString(1, nome); // Substitui o primeiro ? por 'nome'
            pstmt.setString(2, senha);
            pstmt.executeUpdate();
            
            System.out.println("Usuário inserido com sucesso");
        } catch (Exception e){
            System.out.println("Erro ao inserir usuario: " + e.getMessage());
        }
    }
}
