package main;

import domain.Game;
import exceptions.InvalidMenuOptionException;
import exceptions.NegativeNumberException;
import services.ServicesGameLibrary;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class GamesLibraryMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        ArrayList<Game> games = new ArrayList<>();
        ServicesGameLibrary service = new ServicesGameLibrary();

        int option = 0;
        boolean running = true;


        while(running){
            System.out.println("\n1 - Register game\n" +
                    "2 - List games\n" +
                    "3 - Search game\n" +
                    "4 - Remove game\n" +
                    "5 - Update game price\n" +
                    "6 - Show statistics\n" +
                    "7 - Exit");

            try{
                System.out.print("Choose any option ( 1 - 7): ");
                option = scanner.nextInt();
                scanner.nextLine();

            }catch (InputMismatchException e){
                System.out.println("Please enter a valid number!");
                scanner.nextLine();
                continue;
            }
            try{
                service.optionVerify(option);
            }catch (InvalidMenuOptionException e){
                System.out.println(e.getMessage());
                continue;
            }


            switch (option){
                case 1 :{
                    Game game = new Game();
                    System.out.print("Enter the game name: ");
                    game.setName(scanner.nextLine().trim());

                    System.out.print("Enter the game price: ");
                    game.setPrice(scanner.nextDouble());
                    scanner.nextLine();

                    try {
                        service.invalidPrice(game.getPrice());
                    }catch (NegativeNumberException e){
                        System.out.println(e.getMessage());
                        continue;
                    }


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

                    }
                    if (!found) {
                        System.out.println("This game does not exist in the list. Please add it.");
                        break;
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

                case 6 : {
                    if (games.isEmpty()){
                        System.out.println("The list is empty!");
                        break;
                    }
                    Game game = games.get(0);
                    double mostExpensive = 0.0;
                    double cheapest = 0.0;
                    double averagePrice = 0.0;
                    String nameCheapest = game.getName();
                    String nameExpensive = game.getName();
                    cheapest = game.getPrice();
                    mostExpensive = game.getPrice();
                    for (int i = 0; i < games.size(); i++){
                        game = games.get(i);

                        averagePrice += game.getPrice();
                        if (game.getPrice() > mostExpensive){
                            mostExpensive = game.getPrice();
                            nameExpensive = game.getName();
                        }

                        if (game.getPrice() < cheapest){
                            cheapest = game.getPrice();
                            nameCheapest = game.getName();
                        }
                    }

                    averagePrice = averagePrice/ games.size();

                    System.out.println("===== GAME STATISTICS =====");
                    System.out.println("Total games: " + games.size());
                    System.out.printf("Average price: %.2f%n" , averagePrice);
                    System.out.println("Most expensive: " + nameExpensive + " - " + mostExpensive);
                    System.out.println("Cheapest: " + nameCheapest + " - " + cheapest);
                    break;

                }//end case 6

                case 7 : {
                    System.out.println("Closing program...");
                    running = false;
                    break;

                }



            }//end switch


        }//end while
    }
}
