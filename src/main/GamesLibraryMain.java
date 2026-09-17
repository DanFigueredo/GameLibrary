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
                    System.out.println("===== Game added successfully =====");
                    break;
                }//end case 1

                case 2 :{
                    if (games.isEmpty()){
                        System.out.println("The list is empty");
                        continue;
                    }
                    System.out.println("===== Game List: ======");
                    for (int i = 0; i < games.size(); i++){
                        Game game = games.get(i);
                        game.showData();

                    }
                    break;
                }//end case 2

                case 3 : {
                    if (games.isEmpty()) {
                        System.out.println("There are no games to search.");
                        break;
                    }
                    String search;
                    System.out.print("Enter the game name you want to search: \n");
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
                            break;
                        }
                    }
                    break;
                }//end case 3

                case 4 : {
                    int optToRemove = -1;
                    if (games.isEmpty()) {
                        System.out.println("There are no games to remove.");
                        break;
                    }
                    System.out.println("Game list: ");
                    for (int i = 0; i < games.size(); i++){
                        Game game = games.get(i);
                        System.out.println(i+1 +  " - " + game.getName());
                    }
                    System.out.print("Choose Which game you want to remove: ");
                    optToRemove = scanner.nextInt();
                    if (optToRemove <= 0 || optToRemove > games.size()){
                        System.out.println("Invalid option!");
                        continue;
                    }

                    games.remove(optToRemove - 1);
                    System.out.println("====== Game removed successfully ======");
                    break;
                }//end case 4

                case 5 : {
                    int optToAddPrice = -1;
                    double priceUp = 0.0;
                    if (games.isEmpty()) {
                        System.out.println("There are no games to update.");
                        break;
                    }
                    System.out.println("Game list: ");
                    for (int i = 0; i < games.size(); i++){
                        Game game = games.get(i);
                        System.out.println(i+1 +  " - " + game.getName());
                    }

                    System.out.print("Choose Which game you want to update price: ");
                    optToAddPrice = scanner.nextInt();
                    if (optToAddPrice <= 0 || optToAddPrice > games.size()){
                        System.out.println("Invalid option!");
                        continue;
                    }

                    System.out.print("Enter the new price: ");
                    priceUp = scanner.nextDouble();

                    if (priceUp < 0){
                        System.out.println("Invalid price");
                        continue;
                    }
                    Game game = games.get(optToAddPrice - 1);
                    game.setPrice(priceUp);

                    System.out.println("======" + game.getName() + " Price updated successfully======");

                    break;
                }//end case 5



                case 7 : {
                    break;
                }

            }

        }
    }
}
