package dad.javafx;

import java.lang.ModuleLayer.Controller;

import dad.javafx.mvc.InicioSesionController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class InicioSesionApp extends Application {
	
	private InicioSesionController controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		controller = new InicioSesionController();
		
		Scene scene = new Scene(controller.getView(), 300, 200);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("InicioSesionMVC");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
