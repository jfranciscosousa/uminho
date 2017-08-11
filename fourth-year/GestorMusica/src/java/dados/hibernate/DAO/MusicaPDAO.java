package dados.hibernate.DAO;

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
import dados.hibernate.criteria.MusicaPCriteria;
import dados.modelos.Musica;
import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class MusicaPDAO {
	public static Musica loadMusicaPByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return loadMusicaPByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Musica getMusicaPByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return getMusicaPByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Musica loadMusicaPByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return loadMusicaPByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Musica getMusicaPByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return getMusicaPByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Musica loadMusicaPByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Musica) session.load(Musica.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Musica getMusicaPByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Musica) session.get(Musica.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Musica loadMusicaPByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Musica) session.load(Musica.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Musica getMusicaPByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Musica) session.get(Musica.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMusicaP(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return queryMusicaP(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMusicaP(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return queryMusicaP(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Musica[] listMusicaPByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return listMusicaPByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Musica[] listMusicaPByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return listMusicaPByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMusicaP(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From MusicaP as MusicaP");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryMusicaP(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From MusicaP as MusicaP");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("MusicaP", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Musica[] listMusicaPByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryMusicaP(session, condition, orderBy);
			return (Musica[]) list.toArray(new Musica[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Musica[] listMusicaPByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryMusicaP(session, condition, orderBy, lockMode);
			return (Musica[]) list.toArray(new Musica[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Musica loadMusicaPByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return loadMusicaPByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Musica loadMusicaPByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return loadMusicaPByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Musica loadMusicaPByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Musica[] musicaPs = listMusicaPByQuery(session, condition, orderBy);
		if (musicaPs != null && musicaPs.length > 0)
			return musicaPs[0];
		else
			return null;
	}
	
	public static Musica loadMusicaPByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Musica[] musicaPs = listMusicaPByQuery(session, condition, orderBy, lockMode);
		if (musicaPs != null && musicaPs.length > 0)
			return musicaPs[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateMusicaPByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return iterateMusicaPByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMusicaPByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return iterateMusicaPByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMusicaPByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From MusicaP as MusicaP");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMusicaPByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From MusicaP as MusicaP");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("MusicaP", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Musica createMusicaP() {
		return new Musica();
	}
	
	public static boolean save(Musica musicaP) throws PersistentException {
		try {
			GestorMusicaPersistentManager.instance().saveObject(musicaP);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Musica musicaP) throws PersistentException {
		try {
			GestorMusicaPersistentManager.instance().deleteObject(musicaP);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(Musica musicaP) throws PersistentException {
		try {
			GestorMusicaPersistentManager.instance().getSession().refresh(musicaP);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Musica musicaP) throws PersistentException {
		try {
			GestorMusicaPersistentManager.instance().getSession().evict(musicaP);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Musica loadMusicaPByCriteria(MusicaPCriteria musicaPCriteria) {
		Musica[] musicaPs = listMusicaPByCriteria(musicaPCriteria);
		if(musicaPs == null || musicaPs.length == 0) {
			return null;
		}
		return musicaPs[0];
	}
	
	public static Musica[] listMusicaPByCriteria(MusicaPCriteria musicaPCriteria) {
		return musicaPCriteria.listMusicaP();
	}
}
