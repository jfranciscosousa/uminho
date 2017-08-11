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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "AlbumP")
@XmlRootElement
public class Album implements Serializable {

    public Album() {
    }

    public Album(String nome, int ano) {
        this.nome = nome;
        this.ano = ano;
    }

    private java.util.Set this_getSet(int key) {
        if (key == ORMConstants.KEY_ALBUMP_MUSICA) {
            return ORM_musica;
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
    @GeneratedValue(generator = "ALBUMP_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "ALBUMP_ID_GENERATOR", strategy = "native")
    private int ID;

    @Column(name = "Nome", nullable = true, length = 255)
    private String nome;

    @Column(name = "Ano", nullable = false, length = 10)
    private int ano;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "ArtistaPID", nullable = false, updatable = false, insertable = false)})
    private Artista artista;

    @OneToMany(orphanRemoval = true, targetEntity = Musica.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
    @JoinColumns({
        @JoinColumn(name = "AlbumPID", nullable = false)})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set ORM_musica = new java.util.HashSet();

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

    public void setAno(int value) {
        this.ano = value;
    }

    public int getAno() {
        return ano;
    }

    private void setORM_Musica(java.util.Set value) {
        this.ORM_musica = value;
    }

    private java.util.Set getORM_Musica() {
        return ORM_musica;
    }

    public List<Musica> getMusicas() {
        return new ArrayList<>(this.ORM_musica);
    }

    public void addMusica(Musica musica) {
        this.ORM_musica.add(musica);
    }

    public Artista getArtista() {
        return artista;
    }

    @Transient
    public final MusicaSetCollection musica = new MusicaSetCollection(this, _ormAdapter, ORMConstants.KEY_ALBUMP_MUSICA, ORMConstants.KEY_MUL_ONE_TO_MANY);

    @Override
    public String toString() {
        return "AlbumP{" + "ID=" + ID + ", nome=" + nome + ", ano=" + ano + '}';
    }

}
