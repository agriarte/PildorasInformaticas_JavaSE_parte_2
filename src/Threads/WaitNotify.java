package Threads;

//wait solo se usa en métodos o bloques sincronizados. Wait pausa la ejecución hasta que se ejecuta un notify del mismo
//objeto. Se debe usar también syncronized

public class WaitNotify {
    public static void main(String[] args) {
        MyHouse house = new MyHouse();

        //se crean 2 hilos para ejecutar 2 métodos del mismo objeto
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    house.eatPizza();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                house.pizzaGuy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}

class MyHouse {
    private boolean pizzaArrived = false;

    public void eatPizza() throws InterruptedException {
        synchronized (this) {
            System.out.println("Thread 1 - si hay pizza comeremos");
            //nunca usar un if
            //wait detiene el thread hasta que se ejecuta un notify en el mismo objeto
            while (!pizzaArrived) {
                wait();
            }
        }
        System.out.println("Thread 1 - comiendo..");
    }

    public void pizzaGuy() throws InterruptedException {
        synchronized (this) {
            System.out.println("Thread 2 - esperando pizza");
            Thread.sleep(5000);
            this.pizzaArrived = true;
            notifyAll();

        }
    }
}
