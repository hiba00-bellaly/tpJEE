package ma.Bankati.presentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import metier.ProduitMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller

@Data @AllArgsConstructor @NoArgsConstructor

public class ProduitController implements IProduitController{
    @Autowired
    @Qualifier("metier")
    ProduitMetier produitMetier;

    public void afficher_PrixTTC_Produit(Integer idProduit) throws Exception{



        Integer PRIXProduit =produitMetier.calculer_Produit(idProduit);
        System.out.println(PRIXProduit);



    }


}
