package org.gerdoc.servlet;

import org.gerdoc.model.Rol;
import org.gerdoc.service.RolService;
import org.gerdoc.service.impl.RolServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

@WebServlet("/RolServlet")
public class RolServlet extends HttpServlet
{
    @Serial
    private static final long serialVersionUID = 1L;
    private final RolService rolService = new RolServiceImpl( );

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String accion = req.getParameter("accion");
        if ("delete".equals(accion))
        {
            Long id = Long.parseLong(req.getParameter("id"));
            rolService.deleteById(id);
            resp.sendRedirect("Rols.jsp");
            return;
        }
        String nombre = req.getParameter("nombre" );
        String descripcion = req.getParameter("descripcion" );
        Long id = Long.parseLong( req.getParameter("id" ) );

        Rol rol = Rol.builder( )
                .nombre( nombre )
                .descripcion( descripcion )
                .build();
        if( "update".equals(accion) )
        {
            rol.setId( id );
            rolService.update( rol );
        }
        else
        {
            rolService.save( rol );
        }
        resp.sendRedirect("Rols.jsp");
    }
}
