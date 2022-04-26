package Vista;
import java.util.Scanner;
import static Vista.UIConcursoMethods.*;

public  class UIConcursoMenu {

    public static void showUserMenuContest() {
        Scanner sc = new Scanner(System.in);
        boolean endgame=false;
        UIConcursoMethods.showWelcome();
        do {
            String userChoice = sc.nextLine();
            switch (userChoice) {
                case "1" -> {
                    UIConcursoMethods.showLogicGame();
                    UIConcursoMethods.playConcurse();
                    endgame=true;
                }
                case "2" -> {
                    UIConcursoMethods.showScoreHistory();
                    endgame=true;
                }
                default -> {
                    System.out.println("Ingrese una opción valida: 1 o 2");
                }
            }
        } while (!endgame);
    }
}
