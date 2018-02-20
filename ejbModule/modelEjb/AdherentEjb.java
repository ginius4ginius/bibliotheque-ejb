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

}
