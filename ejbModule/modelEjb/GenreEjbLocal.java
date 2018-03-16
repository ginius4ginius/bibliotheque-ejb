package modelEjb;

import java.util.List;
import javax.ejb.Local;
import model.Genre;
import model.Livre;


/**
 * @generated DT_ID=none
 */
@Local
public interface GenreEjbLocal
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public Genre persistGenre(Genre genre);

    /**
     * @generated DT_ID=none
     */
    public Genre mergeGenre(Genre genre);

    /**
     * @generated DT_ID=none
     */
    public void removeGenre(Genre genre);

    /**
     * @generated DT_ID=none
     */
    public List<Genre> getGenreFindAll();
    
    public boolean rechercheUnGenre(Genre genre);
    
    public List<Livre> getAllLivreByGenre(Genre genre);

}
