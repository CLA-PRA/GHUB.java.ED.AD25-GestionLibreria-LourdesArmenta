package listaDoble;
public class ListaDoble<T>{
    //atributos
    private Nodo<T>cabeza;
    private int tamanio;
    //constructor por defecto
    public ListaDoble(){
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
        return cabeza == null;
    }
    //agrega un nuevo nodo al fina de la lista
    public void agregar(T valor){
        Nodo<T> nuevo = new Nodo<>();
        //fija el valor al nuevo
        nuevo.setValor(valor);
        if (esVacia()){
            //cabeza apunta al nuevo
            cabeza = nuevo;
            //cola apunta a nuevo
            
        }else{
            //se agrega al fina de la lista
            Nodo<T> aux = cabeza;
            while (aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo); 
            nuevo.setAnterior(aux); //ESTA ES UNA LINEA NUEVA RESPECTO A LA LISTA SIMPLE
        }
        tamanio++;
    }
    /*
     * Inserta un nuevo nodo en la lista
     * @param valor: valor a agregar
     * @param pos: indica la posicion en donde se insertará el nodo
     * @throws : PosicionIlegalException en caso de que la posicion no exista
     */
    public void insertar(T valor, int pos) throws PosicionIlegalException{
        if (pos>=0 && pos<=tamanio){
            Nodo<T> nuevo = new Nodo<>();
            nuevo.setValor(valor);
            if(pos==0){//insertar al principo
                cabeza.setAnterior(nuevo); //NUEVA LINEA AGREGADA PARA LISTA DOBLE
                nuevo.setSiguiente(cabeza);
                cabeza = nuevo;

            }else{
                if(pos == tamanio){ // al final
                    Nodo<T> aux = cabeza;
                    while (aux.getSiguiente() != null){
                        aux = aux.getSiguiente();
                    }
                    aux.setSiguiente(nuevo); 
                    nuevo.setAnterior(aux); /// ESTA ES UNA NUEVA LINEA RESPECTO AL ANTERIOR

                }else{ // en medio
                    Nodo<T> aux = cabeza;
                    for (int i=0;i<=pos-2;i++){
                        aux = aux.getSiguiente();

                    }
                    Nodo<T> siguiente = aux.getSiguiente();
                    aux.setSiguiente(nuevo);
                    nuevo.setSiguiente(siguiente);
                    nuevo.setAnterior(aux); ///ESTA ES UNA NUEVA LINEA RESPECTO A LA LISTA SIMPLE
                    siguiente.setAnterior(nuevo);///ESTA ES UNA NUEVA LINEA RESPECTO A LA LISTA SIMPLE

                }

            }
            tamanio++;

        }else{
            throw new PosicionIlegalException();
        }

    }
    /*
     * Elimina un nodo de una determinada posicion
     * @param pos: posicion a eliminar
     * @throws PosicionIlegalException
     */

    public T remover(int pos) throws PosicionIlegalException{
        if (pos >=0 && pos <tamanio){ //posicion correcta
            if (pos ==0){
                T valor = cabeza.getValor();
                cabeza = cabeza.getSiguiente();
                if (cabeza !=null)
                    cabeza.setAnterior(null); ///ESTA ES UNA NUEVA LINEA QUE SE INSERTO
                tamanio--;
                return valor;
            }else{ 
                if (pos == tamanio-1){ //eliminar al final de la lista
                    Nodo<T> aux = cabeza;
                    for(int i=0;i<=pos-2;i++){ 
                        aux = aux.getSiguiente();
                    }
                    T valor = aux.getSiguiente().getValor();
                   
                    Nodo<T> prox = aux.getSiguiente();
                    aux.setSiguiente(prox.getSiguiente());
                    tamanio--;
                    return valor;

                }else {
                    //eliminar  en medio
                    Nodo<T> aux = cabeza;
                    for(int i=0;i<=pos-2;i++){
                        aux = aux.getSiguiente();

                    }
                    T valor = aux.getSiguiente().getValor();
                    Nodo<T> prox = aux.getSiguiente();
                    
                    prox.getSiguiente().setAnterior(aux);
                    aux.setSiguiente(prox.getSiguiente());
                    tamanio--;
                    return valor;
                }


            }

        }else{ //posicion incorrecta
            throw new PosicionIlegalException();

        }
        
    }
     /*
     * Elimina un nodo que contiene un T valor
     * @param T: valor a eliminar
     * @return: si lo encuentra retorna la posicion a eliminar,si no retorna -1
     * @throws PosicionIlegalException
     */

    public int remover(T valor) throws PosicionIlegalException{
        Nodo<T> aux = cabeza;
        int pos = 0;
        while (aux != null){
            if(valor.equals(aux.getValor())){
                remover(pos);
                return pos;
            }
            aux = aux.getSiguiente();
            pos++;

        }
        return -1;
       
        
    }

    /*
     * Devuelve el valor de una determinada posicion
     * @param pos: posicion
     * @return : el valor de tipo T
     * @throws PosicionIlegalException
     */
    public T getValor(int pos) throws PosicionIlegalException{
        if(pos>=0 && pos<tamanio){//es una posicion válida
            T valor;
            if(pos ==0){
                valor = cabeza.getValor();
                return valor;

            }else{
                Nodo<T> aux = cabeza;
                for(int i=0;i<=pos-1;i++){
                    aux = aux.getSiguiente();
                }
                valor = aux.getValor();
                return valor;
            }

        }else{//es una posicion inválida
            throw new PosicionIlegalException();

        }
        
    }
    public void limpiar(){
        cabeza = null;
        tamanio = 0;
    }

    @Override
    public String toString() {
        Nodo<T> aux = cabeza;
        String cadena = "[ ";
        while (aux !=null){
            cadena = cadena +aux.getValor()+"\n";
            aux = aux.getSiguiente();

        }
        cadena = cadena+" ]";
        return cadena;

    }

    public boolean contiene(T valor){
         Nodo<T> aux = cabeza;
         while (aux !=null){
            if (valor.equals(aux.getValor())){
                return true;
            }
            aux = aux.getSiguiente();
         }
         return false;
    }
    
    
}