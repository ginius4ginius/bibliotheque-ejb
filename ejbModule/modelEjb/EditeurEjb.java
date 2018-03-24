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

import model.Auteur;
import model.Editeur;


/**
 * @generated DT_ID=none
 */
@Stateless(name = "EditeurEjb", mappedName = "GestionBibliotheque-ejb-EditeurEjb")
public class EditeurEjb
        implements EditeurEjbLocal, EditeurEjbRemote
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
    public EditeurEjb() {
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
    public Editeur persistEditeur(Editeur editeur) {
        em.persist(editeur);
        return editeur;
    }

    /**
     * @generated DT_ID=none
     */
    public Editeur mergeEditeur(Editeur editeur) {
        return em.merge(editeur);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeEditeur(Editeur editeur) {
        editeur = em.find(Editeur.class, editeur.getNum());
        em.remove(editeur);
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Editeur> getEditeurFindAll() {
        return em.createNamedQuery("Editeur.findAll").getResultList();
    }
    
    /**
     * rechercher un éditeur
     * @param editeur
     * @return
     */
    public boolean rechercherUnEditeur(Editeur edit) {
    	//auteur = em.find(Auteur.class, auteur.getNum());
    	boolean result = false;
    	TypedQuery<Editeur> query = em.createQuery("SELECT x FROM Editeur x WHERE x.nom LIKE :nom", Editeur.class);
    	List<Editeur> listeEditeur = query.setParameter("nom", edit.getNom()).getResultList();
    	

    	if((listeEditeur.size() !=0)) {
    		System.out.println("editeur trouvé");
    		result = true;
    	}
    	return result;
    	   	
    }
    
    
    public Editeur rechercherUnEditeurId(Editeur edit) {
    	//auteur = em.find(Auteur.class, auteur.getNum());
    	Editeur unEdit = null;
    	TypedQuery<Editeur> query = em.createQuery("SELECT x FROM Editeur x WHERE x.nom LIKE :nom", Editeur.class);
    	List<Editeur> listeEditeur = query.setParameter("nom", edit.getNom()).getResultList();
    	

    	if((listeEditeur.size() !=0)) {
    		unEdit = listeEditeur.get(0);
    	}
    	return unEdit;
    	   	
    }
    
    public boolean ifExist(Editeur edit) {
    	if (rechercherUnEditeur(edit))
    		return true;
    	return false;
    }
    
    

}
