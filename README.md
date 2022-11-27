# COMP2042_CW_hfylt5
Tang,Liqi 20259468

Fix the scoring system error: add the score correctly. 

Fix the cell number adding error.

Fix the quit error: quit the game automatically when the "OK" button is clicked in an alert. 

Fix the cell movement bug: it won't generate random numbers without movements between cells.

Fix the double merge bug: if there is a row like 2 2 2 2, when user press either left or right key, the cells will be merged as 4 4.

Fix the press key bug: the cells only will be moved when the users press the up, down, left, and right keys on the keyboard.

Fix the reach goal bug: when user reach final goal ---2048, the game will be ended automatically and show congratulations words to the user.

Create 'GenerateNumRandom', 'Move', 'passDestination', 'StartController', 'MenuController', 'Record', 'RecordUser' and 'Survival' classes and Pane package. 
Create a permanent high score list (using a file to store scores and player names). 

Add 4 modes to the game: 'Classic' Mode, 'Hard' Mode,'Own' Mode and 'Survival' Mode.

Create a Pane package to save Start.fxml and Menu.fxml: Start.fxml: 
set and create the prototype scene and layout of the start scene; 
Menu.fxml: set and create the prototype scene and layout of the menu scene;

'StartController' class: 
Extend, switch the scenes and contain the function map to different buttons: switchToMenu(), getname() functions;

'MenuController' class: 
Extend, switch the scenes and contain the function map to different buttons: 
switchToGame(), changecolor(), help(), chooseMode(), Showrecord() and quit() functions;

'Main' class: 
Set the default primaryStage in the main menu, and create a "START" button to enter the menu scene and get the user name, the menu scene contains "start game", "change background colour", "exit" and "rules" buttons: 
"start game" button: choose the game mode, start the game, switch the menu scene to game scene; 
"change background colour" button: change the background colour of the game scene, then click this button, a choice dialogue pop up window to let user choose and change the background colour; 
"rules" button: show the game rules; 
"record" button: show the highest score and recording keeper's name;
"exit" button: quit the game;

'GameScene' class: 
Divided the 'GameScene' class into 'Cell' class, 'GenerateNumRandon' class, 'Move' class, and 'passDestination' class.

'passDestination' class: 
Divided the original 'passDestination' method into four functions: ' passLeft', 'passRight', 'passDown' and 'passUp' methods.

'Record' and 'RecordUser' classes are used to store the highest score and recording keeper's name.

'Survival' class: create a countdown timer for 'Survival' Mode.

'EndGame' class: 
Create a popup window to pop up the final score. Show the highest score in the end-game scene. 
Create a 'Try Again!' button: when users click this button, they can begin a new game without entering the menu scene. 
Create a 'Back to Menu' button: when users click this button, they can back to the menu scene.
