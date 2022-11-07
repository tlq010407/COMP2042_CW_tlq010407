# COMP2042_CW_hfylt5
Tang,Liqi 20259468

Create a Pane package to save Start.fxml and Menu.fxml:
Start.fxml: set and create the prototype scene and layout of start scene;
Menu.fxml: set and create the prototype scene and layout of menu scene;

Extend Controller.java to switch the scenes and contain the functions map to different buttons:
switchToMenu(), switchToGame(), changecolor(), help(), and quit() functions;

set the default primaryStage in main menu, and creat a "START" button to enter the menu scene,
the menu scene contains "start game", "change background color", "exit" and "rules" buttons:
"start game" button: start game, switch the menu scene to game scene;
"change background color" button: change the background color of the game scene, when click this button, a choice dialog popup window to let user to choose and change the background color;
"rules" button: show the game rules;
"exit" button: quit the game;

Divied the 'GameScene' class into 'Cell' class, 'GenerateNumRandon' class, 'Move' class, and 'passDestination' class.

'EndGame' class: delete the quitButton and add restart button to restart the game.
