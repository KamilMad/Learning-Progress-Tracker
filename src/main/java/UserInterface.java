import java.util.Scanner;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);

    public void showInterface(){

        System.out.println("Learning Progress Tracker");
        while (scanner.hasNextLine()){

            String nextLine = scanner.nextLine();
            handleInput(nextLine);

        }
    }

    public void handleInput(String input){
        if (input.isBlank()){
            System.out.println("No input");
        }
        else if (!input.equals("exit")){
            System.out.println("Unknown command!");
        }
        else {
            System.out.println("Bye!");
            System.exit(0);
        }
    }
}
