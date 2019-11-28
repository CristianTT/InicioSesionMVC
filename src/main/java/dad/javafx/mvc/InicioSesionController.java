package dad.javafx.mvc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class InicioSesionController {

	private InicioSesionView view = new InicioSesionView();
	private InicioSesionModel model = new InicioSesionModel();

	public InicioSesionController() {
		model.userProperty().bindBidirectional(view.getUserText().textProperty());
		model.passProperty().bindBidirectional(view.getPassText().textProperty());

		view.getAccederButton().setOnAction(e -> acceder());
		view.getCancelarButton().setOnAction(e -> cancelar());
		
		this.leerCSV();
	}

	private void acceder() {
		String md5 = DigestUtils.md5Hex(model.getPass()).toUpperCase();
		String realPass = model.listUsers.get(model.getUser());
		if (realPass != null && md5.equals(realPass)) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Iniciar sesión");
			alert.setHeaderText("Acceso permitido");
			alert.setContentText("Las credenciales de acceso son válidas");
			alert.showAndWait();
			System.exit(0);
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Iniciar sesión");
			alert.setHeaderText("Acceso denegado");
			alert.setContentText("El usuario y/o la contraseña no son válidos");
			alert.showAndWait();
			model.setPass("");
		}
	}

	private void cancelar() {
		System.exit(0);
	}

	private void leerCSV() {
		BufferedReader br;
		String line = "";
		try {
			br = new BufferedReader(new FileReader("src/main/resources/users.csv"));
			while ((line = br.readLine()) != null) {
				String[] datos = line.split(",");
				model.listUsers.put(datos[0], datos[1]);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public InicioSesionView getView() {
		return view;
	}

}
