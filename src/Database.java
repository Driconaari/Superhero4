import java.util.ArrayList;

public class Database {
    private ArrayList<Superhero> superheroes = new ArrayList<>();

    public void addSuperhero(Superhero superhero) {
        superheroes.add(superhero);
    }

    public ArrayList<Superhero> getAllSuperheroes() {
        return superheroes;
    }

    public ArrayList<Superhero> searchSuperheroes(String searchCriteria) {
        ArrayList<Superhero> searchResult = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if (superhero.getName().toLowerCase().contains(searchCriteria.toLowerCase())) {
                searchResult.add(superhero);
            }
        }
        return searchResult;
    }

    public Superhero searchSuperheroByName(String name) {
        for (Superhero superhero : superheroes) {
            if (superhero.getName().equalsIgnoreCase(name)) {
                return superhero;
            }
        }
        return null; // Return null if no match is found
    }
}
