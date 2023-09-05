package modelo;

public class ProductoMenu {
    private String nombre;
    private int precioBase;
    private int costoAjuste; 

    public ProductoMenu(String nombre, int precioBase, int costoAjuste) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.costoAjuste = costoAjuste;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    
    public int getCostoAjuste() {
        return costoAjuste;
    }

    public String generarTextoFactura() {
        StringBuilder factura = new StringBuilder();
        factura.append("Producto: ").append(nombre).append("\n");
        factura.append("Precio Base: $").append(precioBase).append("\n");
        return factura.toString();
    }

	public int getPrecio() {
		
		return 0;
	}
}
