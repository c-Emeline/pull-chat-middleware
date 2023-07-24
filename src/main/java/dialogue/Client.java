package dialogue;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import msgapplication.MsgApplication;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import static javafx.geometry.Pos.CENTER;

public class Client extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(new Scene(MsgApplication.createConnectionPane(primaryStage), 300, 300));
		primaryStage.setTitle("Connection");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
