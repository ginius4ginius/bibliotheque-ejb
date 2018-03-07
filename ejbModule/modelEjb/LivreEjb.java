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
import model.Livre;


/**
 * @generated DT_ID=none
 */
@Stateless(name = "LivreEjb", mappedName = "GestionBibliotheque-ejb-LivreEjb")
public class LivreEjb
        implements LivreEjbLocal, LivreEjbRemote
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
    public LivreEjb() {
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
    public Livre persistLivre(Livre livre) {
        em.persist(livre);
        return livre;
    }

    /**
     * @generated DT_ID=none
     */
    public Livre mergeLivre(Livre livre) {
        return em.merge(livre);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeLivre(Livre livre) {
        livre = em.find(Livre.class, livre.getNum());
        em.remove(livre);
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Livre> getLivreFindAll() {
        return em.createNamedQuery("Livre.findAll").getResultList();
    }
    
    public List<Livre> rechercheUnLivre(Livre l) {
		List<Livre> liste = em.createQuery("SELECT x FROM Livre x WHERE x.ISBN LIKE :num ")
				.setParameter("num", l.getIsbn()).getResultList();
		return liste;
	}

}
