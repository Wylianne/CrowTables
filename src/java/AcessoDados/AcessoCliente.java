package AcessoDados;


import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wylianne
 */
public class AcessoCliente extends Conexao{
    private int id;
    private String nome;
    private String telefone;
    private ResultSet resultado;
    
    public AcessoCliente(){
        Conectar();
    }
    //BUSCA POR TODOS
    public ResultSet Lista()throws Exception{
        try{
        
            getStmt();
            resultado = stmt.executeQuery("SELECT * FROM cliente");
            return resultado;
        }catch (Exception ex){
            System.out.println("SQLException: "+ ex.getMessage());
            return null;
        }
    }
    
    //BUSCA POR ID
    public ResultSet BuscaExistente(int Codigo) throws Exception{

        try{
            getStmt();
            resultado = stmt.executeQuery("SELECT * FROM CLIENTE WHERE ID="+Codigo);
            return resultado;
        }catch (Exception ex){
            System.out.println("SQLException: "+ex.getMessage());
            return null;
        }
    }
}