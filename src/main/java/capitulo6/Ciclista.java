package capitulo6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ciclista {
    private String nombre;
    private String ciudad;
    private String calle;
    private int numero;
    private boolean usaCasco;

    //Añado una lista de bicicletas a los ciclistas
    private final List<Bicicleta> bicicletas = new ArrayList<>();

    // Constructor con datos obligatorios
    public Ciclista(String nombre, String ciudad, String calle, int numero, boolean usaCasco) {
        setNombre(nombre);
        setCiudad(ciudad);
        setCalle(calle);
        setNumero(numero);
        setUsaCasco(usaCasco);
    }

    // (a) Variante de encender/apagar luces seleccionando bici de la colección
    public void encenderLucesDeBici(int indice) {
        Bicicleta b = biciPorIndice(indice);
        System.out.println(nombre + " va a encender las luces de su bici #" + indice + "...");
        b.encenderLuces();
    }

    public void apagarLucesDeBici(int indice) {
        Bicicleta b = biciPorIndice(indice);
        System.out.println(nombre + " va a apagar las luces de su bici #" + indice + "...");
        b.apagarLuces();
    }

    private Bicicleta biciPorIndice(int indice) {
        if (indice < 0 || indice >= bicicletas.size()) {
            throw new IndexOutOfBoundsException("No existe bici en índice " + indice);
        }
        return bicicletas.get(indice);
    }

    // (f) Comprar/vender bici (añadir/quitar de la lista) con mensajes
    public boolean comprarBici(Bicicleta bici) {
        if (bici == null) return false;
        boolean ok = bicicletas.add(bici);
        if (ok) System.out.println(nombre + " ha comprado una bici: " + bici.getColor());
        return ok;
    }

    public boolean venderBici(Bicicleta bici) {
        if (bici == null) return false;
        boolean ok = bicicletas.remove(bici);
        if (ok) System.out.println(nombre + " ha vendido una bici: " + bici.getColor());
        else System.out.println(nombre + " no posee esa bici.");
        return ok;
    }

    public List<Bicicleta> getBicicletas() {
        return Collections.unmodifiableList(bicicletas);
    }

    // Getters/Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("nombre requerido");
        this.nombre = nombre;
    }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) {
        if (ciudad == null || ciudad.isBlank()) throw new IllegalArgumentException("ciudad requerida");
        this.ciudad = ciudad;
    }

    public String getCalle() { return calle; }
    public void setCalle(String calle) {
        if (calle == null || calle.isBlank()) throw new IllegalArgumentException("calle requerida");
        this.calle = calle;
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) {
        if (numero <= 0) throw new IllegalArgumentException("número > 0");
        this.numero = numero;
    }

    public boolean isUsaCasco() { return usaCasco; }
    public void setUsaCasco(boolean usaCasco) { this.usaCasco = usaCasco; }

    @Override
    public String toString() {
        return "Ciclista{nombre='" + nombre + "', ciudad='" + ciudad + "', calle='" + calle +
                "', numero=" + numero + ", usaCasco=" + usaCasco +
                ", bicicletas=" + bicicletas.size() + "}";
    }
}
