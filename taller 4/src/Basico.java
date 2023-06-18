public class Basico extends Pokemon{
    /**
     * Primera evolucion del pokemon basico
     */
    private String evoPrimera;

    /**
     *  Segunda evolucion del pokemon basico
     */
    private String evoSegunda;
    /**
     * Constructor del pokemon
     *
     * @param id
     * @param nombre
     * @param etapa  (evolucion)
     * @param tipo1
     * @param tipo2
     * @param evoPrimera
     * @param evoSegunda
     */
    public Basico(int id, String nombre, String etapa, String tipo1, String tipo2, String evoPrimera, String evoSegunda) {
        super(id, nombre, etapa, tipo1, tipo2);
        this.evoPrimera = evoPrimera;
        this.evoSegunda = evoSegunda;
    }

    /**
     * Metodo que retorna todos los atributos de la clase (reemplaza el print de la direccion de memoria por los atributos del objeto)
     * @return
     */
    @Override
    public String toString() {
        return super.getId() + " " + super.getNombre() + " " + super.getEtapa() + " " + evoPrimera + " " + evoSegunda + " " + super.getTipo1() + " " + super.getTipo2();
    }

    /**
     * Metodo que obtiene el atributo evoPrimera
     * @return evoPrimera
     */
    public String getEvoPrimera() {
        return evoPrimera;
    }
    /**
     * Metodo que obtiene el atributo evoSegunda
     * @return evoSegunda
     */
    public String getEvoSegunda() {
        return evoSegunda;
    }
}
