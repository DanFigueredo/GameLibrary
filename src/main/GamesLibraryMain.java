package main;

import domain.Game;

import java.util.ArrayList;
import java.util.Scanner;

public class GamesLibraryMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        ArrayList<Game> games = new ArrayList<>();
        int option;
        while(true){
            System.out.println("\n1 - Register game\n" +
                    "2 - List games\n" +
                    "3 - Search game\n" +
                    "4 - Remove game\n" +
                    "5 - Update game price\n" +
                    "6 - Show statistics\n" +
                    "7 - Exit");

            System.out.print("Choose any option ( 1 - 7): ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1 :{
                    Game game = new Game();
                    System.out.print("Enter the game name: ");
                    game.setName(scanner.nextLine().trim());


                    System.out.print("Enter the game price: ");
                    game.setPrice(scanner.nextDouble());
                    scanner.nextLine();

                    System.out.print("Enter the game genre: ");
                    game.setGenre(scanner.nextLine());

                    System.out.print("Enter the game release year: ");
                    game.setReleaseYear(scanner.nextInt());

                    games.add(game);
                    break;
                }//end case 1

                case 2 :{
                    if (games.isEmpty()){
                        System.out.println("The list is empty");
                        continue;
                    }
                    for (int i = 0; i < games.size(); i++){
                        Game game = games.get(i);
                        game.showData();

                    }
                    break;
                }//end case 2

                case 3 : {
                    String search;
                    System.out.print("Enter the game name you want to search: ");
                    search = scanner.nextLine().trim();
                    boolean found = false;

                    for(int i = 0; i < games.size(); i++){
                        Game game = games.get(i);
                        if (search.equalsIgnoreCase(game.getName())){
                            game.showData();
                            found = true;
                            break;
                        }
                        if (!found) {
                            System.out.println("This game does not exist in the list. Please add it.");
                        }
                    }
                    break;
                }//fim case 3

                case 7 : {
                    break;
                }

            }

        }
    }
}
