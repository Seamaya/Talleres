package consola;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Aplicación {
	public class CargarArchivos {
	    public void main(String[] args) {
	        // Especifica las rutas de los tres archivos de texto
	        String archivo1 = "C:\\Users\\Samue\\OneDrive\\Escritorio\\Universidad\\Tercer Semestre\\DPO\\Taller 2\\Taller 2 - Hamburguesas_esqueleto\\Taller 2 - Hamburguesas_esqueleto\\data\\combos.txt";
	        String archivo2 = "C:\\Users\\Samue\\OneDrive\\Escritorio\\Universidad\\Tercer Semestre\\DPO\\Taller 2\\Taller 2 - Hamburguesas_esqueleto\\Taller 2 - Hamburguesas_esqueleto\\data\\ingredientes.txt";
	        String archivo3 = "C:\\Users\\Samue\\OneDrive\\Escritorio\\Universidad\\Tercer Semestre\\DPO\\Taller 2\\Taller 2 - Hamburguesas_esqueleto\\Taller 2 - Hamburguesas_esqueleto\\data\\menu.txt";

	        // Intenta leer el contenido de los archivos
	        try {
	            String contenidoArchivo1 = leerArchivo(archivo1);
	            String contenidoArchivo2 = leerArchivo(archivo2);
	            String contenidoArchivo3 = leerArchivo(archivo3);

	            // Puedes hacer lo que necesites con el contenido de los archivos aquí
	            System.out.println("Contenido del archivo 1:");
	            System.out.println(contenidoArchivo1);

	            System.out.println("\nContenido del archivo 2:");
	            System.out.println(contenidoArchivo2);

	            System.out.println("\nContenido del archivo 3:");
	            System.out.println(contenidoArchivo3);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    // Método para leer el contenido de un archivo
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
