package listaDoble;
public class Nodo<T>{
    //atributos
    private T valor;
    private Nodo<T> siguiente;//referencia al siguiente nodo
    private Nodo<T> anterior;//referencia al nodo anterior
    //constructores
    public Nodo(){
        valor =null;
        siguiente = null;
        anterior = null;

    }
    //getter y setter
    public T getValor() {
        return valor;
    }
    public void setValor(T valor) {
        this.valor = valor;
    }
    public Nodo<T> getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
    public Nodo<T> getAnterior() {
        return anterior;
    }
    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }
    
    


}