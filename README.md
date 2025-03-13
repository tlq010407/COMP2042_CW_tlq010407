# 2048 Game - JavaFX Implementation

## Overview
This project is a **JavaFX-based 2048 Game** developed as part of **COMP2042 Coursework**. It includes multiple game modes, enhanced gameplay mechanics, and an improved scoring system. The game is implemented in **Java 17** and uses **JavaFX SDK 19** for GUI development.

## Features
- **Four Game Modes:**
  - **Classic Mode:** Standard 2048 gameplay.
  - **Hard Mode:** Increased difficulty with fewer moves.
  - **Own Mode:** Customizable gameplay.
  - **Survival Mode:** Time-based challenge with a countdown timer.
- **Improved Mechanics:**
  - Fixed **scoring system** to correctly track points.
  - Fixed **cell movement bug** to prevent random number generation without movement.
  - Fixed **double merge bug** (e.g., `2 2 2 2` merges correctly to `4 4`).
  - Fixed **press key bug**, allowing movement only when **arrow keys** are pressed.
  - Fixed **quit error**, ensuring the game exits properly when clicking "OK" in an alert.
  - Fixed **goal achievement bug**, automatically ending the game at **2048** with a congratulatory message.
- **High Score System:**
  - Stores player names and scores in a **persistent high-score file**.
  - Displays leaderboard with rankings.
- **Refactored Code Structure:**
  - Organized into four packages for modularity.
  - Introduced multiple new classes for improved code readability and maintainability.

## Project Structure
### Core Game Classes:
- **`Main.java`** - Entry point of the game, initializes the primary scene.
- **`GameScene.java`** - Manages game logic and board rendering.
- **`Cell.java`** - Represents individual tiles in the game grid.
- **`GenerateNumRandom.java`** - Handles random number generation.
- **`Move.java`** - Manages tile movement mechanics.
- **`passDestination.java`** - Handles directional movement logic (`passLeft`, `passRight`, `passUp`, `passDown`).

### UI & Scene Management:
- **FXML Files:**
  - `Start.fxml` - Defines the start screen layout.
  - `Menu.fxml` - Defines the main menu layout.
- **Controllers:**
  - `StartController.java` - Handles start screen interactions (e.g., `switchToMenu()`, `getname()`).
  - `MenuController.java` - Handles menu navigation (`switchToGame()`, `changecolor()`, `help()`, `chooseMode()`, `Showrecord()`, `quit()`).
- **EndGame.java:**
  - Displays the final score in a popup.
  - Provides **Try Again**, **Back to Menu**, **New Player**, and **Rank** buttons.

### Additional Features:
- **`Record.java`** - Stores high scores and player records.
- **`RankScene.java`** - Displays the ranking leaderboard.
- **`Survival.java`** - Implements a countdown timer for Survival Mode.
- **`Buttons.java`** - Stores button-related methods.

## Installation & Setup
### Prerequisites
- **Java Development Kit (JDK 17)**
- **JavaFX SDK 19** (Download and import into IntelliJ **File > Project Structure > Libraries**)
- **Maven Configuration** (Import external Maven model)

### Running the Game
1. **Clone the Repository:**
   ```sh
   git clone https://github.com/your-repo/2048Game.git
   ```
2. **Open in IntelliJ:**
   - Open the project and import Maven dependencies.
3. **Build the Project:**
   - Navigate to **`src/main/java/com/example/demo`**.
   - Run **`Main.java`** to start the game.

## Documentation
- **Class Diagram:** Available in `Design.pdf`.
- **Javadoc Documentation:** Located in `COMP2042_Liqi_Tang/javadoc`.

## Future Improvements
- Implement AI-based move suggestions.
- Add online multiplayer mode.
- Introduce visual themes and animations.

## Contributors
- **Liqi Tang (20259468)** - Developer
