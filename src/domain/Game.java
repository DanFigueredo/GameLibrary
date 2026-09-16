package domain;

public class Game {
    private String name;
    private double price;
    private String genre;
    private int releaseYear;

    public String getName() {
        return name;
    }

    public Game(String name, double price, String genre, int releaseYear) {
        this.name = name;
        this.price = price;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }

    public Game() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void showData(){
        System.out.println("Game name: " + getName());
        System.out.println("Game price: " + getPrice());
        System.out.println("Game genre: " + getGenre());
        System.out.println("Game release year: " + getReleaseYear());
        System.out.println("--------------------------");


    }
}
