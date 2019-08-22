package Threads;

import java.awt.geom.*;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class UsoThreads {


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        JFrame marco=new MarcoRebote();

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        marco.setVisible(true);

    }

}




//Movimiento de la pelota-----------------------------------------------------------------------------------------

class Pelota{

    // Mueve la pelota invirtiendo posición si choca con límites

    public void mueve_pelota(Rectangle2D limites){

        x+=dx;

        y+=dy;

        if(x<limites.getMinX()){

            x=limites.getMinX();

            dx=-dx;
        }

        if(x + TAMX>=limites.getMaxX()){

            x=limites.getMaxX() - TAMX;

            dx=-dx;
        }

        if(y<limites.getMinY()){

            y=limites.getMinY();

            dy=-dy;
        }

        if(y + TAMY>=limites.getMaxY()){

            y=limites.getMaxY()-TAMY;

            dy=-dy;

        }

    }

    //Forma de la pelota en su posición inicial

    public Ellipse2D getShape(){

        return new Ellipse2D.Double(x,y,TAMX,TAMY);

    }

    private static final int TAMX=15;

    private static final int TAMY=15;

    private double x=0;

    private double y=0;

    private double dx=1;

    private double dy=1;


}

// Lámina que dibuja las pelotas----------------------------------------------------------------------


class LaminaPelota extends JPanel{

    private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();

    //Añadimos pelota a la lámina

    public void add(Pelota b){

        pelotas.add(b);
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2=(Graphics2D)g;

        for(Pelota b: pelotas){

            g2.fill(b.getShape());
        }

    }


}


//Marco con lámina y botones------------------------------------------------------------------------------

class MarcoRebote extends JFrame{
    private LaminaPelota lamina;
    private Thread t;

    public MarcoRebote(){

        setBounds(600,300,400,350);

        setTitle ("Rebotes");

        lamina=new LaminaPelota();

        add(lamina, BorderLayout.CENTER);

        JPanel laminaBotones=new JPanel();

        ponerBoton(laminaBotones, "Dale!", new ActionListener(){

            public void actionPerformed(ActionEvent evento){

                comienza_el_juego();
            }

        });


        ponerBoton(laminaBotones, "Salir", new ActionListener(){

            public void actionPerformed(ActionEvent evento){

                System.exit(0);

            }

        });

        ponerBoton(laminaBotones, "Parar", new ActionListener(){

            public void actionPerformed(ActionEvent evento){

                parar();

            }

        });

        add(laminaBotones, BorderLayout.SOUTH);
    }


    //Ponemos botones

    public void ponerBoton(Container c, String titulo, ActionListener oyente){

        JButton boton=new JButton(titulo);

        c.add(boton);

        boton.addActionListener(oyente);

    }


    public void parar() {
        t.interrupt();
    }


    //Añade pelota y la bota 1000 veces
    public void comienza_el_juego (){


        Pelota pelota=new Pelota();

        lamina.add(pelota);

        //Pasos para crear Hilo
        //1 (PelotaThread) clase que impremente la interfaz Runnable(método Run)
        //2 la tarea del hilo va dentro de Run
        //3 instanciar la clase (PelotaThread) en variable Runnable
        //4 instanciar variable Thread con parámetro Runnable
        //5 ejecutar hilo con método start de clase Thread
        Runnable r=new PelotaThreads(pelota,lamina);
        t = new Thread(r);
        t.start();


    }

    class PelotaThreads implements Runnable{
        private Pelota pelota;
        private Component lamina;

        public PelotaThreads(Pelota pelota, Component lamina) {
            this.pelota = pelota;
            this.lamina = lamina;
        }

        @Override
        public void run() {

            System.out.println("estado del hilo antes de comenzar tarea: " + Thread.currentThread().isInterrupted());

            //bucle infinito mientras hilo actual IS NOT interrumpido
            while (!Thread.currentThread().isInterrupted()){
                pelota.mueve_pelota(lamina.getBounds());

                lamina.paint(lamina.getGraphics());

                //sleep va comentado porque no salta excepción si se interrumpe sleep
                /*try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
            System.out.println("estado del hilo al acabar tarea: " + Thread.currentThread().isInterrupted());

        }
    }
}

