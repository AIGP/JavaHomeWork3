package HomeWork3;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestAsServer {

    public static void main(String[] args) {
        Socket client = null;
        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        try {
            ServerSocket server = new ServerSocket(8888);
            client = server.accept();
            out = new ObjectOutputStream(client.getOutputStream());
            in = new ObjectInputStream(client.getInputStream());
            Cat cat = (Cat) in.readObject();
            System.out.println("Телепортировали кота "+cat.toString());
            out.close();
            in.close();
            client.close();
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}