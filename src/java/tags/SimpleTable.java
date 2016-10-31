/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import java.io.IOException;
import java.io.StringWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Wylianne
 */
public class SimpleTable extends SimpleTagSupport{
    private String value;

    public void setValue(String value) {
        this.value = value;
    }
      
    
    public void doTag() throws IOException, JspException{
        String[] tbody;
       
        switch (value) {
            case "5":
                tbody = new String[2];
                tbody[0] = "Nome";
                tbody[1] = "Telefone";
                break;
            default:
                tbody = new String[3];
                tbody[0] = "Apelido";
                tbody[1] = "CPF";
                tbody[2] = "Email";    

   
        }
        
        
        StringWriter write = new StringWriter();
         
        String table_b ="<tr>";
       
        for (int i = 0; i < tbody.length; i++) {
            if(tbody[i] == ""){
                break;
            }
            table_b += "<th>"+tbody[i]+"</th>";
        }
        
        table_b = table_b+"</tr>";
        
        getJspBody().invoke(write);
    
        getJspContext().getOut().println("<table id='"+value+"' class='table table-striped table-bordered'>"
                + "<thead>"+table_b+"</thead>"
                + "<tfoot>"+table_b+"</tfoot>"+write.toString()+"</table>"
                + "<script>\n" 
                + "            $(document).ready(function(){\n" 
                + "                $('#"+value+"').DataTable();});\n" 
                + "</script>");
    }
    
}
