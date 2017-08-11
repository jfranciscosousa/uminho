/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.servlets;

import dados.modelos.Album;
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
@WebServlet(name = "CreateAlbum", urlPatterns = {"/albums/new"})
public class CreateAlbum extends HttpServlet {

    @EJB
    private GestorMusicaLocal gm;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RequestDispatcher rd = request.getRequestDispatcher("/newalbum.jsp");
            request.setAttribute("artistas", gm.getArtistas());
            rd.forward(request, response);
        } catch (PersistentException ex) {
            Logger.getLogger(CreateAlbum.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServletException(ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String nome = request.getParameter("nome");
            int ano = Integer.parseInt(request.getParameter("ano"));
            int idArtista = Integer.parseInt(request.getParameter("artista"));
            
            Artista artista = gm.getArtista(idArtista);
            Album album = new Album(nome, ano);
            artista.addAlbum(album);
            gm.saveArtista(artista);
            response.sendRedirect("/albums");
        } catch (PersistentException ex) {
            Logger.getLogger(CreateAlbum.class.getName()).log(Level.SEVERE, null, ex);
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
