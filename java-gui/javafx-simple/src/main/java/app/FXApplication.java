package app;

import app.model.Person;
import app.view.PersonOverviewController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

import static javafx.collections.FXCollections.observableArrayList;

@SpringBootApplication
public class FXApplication extends Application implements CommandLineRunner {
    public LayoutConfig layoutConfig;
    private Stage primaryStage;
    private ObservableList<Person> personData;

    public FXApplication() {
        personData = observableArrayList();
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
    }

    public static void main(String[] args) {
        SpringApplication.run(FXApplication.class, args);
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }

    @Override
    public void start(Stage primaryStage) {
        this.layoutConfig = new LayoutConfig();
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

    @Override
    public void run(String... args) throws Exception {
        launch(args);
    }
}
