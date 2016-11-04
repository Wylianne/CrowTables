/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import AcessoDados.AcessoCliente;
import AcessoDados.AcessoInstrumento;
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
    private String list, modal="";
    private String presentedOnTable;
    String[] tbody;
    String table_content="<tbody>";
    String table_b ="<tr>";
    String[][] t_body;
    String id_table, table;
    ResultSetMetaData rsmd, titulos;
    ResultSet res_modal = null;
    int numCol;
    
    
    public void setList(String list) {
        this.list = list;
    }

    public void setPresentedOnTable(String presentedOnTable) {
        this.presentedOnTable = presentedOnTable;
    }    
    
    public void doTag() throws IOException, JspException{
        try {
            switch (list) {
                case "listaPessoas":
                        
                        t_body = new String[8][2]; 
                        t_body[0][0] = "id";
                        t_body[0][1] = "Detalhes";
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
                        AcessoCliente cliente = new AcessoCliente();
                        if (presentedOnTable!=null){
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
                        rsmd = (ResultSetMetaData) res.getMetaData();  
                        numCol = rsmd.getColumnCount()+1; 
                        
                        //Nomes das colunas do banco de dados
                        titulos = (ResultSetMetaData) res.getMetaData();
                        
                        table_content = Content(res, presentedOnTable, id_table);
                        
                        //Monta titulos
                        for (int i = 1; i < numCol; i++) {
                            for (String[] t_body1 : t_body) {
                                if (titulos.getColumnName(i).equals(t_body1[0])) {
                                    table_b += "<th>" + t_body1[1] +"</th>";
                                }
                            }
                        }

                        table_b = table_b+"</tr>";
                        
                        if(presentedOnTable!=null){  
                            res_modal = cliente.Modal();
                            //Verifica quantidade de colunas
                            modal = MontaModal(res_modal, presentedOnTable, id_table, t_body);
                        }else{
                            modal ="";
                        }
                break;      
                case "listaInstrumento":
                        t_body = new String[8][2]; 
                        t_body[0][0] = "id";
                        t_body[0][1] = "Detalhes";
                        t_body[1][0] = "nome";
                        t_body[1][1] = "Nome";
                        t_body[2][0] = "descricao";
                        t_body[2][1] = "Descrição";
                        
                        AcessoInstrumento instrumento = new AcessoInstrumento();
                        if (presentedOnTable!=null){
                            //retorna somente o que esta presente em presentOnTable e id.
                            String filter = presentedOnTable.replace(';', ',');
                            res = instrumento.Lista(filter);
                            String tabela = list;
                            filter = filter.replace(',', '-');
                            id_table = tabela+filter;
                            
                        }else{
                            res = instrumento.Lista();
                            String tabela = list;
                            id_table = tabela;
                            
                        }
                        
                        //Verifica quantidade de colunas
                        rsmd = (ResultSetMetaData) res.getMetaData();  
                        numCol = rsmd.getColumnCount()+1; 
                        
                        //Nomes das colunas do banco de dados
                        titulos = (ResultSetMetaData) res.getMetaData();
                        
                        table_content = Content(res, presentedOnTable, id_table);
                        
                        if(presentedOnTable!=null){  
                            res_modal = instrumento.Modal();
                            modal = MontaModal(res_modal, presentedOnTable, id_table, t_body);
                        }else{
                            modal ="";
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
                        
                        
                        
            }   
            table = Table(table_b, table_content, id_table, modal);
        } catch (Exception ex) {
            Logger.getLogger(SimpleTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        getJspContext().getOut().println(table);
    }
    
    
    public String MontaModal(ResultSet res_modal, String presentedOnTable, String id_table,  String[][] t_body)throws Exception{
        String modal="";
        
        ResultSetMetaData rsmd = (ResultSetMetaData) res_modal.getMetaData();  
        int numCol = rsmd.getColumnCount()+1;

        while (res_modal.next()) {
            //Monta conteudo
            modal += modal;
            for (int j = 1; j < numCol; j++) {
                if (j == 1){
                    modal += "<div id='"+res_modal.getString(j)+id_table+"' class='modal fade' role='dialog'><div class='modal-dialog'><div class='modal-content'><div class='modal-header'><button type='button' class='close' data-dismiss='modal'>&times;</button><h4 class='modal-title'>Detalhes</h4></div><div class='modal-body'>"; 
                }else{
                    modal += "<p><b>"+t_body[j-1][1]+": </b>"+res_modal.getString(j)+"</p>"; 
                }
            }
            modal += "</div><div class='modal-footer'><button type='button' class='btn btn-default' data-dismiss='modal'>Fechar</button></div></div></div></div>";
        }                         
        
        return modal;
    }
        
        
    
    //Monta dados
    public String Content(ResultSet res, String presentedOnTable, String id_table)throws Exception{
        String table_content="";
        
        java.sql.ResultSetMetaData rsmd = res.getMetaData();  
        int numCol = rsmd.getColumnCount()+1;

        while (res.next()) {
            //Monta conteudo
            table_content += "<tr>";
            for (int j = 1; j < numCol; j++) {
                if ((presentedOnTable!=null) && (j == numCol-1)){
                    table_content += "<td><button type='button' class='btn btn-default' data-toggle='modal' data-target='#"+res.getString(j)+id_table+"'>"
                            + "<span class='glyphicon glyphicon-search'></span></button></td>"; 
                }else{
                    table_content += "<td style='vertical-align: middle;'>"+res.getString(j)+"</td>"; 
                }

            }
            table_content += "</tr>";                            
        }
        return table_content;
    }    

    //Monta tabela
    public String Table(String table_b, String table_content, String id_table, String modal)throws Exception{
        String table="";
        

        table = "<table id='"+id_table+"' class='table table-striped table-bordered'>"
                + "<thead>"+table_b+"</thead>"
                + "<tfoot>"+table_b+"</tfoot>"+table_content+"</table>"+modal
                + "<script>\n" 
                + "            $(document).ready(function(){" 
                + "                $('#"+id_table+"').DataTable({\n" +
"        \"language\": {\n" +
"            \"lengthMenu\": \"_MENU_ resultados por página\",\n" +
"            \"zeroRecords\": \"Nenhum registro encontrado\",\n" +
"            \"info\": \"Mostrando de _START_ até _END_ de _TOTAL_ registros\",\n" +
"            \"infoEmpty\": \"Nenhum registro encontrado\",\n" +
"            \"infoFiltered\": \"(Filtrados de _MAX_ registros)\",\n" +
"            \"search\": \"Pesquisar \","+
"            \"oPaginate\": {\n" +
"                   \"sNext\": \"Próximo\",\n" +
"                   \"sPrevious\": \"Anterior\",\n" +
"                   \"sFirst\": \"Primeiro\",\n" +
"                   \"sLast\": \"Último\"\n" +
"            }"+
"        }\n" +
"    })});" 
                + "</script>";
        
        return table;
    }
}
