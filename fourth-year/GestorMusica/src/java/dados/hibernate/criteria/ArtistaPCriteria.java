package dados.hibernate.criteria;

/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universidade do Minho
 * License Type: Academic
 */
import dados.hibernate.GestorMusicaPersistentManager;
import dados.modelos.Artista;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ArtistaPCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	public final StringExpression morada;
	public final CollectionExpression album;
	
	public ArtistaPCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nome = new StringExpression("nome", this);
		morada = new StringExpression("morada", this);
		album = new CollectionExpression("ORM_album", this);
	}
	
	public ArtistaPCriteria(PersistentSession session) {
		this(session.createCriteria(Artista.class));
	}
	
	public ArtistaPCriteria() throws PersistentException {
		this(GestorMusicaPersistentManager.instance().getSession());
	}
	
	public AlbumPCriteria createAlbumCriteria() {
		return new AlbumPCriteria(createCriteria("ORM_album"));
	}
	
	public Artista uniqueArtistaP() {
		return (Artista) super.uniqueResult();
	}
	
	public Artista[] listArtistaP() {
		java.util.List list = super.list();
		return (Artista[]) list.toArray(new Artista[list.size()]);
	}
}

