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
import dados.hibernate.criteria.ArtistaPCriteria;
import dados.hibernate.GestorMusicaPersistentManager;
import dados.modelos.Artista;
import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class ArtistaPDAO {
	public static Artista loadArtistaPByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return loadArtistaPByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Artista getArtistaPByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return getArtistaPByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Artista loadArtistaPByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return loadArtistaPByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Artista getArtistaPByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return getArtistaPByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Artista loadArtistaPByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Artista) session.load(Artista.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Artista getArtistaPByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Artista) session.get(Artista.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Artista loadArtistaPByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Artista) session.load(Artista.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Artista getArtistaPByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Artista) session.get(Artista.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryArtistaP(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return queryArtistaP(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryArtistaP(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return queryArtistaP(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Artista[] listArtistaPByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return listArtistaPByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Artista[] listArtistaPByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return listArtistaPByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryArtistaP(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From ArtistaP as ArtistaP");
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
	
	public static List queryArtistaP(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From ArtistaP as ArtistaP");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ArtistaP", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Artista[] listArtistaPByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryArtistaP(session, condition, orderBy);
			return (Artista[]) list.toArray(new Artista[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Artista[] listArtistaPByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryArtistaP(session, condition, orderBy, lockMode);
			return (Artista[]) list.toArray(new Artista[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Artista loadArtistaPByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return loadArtistaPByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Artista loadArtistaPByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return loadArtistaPByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Artista loadArtistaPByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Artista[] artistaPs = listArtistaPByQuery(session, condition, orderBy);
		if (artistaPs != null && artistaPs.length > 0)
			return artistaPs[0];
		else
			return null;
	}
	
	public static Artista loadArtistaPByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Artista[] artistaPs = listArtistaPByQuery(session, condition, orderBy, lockMode);
		if (artistaPs != null && artistaPs.length > 0)
			return artistaPs[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateArtistaPByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return iterateArtistaPByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateArtistaPByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = GestorMusicaPersistentManager.instance().getSession();
			return iterateArtistaPByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateArtistaPByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From ArtistaP as ArtistaP");
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
	
	public static java.util.Iterator iterateArtistaPByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From ArtistaP as ArtistaP");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ArtistaP", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Artista createArtistaP() {
		return new Artista();
	}
	
	public static boolean save(Artista artistaP) throws PersistentException {
		try {
			GestorMusicaPersistentManager.instance().saveObject(artistaP);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Artista artistaP) throws PersistentException {
		try {
			GestorMusicaPersistentManager.instance().deleteObject(artistaP);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(Artista artistaP) throws PersistentException {
		try {
			GestorMusicaPersistentManager.instance().getSession().refresh(artistaP);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Artista artistaP) throws PersistentException {
		try {
			GestorMusicaPersistentManager.instance().getSession().evict(artistaP);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Artista loadArtistaPByCriteria(ArtistaPCriteria artistaPCriteria) {
		Artista[] artistaPs = listArtistaPByCriteria(artistaPCriteria);
		if(artistaPs == null || artistaPs.length == 0) {
			return null;
		}
		return artistaPs[0];
	}
	
	public static Artista[] listArtistaPByCriteria(ArtistaPCriteria artistaPCriteria) {
		return artistaPCriteria.listArtistaP();
	}
}
