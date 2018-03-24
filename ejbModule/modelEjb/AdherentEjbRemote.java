package modelEjb;

import java.util.List;
import javax.ejb.Remote;

import model.Adherent;


/**
 * @generated DT_ID=none
 */
@Remote
public interface AdherentEjbRemote
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public Adherent persistAdherent(Adherent adherent);

    /**
     * @generated DT_ID=none
     */
    public Adherent mergeAdherent(Adherent adherent);

    /**
     * @generated DT_ID=none
     */
    public void removeAdherent(Adherent adherent);

    /**
     * @generated DT_ID=none
     */
    public List<Adherent> getAdherentFindAll();
    
    public boolean rechercherAdherent(Adherent adh);
    
    public boolean updateAdherentAdr(Adherent adh, String adrRue, int adrCP, String adrVille);
    
    public boolean modifierAdherentAdr(Adherent adh, String adrRue, int adrCP, String adrVille);
    
    public Adherent rechercherUnAdhId(Adherent adh);
    
    public boolean ifExist(Adherent adh) ;

}
