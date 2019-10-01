package PaqueteSockets;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorChat {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MarcoServidorChat mimarco = new MarcoServidorChat();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoServidorChat extends JFrame implements Runnable {

    private JTextArea areatexto;

    public MarcoServidorChat() {

        setBounds(1200, 300, 280, 350);

        JPanel milamina = new JPanel();

        milamina.setLayout(new BorderLayout());

        areatexto = new JTextArea();

        milamina.add(areatexto, BorderLayout.CENTER);

        add(milamina);

        setVisible(true);

        Thread miHilo = new Thread(this);
        miHilo.start();


    }

    @Override
    public void run() {
        System.out.println("Ejecutando Thread");


        try {
            //crear una escucha permanente del puerto x
            ServerSocket miServerSocket = new ServerSocket(9999);

            //bucle sin fin, siempre a la escucha de nuevas entradas
            while (true) {
                //accept devuelve un objeto tipo Socket. Con la siguiente linea le estamos diciendo que acepte todas las
                //conexiones y las guardamos en un Socket
                Socket miSocket = miServerSocket.accept();
                //flujo de entrada de datos
                DataInputStream miFlujoEntrada = new DataInputStream(miSocket.getInputStream());
                //leer flujo de entrada, se guarda en String
                String texto = miFlujoEntrada.readUTF();
                //añadir texto al fieldtext
                areatexto.append("\n" + texto);
                //cerrar conexiones
                miSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

