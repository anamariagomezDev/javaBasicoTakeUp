package capitulo4.sentencies; // Declara el paquete donde vive esta clase.

public class Sentencies2 { // Define la clase pública Sentencies2.
    public static void main(String[] args) { // Punto de entrada del programa.

        int code; // Código del producto en cada factura.
        int liters; // Cantidad de litros en cada factura.
        float price; // Precio por litro (no se pide por teclado, se asigna en el switch).
        float invoice_amount; // Monto de la factura actual (liters * price).
        float total_invoicing; // Acumulado del monto de todas las facturas.
        int liters_cod1; // Total de litros vendidos del producto con código 1.
        int over_600; // Contador de facturas cuyo monto es mayor o igual a 600 €.

        total_invoicing = 0; // Inicializa el total facturado a 0.
        liters_cod1 = 0;     // Inicializa el acumulado de litros del producto 1 a 0.
        over_600 = 0;        // Inicializa el contador de facturas >= 600 € a 0.
        total_invoicing = 0; // Redundante: ya se inicializó antes.
        code = 0;            // Inicializa el código (valor de arranque, será reemplazado en el bucle).
        over_600 = 0;        // Redundante: ya se inicializó antes.

        for (int i = 1; i <= 5; i++) { // Bucle que simula 5 facturas (i de 1 a 5).
            System.out.println("Invoice nº " + i); // Muestra el número de factura.

            code = (int) (Math.random() * 2) + 1;  // Genera un código aleatorio 1..2 (ver nota abajo).
            System.out.println("product code: " + code); // Muestra el código de producto.

            liters = (int) (Math.random() * 10) + 1; // Genera litros aleatorios 1..10.
            System.out.println("number (liters): " + liters); // Muestra la cantidad de litros.

            // Asigna el precio por litro según el código:
            switch (code) {
                case 1:
                    price = 0.6f;     // Precio para código 1.
                    break;
                case 2:
                    price = 30f;      // Precio para código 2.
                    break;
                case 3:
                    price = 101.25f;  // Precio para código 3 (no ocurrirá con el random actual).
                    break;
                default:
                    price = 0;        // Caso “imposible” aquí; seguridad por defecto.
            }

            invoice_amount = liters * price;     // Calcula el monto de la factura actual.
            total_invoicing += invoice_amount;   // Acumula en el total facturado.

            if (code == 1)               // Si el producto es código 1,
                liters_cod1 += liters;   // acumula sus litros.

            if (invoice_amount >= 600) // Si el monto de la factura es >= 600 €,
                over_600++;            // incrementa el contador de “facturas grandes”.
        }

        System.out.println("\n\n\nSales Overview\n"); // Separador y cabecera del resumen.

        // total invoicing
        System.out.println("Total invoicing: " + total_invoicing + "€"); // Muestra el total facturado.

        // liters of article 1
        System.out.println("Liters Article 1: " + liters_cod1 + " liters"); // Litros del artículo 1.

        // Invoice of more than 600 euros
        System.out.println("Invoice over 600€: " + over_600); // Número de facturas >= 600 €.
    }
}