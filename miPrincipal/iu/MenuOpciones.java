package miPrincipal.iu;
import miPrincipal.servicio.ServicioDatos;
import miPrincipal.modelo.Libro;
import miPrincipal.modelo.Pedido;
import miPrincipal.modelo.Libreria;
import java.util.Scanner;
import utilerias.Fecha;
import listaDoble.ListaDoble;
import listaDoble.PosicionIlegalException;
import cola.Cola;
import pila.Pila;

import java.util.Scanner;

public class MenuOpciones{
    static Scanner scanner = new  Scanner(System.in);
    static private Libreria libreria = new Libreria();

    public static void agregarLibro(){
        System.out.print("Ingrese el título del libro:");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro:");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro:");
        String isbn = scanner.nextLine();
        Libro libro = new Libro(titulo, autor, isbn);
        if (libreria.agregarLibro(libro))
            System.out.println("libro se agrego exitosamente a la lista: "+libro);

        else
            System.out.println("Error: no fue posible agregar Libro a la lista");
   

    }
    
    public static void mostrarLibros() throws PosicionIlegalException{

        ListaDoble<Libro> listaLibros=libreria.obtenerLibros();
        
        if (listaLibros.esVacia()) {
            System.out.println("La lista de libros esta vacia.");
        } else {
            System.out.println("Lista de libros:");
            for(int i=0;i<listaLibros.getTamanio();i++){
                System.out.println(listaLibros.getValor(i));
            }
            
        }

    }

    public static void agregarLibroCola(){
        
        System.out.print("Ingrese el titulo del libro:");
        String tituloCola = scanner.nextLine();
        System.out.print("Ingrese el autor del libro:");
        String autorCola = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro:");
        String isbnCola = scanner.nextLine();
        Libro libroCola = new Libro(tituloCola, autorCola, isbnCola);
        if (libreria.agregarLibroCola(libroCola))
        
            System.out.println("libro se agrego exitosamente a la cola");
        else
            System.out.println("Error: no fue posible agregar Libro a la cola");
        
    }

    public static Libro obtenerLibroCola(){

        Libro libro = libreria.obtenerLibroCola();
        if (libro != null){
            System.out.println("El siguiente libro disponible sera: "+libro);
            return libro;
        }
        else{
            System.out.println("No existen libros prestados");
            return null;
        }
     
    }

    public static void mostrarReservaLibros(){
        Cola<Libro> listaLibrosReserva = libreria.mostrarReservaLibros();
        if (listaLibrosReserva.esVacia()) {
            System.out.println("La lista de reservas esta vacia.");
        } else {
            System.out.println("Lista de libros:");
            System.out.println(listaLibrosReserva);
            

        }
        

    }

    public static void crearPedido(){
        System.out.print("Ingrese el título del libro para el pedido:");
        String tituloPedido = scanner.nextLine();
        System.out.print("Ingrese el autor del libro para el pedido:");
        String autorPedido = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro para el pedido:");
        String isbnPedido = scanner.nextLine();
        Libro libroPedido = libreria.crearLibro(tituloPedido, autorPedido, isbnPedido);
        Pedido pedido=null;
        if (libroPedido!=null){
            pedido = libreria.crearPedido(libroPedido, new Fecha());
            if (pedido !=null)
                System.out.println("Pedido creado exitosamente: "+pedido);
            else
                System.out.println("No fue posible crear el pedido");
        }else{
            System.out.println("Error: no fue posible crear el Libro");
        }
       
    }

    public static void devolverLibro() throws PosicionIlegalException{
        System.out.print("Ingrese el ISBN del libro a devolver:");
        String isbnDevolver = scanner.nextLine();
        Libro libroDevolver = libreria.buscarLibro(isbnDevolver);
        if (libroDevolver == null){
            System.out.println("Error: no existe ningun libro con esas caracteristicas");
            return;
        }

        System.out.println("Titulo del libro a devolver:"+libroDevolver.getTitulo());
        
        System.out.println("Autor del libro a devolver:"+libroDevolver.getAutor());
        libreria.devolverLibro(libroDevolver);
        System.out.println("Libro devuelto a la lista: " + libroDevolver);
        

    }

    public static Libro eliminarUltimoLibro() throws PosicionIlegalException{
        Libro libroEliminado = libreria.eliminarUltimoLibro();
        if (libroEliminado != null){
            System.out.println("Libro eliminado de la lista y agregado a la pila: " + libroEliminado);
            return libroEliminado;
        } 
        else{
            System.out.println("Error: no se pudo eliminar ultimo libro");
            return null;
        }

    }

    public static void deshacerEliminarLibro(){
        Libro libroRestaurado = libreria.deshacerEliminarLibro();
        if(libroRestaurado !=null)
            System.out.println("Libro restaurado a la lista: " + libroRestaurado);
        else
            System.out.println("No hay libros para deshacer la eliminación.");
       

    }


	
}
