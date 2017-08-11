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
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "MusicaP")
@XmlRootElement
public class Musica implements Serializable {

    public Musica() {
    }

    public Musica(String titulo, long duracao) {
        this.titulo = titulo;
        this.duracao = duracao;
    }

    @Column(name = "ID", nullable = false, length = 10)
    @Id
    @GeneratedValue(generator = "MUSICAP_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "MUSICAP_ID_GENERATOR", strategy = "native")
    private int ID;

    @Column(name = "Titulo", nullable = true, length = 255)
    private String titulo;

    @Column(name = "Duracao", nullable = false, length = 19)
    private long duracao;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "AlbumPID", nullable = false, updatable = false, insertable = false)})
    private Album album;

    private void setID(int value) {
        this.ID = value;
    }

    public int getID() {
        return ID;
    }

    public int getORMID() {
        return getID();
    }

    public void setTitulo(String value) {
        this.titulo = value;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setDuracao(long value) {
        this.duracao = value;
    }

    public long getDuracao() {
        return duracao;
    }

    public Album getAlbum() {
        return album;
    }

    @Override
    public String toString() {
        return "ID=" + ID + ", titulo=" + titulo + ", duracao=" + duracao;
    }

}
