package cola;
public class Cola<T> {
    //atributos
    private Nodo<T>cabeza;
    private Nodo<T> cola;
    private int tamanio;
    //constructor por defecto
    public Cola() {
        cabeza = null;
        tamanio = 0;
        cola = null;
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
        
        return cola == null;
    }
    //agrega un nuevo nodo a la cola
    public void encolar(T valor){
        Nodo<T> nuevo = new Nodo<>();
        //fija el valor al nuevo
        nuevo.setValor(valor);
        if (esVacia()){
            //cabeza apunta al nuevo
            cabeza = nuevo;
            //cola apunta a nuevo
            cola = nuevo;
        }else{
            //se enlaza el campo siguiente con la cola del nuevo
            cola.setSiguiente(nuevo);
            
            //la nueva cola pasa a ser nuevo
            cola = nuevo;
        }
        tamanio++;
    }
    //elimina el ultimo nodo de la pila
    public void desencolar(){
        if (!esVacia()){
            //verificar si hay un solo elemento en la cola
            if(cabeza==cola){
                cabeza = null;
                cola = null;
            }else //hay mas de un elemento en la cola
            {
                //se elimina el primer elemento de la cola
                //desplazando la cabeza al siguiente
                cabeza = cabeza.getSiguiente();
            }
            tamanio--;
        }
    }
    //regresa el valor del tope de la pila
    public T frente(){
        if (!esVacia()){
            return cabeza.getValor();
        }else{
            return null;
        }
    }
    
    public Nodo<T> getCabeza() {
        return cabeza;
    }
    @Override
    public String toString() {
        Nodo<T> aux = cabeza;
        String cadena ="";
        while (aux != null){
            cadena = cadena+aux.getValor()+"\n";
            aux=aux.getSiguiente();    
        }
        return cadena;
    }

    
    
}