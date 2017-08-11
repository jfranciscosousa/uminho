/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.servlets;

import dados.modelos.Album;
import dados.modelos.Artista;
import dados.modelos.Musica;
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
@WebServlet(name = "CreateMusica", urlPatterns = {"/musicas/new"})
public class CreateMusica extends HttpServlet {

    @EJB
    private GestorMusicaLocal gm;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RequestDispatcher rd = request.getRequestDispatcher("/newmusica.jsp");
            request.setAttribute("albums", gm.getAlbums());
            rd.forward(request, response);
        } catch (PersistentException ex) {
            Logger.getLogger(CreateMusica.class.getName()).log(Level.SEVERE, null, ex);
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
            String titulo = request.getParameter("titulo");
            long duracao = Long.parseLong(request.getParameter("duracao"));
            int idAlbum = Integer.parseInt(request.getParameter("album"));
            
            Album album = gm.getAlbum(idAlbum);
            Musica musica = new Musica(titulo, duracao);
            album.addMusica(musica);
            gm.saveAlbum(album);
            response.sendRedirect("/musicas");
        } catch (PersistentException ex) {
            Logger.getLogger(CreateMusica.class.getName()).log(Level.SEVERE, null, ex);
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
