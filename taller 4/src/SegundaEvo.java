public class SegundaEvo extends Pokemon{
    /**
     * Primera evolucion del pokemon de segunda evolucion (primera evolucion del pokemon)
     */
    private String evoPrimera;
    /**
     * Segunda evolucion del pokemon de segunda evolucion (primera evolucion del pokemon)
     */
    private String evoSegunda;

    /**
     * Constructor del pokemon
     * @param id
     * @param nombre
     * @param etapa  (evolucion)
     * @param tipo1
     * @param tipo2
     */
    public SegundaEvo(int id, String nombre, String etapa, String tipo1, String tipo2, String evoPrimera, String evoSegunda) {
        super(id, nombre, etapa, tipo1, tipo2);
        this.evoPrimera = evoPrimera;
        this.evoSegunda = evoSegunda;
    }

    /**
     *
     * @return Retorna primera evolucion del pokemon de segunda evolucion (primera evolucion del pokemon)
     */
    public String getEvoPrimera() {
        return evoPrimera;
    }
    /**
     *
     * @return Retorna segunda evolucion del pokemon de segunda evolucion (primera evolucion del pokemon)
     */
    public String getEvoSegunda() {
        return evoSegunda;
    }

    /**
     * Metodo para retornar todos los datos del nodo (reemplaza el print de la direccion de memoria por los atributos del objeto)
     * @return
     */

    @Override
    public String toString() {
        return super.getId() + " " + super.getNombre() + " " + super.getEtapa() + " " + evoPrimera + " " + evoSegunda + " " + super.getTipo1() + " " + super.getTipo2();
    }
}
