package Threads;

public class SincronizandoHilos {
    public static void main(String[] args) {

        //los hilos si no decimos nada se ejecutan de manera alternada sin seguir un orden
        //saltando la ejecución de un hilo a otro sin control
        //con join() forzamos la ejecución completa de la tarea antes de seguir con otra cosa

        SincronizaThreads hilo1 = new SincronizaThreads();

        SincronizaThreads hilo2 = new SincronizaThreads();

        hilo1.start();
        try {
            hilo1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hilo2.start();
        try {
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("fin de tareas");

    }
}

class SincronizaThreads extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("ejecutando Thread " + getName());

        }
    }
}
