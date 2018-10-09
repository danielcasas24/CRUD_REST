package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.cliente.CRUD;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/styles.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/font-awesome-4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("\t<title>Inscripci&oacute;n de Asignaturas</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"col-md-7\">\n");
      out.write("                <h1>Inscripci&oacute;n de Asignaturas</h1>\n");
      out.write("                \n");
      out.write("                <h2>Inscribir asignaturas</h2>\n");
      out.write("                <form action=\"AccederDatos\" method=\"get\">\n");
      out.write("                    <input id=\"action\" name=\"action\" value=\"create\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-5\">Seleccione un estudiante:</div>\n");
      out.write("                        <div class=\"col-md-7\">\n");
      out.write("                            <select id=\"estudiante\" name=\"estudiante\">\n");
      out.write("                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${estudiante}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-5\">Seleccione una asignatura:</div>\n");
      out.write("                        <div class=\"col-md-7\">\n");
      out.write("                            <select id=\"asignatura\" name=\"asignatura\">\n");
      out.write("                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${asignatura}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-5\">Seleccione un profesor:</div>\n");
      out.write("                        <div class=\"col-md-7\">\n");
      out.write("                            <select id=\"profesor\" name=\"profesor\">\n");
      out.write("                                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${profesor}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-5\">Seleccione un horario:</div>\n");
      out.write("                        <div class=\"col-md-7\">\n");
      out.write("                            <select id=\"horario\" name=\"horario\">\n");
      out.write("                                <option value=\"Mañana\">Ma&ntilde;ana</option>\n");
      out.write("                                <option value=\"Tarde\">Tarde</option>\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <input type=\"submit\" value=\"Inscribir\" >\n");
      out.write("                </form>\n");
      out.write("                <hr/>\n");
      out.write("                \n");
      out.write("                <h2>Consultar asignaturas inscritas</h2>\n");
      out.write("                <form action=\"AccederDatos\" method=\"get\">\n");
      out.write("                    <input id=\"action\" name=\"action\" value=\"read\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-5\">Digite el ID:</div>\n");
      out.write("                        <div class=\"col-md-7\"><input id=\"idpp\" name=\"idpp\" type=\"text\" value=\"0\"></div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-5\">Seleccione una opci&oacute;n:</div>\n");
      out.write("                        <div class=\"col-md-7\">\n");
      out.write("                            <select id=\"operacion\" name=\"operacion\">\n");
      out.write("                                <option value=\"todo\" selected>Mostrar todas las inscripciones</option>\n");
      out.write("                                <option value=\"inscripcion\">Por n&uacute;mero de inscrpci&oacute;n</option>\n");
      out.write("                                <option value=\"asignatura\">Por c&oacute;digo de asignatura</option>\n");
      out.write("                                <option value=\"profesor\">Por c&oacute;digo de profesor</option>\n");
      out.write("                                <option value=\"estudiante\">Por c&oacute;digo de estudiante</option>\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <input type=\"submit\" value=\"Consultar\" >\n");
      out.write("                </form>\n");
      out.write("                <hr/>\n");
      out.write("                <h2>Actualizaci&oacute;n de Inscripci&oacute;n</h2>\n");
      out.write("                <form action=\"AccederDatos\" method=\"get\">\n");
      out.write("                    <input id=\"action\" name=\"action\" value=\"update\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-5\">Digite la inscripci&oacute;n a modificar:</div>\n");
      out.write("                        <div class=\"col-md-7\"><input id=\"idpp\" name=\"idpp\" type=\"text\" value=\"0\"></div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-5\">Seleccione el nuevo horario:</div>\n");
      out.write("                        <div class=\"col-md-7\">\n");
      out.write("                            <select id=\"operacion\" name=\"operacion\">\n");
      out.write("                                <option value=\"Mañana\" selected>Mañana</option>\n");
      out.write("                                <option value=\"Tarde\">Tarde</option>\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <input type=\"submit\" value=\"Actualizar\" >\n");
      out.write("                </form>\n");
      out.write("                <hr/>\n");
      out.write("                <h2>Eliminaci&oacute;n de Inscripci&oacute;n</h2>\n");
      out.write("                <form action=\"AccederDatos\" method=\"get\">\n");
      out.write("                    <input id=\"action\" name=\"action\" value=\"delete\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-5\">Digite la inscripci&oacute;n a eliminar:</div>\n");
      out.write("                        <div class=\"col-md-7\"><input id=\"idpp\" name=\"idpp\" type=\"text\" value=\"0\"></div>\n");
      out.write("                    </div>\n");
      out.write("                    <input type=\"submit\" value=\"Eliminar\" >\n");
      out.write("                </form>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-5\">\n");
      out.write("                <table class=\"table-bordered table-hover table-responsive text-center\">\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
}
