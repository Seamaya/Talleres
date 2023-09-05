package modelo;

public class ProductoAjustado implements Producto {
    private ProductoMenu base;

    public ProductoAjustado(ProductoMenu base) {
        this.base = base;
    }

    public String getNombre() {
        
        return base.getNombre();
    }

    public int getPrecio() {
        
        return base.getPrecio() + base.getCostoAjuste();
    }

    public String generarTextoFactura() {
        StringBuilder factura = new StringBuilder();
        factura.append("Producto Ajustado: ").append(getNombre()).append("\n");
        factura.append("Precio: $").append(getPrecio()).append("\n");
        return factura.toString();
    }
}

