package dados.modelos;

/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 *
 * This is an automatic generated file. It will be regenerated every time you
 * generate persistence class.
 *
 * Modifying its content may cause the program not work, or your work may lost.
 */
/**
 * Licensee: Universidade do Minho License Type: Academic
 */
import dados.hibernate.ORMConstants;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "ArtistaP")
@XmlRootElement
public class Artista implements Serializable {

    public Artista() {
    }

    public Artista(String nome, String morada) {
        this.nome = nome;
        this.morada = morada;
    }

    private java.util.Set this_getSet(int key) {
        if (key == ORMConstants.KEY_ARTISTAP_ALBUM) {
            return ORM_album;
        }

        return null;
    }

    @Transient
    org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
        public java.util.Set getSet(int key) {
            return this_getSet(key);
        }

    };

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "ARTISTAP_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "ARTISTAP_ID_GENERATOR", strategy = "native")
    private int ID;

    @Column(name = "Nome", nullable = true, length = 255, unique = true)
    private String nome;

    @Column(name = "Morada", nullable = true, length = 255)
    private String morada;

    @OneToMany(orphanRemoval = true, targetEntity = Album.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
    @JoinColumns({
        @JoinColumn(name = "ArtistaPID", nullable = false)})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set ORM_album = new java.util.HashSet();

    private void setID(int value) {
        this.ID = value;
    }

    public int getID() {
        return ID;
    }

    public int getORMID() {
        return getID();
    }

    public void setNome(String value) {
        this.nome = value;
    }

    public String getNome() {
        return nome;
    }

    public void setMorada(String value) {
        this.morada = value;
    }

    public String getMorada() {
        return morada;
    }

    private void setORM_Album(java.util.Set value) {
        this.ORM_album = value;
    }

    private java.util.Set getORM_Album() {
        return ORM_album;
    }

    public void addAlbum(Album album) {
        this.ORM_album.add(album);
    }

    public Set<Album> getAlbuns() {
        return new LinkedHashSet(this.ORM_album);
    }

    @Transient
    public final AlbumSetCollection album = new AlbumSetCollection(this, _ormAdapter, ORMConstants.KEY_ARTISTAP_ALBUM, ORMConstants.KEY_MUL_ONE_TO_MANY);

    @Override
    public String toString() {
        return "nome=" + nome + ", morada=" + morada;
    }

}
