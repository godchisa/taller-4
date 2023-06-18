
public final class NodoDoble {

    /**
     *  Elemento (pokemon)
     */
    private final Elemento elemento;

    /**
     *  Nodo anterior
     */
    private NodoDoble anterior;

    /**
     *  Nodo siguiente
     */
    private NodoDoble siguiente;

    /**
     * Constructor del nodo
     *
     * @param elemento
     */
    public NodoDoble(Elemento elemento) {
        // verificacion de parametros
        if (elemento == null) {
            throw new IllegalArgumentException("Elemento nulo.");
        }
        this.elemento = elemento;
    }

    /**
     * @return elemento
     */
    public Elemento getElemento() {
        return this.elemento;
    }

    /**
     * @return nodo siguiente.
     */
    public NodoDoble getSiguiente() {
        return this.siguiente;
    }

    /**
     * @param siguiente the siguiente to set.
     */
    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return nodo anterior.
     */
    public NodoDoble getAnterior() {
        return this.anterior;
    }

    /**
     * @param anterior the anterior to set.
     */
    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

}