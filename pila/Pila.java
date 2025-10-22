package pila;
public class Pila<T>{
    //atributos
    private Nodo<T>cabeza;
    private int tamanio;
    //constructor por defecto
    public Pila() {
        cabeza = null;
        tamanio = 0;
    }
    //getter y setter
    public int getTamanio() {
        return tamanio;
    }
    //Métodos personalizados
    //confirma si la pila esta vacia
    public boolean esVacia(){
        /*
        if (tamanio == 0){
            return true;

        }else{
            return false;
        }
            */
        return tamanio == 0;
    }
    //agrega un nuevo nodo a la pila
    public void apilar(T valor){
        Nodo<T> nuevo = new Nodo<>();
        //fija el valor al nuevo
        nuevo.setValor(valor);
        if (esVacia()){
            //cabeza apunta al nuevo
            cabeza = nuevo;
        }else{
            //se enlaza el campo siguiente de nuevo con la cabeza
            nuevo.setSiguiente(cabeza);
            //la nueva cabeza de la pila pasa a ser nuevo
            cabeza = nuevo;
        }
        tamanio++;
    }
    //elimina el ultimo nodo de la pila
    public void retirar(){
        if (!esVacia()){
            cabeza = cabeza.getSiguiente();
            tamanio--;
        }
    }
    //regresa el valor del tope de la pila
    public T cima(){
        if (!esVacia()){
            return cabeza.getValor();
        }else{
            return null;
        }
    }
    
    public Nodo<T> getCabeza() {
        return cabeza;
    }
    
}