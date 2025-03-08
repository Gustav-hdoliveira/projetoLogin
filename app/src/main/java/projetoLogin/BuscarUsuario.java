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
    public static boolean buscarUsuario(Connection conexao, String nome){
        String sql = "SELECT * FROM usuarios WHERE nome = ? ";

        
        // Tentando executar a consulta SQL
        try (PreparedStatement stmt = conexao.prepareStatement(sql)){
            
            stmt.setString(1, nome);
            
             ResultSet rs = stmt.executeQuery();
            
           if (rs.next()) {
           
               String nomeArmazenado = rs.getString("nome");
               
               if(nome.equals(nomeArmazenado)) {
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
    
    public static String[] buscarDadosUsuario(Connection conexao, String nomeUsuario) {
        // Array para armazenar nome e senha
        String[] dadosUsuario = new String[3];
        
        // SQL para selecionar o nome e a senha do usuário
        String sql = "SELECT * FROM usuarios WHERE nome = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            // Define o valor do parâmetro na consulta SQL
            stmt.setString(1, nomeUsuario);
            
            // Executa a consulta
            ResultSet rs = stmt.executeQuery();
            
            // Verifica se o usuário foi encontrado
            if (rs.next()) {
                // Armazena o nome e a senha do usuário
                dadosUsuario[0] = rs.getString("nome");
                dadosUsuario[1] = rs.getString("senha");
                dadosUsuario[2] = rs.getString("id");
            } else {
                // Caso o usuário não seja encontrado
                System.out.println("Usuário não encontrado.");
            }
        } catch (Exception e) {
            // Em caso de erro, exibe a mensagem de erro
            System.out.println("Erro ao buscar usuário: " + e.getMessage());
        }
        
        // Retorna os dados do usuário (nome e senha)
        return dadosUsuario;
    }
        
}
