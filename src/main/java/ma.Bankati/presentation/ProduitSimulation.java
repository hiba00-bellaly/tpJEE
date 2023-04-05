package ma.Bankati.presentation;

import dao.IProduitDao;
import dao.daoMysql.ProduitDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import metier.IProduitMetier;
import metier.ProduitMetier;
import model.Produit;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner;

@Data @AllArgsConstructor

public class ProduitSimulation {
    static IProduitController produitController;
    static Scanner clavier = new Scanner(System.in);

    private static boolean estUnNombre(String input){
        try { Integer.parseInt(input);
            return true;
        }catch (Exception e){ return false;} }

    public static void test1() {
       // var dao = new ProduitDao();
        var metier = new ProduitMetier();
        var controleur = new ProduitController();
        //metier.setProduitDao(dao);
        controleur.setProduitMetier(metier);
        String rep ="";
        do {
            System.out.println("================================");
            System.out.println("[test1]=>calcule de PrixTTC ");
            try {
                String input ="";
                while (true){

                    System.out.println("=>entrer l id du produit");
                    input= clavier.nextLine();
                    System.out.println(" please wait for 10 seconds...");

                    try {
                        Thread.sleep(6000);
                    } catch (InterruptedException e) {
                        // Handle the exception if necessary
                    }

                    System.out.println("PrixTTC:");
                    if (estUnNombre(input))break;
                    System.out.println("entrer non valide");
                }
               int id = Integer.parseInt(input);
                controleur.afficher_PrixTTC_Produit(id);
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
            System.out.println("voulez vous quitter?");
            rep=clavier.nextLine();
        }while (!rep.equalsIgnoreCase("oui"));
        System.out.println("au revoir");

    }

    public static void test2() throws Exception {
        IProduitDao<Produit, Integer> dao = null;
        IProduitMetier metier = null;
        IProduitController controller = null;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        var config = classLoader.getResourceAsStream("presentation/config.properties");
        Properties properties = new Properties();
        try {
            properties.load(config);
            var daoClass = properties.getProperty("Dao");
            var serviceClass = properties.getProperty("Service");
            var controllClass = properties.getProperty("Controller");

            Class cDao = Class.forName(daoClass);
            Class cMetier = Class.forName(serviceClass);
            Class cControll = Class.forName(controllClass);

            dao = (IProduitDao<Produit, Integer>) cDao.getDeclaredConstructor().newInstance();
            metier = (IProduitMetier) cMetier.getDeclaredConstructor().newInstance();
            controller= (IProduitController) cControll.getDeclaredConstructor().newInstance();

            Method setDao = cMetier.getMethod("setProduitDao",ProduitDao.class);
            setDao.invoke(metier, dao);

            Method setMetier = cControll.getMethod("setProduitMetier",ProduitMetier.class);
            setMetier.invoke(controller, metier);

            controller.afficher_PrixTTC_Produit(1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void test3() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc.xml");
        produitController = (IProduitController) context.getBean("Controller");
        produitController.afficher_PrixTTC_Produit(1);
    }

    public static void test4()throws Exception{
        ApplicationContext context = new AnnotationConfigApplicationContext("dao","metier","presentation");
        produitController = (IProduitController) context.getBean(ProduitController.class);
        produitController.afficher_PrixTTC_Produit(1);

    }



  //  public static void main(String[] args)throws Exception {
      //  test1();
        //test2();
        //test3();
        //test4();
  //  }
}