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
import dados.modelos.Musica;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class MusicaPCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression titulo;
	public final LongExpression duracao;
	
	public MusicaPCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		titulo = new StringExpression("titulo", this);
		duracao = new LongExpression("duracao", this);
	}
	
	public MusicaPCriteria(PersistentSession session) {
		this(session.createCriteria(Musica.class));
	}
	
	public MusicaPCriteria() throws PersistentException {
		this(GestorMusicaPersistentManager.instance().getSession());
	}
	
	public Musica uniqueMusicaP() {
		return (Musica) super.uniqueResult();
	}
	
	public Musica[] listMusicaP() {
		java.util.List list = super.list();
		return (Musica[]) list.toArray(new Musica[list.size()]);
	}
}

