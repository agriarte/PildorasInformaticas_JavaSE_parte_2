package Threads;

import java.util.concurrent.Semaphore;

public class EjemploSemaphore {
    public static void main(String[] args) {
        // Ejecutamos 10 procesos.
        for (int i = 0; i < 10; i++) {
            new Thread(new miTarea("Proceso " + i)).start();
        }

    }
}

class miTarea implements Runnable {

    //Semaphore determina cuantos threads se pueden ejecutar a la vez.
    //método acquire da permisos, cuando se acaba la tarea se libera con release.
    //ej: miSemaforo.acquire(); miSemaforo.release();

    private static final Semaphore miSemaforo = new Semaphore(1);

    private final String nombre;

    miTarea(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {

        try {
            //adquirir permiso
            miSemaforo.acquire();
            System.out.println("El proceso [ " + this.nombre + "  ] dormira por 5 segundos" );
            Thread.sleep(5000);
            System.out.println("Finaliza el proceso [ " + this.nombre + " ]");

            //libera permiso
            miSemaforo.release();



        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}