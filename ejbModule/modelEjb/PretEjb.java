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
import model.Pret;


/**
 * @generated DT_ID=none
 */
@Stateless(name = "PretEjb", mappedName = "GestionBibliotheque-ejb-PretEjb")
public class PretEjb
        implements PretEjbLocal, PretEjbRemote
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
    public PretEjb() {
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

}
