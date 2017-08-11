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
import dados.hibernate.criteria.AlbumPCriteria;
import dados.hibernate.GestorMusicaPersistentManager;
import dados.modelos.Album;
import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class AlbumPDAO {
	public static Album loadAlbumPByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return loadAlbumPByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Album getAlbumPByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return getAlbumPByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Album loadAlbumPByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return loadAlbumPByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Album getAlbumPByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return getAlbumPByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Album loadAlbumPByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Album) session.load(Album.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Album getAlbumPByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Album) session.get(Album.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Album loadAlbumPByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Album) session.load(Album.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Album getAlbumPByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Album) session.get(Album.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAlbumP(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return queryAlbumP(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAlbumP(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return queryAlbumP(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Album[] listAlbumPByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return listAlbumPByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Album[] listAlbumPByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return listAlbumPByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAlbumP(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From AlbumP as AlbumP");
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
	
	public static List queryAlbumP(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From AlbumP as AlbumP");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("AlbumP", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Album[] listAlbumPByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryAlbumP(session, condition, orderBy);
			return (Album[]) list.toArray(new Album[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Album[] listAlbumPByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryAlbumP(session, condition, orderBy, lockMode);
			return (Album[]) list.toArray(new Album[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Album loadAlbumPByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return loadAlbumPByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Album loadAlbumPByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return loadAlbumPByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Album loadAlbumPByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Album[] albumPs = listAlbumPByQuery(session, condition, orderBy);
		if (albumPs != null && albumPs.length > 0)
			return albumPs[0];
		else
			return null;
	}
	
	public static Album loadAlbumPByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Album[] albumPs = listAlbumPByQuery(session, condition, orderBy, lockMode);
		if (albumPs != null && albumPs.length > 0)
			return albumPs[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateAlbumPByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return iterateAlbumPByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAlbumPByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return iterateAlbumPByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAlbumPByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From AlbumP as AlbumP");
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
	
	public static java.util.Iterator iterateAlbumPByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From AlbumP as AlbumP");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("AlbumP", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Album createAlbumP() {
		return new Album();
	}
	
	public static boolean save(Album albumP) throws PersistentException {
		try {
			GestorMusicaPersistentManager.instance().saveObject(albumP);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Album albumP) throws PersistentException {
		try {
			GestorMusicaPersistentManager.instance().deleteObject(albumP);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(Album albumP) throws PersistentException {
		try {
			GestorMusicaPersistentManager.instance().getSession().refresh(albumP);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Album albumP) throws PersistentException {
		try {
			GestorMusicaPersistentManager.instance().getSession().evict(albumP);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Album loadAlbumPByCriteria(AlbumPCriteria albumPCriteria) {
		Album[] albumPs = listAlbumPByCriteria(albumPCriteria);
		if(albumPs == null || albumPs.length == 0) {
			return null;
		}
		return albumPs[0];
	}
	
	public static Album[] listAlbumPByCriteria(AlbumPCriteria albumPCriteria) {
		return albumPCriteria.listAlbumP();
	}
}
