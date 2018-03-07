package modelEjb;

import java.util.List;
import javax.ejb.Remote;

import model.Adherent;
import model.Livre;
import model.Pret;


/**
 * @generated DT_ID=none
 */
@Remote
public interface PretEjbRemote
{

    /**
     * @generated DT_ID=none
     */
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    /**
     * @generated DT_ID=none
     */
    public Pret persistPret(Pret pret);

    /**
     * @generated DT_ID=none
     */
    public Pret mergePret(Pret pret);

    /**
     * @generated DT_ID=none
     */
    public void removePret(Pret pret);

    /**
     * @generated DT_ID=none
     */
    public List<Pret> getPretFindAll();
    
    public List<Pret> rechercheUnPret(Pret pret);
    
    public boolean ifIsDisponible(Livre l);
    
    public Pret persistPret(Pret pret, Livre l, Adherent a);
    
    public boolean AccepterPret(Pret pret, Livre l, Adherent a);
    
    public List<Pret> recherchePretParAdherent(Adherent a);
    
    public List<Pret> rechercheAllPret();
    
    public List <Pret> listePretNomrendu();

}
