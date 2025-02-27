/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoLogin;

/**
 *
 * @author GUSTAVOHENRIQUEDEOLI
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtualizarUsuarios {
    public static void atualizarUsuario(Connection conexao, int id, String novoNome, String novaSenha) throws SQLException{
        String sql = "UPDATE usuario SET nome = ?, senha = ? WHERE id = ?";
        
        try {
            try(PreparedStatement pstmt = conexao.prepareStatement(sql)){
                pstmt.setString(1, novoNome);
                
                // Substitui o segundo parâmetro (?) com o novo email fornecido.
                pstmt.setString(2, novaSenha);
                
                // Substitui o terceiro parâmetro (?) com o ID do usuário para identificar qual usuário atualizar.
                pstmt.setInt(3, id);
                
                // Executa o comando SQL e retorna o número de linhas afetadas pela operação.
                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0){
                    System.out.println("Usuário atualizado com sucesso!");
                } else {
                    // Se nenhuma linha foi atualizada (significa que o ID fornecido não foi encontrado), imprime uma mensagem.
                    System.out.println("Nenhum usuário encontrado com o ID fornecido.");
                }
            
            } catch (Exception e) {
                System.out.println("Erro ao atualizar usuário: " + e.getMessage());
            }
            
        } catch (Exception e) {
            // Caso ocorra um erro ao tentar preparar ou executar a instrução SQL, 
            // ele é capturado aqui. A mensagem do erro é impressa.
            System.out.println("Erro ao conectar ou executar SQL: " + e.getMessage());
        }
    }
}
