import java.util.ArrayList;
import java.util.Scanner;


class UserInterface {
    private Database database;
    private Controller controller;
    private Scanner scanner;

    public UserInterface() {
        database = new Database();
        controller = new Controller(database);
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;

        while (running) {
            // Display menu and handle user input here
            // Implement the menu options and their respective actions
            // Use the Controller class for interacting with superheroes
        }

        scanner.close();
    }
}