package EduManager.ui;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WelcomeScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("EduManager | Welcome");

        Button loginBtn = new Button("Login");
        Button signupBtn = new Button("Sign Up");
        Button guestBtn = new Button("Browse as Guest");

        loginBtn.setOnAction(e -> new LoginScreen().start(new Stage()));
        signupBtn.setOnAction(e -> new SignupScreen().start(new Stage()));
        guestBtn.setOnAction(e -> {
            System.out.println("Guest mode — course viewer coming soon...");
            primaryStage.close();
        });

        VBox root = new VBox(20, loginBtn, signupBtn, guestBtn);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #2b2b2b; -fx-padding: 40;");

        Scene scene = new Scene(root, 400, 300);
        scene.getStylesheets().add("styles/dark-theme.css"); // We'll make this later

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
