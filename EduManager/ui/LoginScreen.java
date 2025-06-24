package EduManager.ui;

import controller.DatabaseManager;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

public class LoginScreen extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("EduManager | Login");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        PasswordField passField = new PasswordField();
        passField.setPromptText("Password");

        Button loginBtn = new Button("Login");
        Label status = new Label();

        loginBtn.setOnAction(e -> {
            try (Connection conn = DatabaseManager.getConnection()) {
                String sql = "SELECT * FROM students WHERE email = ? AND password = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, emailField.getText());
                ps.setString(2, passField.getText());
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    status.setText("✅ Login Success! Welcome, " + rs.getString("name"));
                    // TODO: Open Dashboard here
                    stage.close();
                } else {
                    status.setText("❌ Invalid Credentials");
                }
            } catch (Exception ex) {
                status.setText("❌ " + ex.getMessage());
            }
        });

        VBox root = new VBox(10, emailField, passField, loginBtn, status);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #2b2b2b; -fx-padding: 30;");

        Scene scene = new Scene(root, 400, 300);
        scene.getStylesheets().add("styles/dark-theme.css");

        stage.setScene(scene);
        stage.show();
    }
}

