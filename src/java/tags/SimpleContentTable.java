/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;


import AcessoDados.AcessoCliente;
import com.mysql.jdbc.ResultSetMetaData;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Wylianne
 */
public class SimpleContentTable extends SimpleTagSupport{
    ResultSet res;
    AcessoCliente cliente = new AcessoCliente();
    int id = 0;
    String cpf = "";
    String nome = "";
    String identidade = "";
    String dataNascimento = "";
    String escolaridade = "";
    String endereco = "";
    String telefone = "";
    String table_content = "";
    private String value;

    public void setValue(String value) {
        this.value = value;
    }
    
    
    @Override
    public void doTag() throws IOException, JspException{
            String[][] conteudo = null;
            
            
            switch (value) {
                case "5":
                    conteudo = new String[3][2];
                    conteudo[0][0] = "Wylianne";
                    conteudo[0][1] = "999346862";
                    conteudo[1][0] = "Paulo";
                    conteudo[1][1] = "907337777";
                    conteudo[2][0] = "Maria";
                    conteudo[2][1] = "990731251";
                    break;
                default:
                    try {
                        
                        
                        //conteudo[0][0] = Integer.toString(i);
                        res = cliente.Lista();
                        res.last(); 
                        int qntL = res.getRow(); 
                        res.beforeFirst();
                        
                        ResultSetMetaData rsmd = (ResultSetMetaData) res.getMetaData();  
                        int numCol = rsmd.getColumnCount(); 
                        
                        //Quantidade de colunas pode ser substituida por
                        //numCol, seria necessário for
                        conteudo = new String[qntL][3];
                        
                        int i =0;
                        while (res.next()) {
                            //Recupera pelo numero da coluna
                            //int j = 2;
                            //conteudo[i][0] = res.getString(j++);
                            //conteudo[i][1] = res.getString(j++);
                            //conteudo[i][2] = res.getString(j++);
                           
                            //Recupera pelo titulo da coluna
                            conteudo[i][0] = res.getString("nome");
                            conteudo[i][1] = res.getString("escolaridade");
                            conteudo[i][2] = res.getString("identidade");
                            i++;
                            
                        }
                        
                    } catch (Exception ex) {
                        Logger.getLogger(SimpleContentTable.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                    
            }
        String table_content="<tbody>";
        
        //Saber comprimento conteudo[0].length
        
            for (int i = 0; i < conteudo.length; i++) {
                if(conteudo[i][0] == ""){
                    break;
                }
                table_content += "<tr>";
                for (int j = 0; j < conteudo[i].length; j++) {
                    table_content += "<td>"+conteudo[i][j]+"</td>";
                }
                table_content += "</tr>";
            }
            table_content += "</tbody>";
        
        
        
        getJspContext().getOut().println(table_content);        
    }
    
}
