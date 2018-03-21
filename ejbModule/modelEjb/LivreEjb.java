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

import model.Auteur;
import model.Editeur;
import model.Genre;
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
    
    /**
     * fonction qui recherche un livre dans la liste des livre et 
     * @return 
     */
    public boolean rechercheUnLivre(Livre livre) {
    	boolean result = false;
    		List<Livre> liste = em.createQuery("SELECT x FROM Livre x WHERE x.isbn LIKE :num ")
			.setParameter("num", livre.getIsbn()).getResultList();
    	
		if (liste.size() != 0) {
			result = true;
		}

		return result;
	}
    
    
    public Livre rechercheUnLivreId(Livre livre) {
    	Livre livreResult = null;
    		List<Livre> liste = em.createQuery("SELECT x FROM Livre x WHERE x.isbn LIKE :num ")
			.setParameter("num", livre.getIsbn()).getResultList();
    	
		if (liste.size() != 0) {
			livreResult = liste.get(0);
		}

		return livreResult;
	}
    
    public List<Livre> getLivreFindAuteur(Auteur auteur) {
    	
    	List<Livre> liste = em.createQuery("SELECT x FROM Livre x WHERE x.auteur LIKE :num ")
    				.setParameter("num", auteur.getNum()).getResultList();
    	
    	return liste;
    			
    }
    
 public List<Livre> getLivreFindGenre(Genre genre) {
    	
    	List<Livre> liste = em.createQuery("SELECT x FROM Livre x WHERE x.genre LIKE :num ")
    				.setParameter("num", genre.getNum()).getResultList();
    	
    	return liste;
    			
    }
 
 public List<Livre> getLivreFindEditeur(Editeur editeur) {
 	
 	List<Livre> liste = em.createQuery("SELECT x FROM Livre x WHERE x.editeur LIKE :num ")
 				.setParameter("num", editeur.getNum()).getResultList();
 	
 	return liste;
 			
 }



@Override
public boolean ifExist(Livre l) {
	if (rechercheUnLivre(l))
		return true;
	return false;
}
    

}
