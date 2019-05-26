package edu.cuny.brooklyn.cisc3120.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class JavaFXCalculatorApp extends Application {
    private final static String MAIN_SCENE_FXML = "fxml_mainscene.fxml";
    private final static String APP_TITLE = "Simple JavaFX Calculator";
    private static final String MAIN_CSS_FILE = "appmain.css";
    
//    As follows from the filenames we have: Controller Class in MainSceneController, Model in CalculatorModel  
//    and View in fxml_mainscene.fxml. This separates our App into 3 logical part that serve different purposes.
//    Model contains logic of the App, View is responsible for UI and Controller handles input-output behaviour.
//    Divide and Conquer!!! 
    
            
            
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane mainPane = (Pane)FXMLLoader.load(getClass().getResource(MAIN_SCENE_FXML));
        Scene mainScene = new Scene(mainPane);  
        
        mainScene.getStylesheets().add(MAIN_CSS_FILE);
        
        primaryStage.setTitle(APP_TITLE);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
}
