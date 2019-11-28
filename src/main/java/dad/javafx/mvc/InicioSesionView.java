package dad.javafx.mvc;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class InicioSesionView extends VBox {

	private TextField userText;
	private PasswordField passText;
	private Button accederButton, cancelarButton;

	public InicioSesionView() {
		userText = new TextField();
		passText = new PasswordField();
		accederButton = new Button("Acceder");
		cancelarButton = new Button("Cancelar");

		GridPane loginPane = new GridPane();
		loginPane.addRow(0, new Label("Usuario: "), userText);
		loginPane.addRow(1, new Label("Contraseña: "), passText);
		loginPane.setVgap(10);
		loginPane.setHgap(10);
		loginPane.setAlignment(Pos.CENTER);
		loginPane.setPadding(new Insets(10, 20, 10, 20));
		ColumnConstraints[] cols = { new ColumnConstraints(), new ColumnConstraints() };
		loginPane.getColumnConstraints().setAll(cols);
		cols[0].setHgrow(Priority.ALWAYS);
		cols[1].setHgrow(Priority.ALWAYS);

		HBox buttonsBox = new HBox(15, accederButton, cancelarButton);
		buttonsBox.setAlignment(Pos.CENTER);

		this.getChildren().addAll(loginPane, buttonsBox);
		this.setSpacing(15);
		this.setAlignment(Pos.CENTER);

	}

	public TextField getUserText() {
		return userText;
	}

	public void setUserText(TextField userText) {
		this.userText = userText;
	}

	public PasswordField getPassText() {
		return passText;
	}

	public void setPassText(PasswordField passText) {
		this.passText = passText;
	}

	public Button getAccederButton() {
		return accederButton;
	}

	public void setAccederButton(Button accederButton) {
		this.accederButton = accederButton;
	}

	public Button getCancelarButton() {
		return cancelarButton;
	}

	public void setCancelarButton(Button cancelarButton) {
		this.cancelarButton = cancelarButton;
	}

}
