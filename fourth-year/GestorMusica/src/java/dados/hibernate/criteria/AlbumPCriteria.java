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
import dados.modelos.Album;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class AlbumPCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression nome;
	public final IntegerExpression ano;
	public final CollectionExpression musica;
	
	public AlbumPCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		nome = new StringExpression("nome", this);
		ano = new IntegerExpression("ano", this);
		musica = new CollectionExpression("ORM_musica", this);
	}
	
	public AlbumPCriteria(PersistentSession session) {
		this(session.createCriteria(Album.class));
	}
	
	public AlbumPCriteria() throws PersistentException {
		this(GestorMusicaPersistentManager.instance().getSession());
	}
	
	public MusicaPCriteria createMusicaCriteria() {
		return new MusicaPCriteria(createCriteria("ORM_musica"));
	}
	
	public Album uniqueAlbumP() {
		return (Album) super.uniqueResult();
	}
	
	public Album[] listAlbumP() {
		java.util.List list = super.list();
		return (Album[]) list.toArray(new Album[list.size()]);
	}
}

