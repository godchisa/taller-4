public abstract class Pokemon implements Elemento{
    /**
     * Id del pokemon
     */
    private int id;

    /**
     * Nombre del pokemon
     */
    private String nombre;

    /**
     * Etapa del pokemon
     */
    private String etapa;

    /**
     * Tipo 1 del pokemon
     */
    private String tipo1;

    /**
     * Tipo 2 del pokemon
     */
    private String tipo2;

    /**
     * Constructor del pokemon
     * @param id
     * @param nombre
     * @param etapa (evolucion)
     * @param tipo1
     * @param tipo2
     */

    public Pokemon(int id, String nombre, String etapa, String tipo1, String tipo2) {
        this.id = id;
        this.nombre = nombre;
        this.etapa = etapa;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
    }

    /**
     * Metodo que devuelve el objeto pokemon en string (reemplaza el print de la direccion de memoria por los atributos del objeto)
     * @return atributos del pokemon en string
     */
    @Override
    public String toString() {
        return id + " " + nombre + " " + etapa + " " + tipo1 + " " + tipo2 ;
    }

    /**
     * @return ID pokemon
     */
    public int getId() {
        return id;
    }

    /**
     * @return nombre del pokemon
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return etapa del pokemon
     */
    public String getEtapa() {
        return etapa;
    }

    /**
     * @return primer tipo del pokemon
     */

    public String getTipo1() {
        return tipo1;
    }

    /**
     * @return segundo tipo del pokemon
     */

    public String getTipo2() {
        return tipo2;
    }

    /**
     * Metodo para comparar 2 Elementos
     * @param e elemento a comparar.
     * @return
     */
    @Override
    public boolean esIgual(Elemento e) {
        NodoDoble aux = new NodoDoble(e);
        if (aux.getElemento().equals(e)){
            return true;
        }
        return false;
    }
}

