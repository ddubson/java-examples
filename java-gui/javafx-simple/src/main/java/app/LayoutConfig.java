package app;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;

/**
 * Author: ddubson
 */
public class LayoutConfig {
    private URL personEditDialogURI = this.getClass().getResource("/app/view/PersonEditDialog.fxml");

    private FXMLLoader personOverviewLoader;
    private FXMLLoader personEditDialogLoader;
    private FXMLLoader rootLayoutLoader;

    private BorderPane rootLayout;
    private AnchorPane personOverview;
    private AnchorPane personEditDialog;

    public FXMLLoader personEditDialogLoader() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(personEditDialogURI);
        return loader;
    }


    public FXMLLoader rootLayoutLoader() {
        if (this.rootLayoutLoader == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("/app/view/RootLayout.fxml"));
            this.rootLayoutLoader = loader;
        }
        return this.rootLayoutLoader;
    }

    public BorderPane rootLayout() throws IOException {
        if (this.rootLayout == null) {
            this.rootLayout = (BorderPane) rootLayoutLoader().load();
        }

        return this.rootLayout;
    }

    public FXMLLoader personOverviewLoader() {
        if (this.personOverviewLoader == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("/app/view/PersonOverview.fxml"));
            this.personOverviewLoader = loader;
        }

        return this.personOverviewLoader;
    }

    public AnchorPane personOverview() throws IOException {
        if (this.personOverview == null) {
            this.personOverview = (AnchorPane) personOverviewLoader().load();
        }

        return this.personOverview;
    }
}
