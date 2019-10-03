package Threads;

//https://www.geeksforgeeks.org/synchronized-in-java/

// A Java program to demonstrate working of
// synchronized.

//Syncrhronized evita que un método de un objeto o solo un bloque de ese método se ejecute por varios hilos
//al mismo tiempo.

//en este ejemplo los objetos instanciados de Sender están sincronizados.


// Driver class
public class EjemploSynchronized1 {
    public static void main(String args[]) {
        Sender snd = new Sender();
        ThreadedSend S1 =
                new ThreadedSend(" Hi ", snd);
        ThreadedSend S2 =
                new ThreadedSend(" Bye ", snd);

        // Start two threads of ThreadedSend type
        S1.start();
        S2.start();

        // wait for threads to end
        try {
            S1.join();
            S2.join();
        } catch (Exception e) {
            System.out.println("Interrupted");
        }
    }
}

// A Class used to send a message
class Sender {
    public void send(String msg) {
        System.out.println("Sending\t" + msg);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Thread interrupted.");
        }
        System.out.println("\n" + msg + "Sent");
    }
}

// Class for send a message using Threads
class ThreadedSend extends Thread {
    Sender sender;
    private String msg;
    private Thread t;

    // Recieves a message object and a string
    // message to be sent
    ThreadedSend(String m, Sender obj) {
        msg = m;
        sender = obj;
    }

    public void run() {
        // Only one thread can send a message
        // at a time.
        synchronized (sender) {

            // synchronizing the snd object
            sender.send(msg);
        }
    }
}



