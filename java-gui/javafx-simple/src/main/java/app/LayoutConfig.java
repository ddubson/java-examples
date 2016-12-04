package app;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

/**
 * Author: ddubson
 */
public class LayoutConfig {
    private BorderPane rootLayout;
    private FXMLLoader rootLayoutLoader;
    private AnchorPane personOverview;
    private FXMLLoader personOverviewLoader;

    public FXMLLoader rootLayoutLoader() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/app/view/RootLayout.fxml"));
        return loader;
    }

    public BorderPane rootLayout() throws IOException {
        if(this.rootLayoutLoader == null) this.rootLayoutLoader = rootLayoutLoader();

        if(this.rootLayout == null) {
            this.rootLayout = (BorderPane) rootLayoutLoader.load();
        }

        return this.rootLayout;
    }

    public FXMLLoader personOverviewLoader() {
        if(this.personOverviewLoader == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("/app/view/PersonOverview.fxml"));
            this.personOverviewLoader = loader;
        }

        return this.personOverviewLoader;
    }

    public AnchorPane personOverview() throws IOException {
        if (this.personOverviewLoader == null) this.personOverviewLoader = personOverviewLoader();

        if(this.personOverview == null) {
            this.personOverview = (AnchorPane) personOverviewLoader.load();
        }

        return this.personOverview;
    }
}
