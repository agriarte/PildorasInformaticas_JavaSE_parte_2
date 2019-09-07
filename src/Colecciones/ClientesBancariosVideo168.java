package Colecciones;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ClientesBancariosVideo168 {
    public static void main(String[] args) {
        Clientes cliente1 = new Clientes("Juan", "1", 1000);
        Clientes cliente2 = new Clientes("Ivan", "2", 2000);
        Clientes cliente3 = new Clientes("Pedro", "3", 3000);
        Clientes cliente4 = new Clientes("Pepe", "4", 4000);

        //añado a propósito un cliente duplicado, num cuenta 1 ya existe
        Clientes cliente5 = new Clientes("Juan Repetido", "1", 4000);

        //colección HashSet características: no permite duplicados, no ordena, rapida, no acceso aleatorio
        Set<Clientes> clientesDelBanco = new HashSet<>();
        clientesDelBanco.add(cliente1);
        clientesDelBanco.add(cliente2);
        clientesDelBanco.add(cliente3);
        clientesDelBanco.add(cliente4);

        //cliente duplicado. El override de hashCode y equals impedirá que se añada a la colección
        //porque el num de cuenta ya existe
        clientesDelBanco.add(cliente5);

        for (Clientes c: clientesDelBanco) {
            System.out.println(c.getNombre() + " " + c.getnCuenta() + " " + c.getSaldo());
            System.out.println(c.hashCode());
        }

    }
}

class Clientes {
    private String nombre;
    private String nCuenta;
    private double saldo;

    public Clientes(String nombre, String nCuenta, double saldo) {
        this.nombre = nombre;
        this.nCuenta = nCuenta;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getnCuenta() {
        return nCuenta;
    }

    public void setnCuenta(String nCuenta) {
        this.nCuenta = nCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    //hashCode y equals verifican nCuenta es único y evita duplicados
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clientes clientes = (Clientes) o;
        return nCuenta.equals(clientes.nCuenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nCuenta);
    }
}