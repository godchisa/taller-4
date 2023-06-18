
public interface Coleccion {

    /**
     * Agrega un elemento al final de la coleccion
     * @param e the elemento a agregar
     * @return true si el elemento fue agregado
     */
    boolean agregarAlFinal(Elemento e);

    /**
     * Agrega un elemento al inicio de la coleccion
     * @param e the elemento a agregar
     * @return true si el elemento fue agregado
     */

    boolean agregarAlInicio(Elemento e);

    /**
     * Metodo que devuelve la cabeza de la lista
     * @return
     */
    NodoDoble getCabeza();
    /**
     * @return true si la coleccion esta vacia
     */
    boolean isVacia();

    /**
     * @return el numero de elementos en la coleccion.
     */
    int tamanio();
    /**
     * Metodo que despliega id de pokemones en orden creciente dado un rango de id's
     */
    void desplegarIdRangos();

    /**
     * Metodo que despliega pokemones en orden alfabetico
     */
    void desplegarAlf();

    /**
     * Metodo que despliega pokemones segun su tipo
     */
    void desplegarTipo();

    /**
     * Despliega todos los pokemones que están en la etapa Primera Evolucion
     */
    void desplegarPrimeraEvo();

    /**
     * Metodo para obtener una busqueda personalizada, como buscar por id o nombre
     * @param listaPokemones
     */
    void busquedaPersonalizada(ListaNexoDoble listaPokemones);

}
