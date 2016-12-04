package app;

import app.view.PersonOverviewController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class FXApplication extends Application implements CommandLineRunner {
    private LayoutConfig layoutConfig;
    private Stage primaryStage;
    private SampleData data;

    public static void main(String[] args) {
        SpringApplication.run(FXApplication.class, args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.layoutConfig = new LayoutConfig();
        this.data = new SampleData();
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        // Show the scene containing the root layout.
        try {
            Scene scene = new Scene(layoutConfig.rootLayout());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            layoutConfig.rootLayout().setCenter(layoutConfig.personOverview());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Give the controller access to the main app.
        PersonOverviewController controller = layoutConfig.personOverviewLoader().getController();
        controller.setFXApplication(this);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public SampleData getData() {
        return data;
    }

    @Override
    public void run(String... args) throws Exception {
        launch(args);
    }
}
