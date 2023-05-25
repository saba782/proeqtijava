import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ATMGUI extends Application {

    private Stage window;
    private Scene loginScene, mainScene;
    private TextField usernameInput, pinInput;
    private Label welcomeLabel, errorLabel;
    private GridPane numberKeyboard;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        // Login Scene
        GridPane loginGrid = createLoginGrid();
        loginScene = new Scene(loginGrid, 300, 200);

        // Main Scene
        GridPane mainGrid = createMainGrid();
        mainScene = new Scene(mainGrid, 300, 200);

        window.setScene(loginScene);
        window.setTitle("ATM GUI");
        window.show();
    }

    private GridPane createLoginGrid() {
        GridPane loginGrid = new GridPane();
        loginGrid.setAlignment(Pos.CENTER);
        loginGrid.setHgap(10);
        loginGrid.setVgap(10);
        loginGrid.setPadding(new Insets(25, 25, 25, 25));
        loginGrid.setStyle("-fx-background-color: #F8F8FF;");

        welcomeLabel = new Label("Welcome to the ATM!");
        welcomeLabel.setStyle("-fx-font-size: 24px;");

        Label usernameLabel = new Label("Username:");
        usernameLabel.setStyle("-fx-font-size: 16px;");

        usernameInput = new TextField();
        usernameInput.setStyle("-fx-font-size: 16px;");

        Label pinLabel = new Label("PIN:");
        pinLabel.setStyle("-fx-font-size: 16px;");

        pinInput = new PasswordField();
        pinInput.setStyle("-fx-font-size: 16px;");

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> login());
        loginButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 16px;");

        errorLabel = new Label("");
        errorLabel.setStyle("-fx-text-fill: red;");
        numberKeyboard = createNumberKeyboard();

        loginGrid.add(welcomeLabel, 0, 0, 2, 1);
        loginGrid.add(usernameLabel, 0, 1);
        loginGrid.add(usernameInput, 1, 1);
        loginGrid.add(pinLabel, 0, 2);
        loginGrid.add(pinInput, 1, 2);
        loginGrid.add(loginButton, 1, 3);
        loginGrid.add(errorLabel, 1, 4);
        loginGrid.add(numberKeyboard, 2, 1, 1, 4);

        return loginGrid;
    }

    private GridPane createMainGrid() {
        GridPane mainGrid = new GridPane();
        mainGrid.setAlignment(Pos.CENTER);
        mainGrid.setHgap(10);
        mainGrid.setVgap(10);