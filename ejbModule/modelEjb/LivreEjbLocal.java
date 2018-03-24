package modelEjb;

import java.util.List;
import javax.ejb.Local;

import model.Auteur;
import model.Editeur;
import model.Genre;
import model.Livre;


/**
 * @generated DT_ID=none
 */
@Local
public interface LivreEjbLocal
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public Livre persistLivre(Livre livre);

    /**
     * @generated DT_ID=none
     */
    public Livre mergeLivre(Livre livre);

    /**
     * @generated DT_ID=none
     */
    public void removeLivre(Livre livre);

    /**
     * @generated DT_ID=none
     */
    public List<Livre> getLivreFindAll();
    
    public boolean rechercheUnLivre(Livre l);
    
    public Livre rechercheUnLivreId(Livre livre);
    
    public List<Livre> getLivreFindAuteur(Auteur auteur);
    
	public List<Livre> getLivreFindGenre(Genre genre);
	
	public List<Livre> getLivreFindEditeur(Editeur editeur);
	
	public boolean ifExist(Livre l);

}
