package PaqueteSockets;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ClienteChat {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MarcoClienteChat mimarco=new MarcoClienteChat();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}


class MarcoClienteChat extends JFrame{

    public MarcoClienteChat(){

        setBounds(600,300,280,350);

        LaminaClienteChat milamina=new LaminaClienteChat();

        add(milamina);

        setVisible(true);

    }

}


class LaminaClienteChat extends JPanel {

    public LaminaClienteChat(){

        JLabel cliente=new JLabel("CLIENTE");

        add(cliente);

        campo1=new JTextField(20);

        add(campo1);

        miboton=new JButton("Enviar");

        miboton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(campo1.getText());

                try {
                    //creación de Socket (vía de comunicación)
                    Socket miSocket= new Socket("192.168.1.43",9999);
                    //creación de flujo de datos (OutputString)
                    DataOutputStream flujoSalida = new DataOutputStream(miSocket.getOutputStream());
                    //definir que va en el flujo de datos
                    flujoSalida.writeUTF(campo1.getText());
                    flujoSalida.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        add(miboton);

    }



    private JTextField campo1;

    private JButton miboton;
}





