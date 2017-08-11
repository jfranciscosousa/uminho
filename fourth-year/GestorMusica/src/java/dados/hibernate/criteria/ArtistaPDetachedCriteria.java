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
import dados.hibernate.criteria.AlbumPDetachedCriteria;
import dados.hibernate.criteria.ArtistaPCriteria;
import dados.modelos.Artista;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ArtistaPDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	public final StringExpression morada;
	public final CollectionExpression album;
	
	public ArtistaPDetachedCriteria() {
		super(Artista.class, ArtistaPCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		morada = new StringExpression("morada", this.getDetachedCriteria());
		album = new CollectionExpression("ORM_album", this.getDetachedCriteria());
	}
	
	public ArtistaPDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ArtistaPCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		morada = new StringExpression("morada", this.getDetachedCriteria());
		album = new CollectionExpression("ORM_album", this.getDetachedCriteria());
	}
	
	public AlbumPDetachedCriteria createAlbumCriteria() {
		return new AlbumPDetachedCriteria(createCriteria("ORM_album"));
	}
	
	public Artista uniqueArtistaP(PersistentSession session) {
		return (Artista) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Artista[] listArtistaP(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Artista[]) list.toArray(new Artista[list.size()]);
	}
}

