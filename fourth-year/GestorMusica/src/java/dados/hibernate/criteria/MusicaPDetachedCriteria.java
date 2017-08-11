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
import dados.modelos.Musica;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class MusicaPDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression titulo;
	public final LongExpression duracao;
	
	public MusicaPDetachedCriteria() {
		super(Musica.class, MusicaPCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
		duracao = new LongExpression("duracao", this.getDetachedCriteria());
	}
	
	public MusicaPDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, MusicaPCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
		duracao = new LongExpression("duracao", this.getDetachedCriteria());
	}
	
	public Musica uniqueMusicaP(PersistentSession session) {
		return (Musica) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Musica[] listMusicaP(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Musica[]) list.toArray(new Musica[list.size()]);
	}
}

