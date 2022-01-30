import java.util.Scanner;

public class Main {
    String choice = "";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean play = play();
        if (play) {
            TextBasedGame game = new TextBasedGame();
            game.about();
            game.input();
        } else {
            System.out.println("Thank you for checking out the game. Good-bye");
        }
    }

    public static boolean play() {
        System.out.println("Would you like to play?");
        System.out.println("1. To Play");
        System.out.println("2. To Quit");
        while (true) {
            String answer = scanner.nextLine();
            if (answer.equals("1")) {
                return true;
            } else if (answer.equals("2")) {
                return false;
            } else {
                System.out.println("Sorry, that was an invalid entry. Please choose 1 to play or 2 to quit");
            }
        }
    }

}
