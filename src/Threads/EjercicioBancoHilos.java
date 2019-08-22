package Threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EjercicioBancoHilos {
    public static void main(String[] args) {

        Banco banco = new Banco();
        for (int i = 0; i < 100; i++) {
            EjecutandoTransferencias r = new EjecutandoTransferencias(banco, i, 200);
            Thread t = new Thread(r);
            t.start();
        }
    }
}

class Banco {
    private final double[] cuentas;
    //para sincronizar se usa lock;
    private Lock bloqueBanco = new ReentrantLock();
    //Condition es para hacer condiciones de la sincronización
    private Condition saldoSuficiente;

    public Banco() {
        cuentas = new double[100];
        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i] = 2000;
        }
        System.out.println("fin");
    }

    public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {

        //sicronización con ReentrantLock
        //lock bloquea el código para que ningún otro hilo ejecute esas líneas
        //al acabar unlock permite que otro hilo ejecute el código
        bloqueBanco.lock();
        try {
            //if (cuentas[cuentaOrigen] < cantidad) return;//evitar que se haga la transferencia sin saldo

            //retener ejecución mientras saldo insuficiente. await() pausa el hilo
            while (cuentas[cuentaOrigen] < cantidad) saldoSuficiente.await();

            System.out.println(Thread.currentThread());
            cuentas[cuentaOrigen] -= cantidad;
            cuentas[cuentaDestino] += cantidad;

            System.out.println(cantidad + "$ de la cuenta " + cuentas[cuentaOrigen] + " a la cuenta " + cuentas[cuentaDestino]);

            //System.out.println(getSaldoTotal());
            System.out.printf("Saldo total: %10.2f%n", getSaldoTotal());

            //revisa que el saldoSuficiente permita hacer transfe. Si algún hilo está pausado en ese caso se reactivará
            //saldoSuficiente.signalAll();
        } finally {
            bloqueBanco.unlock();
        }

    }

    public double getSaldoTotal() {

        double sumaSaldoTotal = 0;
        for (double c : cuentas) {
            sumaSaldoTotal += c;
        }
        return sumaSaldoTotal;
    }
}

class EjecutandoTransferencias implements Runnable {
    private Banco miBanco;
    private int cuentadeorigen;
    private double cantidadmaxima;

    public EjecutandoTransferencias(Banco miBanco, int cuentadeorigen, double cantidadmaxima) {
        this.miBanco = miBanco;
        this.cuentadeorigen = cuentadeorigen;
        this.cantidadmaxima = cantidadmaxima;
    }

    @Override
    public void run() {
        System.out.println("run");
        while (true) {

            int cuentaDeDestino = (int) (Math.random() * 100);
            double cantidadATransferir = cantidadmaxima * Math.random();
            try {
                miBanco.transferencia(cuentadeorigen, cuentaDeDestino, cantidadATransferir);

                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
