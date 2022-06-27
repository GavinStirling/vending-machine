import java.util.Scanner;

public class Commands {

    private final Scanner scanner = new Scanner(System.in);
    private final String name;
    private final String[] commands;

    public Commands(String name, String[] commands) {
        this.name = name;
        this.commands = commands;
    }

    public void printMessage(String message) {
        System.out.println("----------");
        System.out.println(message);
        System.out.println("----------");
    }

    public void printGreeting() {
        System.out.println("----------");
        System.out.println("Welcome to the " + name + " commands.");
        System.out.println("----------");
    }

    public void printCommands() {
        for (int i = 0; i < commands.length; i++) {
            System.out.println((i+1) + ": " + commands[i]);
        }
    }

    public String getStringInput() {
        System.out.println("Enter your text below:");
        String userInput = scanner.nextLine();
        if (userInput.equals("")) {
            System.out.println("Please try again");
            getStringInput();
        }
        return userInput;
    }

    public int getCommandInput() {
        System.out.println("Enter your number below:");
        int userInput = scanner.nextInt();
        if (userInput > 0 && userInput <= commands.length) {
            return userInput;
        } else {
            System.out.println("Please try again");
            getCommandInput();
        }
        return 0;
    }

    public int getIntegerInput() {
        System.out.println("Enter your number below:");
        int userInput = scanner.nextInt();
        if (userInput > 0) {
            return userInput;
        } else {
            System.out.println("Please try again");
            getIntegerInput();
        }
        return 0;
    }

    public double getDoubleInput() {
        System.out.println("Enter your number below:");
        double userInput = scanner.nextDouble();
        if (userInput > 0.0) {
            return userInput;
        } else {
            System.out.println("Please try again");
            getDoubleInput();
        }
        return 0;
    }
}
