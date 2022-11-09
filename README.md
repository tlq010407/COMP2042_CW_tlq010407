# COMP2042_CW_hfylt5
Tang,Liqi 20259468

Fix the scoring system error: add the score correctly.
Fix the quit error: quit the game automatically when clicked the "OK" button in alert.

Create a Pane package to save Start.fxml and Menu.fxml:
Start.fxml: set and create the prototype scene and layout of start scene;
Menu.fxml: set and create the prototype scene and layout of menu scene;

'Controller' class: 
Extend, switch the scenes and contain the functions map to different buttons:
switchToMenu(), switchToGame(), changecolor(), help(), and quit() functions;

'Main' class:
Set the default primaryStage in main menu, and creat a "START" button to enter the menu scene,
the menu scene contains "start game", "change background color", "exit" and "rules" buttons:
"start game" button: start game, switch the menu scene to game scene;
"change background color" button: change the background color of the game scene, when click this button, a choice dialog popup window to let user to choose and change the background color;
"rules" button: show the game rules;
"exit" button: quit the game;

'GameScene' class:
Divied the 'GameScene' class into 'Cell' class, 'GenerateNumRandon' class, 'Move' class, and 'passDestination' class.

'EndGame' class: 
Create a popup window to popup the final score.
Show the highest score in end game scene.
Create a 'Try Again!' button: when user click this button, they can begian a new game without enter the menu scene.
Create a 'Back to Menu' button: when user click this button, they can back to menu scene.

Create a 'Record' class to contain a permenent highest score.
Create a 'Rank' class.
