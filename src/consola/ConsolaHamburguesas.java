package consola;


public class ConsolaHamburguesas 
{
	public static void main(String[]arg)
	{
		mostrarMenu();
	}
	public  static void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Mostrar menú");
		System.out.println("2. Iniciar un nuevo pedido ");
		System.out.println("3. Agregar un elemento a un pedido");
		System.out.println("4. Cerrar un pedido y guardar la factura");
		System.out.println("5. Consultar la información de un pedido dado su id");
	}

}
