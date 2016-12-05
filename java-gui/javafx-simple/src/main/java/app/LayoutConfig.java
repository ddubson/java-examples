package app;

import javafx.fxml.FXMLLoader;

import java.net.URL;

/**
 * Author: ddubson
 */
public class LayoutConfig {
    private static final String ROOT_VIEW_DIR = "/app/view";
    private URL personEditDialogURI = this.getClass().getResource(ROOT_VIEW_DIR + "/PersonEditDialog.fxml");
    private URL rootLayoutURL = this.getClass().getResource(ROOT_VIEW_DIR + "/RootLayout.fxml");
    private URL personOverviewURL = this.getClass().getResource(ROOT_VIEW_DIR + "/PersonOverview.fxml");

    public FXMLLoader personEditDialogLoader() {
        return new FXMLLoader(personEditDialogURI);
    }

    public FXMLLoader rootLayoutLoader() {
        return new FXMLLoader(rootLayoutURL);
    }

    public FXMLLoader personOverviewLoader() {
        return new FXMLLoader(personOverviewURL);

    }
}
