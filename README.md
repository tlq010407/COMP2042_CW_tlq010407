# COMP2042_CW_tlq010407
Tang,Liqi 20259468

In order to compile this 2048Game, download javafx packages('javafx-sdk-19') online and JDK-17, and imported into intellJ File/project structure/library.
Build project.
Run the file Main.java in the following directory:COMP2042_CW_tlq010407/src/main/java/com/example/demo
Open file using existing resources and import from external model maven

Design.pdf: the class diagram.

javadoc:the javedoc file is in the same file as the design.pdf, path: COMP2042 Liqi Tang/javadoc.

Fix the scoring system error: add the score correctly. 

Fix the quit error: quit the game automatically when the "OK" button is clicked in an alert. 

Fix the cell movement bug: it won't generate random numbers without movements between cells.

Fix the double merge bug: if there is a row like 2 2 2 2, when user press either left or right key, the cells will be merged as 4 4.

Fix the press key bug: the cells only will be moved when the users press the up, down, left, and right keys on the keyboard.

Fix the reach goal bug: when user reach final goal ---2048, the game will be ended automatically and show congratulations words to the user.

Create 'GenerateNumRandom', 'Move', 'passDestination', 'StartController', 'MenuController', 'Record', 'RankScene', 'Buttons' and 'Survival' classes and 4 packages to do the refactoring. 
Create a permanent high score list (using a file to store scores and player names). 

Add 4 modes to the game: 'Classic' Mode, 'Hard' Mode,'Own' Mode and 'Survival' Mode.

Create two fxml files:
Start.fxml: set and create the prototype scene and layout of the start scene; 
Menu.fxml: set and create the prototype scene and layout of the menu scene;

'StartController' class: 
Extend, switch the scenes and contain the function map to different buttons: switchToMenu(), getname() functions;

'MenuController' class: 
Extend, switch the scenes and contain the function map to different buttons: 
switchToGame(), changecolor(), help(), chooseMode(), Showrecord() and quit() functions;

'Main' class: 
Set the default primaryStage in the main menu, and create a "START" button to enter the menu scene and get the user name.

'GameScene' class: 
Divided the 'GameScene' class into 'Cell' class, 'GenerateNumRandon' class, 'Move' class, and 'passDestination' class.

'passDestination' class: 
Divided the original 'passDestination' method into four functions: ' passLeft', 'passRight', 'passDown' and 'passUp' methods.

'Record'classes: Store the highest score and recording keeper's name.

'Survival' class: create a countdown timer for 'Survival' Mode.

'Buttons' class: store the button methods.

'RankScene' class: show the rank scene.

'EndGame' class: 
Create a popup window to pop up the final score. Show the highest score in the end-game scene. 
Create a 'Try Again!' button: begin a new game without entering the menu scene. 
Create a 'Back to Menu' button: back to the menu scene.
Create a 'New Player' button: To enter an new user's name.
Create a 'Rank' button: To show the rank scene.
