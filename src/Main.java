import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Controller controller = new Controller(database);

        Scanner scanner = new Scanner(System.in);

        boolean running = true; // Indikator for om programmet kører

        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Tilføj Superhelt");
            System.out.println("2. Vis alle Superhelte");
            System.out.println("3. Søg efter Superhelt");
            System.out.println("4. Afslut");

            int valg = scanner.nextInt();
            scanner.nextLine(); // Læs en linje for at håndtere Enter-tasten

            switch (valg) {
                case 1:
                    System.out.print("Navn: ");
                    String navn = scanner.nextLine();
                    System.out.print("Rigtigt navn: ");
                    String rigtigtNavn = scanner.nextLine();
                    System.out.print("Er menneske (Ja/Nej): ");
                    boolean erMenneske = scanner.nextLine().equalsIgnoreCase("Ja");
                    System.out.print("Skabelsesår: ");
                    int skabelsesaar = scanner.nextInt();
                    scanner.nextLine(); // Læs en linje for at håndtere Enter-tasten
                    System.out.print("Styrke: ");
                    String styrke = scanner.nextLine();
                    controller.addSuperhero(navn, rigtigtNavn, erMenneske, skabelsesaar, styrke);
                    System.out.println("Superhelt tilføjet!");
                    break;

                case 2:
                    ArrayList<Superhero> superheroeList = controller.getAllSuperheroes();
                    if (superheroeList.isEmpty()) {
                        System.out.println("Der er ingen superhelte i databasen.");
                    } else {
                        System.out.println("Liste over superhelte:");
                        for (Superhero superhero : superheroeList) {
                            System.out.println("Navn: " + superhero.getName());
                            System.out.println("Rigtige navn: " + superhero.getRealName());
                            System.out.println("Er menneske: " + (superhero.isHuman() ? "Ja" : "Nej"));
                            System.out.println("Skabelsesår: " + superhero.getCreationYear());
                            System.out.println("Styrke: " + superhero.getStrength()); // Vis styrken
                            System.out.println();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter the search criteria: ");
                    String searchCriteria = scanner.nextLine();
                    ArrayList<Superhero> searchResults = controller.searchSuperheroes(searchCriteria);

                    if (searchResults.isEmpty()) {
                        System.out.println("No matching superheroes found.");
                    } else {
                        System.out.println("Matching superheroes:");
                        for (Superhero superhero : searchResults) {
                            // Display details of matching superheroes...
                            System.out.println("Navn: " + superhero.getName());
                            System.out.println("Rigtige navn: " + superhero.getRealName());
                            System.out.println("Er menneske: " + (superhero.isHuman() ? "Ja" : "Nej"));
                            System.out.println("Skabelsesår: " + superhero.getCreationYear());
                            System.out.println("Styrke: " + superhero.getStrength());
                            System.out.println();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Farvel!");
                    running = false; // Stop løkken og afslut programmet
                    break;

                case 5:
                    // Edit Superhero
                    System.out.print("Enter the name of the superhero to edit: ");
                    String editName = scanner.nextLine();
                    Superhero superheroToEdit = controller.searchSuperheroByName(editName);

                    if (superheroToEdit != null) {
                        // Prompt the user for new values
                        System.out.print("New real name: ");
                        String newRealName = scanner.nextLine();
                        System.out.print("Is human (Ja/Nej): ");
                        boolean newIsHuman = scanner.nextLine().equalsIgnoreCase("Ja");
                        System.out.print("New creation year: ");
                        int newCreationYear = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        System.out.print("New strength: ");
                        String newStrength = scanner.nextLine();

                        // Attempt to edit the superhero
                        boolean editSuccess = controller.editSuperhero(
                                editName,
                                newRealName,
                                newIsHuman,
                                newCreationYear,
                                newStrength
                        );

                        if (editSuccess) {
                            System.out.println("Superhero successfully edited.");
                        } else {
                            System.out.println("No matching superhero found for editing.");
                        }
                    } else {
                        System.out.println("No matching superhero found.");
                    }
                    break;

                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
                    break;
            }
        }
        scanner.close(); // Luk scanneren ved afslutning
    }
}
