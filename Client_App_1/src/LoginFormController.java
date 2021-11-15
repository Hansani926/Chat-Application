import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginFormController {
    public AnchorPane root;
    public AnchorPane btnLogin;
    public TextField txtName;
    public void setUI(String location) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource(".."+location))));
        stage.centerOnScreen();
    }



    public void loginOnAction(MouseEvent mouseEvent) throws IOException {
        String name = txtName.getText().trim();

        if (name.length()>0 ){

            if (name.equalsIgnoreCase("Hansani")
                    ){


                URL resource = this.getClass().
                        getResource("ClientUi.fxml");
                Parent load = FXMLLoader.load(resource);
                Scene scene= new Scene(load);
                Stage stage= (Stage) root.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();


            }else{
                new Alert(Alert.AlertType.WARNING,"Try Again !!!!",
                        ButtonType.OK,ButtonType.NO).show();
            }
        }else{
            new Alert(Alert.AlertType.WARNING,"Empty !!!!",
                    ButtonType.OK,ButtonType.NO).show();
        }

    }
}
