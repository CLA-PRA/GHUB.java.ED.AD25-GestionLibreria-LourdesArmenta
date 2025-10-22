package miPrincipal.modelo;

import listaDoble.ListaDoble;
import listaDoble.PosicionIlegalException;
import pila.Pila;
import cola.Cola;
import utilerias.Fecha;
import miPrincipal.servicio.ServicioDatos;
import java.util.Scanner;

public class Libreria{
    ServicioDatos dataService;
    ListaDoble<Libro> listaLibros;
    Cola<Libro> colaLibros;
    Pila<Libro> pilaLibrosEliminados;
    Scanner scanner; 

    public Libreria(){
        dataService = new ServicioDatos();
        scanner = new Scanner(System.in);
        listaLibros = new ListaDoble<>();
        colaLibros = new Cola<>();
        pilaLibrosEliminados = new Pila<>();

    }

    public boolean agregarLibro(Libro libro){
        
           listaLibros.agregar(libro);
           return true;
        
    }

    public ListaDoble<Libro> obtenerLibros(){
        return listaLibros;

    }

    public boolean agregarLibroCola(Libro libro){

        colaLibros.encolar(libro);
        return true;

    }

    public Libro obtenerLibroCola(){

        return colaLibros.frente();
        

    }
    public Libro obtenerLibroPila(){
        return pilaLibrosEliminados.cima();
    }

    public Cola<Libro> mostrarReservaLibros(){
       
        return colaLibros;


    }

    public Libro crearLibro(String titulo, String autor, String isbn){
        Libro libro = new Libro(titulo,autor,isbn);
        return libro;
    }

    public Pedido crearPedido(Libro libro, Fecha fecha){
        Pedido pedido = new Pedido(libro, new Fecha());

        return pedido;

    }

    public boolean devolverLibro(Libro libro) throws PosicionIlegalException{
        listaLibros.remover(libro);
        return true;

    }

    public Libro eliminarUltimoLibro() throws PosicionIlegalException{
        if (listaLibros.esVacia()) {
            return null;
        } else {
            Libro libroEliminado = listaLibros.remover(listaLibros.getTamanio()-1);
             
            pilaLibrosEliminados.apilar(libroEliminado);
            return libroEliminado;
        }

    }

    public Libro deshacerEliminarLibro(){
        if (pilaLibrosEliminados.esVacia()) {
            return null;
        
        } else {
            
            Libro libroRestaurado = pilaLibrosEliminados.cima();
            pilaLibrosEliminados.retirar();
            listaLibros.agregar(libroRestaurado);
            return libroRestaurado;
        }

    }

    public Libro buscarLibro(String isbn) throws PosicionIlegalException{

        for(int i=0;i<listaLibros.getTamanio();i++){
            if(isbn.equals(listaLibros.getValor(i).getIsbn())){
                return listaLibros.getValor(i);
            }
        }
        
        return null; // Si no se encuentra el libro, devuelve null

    }


}