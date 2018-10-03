package ComponentesSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjercicioComponentesSwing {
    public static void main(String[] args) {
        MarcoComponentesSwing miMarco = new MarcoComponentesSwing();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoComponentesSwing extends JFrame{
    public MarcoComponentesSwing() throws HeadlessException {
        setBounds(600,400,700,500);
        add(new LaminaComponentesSwing());
        setVisible(true);
    }
}

class LaminaComponentesSwing extends JPanel{

JLabel labelNombre,labelApellido;
JTextField fieldNombre,fieldApellido;
String ultimoNombre,ultimoApellido;

JTextArea areaTexto;

JButton boton1,boton2;
JCheckBox checkBox1,checkBox2;
JRadioButton radioButton1,radioButton2;

String nombre,apellido;

    public LaminaComponentesSwing() {
        setLayout(new BorderLayout(10,10));
        JPanel superior = new JPanel();
        JPanel centro = new JPanel();
        JPanel inferior = new JPanel();

        labelNombre = new JLabel("Nombre:");
        labelApellido = new JLabel("Apellido:");
        fieldNombre = new JTextField(20);
        fieldApellido = new JTextField(20);

        superior.add(labelNombre);
        superior.add(fieldNombre);
        superior.add(labelApellido);
        superior.add(fieldApellido);

        areaTexto = new JTextArea(20,35);
        JScrollPane miScrollPane = new JScrollPane(areaTexto);
        areaTexto.setLineWrap(true);
        centro.add(miScrollPane);

        boton1= new JButton("Botón 1");
        boton2 = new JButton("Botón 2");
        checkBox1 = new JCheckBox("Casilla 1",true);//crear checkBox en estado Selected
        checkBox2 = new JCheckBox("Casilla 2");
        radioButton1 = new JRadioButton("Radio 1");
        radioButton2 = new JRadioButton("Radio 2");

        boton1.addActionListener(new ManejaClicks());
        boton2.addActionListener(new ManejaClicks());
        checkBox1.addActionListener(new ManejaClicks());
        checkBox2.addActionListener(new ManejaClicks());
        radioButton1.addActionListener(new ManejaClicks());
        radioButton2.addActionListener(new ManejaClicks());




        radioButton2.setSelected(true);//cambiar estado una vez creado

        ButtonGroup miGrupo = new ButtonGroup();
        miGrupo.add(radioButton1);
        miGrupo.add(radioButton2);

        inferior.add(boton1);
        inferior.add(boton2);
        inferior.add(checkBox1);
        inferior.add(checkBox2);
        inferior.add(radioButton1);
        inferior.add(radioButton2);

        add(superior,BorderLayout.NORTH);
        add(centro,BorderLayout.CENTER);
        add(inferior,BorderLayout.SOUTH);
    }
    private class ManejaClicks implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            esNuevoNombre();
            if (e.getSource()==boton1){
                areaTexto.setText(areaTexto.getText()+"Has pulsado boton 1\n");
            }
            if (e.getSource()==boton2){
                areaTexto.setText(areaTexto.getText()+"Has pulsado boton 2\n");
            }
            if (e.getSource()==checkBox1){
                if (checkBox1.isSelected()) areaTexto.setText(areaTexto.getText()+"Casilla 1 ON\n");
                else areaTexto.setText(areaTexto.getText()+"Casilla 1 OFF\n");

            }
            if (e.getSource()==checkBox2){
                if (checkBox2.isSelected()) areaTexto.setText(areaTexto.getText()+"Casilla 2 ON\n");
                else areaTexto.setText(areaTexto.getText()+"Casilla 2 OFF\n");

            }
            if (e.getSource()==radioButton1){
                if (radioButton1.isSelected()) areaTexto.setText(areaTexto.getText()+"Radio 1 ON\n");
            }
            if (e.getSource()==radioButton2){
                if (radioButton2.isSelected()) areaTexto.setText(areaTexto.getText()+"Radio 2 ON\n");
            }

        }
        private void esNuevoNombre(){
            //si ha cambiado el nombre, representa que es nuevo usuario y lo imprimirá
            if (!(fieldNombre.getText().equals(ultimoNombre) && fieldApellido.getText().equals(ultimoApellido))){
                System.out.print("Listado de acciones del usuario: ");
                System.out.println(fieldNombre.getText() + " " + fieldApellido.getText());
                areaTexto.setText(areaTexto.getText()+"Listado de acciones del usuario: \n" +
                        fieldNombre.getText() + " " + fieldApellido.getText() + "\n");
                ultimoNombre = fieldNombre.getText();
                ultimoApellido = fieldApellido.getText();
            }
        }
    }
}