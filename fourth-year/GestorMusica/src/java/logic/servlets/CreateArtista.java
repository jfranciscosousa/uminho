/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.servlets;

import dados.modelos.Artista;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.beans.GestorMusicaLocal;
import org.orm.PersistentException;

/**
 *
 * @author jose
 */
@WebServlet(name = "CreateArtista", urlPatterns = {"/artistas/new"})
public class CreateArtista extends HttpServlet {

    @EJB
    private GestorMusicaLocal gm;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher("/newartista.html");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String nome = req.getParameter("nome");
            String morada = req.getParameter("morada");
            Artista artista = new Artista(nome, morada);
            gm.saveArtista(artista);
            resp.sendRedirect("/artistas");
        } catch (PersistentException ex) {            
            Logger.getLogger(CreateArtista.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServletException(ex);
        }
    }

    
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
