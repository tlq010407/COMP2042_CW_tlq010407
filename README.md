# COMP2042_CW_hfylt5
Tang,Liqi 20259468

Fix the scoring system error: add the score correctly. 

Fix the cell number adding error.

Fix the double merge: when one of the column is like 2 2 2 2, then when we press the left or right key, it gonna be merge to two 4, instead of one 4 and two 2.

Fix the quit error: quit the game automatically when the "OK" button is clicked in an alert. 

Fix the cell movement bug: it won't generate random number while there is no movenments happen between cells.

Create 'GenerateNumRandom', 'Move', 'passDestination', 'StartController', 'MenuController', 'Record', 'RecordUser' and 'Survival' classes and Pane package. 
Create a permanent high score list (using a file to store scores and player names). 

Add 3 modes to the game: 'Classic' Mode, 'Hard' Mode, and 'Survival' Mode.

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
