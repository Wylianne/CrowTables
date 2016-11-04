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
public class AcessoInstrumento extends Conexao{

    private ResultSet resultado;
    
    public AcessoInstrumento(){
        Conectar();
    }
    


    //Modal
    public ResultSet Modal()throws Exception{
        try{
            getStmt();
            resultado = stmt.executeQuery("SELECT * FROM instrumento");
            return resultado;
        }catch (Exception ex){
            System.out.println("SQLException: "+ ex.getMessage());
            return null;
        }
    }
    //BUSCA POR TODOS
    
    public ResultSet Lista()throws Exception{
        try{
            getStmt();
            resultado = stmt.executeQuery("SELECT nome, descricao FROM instrumento");
            return resultado;
        }catch (Exception ex){
            System.out.println("SQLException: "+ ex.getMessage());
            return null;
        }
    }
    
    
    public ResultSet Lista(String filter)throws Exception{
        try{
        
            getStmt();
            resultado = stmt.executeQuery("SELECT "+filter+", id FROM instrumento");
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
            resultado = stmt.executeQuery("SELECT * FROM instrumento WHERE ID="+Codigo);
            return resultado;
        }catch (Exception ex){
            System.out.println("SQLException: "+ex.getMessage());
            return null;
        }
    }
}
