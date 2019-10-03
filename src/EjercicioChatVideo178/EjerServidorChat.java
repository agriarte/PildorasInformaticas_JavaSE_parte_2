package EjercicioChatVideo178;

import javax.swing.*;
        import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
        import java.net.Socket;

public class EjerServidorChat {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        EjercicioChatVideo178.MarcoServidorChat mimarco = new EjercicioChatVideo178.MarcoServidorChat();

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

            //variables que viajan en el socket
            String nick,ip,mensaje;

            //instancia de la clase que lleva los datos
            EnvioPaqueteDatos paqueteRecibido;

            //bucle sin fin, siempre a la escucha de nuevas entradas
            while (true) {
                //accept devuelve un objeto tipo Socket. Con la siguiente linea le estamos diciendo que acepte todas las
                //conexiones y las guardamos en un Socket
                Socket miSocket = miServerSocket.accept();

                //obtenemos la dirección del cliente en formato InetAdress. La siguiente linea
                //es para convertirlo a formato String
                InetAddress dirCliente=miSocket.getInetAddress();
                String dirClienteStr = dirCliente.getHostAddress();
                //flujo de entrada de datos
                ObjectInputStream miFlujoEntrada = new ObjectInputStream(miSocket.getInputStream());
                //leer flujo de entrada, paquete serializado
                paqueteRecibido =(EnvioPaqueteDatos) miFlujoEntrada.readObject();

                nick = paqueteRecibido.getNick();
                ip = paqueteRecibido.getIp();
                mensaje = paqueteRecibido.getTextoCliente();


                //añadir texto al fieldtext
                areatexto.append("\n Nick : " + nick + " Ip:  " + ip + " Mensaje: " + mensaje);

                //### Reenvio de mensajes, 3 pasos:
                //1-construción de puente de comunicación (el soket)
                //2- de flujo de datos (el stream)
                //3- meter en el stream el objeto
                // y también cerrar el socket
                Socket reenvioDestinatario = new Socket(ip,9090);
                ObjectOutputStream  paqueteReenvio = new ObjectOutputStream(reenvioDestinatario.getOutputStream());
                paqueteReenvio.writeObject(paqueteRecibido);
                reenvioDestinatario.close();

                //cerrar conexiones
                miSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

