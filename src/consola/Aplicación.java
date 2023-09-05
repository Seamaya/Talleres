package consola;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;


public class Aplicación {
	public static void main(String[] args) { 
			System.out.println("\nOpciones de la aplicación\n");
			System.out.println("1. Mostrar menú");
			System.out.println("2. Iniciar un nuevo pedido ");
			System.out.println("3. Agregar un elemento a un pedido");
			System.out.println("4. Cerrar un pedido y guardar la factura");
			System.out.println("5. Consultar la información de un pedido dado su id");
		
	}
	
	public class CargarArchivos {
		String archivo1 = "C:\\Users\\Samue\\OneDrive\\Escritorio\\Universidad\\Tercer Semestre\\DPO\\Taller 2\\Taller 2 - Hamburguesas_esqueleto\\Taller 2 - Hamburguesas_esqueleto\\data\\combos.txt";
	    String archivo2 = "C:\\Users\\Samue\\OneDrive\\Escritorio\\Universidad\\Tercer Semestre\\DPO\\Taller 2\\Taller 2 - Hamburguesas_esqueleto\\Taller 2 - Hamburguesas_esqueleto\\data\\ingredientes.txt";
	    String archivo3 = "C:\\Users\\Samue\\OneDrive\\Escritorio\\Universidad\\Tercer Semestre\\DPO\\Taller 2\\Taller 2 - Hamburguesas_esqueleto\\Taller 2 - Hamburguesas_esqueleto\\data\\menu.txt";{
	    	
	
  
	        try {
	            String contenidoArchivo1 = leerArchivo(archivo1);
	            String contenidoArchivo2 = leerArchivo(archivo2);
	            String contenidoArchivo3 = leerArchivo(archivo3);

	            
	            System.out.println("Contenido de combos:");
	            System.out.println(contenidoArchivo1);

	            System.out.println("\nContenido de ingredientes:");
	            System.out.println(contenidoArchivo2);

	            System.out.println("\nContenido del menu:");
	            System.out.println(contenidoArchivo3);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	      
	    }

		
	    public String leerArchivo(String rutaArchivo) throws IOException {
	        StringBuilder contenido = new StringBuilder();
	        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
	            String linea;
	            while ((linea = br.readLine()) != null) {
	                contenido.append(linea).append("\n");
	            }
	        }
	        return contenido.toString();
	    }
	}
	


}
