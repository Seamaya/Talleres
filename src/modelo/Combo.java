package modelo;

import java.util.ArrayList;
import java.util.List;

public class Combo implements Producto {
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
    	return nombreCombo + " Tiene un costo total de: ";
    }

    public String getNombre() {
        return nombreCombo;
    }
}

