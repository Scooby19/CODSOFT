package EduManager.ui;

import controller.DatabaseManager;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SignupScreen extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("EduManager | Sign Up");

        TextField nameField = new TextField();
        nameField.setPromptText("Full Name");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        PasswordField passField = new PasswordField();
        passField.setPromptText("Password");

        Button signupBtn = new Button("Sign Up");
        Label status = new Label();

        signupBtn.setOnAction(e -> {
            try (Connection conn = DatabaseManager.getConnection()) {
                String sql = "INSERT INTO students (name, email, password) VALUES (?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, nameField.getText());
                ps.setString(2, emailField.getText());
                ps.setString(3, passField.getText());
                ps.executeUpdate();
                status.setText("✅ Registered Successfully!");
            } catch (Exception ex) {
                status.setText("❌ " + ex.getMessage());
            }
        });

        VBox root = new VBox(10, nameField, emailField, passField, signupBtn, status);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #2b2b2b; -fx-padding: 30;");

        Scene scene = new Scene(root, 400, 300);
        scene.getStylesheets().add("styles/dark-theme.css");

        stage.setScene(scene);
        stage.show();
    }
}
