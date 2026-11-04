# GameLibrary

A Java console application for managing a personal video game collection.

GamesLibrary allows users to register, list, search, remove, and update games, as well as view statistics about their collection.

## Features

- **Register Games:** Add games with their name, price, genre, and release year.
- **List Games:** Display all registered games.
- **Search Games:** Find games by name, regardless of uppercase or lowercase letters.
- **Remove Games:** Select and remove a game from the collection.
- **Update Prices:** Change the price of a registered game.
- **Collection Statistics:** Display the total number of games, average price, most expensive game, and cheapest game.
- **Input Validation:** Handle invalid menu options, empty game names, negative prices, and invalid numeric menu input.

## Technologies and Concepts

- Java
- Object-Oriented Programming (OOP)
- Encapsulation
- ArrayList and Java Collections
- Exception Handling
- Custom Exceptions
- Package Organization

## Project Structure

```text
GamesLibrary/
└── src/
    ├── domain/
    │   └── Game.java
    ├── exceptions/
    │   ├── InvalidGameNameException.java
    │   ├── InvalidMenuOptionException.java
    │   └── NegativeNumberException.java
    ├── main/
    │   └── GamesLibraryMain.java
    └── services/
        └── ServicesGameLibrary.java
```

## How to Run

1. Clone this repository:

```bash
git clone https://github.com/DanFigueredo/GamesLibrary.git
```

2. Open the project in your preferred Java IDE, such as IntelliJ IDEA.

3. Run the `GamesLibraryMain.java` file located in the `main` package.

4. Follow the console menu to manage your game collection.

## Important Notes

- Game information is stored in memory using an `ArrayList`.
- Data is not persisted after the application is closed.
- This project was developed as a personal learning project to practice Java fundamentals and object-oriented programming.

## Author

**Daniel Figueredo**

- GitHub: [DanFigueredo](https://github.com/DanFigueredo)
- LinkedIn: [Daniel Figueredo](https://www.linkedin.com/in/daniel-figueredo07/)
