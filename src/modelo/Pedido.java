package modelo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numeroPedidos;
    private int idPedido;
    private String nombreCliente;
    private String direccionCliente;
    private List<Producto> productos;

    public Pedido(String nombreCliente, String direccionCliente) {
        this.numeroPedidos++;
        this.idPedido = this.numeroPedidos;
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        this.productos = new ArrayList<>();
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void agregarProducto(Producto nuevoItem) {
        productos.add(nuevoItem);
    }

    private int getPrecioNetoPedido() {
        int precioNeto = 0;
        for (Producto producto : productos) {
            precioNeto += producto.getPrecio();
        }
        return precioNeto;
    }

    private int getPrecioTotalPedido() {
        int precioNeto = getPrecioNetoPedido();
        int precioTotal = precioNeto + getPrecioIvaPedido();
        return precioTotal;
    }

    private int getPrecioIvaPedido() {
        int precioNeto = getPrecioNetoPedido();
        int iva = (int) (precioNeto * 0.19); 
        return iva;
    }
    public int getPrecio() {
        return getPrecio();
    }
    public String getNombre() {
        return getNombre();
    }


    private String generarTextoFactura() {
        StringBuilder factura = new StringBuilder();
        factura.append("ID Pedido: ").append(idPedido).append("\n");
        factura.append("Nombre del Cliente: ").append(nombreCliente).append("\n");
        factura.append("Dirección del Cliente: ").append(direccionCliente).append("\n");
        factura.append("Productos:\n");

        for (Producto producto : productos) {
            factura.append("  - ").append(producto.getNombre()).append(": $").append(producto.getPrecio()).append("\n");
        }

        factura.append("Precio Neto: $").append(getPrecioNetoPedido()).append("\n");
        factura.append("IVA: $").append(getPrecioIvaPedido()).append("\n");
        factura.append("Precio Total: $").append(getPrecioTotalPedido()).append("\n");

        return factura.toString();
    }

    public void guardarFactura(File archivo) throws IOException {
        String facturaTexto = generarTextoFactura();
        try (FileWriter escritor = new FileWriter(archivo)) {
            escritor.write(facturaTexto);
        }
    }
}

