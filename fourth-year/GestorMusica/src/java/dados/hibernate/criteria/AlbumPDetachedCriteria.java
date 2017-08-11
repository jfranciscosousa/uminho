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
import dados.modelos.Album;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class AlbumPDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	public final IntegerExpression ano;
	public final CollectionExpression musica;
	
	public AlbumPDetachedCriteria() {
		super(Album.class, AlbumPCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		ano = new IntegerExpression("ano", this.getDetachedCriteria());
		musica = new CollectionExpression("ORM_musica", this.getDetachedCriteria());
	}
	
	public AlbumPDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, AlbumPCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		ano = new IntegerExpression("ano", this.getDetachedCriteria());
		musica = new CollectionExpression("ORM_musica", this.getDetachedCriteria());
	}
	
	public MusicaPDetachedCriteria createMusicaCriteria() {
		return new MusicaPDetachedCriteria(createCriteria("ORM_musica"));
	}
	
	public Album uniqueAlbumP(PersistentSession session) {
		return (Album) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Album[] listAlbumP(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Album[]) list.toArray(new Album[list.size()]);
	}
}

