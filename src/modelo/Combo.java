package modelo;

import java.util.ArrayList;
import java.util.List;

public class Combo {
    private double descuento;
    private String nombreCombo;
    private List<Producto> itemsCombo;

    public Combo(String nombre, double descuento) {
        this.nombreCombo = nombre;
        this.descuento = descuento;
        this.itemsCombo = new ArrayList<>();
    }

    public void agregarItemACombo(Producto itemCombo) {
        itemsCombo.add(itemCombo);
    }

    public int getPrecio() {
        int precioTotal = 0;
        for (Producto producto : itemsCombo) {
            precioTotal += producto.getPrecio();
        }

        int precioConDescuento = (int) (precioTotal * (1.0 - descuento));
        return precioConDescuento;
    }

    public String generarTextoFactura() {
        StringBuilder factura = new StringBuilder();
        factura.append("Combo: ").append(nombreCombo).append("\n");
        factura.append("Productos en el Combo:\n");

        for (Producto producto : itemsCombo) {
            factura.append("  - ").append(producto.getNombre()).append(": $").append(producto.getPrecio()).append("\n");
        }

        factura.append("Descuento: ").append((int) (descuento * 100)).append("%\n");
        factura.append("Precio con Descuento: $").append(getPrecio()).append("\n");

        return factura.toString();
    }

    public String getNombre() {
        return nombreCombo;
    }
}

