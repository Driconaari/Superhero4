public class Superhero {
    private String name;
    private String realName;
    private boolean isHuman;
    private int creationYear;
    private String strength;

    public Superhero(String name, String realName, boolean isHuman, int creationYear, String strength) {
        this.name = name;
        this.realName = realName;
        this.isHuman = isHuman;
        this.creationYear = creationYear;
        this.strength = strength;
    }

    // Rest of your getter methods and any other methods you need should be defined here...

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public String getStrength() {
        return strength;
    }

    public void setRealName(String realName) {
    }

    public void setIsHuman(boolean isHuman) {
    }

    public void setCreationYear(int creationYear) {
    }

    public void setStrength(String strength) {
    }

    // Add other getter and setter methods as needed
}
