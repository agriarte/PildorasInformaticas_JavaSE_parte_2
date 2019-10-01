package EjercicioChatVideo178;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;


public class EjerClienteChat {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        EjercicioChatVideo178.MarcoClienteChat mimarco=new EjercicioChatVideo178.MarcoClienteChat();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}


class MarcoClienteChat extends JFrame{

    public MarcoClienteChat(){

        setBounds(600,300,280,350);

        EjercicioChatVideo178.LaminaClienteChat milamina=new EjercicioChatVideo178.LaminaClienteChat();

        add(milamina);

        setVisible(true);

    }

}


class LaminaClienteChat extends JPanel implements Runnable {
    private JTextField campo1Txt,nickTxt,ipTxt;
    private JButton mibotonBtn;
    private JTextArea areaChatTxt;
    private JLabel chatTxt;

    public LaminaClienteChat(){

        nickTxt = new JTextField(5);
        add(nickTxt);

        chatTxt=new JLabel("--CHAT--");
        add(chatTxt);

        ipTxt = new JTextField(8);
        add(ipTxt);

        areaChatTxt = new JTextArea(12,20);
        add(areaChatTxt);

        campo1Txt =new JTextField(20);

        add(campo1Txt);

        mibotonBtn=new JButton("Enviar");

        mibotonBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(campo1Txt.getText());

                try {
                    //creación de Socket (vía de comunicación)
                    Socket miSocket= new Socket("192.168.1.40",9999);

                    EnvioPaqueteDatos datos = new EnvioPaqueteDatos();

                    datos.setNick(nickTxt.getText());
                    datos.setIp(ipTxt.getText());
                    datos.setTextoCliente(campo1Txt.getText());

                    //crear flujo de salida con objeto serializado.
                    //como datos implementa Serializable ya se se serializa el objeto
                    //Para enviar objetos por Sockets han de estar serializados (convertidos a unos y ceros )
                    ObjectOutputStream flujoSalidaPaquete = new ObjectOutputStream(miSocket.getOutputStream());

                    flujoSalidaPaquete.writeObject(datos);

                    miSocket.close();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        add(mibotonBtn);

        //ejecutar hilo de escucha

        Thread miHilo = new Thread(this);
        miHilo.start();

    }

    @Override
    public void run() {
        //este será el hilo en segundo plano siempre a la escucha para recibir chat
        try {
            //crear puente, flujo y rellena flujo
            ServerSocket escuchaCliente = new ServerSocket(9090);
            Socket cliente;
            EnvioPaqueteDatos paqueteRecibidos;
            while (true){
                cliente = escuchaCliente.accept();
                ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
                paqueteRecibidos =(EnvioPaqueteDatos) flujoEntrada.readObject();

                areaChatTxt.append("\n" + paqueteRecibidos.getNick() + ": " + paqueteRecibidos.getTextoCliente() );
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class EnvioPaqueteDatos implements Serializable {
    private String nick,ip, textoCliente;


    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTextoCliente() {
        return textoCliente;
    }

    public void setTextoCliente(String textoCliente) {
        this.textoCliente = textoCliente;
    }
}
