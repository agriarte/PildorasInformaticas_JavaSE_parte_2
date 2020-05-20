package Video178Chat;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ClienteVideo178 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MarcoCliente miMarco = new MarcoCliente();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class MarcoCliente extends JFrame {

    public MarcoCliente() {
        setBounds(600, 300, 280, 350);
        LaminaMarcoCliente miLamina = new LaminaMarcoCliente();
        add(miLamina);
        setVisible(true);
        addWindowListener(new EnvioOnline());
    }

}

class EnvioOnline extends WindowAdapter {

    public void windowOpened(WindowEvent e) {
        Socket miSocket;
        try {
            miSocket = new Socket("192.168.1.45", 9999);
            PaqueteEnvio datos = new PaqueteEnvio();
            datos.setMensaje("online");
            ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());
            paqueteDatos.writeObject(datos);
            miSocket.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

}

class LaminaMarcoCliente extends JPanel implements Runnable {

    private JTextField campo1;    //, ip;
    private JComboBox ip;
    private JLabel nick;
    private JTextArea campoChat;
    private JButton miBoton;
    public LaminaMarcoCliente() {
        String nickUsuario = JOptionPane.showInputDialog("Nick: ");
        JLabel nNick = new JLabel("Nick: ");
        add(nNick);
        nick = new JLabel();
        nick.setText(nickUsuario);
        add(nick);
        JLabel texto = new JLabel("Online: ");
        add(texto);

        ip = new JComboBox();
        add(ip);
        campoChat = new JTextArea(12, 20);
        add(campoChat);
        campo1 = new JTextField(20);
        add(campo1);
        miBoton = new JButton("Enviar");
        EnviaTexto miEvento = new EnviaTexto();
        miBoton.addActionListener(miEvento);
        add(miBoton);
        Thread miHilo = new Thread(this);
        miHilo.start();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            ServerSocket servidorCliente = new ServerSocket(9090);
            Socket cliente;
            PaqueteEnvio paqueteRecibido;
            while (true) {
                //en escucha infinita. Controla si llegan paquetes de texto. La primera vez que se conecta un cliente
                //mandará la clave "online" y se usará para actualizar ComboBox con la ip del cliente
                cliente = servidorCliente.accept();
                ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
                paqueteRecibido = (PaqueteEnvio) flujoEntrada.readObject();
                if (!paqueteRecibido.getMensaje().equals("online"))
                    //si ya llegan mensajes actualizar campoChat
                    campoChat.append(paqueteRecibido.getNick() + ": " + paqueteRecibido.getMensaje() + "\n");
                else {
                    //si llega online, primera vez que arranca el cliente, actualiza comboBox
                    ArrayList<String> ipsMenu = new ArrayList<String>();
                    ipsMenu = paqueteRecibido.getIps();
                    ip.removeAllItems();
                    for (String z : ipsMenu)
                        ip.addItem(z);
                }
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.getMessage();
        }

    }

    private class EnviaTexto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            campoChat.append("Yo: " + campo1.getText() + "\n");
            try {
                // Direccion de IP del servidor y puerto del servidor que esta a la escucha
                // en el constructor del socket
                Socket miSocket = new Socket("192.168.1.45", 9999);
                PaqueteEnvio datos = new PaqueteEnvio();
                datos.setNick(nick.getText());
                datos.setIp(ip.getSelectedItem().toString());
                datos.setMensaje(campo1.getText());
                ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());
                paqueteDatos.writeObject(datos);
                miSocket.close();
            } catch (UnknownHostException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                // IP mal, ocupada, congestion en la red y tarde en contestar, etc
                System.out.println(e1.getMessage());
            }
        }

    }

}

class PaqueteEnvio implements Serializable {

    private String nick, ip, mensaje;
    private ArrayList<String> ips;

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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ArrayList<String> getIps() {
        return ips;
    }

    public void setIps(ArrayList<String> ips) {
        this.ips = ips;
    }

}
