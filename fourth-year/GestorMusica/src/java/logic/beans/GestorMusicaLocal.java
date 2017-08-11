/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.beans;

import dados.modelos.Album;
import dados.modelos.Artista;
import dados.modelos.Musica;
import java.util.Collection;
import javax.ejb.Local;
import org.orm.PersistentException;

/**
 *
 * @author jose
 */
@Local
public interface GestorMusicaLocal {

    public void saveArtista(Artista artista) throws PersistentException;
    
    public void saveAlbum(Album album) throws PersistentException;

    public Artista getArtista(int id) throws PersistentException;

    public Album getAlbum(int id) throws PersistentException;

    public Collection<Artista> getArtistas() throws PersistentException;

    public Collection<Album> getAlbums() throws PersistentException;

    public Collection<Musica> getMusicas() throws PersistentException;
}
