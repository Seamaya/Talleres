package modelo;

import java.io.*;
import java.util.ArrayList;

public class Restaurante {
    private Pedido pedidoEnCurso;
    private ArrayList<Producto> menuBase;
    private ArrayList<Ingrediente> ingredientes;

    public Restaurante() {
        this.pedidoEnCurso = null;
        this.menuBase = new ArrayList<>();
        this.ingredientes = new ArrayList<>();
    }

    public void iniciarPedido(String nombreCliente, String direccionCliente) {
        pedidoEnCurso = new Pedido(nombreCliente, direccionCliente);
    }

    public void cerrarYGuardarPedido() {
        if (pedidoEnCurso != null) {
            try {
                pedidoEnCurso.guardarFactura(new File("factura.txt"));
                System.out.println("Pedido cerrado y factura guardada en 'factura.txt'");
            } catch (IOException e) {
                System.err.println("Error al guardar la factura.");
                e.printStackTrace();
            }
            pedidoEnCurso = null; 
        } else {
            System.out.println("No hay pedido en curso para cerrar.");
        }
    }

    public Pedido getPedidoEnCurso() {
        return pedidoEnCurso;
    }

    public ArrayList<Producto> getMenuBase() {
        return menuBase;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) {
        cargarIngredientes(archivoIngredientes);
        cargarMenu(archivoMenu);
        cargarCombos(archivoCombos);
    }

    private void cargarIngredientes(File archivoIngredientes) {
    	try {
            BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 2) {
                    String nombre = partes[0].trim();
                    int costoAdicional = Integer.parseInt(partes[1].trim());
                    Ingrediente ingrediente = new Ingrediente(nombre, costoAdicional);
                    ingredientes.add(ingrediente);
                }
            }

            br.close();
        } catch (IOException e) {
            System.err.println("Error al cargar ingredientes desde el archivo.");
            e.printStackTrace();
        }
    }

    private void cargarMenu(File archivoMenu) {
    	try {
            BufferedReader br = new BufferedReader(new FileReader(archivoMenu));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 2) {
                    String nombre = partes[0].trim();
                    int precioBase = Integer.parseInt(partes[1].trim());
                    ProductoMenu productoMenu = new ProductoMenu(nombre, precioBase);
                    menuBase.add(productoMenu);
                }
            }

            br.close();
        } catch (IOException e) {
            System.err.println("Error al cargar elementos del menú desde el archivo.");
            e.printStackTrace();
        }
    }

    private void cargarCombos(File archivoCombos) {
       
    }
}
