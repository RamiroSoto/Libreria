package com.Nombre.prolibre.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class App extends Application
{
    public static void main( String[] args )
    { 
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
        primaryStage = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        primaryStage.show();
	}    
    
}
