package Threads;

import java.util.concurrent.CountDownLatch;

public class EjemploCountDownLatch {
    public static void main(String[] args)  {
        //
        int nTareas=2;
        CountDownLatch countDownLatch = new CountDownLatch(nTareas);

        //Crear y arrancar 2 Hilos
        Hilo hilo1 = new Hilo(countDownLatch, "Primer Hilo");
        Hilo hilo2 = new Hilo(countDownLatch, "Segundo Hilo");

        System.out.println("*Iniciando hilos*");
        hilo1.start();
        hilo2.start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("FIN DE TAREAS");


    }
}

class Hilo extends Thread{
    private CountDownLatch latch;
    private String nombre;

    public Hilo(CountDownLatch latch, String nombre) {
        this.latch = latch;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.println("hacer cualquier cosa en el " + nombre);
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + nombre);
        }
        //tarea finalizada decrementa contador de latch
        latch.countDown();
    }
}
