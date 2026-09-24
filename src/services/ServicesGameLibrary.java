package services;

import exceptions.InvalidMenuOptionException;
import exceptions.NegativeNumberException;

public class ServicesGameLibrary {
    public void optionVerify(int opt ){
        if (opt > 7 || opt < 1){
            throw new InvalidMenuOptionException("Invalid option!!!");

        }
    }

    public void invalidPrice(double price){
        if (price < 0){
            throw new NegativeNumberException("Invalid price: price cannot be negative.");

        }

    }
}
