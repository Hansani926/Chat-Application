import com.sun.deploy.net.socket.UnixDomainSocket;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.Socket;
import java.util.Base64;

public class ClientUiController {
    public TextArea TxtMessageArea;
    public TextField TxtMessage;

    static Socket socket = null;
    static DataOutputStream dataOutputStream;
    static DataInputStream dataInputStream;
    public AnchorPane root;


    public void initialize() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket = new Socket("localhost", 5000);
                    dataInputStream = new DataInputStream(socket.getInputStream());
                    dataOutputStream = new DataOutputStream(socket.getOutputStream());

                    String messageIn = "";

                    while (!messageIn.equals("end")) {
                        messageIn = dataInputStream.readUTF();
                        TxtMessageArea.appendText("\n"+"Client"+":" + messageIn.trim());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }




            }


        }).start();




        }



    public void SendMessage(ActionEvent actionEvent) throws IOException {

        String reply="";
        reply=TxtMessage.getText();
        dataOutputStream.writeUTF(reply);
        TxtMessage.clear();
    }
}
