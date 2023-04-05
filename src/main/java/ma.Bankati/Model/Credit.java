package ma.Bankati.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Credit {

    private  Long id;
    private Double capilate_Emprunt;
    private Integer Nombre_mois;
    private Double Taux_Mensuel;
    private String nom_demandeur;
    private Double mensualite;



    @Override

public String toString(){
        var creditStr = "=================================================";
            creditStr += "=> Credit numero "+getId();
            creditStr += "=>Nom du demandeur de credit :"+ getNom_demandeur();
            creditStr += "=>Capital emprunte "+ getCapilate_Emprunt();
            creditStr +="=> nombre de mois "+ getNombre_mois();
            creditStr +="=> taux mensuel "+ getTaux_Mensuel() ;


        creditStr = "=================================================";

        return creditStr;
    }
}
