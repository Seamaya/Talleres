package modelo;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


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

    public void cerrarYGuardarPedido(String nombreCliente, String direccionCliente) {
    	this.pedidoEnCurso = new Pedido(nombreCliente, direccionCliente);
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
                    ProductoMenu productoMenu = new ProductoMenu(nombre, precioBase, precioBase);
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
