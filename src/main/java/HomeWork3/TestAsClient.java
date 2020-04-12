package HomeWork3;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class TestAsClient {

    public static void main(String[] args) throws InterruptedException {
        Socket client = null;
        ObjectOutputStream out = null;
        ObjectInputStream in = null;

        try {
            client = new Socket("127.0.0.1", 8888);
            out = new ObjectOutputStream(client.getOutputStream());
            in = new ObjectInputStream(client.getInputStream());
            Cat cat = new Cat("Васька");
            out.writeObject(cat);
            out.flush();
            out.close();
            in.close();
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}