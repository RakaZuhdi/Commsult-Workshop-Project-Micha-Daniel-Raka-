package id.ac.sgu.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class Main extends Application implements EventHandler<ActionEvent> {
	
	Stage window;
	Scene scene1, scene2;
	Button button;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("thenewboston");
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		Label nameLabel = new Label("Username");
		GridPane.setConstraints(nameLabel, 0, 0);
		
		TextField nameInput = new TextField("Bucky");
		GridPane.setConstraints(nameInput, 1, 0);
		
		Label passLabel = new Label("Password");
		GridPane.setConstraints(passLabel, 0, 1);
		
		TextField passInput = new TextField();
		passInput.setPromptText("password");
		GridPane.setConstraints(passInput, 1, 1);
		
		Button loginButton = new Button("Log In");
		GridPane.setConstraints(loginButton, 1, 2);
		
		grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);
		
		Scene scene = new Scene(grid, 300, 200);
		window.setScene(scene);
		window.show();
		
		
//		window = primaryStage;
//		window.setTitle("thenewboston");
//		
//		HBox topMenu = new HBox();
//		Button buttonA = new Button("File");
//		Button buttonB = new Button("Edit");
//		Button buttonC = new Button("View");
//		topMenu.getChildren().addAll(buttonA, buttonB, buttonC);
//		
//		VBox leftMenu = new VBox();
//		Button buttonD = new Button("D");
//		Button buttonE = new Button("E");
//		Button buttonF = new Button("F");
//		leftMenu.getChildren().addAll(buttonD, buttonE, buttonF);
//		
//		BorderPane borderPane = new BorderPane();
//		borderPane.setTop(topMenu);
//		borderPane.setLeft(leftMenu);
//		
//		StackPane layout = new StackPane();
//		Scene scene = new Scene(borderPane, 300, 250);
//		window.setScene(scene);
//		window.show();
		
		
//		window = primaryStage;
//		window.setTitle("JavaFX - the newboston");
//		button = new Button("Close Program");
//		button.setOnAction(e -> {
//			e.consume();
//			closeProgram();
//		});
//		
//		window.setOnCloseRequest(e -> closeProgram());
//		
//		StackPane layout = new StackPane();
//		layout.getChildren().add(button);
//		Scene scene = new Scene(layout, 300, 250);
//		window.setScene(scene);
//		window.show();
		
//		window = primaryStage;
//		window.setTitle("the new boston");
//		button = new Button("Click Me");
//		
//		button.setOnAction(e -> {
//			boolean result = ConfirmBox.display("Title of the Window", "Are you sure you want to send naked pics?");
//			System.out.println(result);
//		});
//		
//		StackPane layout = new StackPane();
//		layout.getChildren().add(button);
//		Scene scene = new Scene(layout, 300, 250);
//		window.setScene(scene);
//		window.show();
//		
//		window = primaryStage;
//		window.setTitle("thenewboston");
//		
//		button = new Button("Click Me");
//		button.setOnAction(e -> AlertBox.display("Title of the Window", "Wow this alert box is awesome!"));
//		
//		StackPane layout = new StackPane();
//		layout.getChildren().add(button);
//		Scene scene = new Scene(layout, 300, 250);
//		window.setScene(scene);
//		window.show();
		
		
//		window = primaryStage;
//		
//		Label label1 = new Label("Welcone to the first scene!");
//		Button button1 = new Button("Go to scene 2");
//		button1.setOnAction(e -> window.setScene(scene2));
//		
//		VBox layout1 = new VBox(20);
//		layout1.getChildren().addAll(label1, button1);
//		scene1 = new Scene(layout1, 200, 200);
//		
//		Button button2 = new Button("This scene sucks, go back to scene 1");
//		button2.setOnAction(e -> window.setScene(scene1));
//		
//		StackPane layout2 = new StackPane();
//		layout2.getChildren().add(button2);
//		scene2 = new Scene(layout2, 600, 300);
//		
//		window.setScene(scene1);
//		window.setTitle("Title here");
//		window.show();
		
//		primaryStage.setTitle("Title of the Window");
//		button = new Button();
//		button.setText("Click me!");
//		
//		button.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent event) {
//				System.out.println("I am anonymous inner class!");
//			}
//			
//		});
//		
//		StackPane layout = new StackPane();
//		layout.getChildren().add(button);
//		
//		Scene scene = new Scene(layout, 300, 250);
//		primaryStage.setScene(scene);
//		primaryStage.show();
	}
	
	private void closeProgram() {
//		System.out.println("File is saved!");
//		window.close();
		
		Boolean answer = ConfirmBox.display("Title", "Sure you want to exit?");
		if(answer) {
			window.close();
		}
	}

}


