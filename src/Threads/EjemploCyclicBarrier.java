package Threads;


//JAVA program to demonstrate execution on Cyclic Barrier

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/*CyclicBarrier se utiliza para hacer que los hilos esperen entre sí. Se utiliza cuando diferentes subprocesos procesan
una parte del cálculo y cuando todos los subprocesos han completado la ejecución, el resultado debe combinarse en el
subproceso principal. En otras palabras, se utiliza un CyclicBarrier cuando varios subprocesos realizan diferentes
subtareas y la salida de estas subtareas debe combinarse para formar la salida final. Después de completar su ejecución,
los hilos llaman al método await () y esperan que otros hilos lleguen a la barrera. Una vez que todos los hilos han
llegado, las barreras dan paso a los hilos para proceder.
Primero se crea una nueva instancia de CyclicBarriers que especifica el número de subprocesos que las barreras
deben esperar.*/

public class EjemploCyclicBarrier implements Runnable {
    public static CyclicBarrier newBarrier = new CyclicBarrier(3);

    public static void main(String[] args) {
        // parent thread
        EjemploCyclicBarrier test = new EjemploCyclicBarrier();

        Thread t1 = new Thread(test);
        t1.start();
    }

    public void run() {
        System.out.println("Number of parties required to trip the barrier = " +
                newBarrier.getParties());
        System.out.println("Sum of product and sum = " + (Computation1.product +
                Computation2.sum));

        // objects on which the child thread has to run
        Computation1 comp1 = new Computation1();
        Computation2 comp2 = new Computation2();

        // creation of child thread
        Thread t1 = new Thread(comp1);
        Thread t2 = new Thread(comp2);

        // moving child thread to runnable state
        t1.start();
        t2.start();

        //flujo aqui esperando fin de tareas
        try {
            EjemploCyclicBarrier.newBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        // barrier breaks as the number of thread waiting for the barrier
        // at this point = 3
        System.out.println("Sum of product and sum = " + (Computation1.product +
                Computation2.sum));

        // Resetting the newBarrier
        newBarrier.reset();
        System.out.println("Barrier reset successful");
    }
}

class Computation1 implements Runnable {
    public static int product = 0;

    public void run() {
        product = 2 * 3;
        try {
            EjemploCyclicBarrier.newBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class Computation2 implements Runnable {
    public static int sum = 0;

    public void run() {
        // check if newBarrier is broken or not
        System.out.println("Is the barrier broken? - " + EjemploCyclicBarrier.newBarrier.isBroken());
        sum = 10 + 20;
        try {
            EjemploCyclicBarrier.newBarrier.await(3000, TimeUnit.MILLISECONDS);

            // number of parties waiting at the barrier
            System.out.println("Number of parties waiting at the barrier " +
                    "at this point = " + EjemploCyclicBarrier.newBarrier.getNumberWaiting());
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}



