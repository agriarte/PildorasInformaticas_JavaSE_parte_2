package Threads;

public class SincronizandoHilos2 {
    public static void main(String[] args) {

        //los hilos si no decimos nada se ejecutan de manera alternada sin seguir un orden
        //saltando la ejecución de un hilo a otro sin control
        //con join() forzamos la ejecución completa de la tarea antes de seguir con otra cosa

        SincronizaThreads hilo1 = new SincronizaThreads();

        SincronizaThreads2 hilo2 = new SincronizaThreads2(hilo1);

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

class SincronizaThreads2 extends Thread{
    private Thread thread;

    public SincronizaThreads2(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {

        //la idea es cuando se lanza hilo2 recibe por parámetro hilo para comprobar que ha finalizado antes de seguir
        //theread lleva el hilo 1 y join
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 20; i++) {
            System.out.println("ejecutando Thread " + getName());

        }
    }
}
