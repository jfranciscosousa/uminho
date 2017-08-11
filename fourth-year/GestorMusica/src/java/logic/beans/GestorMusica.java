/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.beans;

import dados.hibernate.DAO.AlbumPDAO;
import dados.hibernate.DAO.ArtistaPDAO;
import dados.hibernate.DAO.MusicaPDAO;
import dados.hibernate.criteria.AlbumPCriteria;
import dados.hibernate.criteria.ArtistaPCriteria;
import dados.hibernate.criteria.MusicaPCriteria;
import dados.modelos.Album;
import dados.modelos.Artista;
import dados.modelos.Musica;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import javax.ejb.Stateless;
import org.orm.PersistentException;

/**
 *
 * @author jose
 */
@Stateless
public class GestorMusica implements GestorMusicaLocal, Serializable {

    private static final long serialVersionUID = 2L;

    @Override
    public void saveAlbum(Album album) throws PersistentException {
        AlbumPDAO.save(album);
    }

    @Override
    public void saveArtista(Artista artista) throws PersistentException {
        ArtistaPDAO.save(artista);
    }

    @Override
    public Artista getArtista(int id) throws PersistentException {
        return ArtistaPDAO.getArtistaPByORMID(id);
    }

    @Override
    public Album getAlbum(int id) throws PersistentException {
        return AlbumPDAO.getAlbumPByORMID(id);
    }

    @Override
    public Collection<Artista> getArtistas() throws PersistentException {
        return Arrays.asList(ArtistaPDAO.listArtistaPByCriteria(new ArtistaPCriteria()));
    }

    @Override
    public Collection<Album> getAlbums() throws PersistentException {
        return Arrays.asList(AlbumPDAO.listAlbumPByCriteria(new AlbumPCriteria()));
    }

    @Override
    public Collection<Musica> getMusicas() throws PersistentException {
        return Arrays.asList(MusicaPDAO.listMusicaPByCriteria(new MusicaPCriteria()));
    }
}
