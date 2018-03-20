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


/**
 * @generated DT_ID=none
 */
@Stateless(name = "AdherentEjb", mappedName = "GestionBibliotheque-ejb-AdherentEjb")
public class AdherentEjb
        implements AdherentEjbLocal, AdherentEjbRemote
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
    public AdherentEjb() {
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
     * ajouter un adhérent dans la bdd
     * @generated DT_ID=none
     */
    public Adherent persistAdherent(Adherent adherent) {
        em.persist(adherent);
        return adherent;
    }

    /**
     * @generated DT_ID=none
     */
    public Adherent mergeAdherent(Adherent adherent) {
        return em.merge(adherent);
    }

    /**
     * supprimer un adhérent
     * @generated DT_ID=none
     */
    public void removeAdherent(Adherent adherent) {
        adherent = em.find(Adherent.class, adherent.getNum());
        em.remove(adherent);
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Adherent> getAdherentFindAll() {
        return em.createNamedQuery("Adherent.findAll").getResultList();
    }
    
    /***
     * rechercher un Adhérent  à partir son num, nom & prénom
     * @param adh
     * @return
     */
    public boolean rechercherAdherent(Adherent adh) {
    	boolean result = false;
    	TypedQuery<Adherent> query = em.createQuery("SELECT x FROM Adherent x WHERE x.nom LIKE :nom AND x.prenom LIKE :prenom", Adherent.class);
    	List<Adherent> listeAdh = query.setParameter("nom", adh.getNom())
    								.setParameter("prenom", adh.getPrenom()).getResultList();
    	
    	
    	if((listeAdh.size() !=0)) {
    		System.out.println("adhérent trouvé");
    		result = true;
    	}
    	return result;
    }
    
    
    
    /***
     * Fonction qui modifier l'adresse d'un ahérent utilisqnt UPDATE query
     * @param adh
     * @param adrRue
     * @param adrCP
     * @param adrVille
     * @return
     */
    public boolean updateAdherentAdr(Adherent adh, String adrRue, int adrCP, String adrVille) {
    	
    	if (rechercherAdherent(adh)==true) {
    		em.getTransaction().begin();
    		String sql = "UPDATE Adherent AS x SET " + 
    					 "adrRue = :rue" + 
    					 "adrCP = :CP" +
    					 "adrVille = :ville" +
    					 "WHERE id = :adhId";
    		Query qr = em.createQuery(sql).setParameter("rue", adrRue)
    									  .setParameter("CP", adrCP)
    									  .setParameter("ville", adrVille)
    									  .setParameter("adhId", adh.getNum());
    		qr.executeUpdate();
    		
    		
    		em.getTransaction().commit();	
    	}
    	return true;			   					   	 										
    }
    
    /// Modifier de l'adresse d'Adhérent utilisant find & merge
    
    public boolean modifierAdherentAdr(Adherent adh, String adrRue, int adrCP, String adrVille) {
    	boolean change = false;
    	adh = em.find(Adherent.class, adh.getNum());
    	if(adh != null) {
	    	adh.setAdrRue(adrRue);
	    	adh.setAdrCP(adrCP);
	    	adh.setAdrVille(adrVille);
	    	em.getTransaction().begin();
	    	em.merge(adh);
	    	em.getTransaction().commit();
	    	change = true;
    	}	
	    	return change;
    }

}
