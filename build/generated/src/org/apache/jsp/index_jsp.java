package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/tlds/CrowTable.tld");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\">\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <script src=\"//code.jquery.com/jquery-1.12.3.js\"></script>\n");
      out.write("        <script src=\"https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>                \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            ");
      if (_jspx_meth_basico_simpleTable_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            \n");
      out.write("            <hr>\n");
      out.write("            <hr>\n");
      out.write("            ");
      if (_jspx_meth_basico_simpleTable_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("            \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_basico_simpleTable_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  basico:simpleTable
    tags.SimpleTable _jspx_th_basico_simpleTable_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(tags.SimpleTable.class) : new tags.SimpleTable();
    _jspx_th_basico_simpleTable_0.setJspContext(_jspx_page_context);
    _jspx_th_basico_simpleTable_0.setValue("5");
    _jspx_th_basico_simpleTable_0.setJspBody(new index_jspHelper( 0, _jspx_page_context, _jspx_th_basico_simpleTable_0, null));
    _jspx_th_basico_simpleTable_0.doTag();
    return false;
  }

  private boolean _jspx_meth_basico_simpleContentTable_0(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  basico:simpleContentTable
    tags.SimpleContentTable _jspx_th_basico_simpleContentTable_0 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(tags.SimpleContentTable.class) : new tags.SimpleContentTable();
    _jspx_th_basico_simpleContentTable_0.setJspContext(_jspx_page_context);
    _jspx_th_basico_simpleContentTable_0.setParent(_jspx_parent);
    _jspx_th_basico_simpleContentTable_0.setValue("5");
    _jspx_th_basico_simpleContentTable_0.setJspBody(new index_jspHelper( 1, _jspx_page_context, _jspx_th_basico_simpleContentTable_0, null));
    _jspx_th_basico_simpleContentTable_0.doTag();
    return false;
  }

  private boolean _jspx_meth_basico_simpleTable_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  basico:simpleTable
    tags.SimpleTable _jspx_th_basico_simpleTable_1 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(tags.SimpleTable.class) : new tags.SimpleTable();
    _jspx_th_basico_simpleTable_1.setJspContext(_jspx_page_context);
    _jspx_th_basico_simpleTable_1.setValue("4");
    _jspx_th_basico_simpleTable_1.setJspBody(new index_jspHelper( 2, _jspx_page_context, _jspx_th_basico_simpleTable_1, null));
    _jspx_th_basico_simpleTable_1.doTag();
    return false;
  }

  private boolean _jspx_meth_basico_simpleContentTable_1(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  basico:simpleContentTable
    tags.SimpleContentTable _jspx_th_basico_simpleContentTable_1 = (_jspx_resourceInjector != null) ? _jspx_resourceInjector.createTagHandlerInstance(tags.SimpleContentTable.class) : new tags.SimpleContentTable();
    _jspx_th_basico_simpleContentTable_1.setJspContext(_jspx_page_context);
    _jspx_th_basico_simpleContentTable_1.setParent(_jspx_parent);
    _jspx_th_basico_simpleContentTable_1.setValue("4");
    _jspx_th_basico_simpleContentTable_1.setJspBody(new index_jspHelper( 3, _jspx_page_context, _jspx_th_basico_simpleContentTable_1, null));
    _jspx_th_basico_simpleContentTable_1.doTag();
    return false;
  }

  private class index_jspHelper
      extends org.apache.jasper.runtime.JspFragmentHelper
  {
    private javax.servlet.jsp.tagext.JspTag _jspx_parent;
    private int[] _jspx_push_body_count;

    public index_jspHelper( int discriminator, JspContext jspContext, javax.servlet.jsp.tagext.JspTag _jspx_parent, int[] _jspx_push_body_count ) {
      super( discriminator, jspContext, _jspx_parent );
      this._jspx_parent = _jspx_parent;
      this._jspx_push_body_count = _jspx_push_body_count;
    }
    public boolean invoke0( JspWriter out ) 
      throws Throwable
    {
      out.write("\n");
      out.write("                ");
      if (_jspx_meth_basico_simpleContentTable_0((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      out.write("\n");
      out.write("            ");
      return false;
    }
    public boolean invoke1( JspWriter out ) 
      throws Throwable
    {
      out.write("\n");
      out.write("                ");
      return false;
    }
    public boolean invoke2( JspWriter out ) 
      throws Throwable
    {
      out.write("\n");
      out.write("                ");
      if (_jspx_meth_basico_simpleContentTable_1((javax.servlet.jsp.tagext.JspTag) _jspx_parent, _jspx_page_context))
        return true;
      out.write("\n");
      out.write("            ");
      return false;
    }
    public boolean invoke3( JspWriter out ) 
      throws Throwable
    {
      out.write("\n");
      out.write("                ");
      return false;
    }
    public void invoke( java.io.Writer writer )
      throws JspException
    {
      JspWriter out = null;
      if( writer != null ) {
        out = this.jspContext.pushBody(writer);
      } else {
        out = this.jspContext.getOut();
      }
      try {
        switch( this.discriminator ) {
          case 0:
            invoke0( out );
            break;
          case 1:
            invoke1( out );
            break;
          case 2:
            invoke2( out );
            break;
          case 3:
            invoke3( out );
            break;
        }
      }
      catch( Throwable e ) {
        if (e instanceof SkipPageException)
            throw (SkipPageException) e;
        throw new JspException( e );
      }
      finally {
        if( writer != null ) {
          this.jspContext.popBody();
        }
      }
    }
  }
}
