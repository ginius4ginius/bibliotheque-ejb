package modelEjb;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Adherent;
import model.Livre;
import model.Pret;

/**
 * @generated DT_ID=none
 */
@Stateless(name = "PretEjb", mappedName = "GestionBibliotheque-ejb-PretEjb")
public class PretEjb implements PretEjbLocal, PretEjbRemote {

	/**
	 * @generated DT_ID=none
	 */
	@Resource
	SessionContext sessionContext;

	/**
	 * @generated DT_ID=none
	 */
	@PersistenceContext(unitName = "GestionBibliotheque-ejb")
	private EntityManager em;

	/**
	 * @generated DT_ID=none
	 */
	public PretEjb() {
	}

	/**
	 * @generated DT_ID=none
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
		Query query = em.createQuery(jpqlStmt);
		if (firstResult > 0) {
			query = query.setFirstResult(firstResult);
		}
		if (maxResults > 0) {
			query = query.setMaxResults(maxResults);
		}

		return query.getResultList();
	}

	/**
	 * @generated DT_ID=none
	 */
	public Pret persistPret(Pret pret) {
		em.persist(pret);
		return pret;
	}

	/**
	 * @generated DT_ID=none
	 */
	public Pret mergePret(Pret pret) {
		return em.merge(pret);
	}

	/**
	 * @generated DT_ID=none
	 */
	public void removePret(Pret pret) {
		pret = em.find(Pret.class, pret.getNum());
		em.remove(pret);
	}

	/**
	 * @generated DT_ID=none
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Pret> getPretFindAll() {
		return em.createNamedQuery("Pret.findAll").getResultList();
	}

	/**
	 * Fonction retournant une liste d'une donnée ou vide .
	 */
	public boolean rechercheUnPret(Pret pret) {
		boolean result = false;
		List<Pret> liste = em.createQuery("SELECT x FROM Pret x WHERE x.datePret LIKE :date")
		.setParameter("date", pret.getDatePret()).getResultList();
		if (liste.size()!=0 ) {
			result = true;
		}

		return result;
		
	}

	/**
	 * fonction permettant de voir si un livre est emprunté.
	 */
	public boolean ifIsDisponible(Livre l) {
		boolean result = true;
		List<Pret> liste = em.createQuery("SELECT x FROM Pret x WHERE x.livre.titre LIKE :livre ")
				.setParameter("livre", l.getTitre()).getResultList();

		if (liste.size() == 0) {
			result = false;
		}

		return result;
	}

	/**
	 * fonction permettant d'inserer un pret selon condition d'acceptation.
	 */
	public Pret persistPret(Pret pret, Livre l, Adherent a) {

		boolean acceptation = AccepterPret(pret, l, a);

		if (acceptation == true) {
			em.persist(pret);
		}

		return pret;
	}

	/**
	 * fonction de vérification des conditions d'acceptation.
	 */
	public boolean AccepterPret(Pret pret, Livre l, Adherent a) {
		boolean result = false;

		List<Pret> listePret = recherchePretParAdherent(a);
		List<Pret> listeLivreEmprunte = em.createQuery("SELECT x FROM Pret x WHERE x.livre.titre LIKE :nom")
				.setParameter("nom", l.getTitre()).getResultList();

		if (listePret.size() < 3) {
			result = true;
		}
		
		if (listeLivreEmprunte.size() == 0) {
			result = true;
		}

		return result;
	}
	
	/**
	 * fonction qui retourne une liste des prets d'un adhérent.
	 */
	public List<Pret> recherchePretParAdherent(Adherent a) {
		List<Pret> listePret = em.createQuery("SELECT x FROM Pret x WHERE x.adherent.nom LIKE :nom")
				.setParameter("nom", a.getNom()).getResultList();
		
		return listePret;
	}
	
	/**
	 * fonction qui restourne une liste de tous les prets.
	 */
	public List<Pret> rechercheAllPret(){
		List<Pret> liste = em.createQuery("SELECT x FROM Pret x").getResultList();
		return liste;
	}
	
	/**
	 * fonction qui retourne une liste de tous les prets non rendu après la date butoire.
	 */
	public List <Pret> listePretNomrendu(){
		List<Pret> liste = em.createQuery("SELECT x.num, x.adherent.nom FROM Pret x WHERE x.dateRetourReelle = null x.dateRetourPrevue > CURRENT_DATE  ").getResultList();
		return liste;
	}

}
