package modelEjb;

import java.util.List;
import javax.ejb.Local;
import model.Editeur;


/**
 * @generated DT_ID=none
 */
@Local
public interface EditeurEjbLocal
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public Editeur persistEditeur(Editeur editeur);

    /**
     * @generated DT_ID=none
     */
    public Editeur mergeEditeur(Editeur editeur);

    /**
     * @generated DT_ID=none
     */
    public void removeEditeur(Editeur editeur);

    /**
     * @generated DT_ID=none
     */
    public List<Editeur> getEditeurFindAll();
    
    public boolean rechercherUnEditeur(Editeur editeur);

}
