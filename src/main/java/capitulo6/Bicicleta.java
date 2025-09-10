package capitulo6;

public class Bicicleta {
    private String color;
    private int numeroMarchas;         // >= 1
    private double velocidadActual;    // km/h, >= 0
    private int marchaActual;          // 1..numeroMarchas
    private boolean arrancada;

    //Añando luces a la bicicleta
    private Luz luzDelantera;
    private Luz luzTrasera;

    // Constructor con datos obligatorios (incluye luces)
    public Bicicleta(String color, int numeroMarchas, Luz luzDelantera, Luz luzTrasera) {
        setColor(color);
        setNumeroMarchas(numeroMarchas);
        setLuzDelantera(luzDelantera);
        setLuzTrasera(luzTrasera);
        setVelocidadActual(0);
        setMarchaActual(1);
        this.arrancada = false;
    }

    // (a) Métodos que encienden/apagan las luces de la bici (cambian su estado lógico)
    public void encenderLuces() {
        System.out.println("Encendiendo luces de la bicicleta...");
        luzDelantera.encender();
        luzTrasera.encender();
    }

    public void apagarLuces() {
        System.out.println("Apagando luces de la bicicleta...");
        luzDelantera.apagar();
        luzTrasera.apagar();
    }

    // (b) Arrancar: marcha y velocidad a 1
    public void arrancar() {
        setArrancada(true);
        setVelocidadActual(1);
        setMarchaActual(1);
        System.out.println("La bicicleta ha arrancado: velocidad=1 km/h, marcha=1.");
    }

    // (c) Acelerar: incrementa velocidad actual
    public void acelerar(double incremento) {
        if (incremento <= 0) {
            System.out.println("Incremento inválido: " + incremento);
            return;
        }
        setVelocidadActual(getVelocidadActual() + incremento);
        System.out.println("Se ha acelerado. Velocidad actual: " + getVelocidadActual() + " km/h.");
    }

    // (d) Frenar: disminuye velocidad actual (no baja de 0)
    public void frenar(double decremento) {
        if (decremento <= 0) {
            System.out.println("Decremento inválido: " + decremento);
            return;
        }
        double nueva = Math.max(0, getVelocidadActual() - decremento);
        setVelocidadActual(nueva);
        System.out.println("Se ha frenado. Velocidad actual: " + getVelocidadActual() + " km/h.");
    }

    // (e) Subir/bajar marcha: respeta límites 1..numeroMarchas
    public void subirMarcha() {
        if (marchaActual < numeroMarchas) {
            setMarchaActual(marchaActual + 1);
            System.out.println("Se ha subido la marcha. Marcha actual: " + marchaActual + ".");
        } else {
            System.out.println("Ya estás en la marcha máxima (" + numeroMarchas + ").");
        }
    }

    public void bajarMarcha() {
        if (marchaActual > 1) {
            setMarchaActual(marchaActual - 1);
            System.out.println("Se ha bajado la marcha. Marcha actual: " + marchaActual + ".");
        } else {
            System.out.println("Ya estás en la marcha mínima (1).");
        }
    }

    // Getters/Setters (usados para modificar estado)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null || color.isBlank()) throw new IllegalArgumentException("color requerido");
        this.color = color;
    }

    public int getNumeroMarchas() {
        return numeroMarchas;
    }

    public void setNumeroMarchas(int numeroMarchas) {
        if (numeroMarchas < 1) throw new IllegalArgumentException("nº marchas >= 1");
        this.numeroMarchas = numeroMarchas;
        if (marchaActual == 0) marchaActual = 1;
        if (marchaActual > numeroMarchas) marchaActual = numeroMarchas;
    }

    public double getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(double velocidadActual) {
        if (velocidadActual < 0) throw new IllegalArgumentException("velocidad >= 0");
        this.velocidadActual = velocidadActual;
    }

    public int getMarchaActual() { return marchaActual; }
    public void setMarchaActual(int marchaActual) {
        if (marchaActual < 1 || marchaActual > numeroMarchas) {
            throw new IllegalArgumentException("marcha fuera de rango");
        }
        this.marchaActual = marchaActual;
    }

    public boolean isArrancada() { return arrancada; }
    public void setArrancada(boolean arrancada) { this.arrancada = arrancada; }

    public Luz getLuzDelantera() {
        return luzDelantera;
    }

    public void setLuzDelantera(Luz luzDelantera) {
        if (luzDelantera == null) throw new IllegalArgumentException("luz delantera requerida");
        this.luzDelantera = luzDelantera;
    }

    public Luz getLuzTrasera() { return luzTrasera; }
    public void setLuzTrasera(Luz luzTrasera) {
        if (luzTrasera == null) throw new IllegalArgumentException("luz trasera requerida");
        this.luzTrasera = luzTrasera;
    }

    @Override
    public String toString() {
        return "Bicicleta{color='" + color + "', marchas=" + numeroMarchas +
                ", vel=" + velocidadActual + ", marcha=" + marchaActual +
                ", arrancada=" + arrancada +
                ", del=" + luzDelantera + ", tras=" + luzTrasera + '}';
    }
}
