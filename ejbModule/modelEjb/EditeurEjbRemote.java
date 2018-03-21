package modelEjb;

import java.util.List;
import javax.ejb.Remote;
import model.Editeur;


/**
 * @generated DT_ID=none
 */
@Remote
public interface EditeurEjbRemote
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
    
    public boolean ifExist(Editeur edit);

}
