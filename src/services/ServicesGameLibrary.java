package services;

import exceptions.InvalidMenuOptionException;

public class ServicesGameLibrary {
    public void optionVerify(int opt ){
        if (opt > 7 || opt < 1){
            throw new InvalidMenuOptionException("Invalid option!!!");

        }
    }
}
