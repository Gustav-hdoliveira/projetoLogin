/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author GUSTAVOHENRIQUEDEOLI
 */
public class ConexaoSQLite {
    
    public Connection conectar(){
        Connection conexao = null; //Declara uma variavel para armazenar a conexão
        String url = "jdbc:sqlite:usuariosNovo.db"; //Defiine o caminho do banco de dados SQLite
        
        try{
            //Tenta estabelecer a conxão com o banco de dados usando a url fornecida
            conexao = DriverManager.getConnection(url);
            System.out.println("Conexão com SQLite estabelecia");
        } catch (SQLException e){
            //Caso occora um erro ele será capturado e exibido
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
        }
        
        return conexao; //Retorna a conexão estabelecida (ou null se falhou)
    }
    
    // Método para fechar a conexão com o banco estabelecida (ou null se falhou)
    
    public void desconectar(Connection conexao){
        
    }
}
