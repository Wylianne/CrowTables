/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import AcessoDados.AcessoDados;
import com.mysql.jdbc.ResultSetMetaData;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Wylianne
 */
public class SimpleTable extends SimpleTagSupport{
    private String list;
    private String presentedOnTable;
    String[] tbody;
    String table_content="<tbody>";
    String table_b ="<tr>";
    String[][] t_body;
    String id_table;
    
    public void setList(String list) {
        this.list = list;
    }

    public void setPresentedOnTable(String presentedOnTable) {
        this.presentedOnTable = presentedOnTable;
    }
      
    
    public void doTag() throws IOException, JspException{
        
       
        switch (list) {
            case "listaPessoas":
                try {
                        
                        t_body = new String[8][2]; 
                        t_body[0][0] = "id";
                        t_body[0][1] = "ID";
                        t_body[1][0] = "cpf";
                        t_body[1][1] = "CPF";
                        t_body[2][0] = "nome";
                        t_body[2][1] = "Nome";
                        t_body[3][0] = "identidade";
                        t_body[3][1] = "Identidade";
                        t_body[4][0] = "dataNascimento";
                        t_body[4][1] = "Data de Nascimento";
                        t_body[5][0] = "escolaridade";
                        t_body[5][1] = "Escolaridade";
                        t_body[6][0] = "endereco";
                        t_body[6][1] = "Endereço";
                        t_body[7][0] = "telefone";
                        t_body[7][1] = "Telefone";
                        
                        ResultSet res;
                        AcessoDados cliente = new AcessoDados();
                        if (presentedOnTable!=null){
                            //retorna somente o que esta presente em presentOnTable e id.
                            String filter = presentedOnTable.replace(';', ',');
                            res = cliente.Lista(filter);
                            String tabela = list;
                            filter = filter.replace(',', '-');
                            id_table = tabela+filter;
                        }else{
                            res = cliente.Lista();
                            String tabela = list;
                            id_table = tabela;
                        }
                        
                        
                        //Verifica quantidade de colunas
                        ResultSetMetaData rsmd = (ResultSetMetaData) res.getMetaData();  
                        int numCol = rsmd.getColumnCount()+1; 
                        
                        //Nomes das colunas
                        ResultSetMetaData titulos = (ResultSetMetaData) res.getMetaData();
                        
                        int q =0;
                        while (res.next()) {
                            //Monta conteudo
                            table_content += "<tr>";
                            for (int j = 1; j < numCol; j++) {
                                table_content += "<td>"+res.getString(j)+"</td>"; 
                            }
                            table_content += "</tr>";                            
                        }
                        
                        //Monta titulos
                        
                        for (int i = 1; i < numCol; i++) {
                            for (String[] t_body1 : t_body) {
                                if (titulos.getColumnName(i).equals(t_body1[0])) {
                                    table_b += "<th>" + t_body1[1] +"</th>";
                                }
                            }
                        }

                        table_b = table_b+"</tr>";
                        
                } catch (Exception ex) {
                    Logger.getLogger(SimpleTable.class.getName()).log(Level.SEVERE, null, ex);
                }

            
   
        }
        
        
        getJspContext().getOut().println("<table id='"+id_table+"' class='table table-striped table-bordered'>"
                + "<thead>"+table_b+"</thead>"
                + "<tfoot>"+table_b+"</tfoot>"+table_content+"</table>"
                + "<script>\n" 
                + "            $(document).ready(function(){\n" 
                + "                $('#"+id_table+"').DataTable();});\n" 
                + "</script>");
    }
    
}
