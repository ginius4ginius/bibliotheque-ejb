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
import javax.persistence.TypedQuery;

import model.Adherent;
import model.Auteur;


/**
 * @generated DT_ID=none
 */
@Stateless(name = "AuteurEjb", mappedName = "GestionBibliotheque-ejb-AuteurEjb")
public class AuteurEjb
        implements AuteurEjbLocal, AuteurEjbRemote
{

    /**
     * @generated DT_ID=none
     */
	@Resource
	SessionContext sessionContext;

    /**
     * @generated DT_ID=none
     */
	    @PersistenceContext(unitName="GestionBibliotheque-ejb")
        private EntityManager em;

    /**
     * @generated DT_ID=none
     */
    public AuteurEjb() {
    }
    
    

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Object queryByRange(String jpqlStmt, int firstResult,
                               int maxResults) {
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
    public Auteur persistAuteur(Auteur auteur) {
        em.persist(auteur);
        return auteur;
    }

    /**
     * @generated DT_ID=none
     */
    public Auteur mergeAuteur(Auteur auteur) {
        return em.merge(auteur);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeAuteur(Auteur auteur) {
        auteur = em.find(Auteur.class, auteur.getNum());
        em.remove(auteur);
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Auteur> getAuteurFindAll() {
        return em.createNamedQuery("Auteur.findAll").getResultList();
    }
    
    /**
     * rechercher un Auteur
     * @param a
     * @return
     */
    public boolean rechercherUnAuteur(Auteur auteur) {
    	//auteur = em.find(Auteur.class, auteur.getNum());
    	boolean result = false;
    	TypedQuery<Auteur> query = em.createQuery("SELECT x FROM Auteur x WHERE x.nom LIKE :nom AND x.prenom LIKE :prenom", Auteur.class);
    	List<Auteur> listeAuteur = query.setParameter("nom", auteur.getNom())
    								.setParameter("prenom", auteur.getPrenom()).getResultList();
    	

    	if((listeAuteur.size() !=0)) {
    		System.out.println("auteur trouvé");
    		result = true;
    	}
    	return result;
    	   	
    }
    
    /**
     * Rechercher Id d'un auteur persisté
     * @param auteur
     * @return
     */
    public Auteur rechercherUnAuteurId(Auteur auteur) {
    	//auteur = em.find(Auteur.class, auteur.getNum());
    	Auteur unAuteur = null;
    	TypedQuery<Auteur> query = em.createQuery("SELECT x FROM Auteur x WHERE x.nom LIKE :nom AND x.prenom LIKE :prenom", Auteur.class);
    	List<Auteur> listeAuteur = query.setParameter("nom", auteur.getNom())
    								.setParameter("prenom", auteur.getPrenom()).getResultList();
    	

    	if((listeAuteur.size() !=0)) {
    		unAuteur = listeAuteur.get(0);
    	}
    	return unAuteur;
    	   	
    }
    
    public boolean ifExist(Auteur auteur) {
    	if (rechercherUnAuteur(auteur))
    		return true;
    	return false;
    }
    
    
    

}
