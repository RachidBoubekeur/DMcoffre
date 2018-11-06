package dmcoffre;
import java.util.Scanner;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Rachid Boubekeur
 */
public class DMcoffre {
    public static void main(String[] args) {
            
    Timer timer = new Timer();
    
    MyTask tps = new MyTask();
    timer.schedule(tps, 0, 1000);
    Thread thread =  new Thread(tps);
    
    String NEWLINE = System.getProperty("line.separator");
    Scanner sc = new Scanner(System.in);
    Random randfac = new Random();
        
        System.out.println("Saisissez le niveau de difficulté :"+NEWLINE+"1 = Facile (7 essaies/combinaisons(3) en moins de 60s)"+NEWLINE+"2 = Moyen (8 essaies/combinaisons(3) en moins de 60s)"+NEWLINE+"3 = Difficile (12 essaies/combinaisons(3) en moins de 60s)");
        int dif = sc.nextInt();
        
    if (dif == 1){// NIVEAU FACILE
        
        thread.start();
        Scanner propofac1 = new Scanner(System.in);
        int facile = 1;                                                                      
        
    while (facile <= 3){ // 3 ESSAIES
        int essfac1 = 0;                                                                     
        int nbaleafac1 = randfac.nextInt(100);
        System.out.println(NEWLINE+"Saisir la combinaison n°" +facile+ " (de 1 à 100)");
        int valfac1 = propofac1.nextInt();                                                   
        
        while (valfac1 != nbaleafac1){ 
            essfac1 ++;                                                                      
            if (valfac1 < nbaleafac1){                                                       
                System.out.println("Supérieur (plus que "+(7 - essfac1)+" essais)");
            }
            
            if (valfac1 > nbaleafac1){                                                       
                System.out.println("Inférieur (plus que "+(7 - essfac1)+" essais)");
            }
            
            if (essfac1 == 7){
            System.out.println(NEWLINE+"ECHEC ! Vous avez fais plus de 7 tetatives, le coffre est reste fermer.");
            System.exit(0);
            }
            
            valfac1 = propofac1.nextInt();            
       
        }
            if (valfac1 == nbaleafac1){                                                      
                System.out.println("BIEN ! vous avez trouvé la combinaison " +facile+"/3 en "+tps.temps+" secondes !");
            }
        facile ++;
    }
    
        System.out.println(NEWLINE+"BRAVO ! Vous avez ouvert le coffre !");     
    }
    
    if (dif == 2){// NIVEAU MOYEN
        
        thread.start();
        Scanner propomoy1 = new Scanner(System.in);
        int moyen = 1;
        
    while (moyen <= 3){ //3 ESSAIES
        
        int essmoy1 = 0;
        int nbaleamoy1 = randfac.nextInt(500);
        System.out.println(NEWLINE+"Entrer la combinaison n°" +moyen+ " (de 1 à 500)");
        int valmoy1 = propomoy1.nextInt();
        
        while (valmoy1 != nbaleamoy1){
            essmoy1 ++;
            if (valmoy1 < nbaleamoy1){
                System.out.println("Supérieur (plus que "+(8 - essmoy1)+" essais)");
            }
            
            if (valmoy1 > nbaleamoy1){
                System.out.println("Inférieur (plus que "+(8 - essmoy1)+" essais)");
            }
            
            if (essmoy1 == 10){
            System.out.println(NEWLINE+"ECHEC ! Vous avez fait plus de 10 tetatives, le coffre est fermer !");
            System.exit(0);
            }
            
            valmoy1 = propomoy1.nextInt();              
       
        }         
            
            if (valmoy1 == nbaleamoy1){
                System.out.println("BIEN ! vous avez trouvé la combinaison " +moyen+"/3 en "+tps.temps+" secondes !");
            }
        moyen ++;
    }
        
        System.out.println(NEWLINE+"BRAVO ! Vous avez ouvert le coffre.");
        
    }
    
    if (dif == 3){// NIVEAU DIFFICILE
        
        thread.start();
        Scanner propodif1 = new Scanner(System.in);
        int difficile = 1;
        
    while (difficile <= 3){ //3 ESSAIES
        
        int essdif1 = 0;
        int nbaleadif1 = randfac.nextInt(1000);
        System.out.println(NEWLINE+"Entrer la combinaison n°" +difficile+ " (de 1 à 1000)");
        int valdif1 = propodif1.nextInt();
        
        while (valdif1 != nbaleadif1){
            essdif1 ++;
            if (valdif1 < nbaleadif1){
                System.out.println("Supérieur ! (plus que "+(10 - essdif1)+" essais)");
            }
            
            if (valdif1 > nbaleadif1){
                System.out.println("Inférieur (plus que "+(10 - essdif1)+" essais)");
            }
            
            if (essdif1 == 15){
            System.out.println(NEWLINE+"ECHEC ! Vous avez fait plus de 15 tentatives, le coffre est bloqué.");
            System.exit(0);
            }
            
            valdif1 = propodif1.nextInt();              
       
        }
            
            if (valdif1 == nbaleadif1){
                System.out.println("BIEN ! vous avez trouvé la combinaison " +difficile+"/3 en "+tps.temps+" secondes !");
            }
        difficile ++;
    }
        
        System.out.println(NEWLINE+"BRAVO ! Vous avez réussi a dévérouiller le coffre fort !");
        
    }
}
}
        class MyTask extends TimerTask {
        public int​ temps = 0;
        @Override
        public void​ run() {
            temps++;
            if (temps >= 60){
                System.out.println("Échec la police arrive (temps écoulé)");
                System.exit(1);
            }
        }
    }