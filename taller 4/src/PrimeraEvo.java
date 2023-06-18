public class PrimeraEvo extends Pokemon{
    /**
     * Siguiente evolucion al pokemon de primera evolucion (segunda evolucion)
     */
    private String evoSiguiente;
    /**
     * Anterior evolucion al pokemon de primera evolucion (basico del pokemon)
     */
    private String evoPrevia;

    /**
     * Constructor del pokemon
     * @param id
     * @param nombre
     * @param etapa  (evolucion)
     * @param tipo1
     * @param tipo2
     * @param evoSiguiente
     * @param evoPrevia
     */
    public PrimeraEvo(int id, String nombre, String etapa, String tipo1, String tipo2, String evoSiguiente, String evoPrevia) {
        super(id, nombre, etapa, tipo1, tipo2);
        this.evoSiguiente = evoSiguiente;
        this.evoPrevia = evoPrevia;
    }

    /**
     *
     * @return Retorna siguiente evolucion del pokemon de primera evolucion (segunda evolucion del pokemon)
     */
    public String getEvoSiguiente() {
        return evoSiguiente;
    }

    /**
     *
     * @return Retorna anterior evolucion del pokemon de primera evolucion (basico del pokemon)
     */
    public String getEvoPrevia() {
        return evoPrevia;
    }

    /**
     * Metodo para retornar todos los datos del nodo (reemplaza el print de la direccion de memoria por los atributos del objeto)
     * @return
     */
    @Override
    public String toString() {
        return super.getId() + " " + super.getNombre() + " " + super.getEtapa() + " " + evoSiguiente + " " + evoPrevia + " " + super.getTipo1() + " " + super.getTipo2();
    }
}
