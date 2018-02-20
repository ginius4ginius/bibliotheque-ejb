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
import model.Genre;


/**
 * @generated DT_ID=none
 */
@Stateless(name = "GenreEjb", mappedName = "GestionBibliotheque-ejb-GenreEjb")
public class GenreEjb
        implements GenreEjbLocal, GenreEjbRemote
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
    public GenreEjb() {
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
    public Genre persistGenre(Genre genre) {
        em.persist(genre);
        return genre;
    }

    /**
     * @generated DT_ID=none
     */
    public Genre mergeGenre(Genre genre) {
        return em.merge(genre);
    }

    /**
     * @generated DT_ID=none
     */
    public void removeGenre(Genre genre) {
        genre = em.find(Genre.class, genre.getNum());
        em.remove(genre);
    }

    /**
     * @generated DT_ID=none
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Genre> getGenreFindAll() {
        return em.createNamedQuery("Genre.findAll").getResultList();
    }

}