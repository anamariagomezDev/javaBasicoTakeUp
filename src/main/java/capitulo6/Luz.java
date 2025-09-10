package capitulo6;

public class Luz {
    private String color;
    private boolean encendida;   // true = encendida
    private int nivelBateria;    // 0..100

    // Constructor obligatorio
    public Luz(String color, int nivelBateria) {
        setColor(color);
        setNivelBateria(nivelBateria);
        this.encendida = false;
    }

    // Acciones básicas (b): encender/apagar cambian el estado lógico
    public boolean encender() {
        if (nivelBateria <= 0) {
            System.out.println("La luz " + color + " no puede encenderse (batería 0%).");
            return false;
        }
        if (!encendida) {
            encendida = true;
            System.out.println("Luz " + color + " encendida.");
        } else {
            System.out.println("Luz " + color + " ya estaba encendida.");
        }
        return true;
    }

    public void apagar() {
        if (encendida) {
            encendida = false;
            System.out.println("Luz " + color + " apagada.");
        } else {
            System.out.println("Luz " + color + " ya estaba apagada.");
        }
    }

    // Getters/Setters (se usarán desde Bicicleta/Ciclista para modificar estado)
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        if (color == null || color.isBlank()) throw new IllegalArgumentException("color requerido");
        this.color = color;
    }

    public boolean isEncendida() {
        return encendida;
    }

    public int getNivelBateria() {
        return nivelBateria;
    }

    public void setNivelBateria(int nivelBateria) {
        if (nivelBateria < 0 || nivelBateria > 100) throw new IllegalArgumentException("batería 0..100");
        this.nivelBateria = nivelBateria;
        if (nivelBateria == 0) encendida = false;
    }

    @Override
    public String toString() {
        return "Luz{color='" + color + "', encendida=" + encendida + ", bateria=" + nivelBateria + "%}";
    }
}
