public class Eevee extends Pokemon{

    /**
     * Primera variante evolutiva de las evoluciones de Eevee
     */
    private String varianteUno;
    /**
     * Segunda variante evolutiva de las evoluciones de Eevee
     */
    private String varianteDos;
    /**
     * Tercera variante evolutiva de las evoluciones de Eevee
     */
    private String varianteTres;
    /**
     * Constructor del pokemon Eevee
     *
     * @param id
     * @param nombre
     * @param etapa  (evolucion)
     * @param tipo1
     * @param tipo2
     */
    public Eevee(int id, String nombre, String etapa, String tipo1, String tipo2, String varianteUno, String varianteDos, String varianteTres) {
        super(id, nombre, etapa, tipo1, tipo2);
        this.varianteUno = varianteUno;
        this.varianteDos = varianteDos;
        this.varianteTres = varianteTres;
    }

    /**
     * Obtiene primera variante evolutiva de Eevee
     * @return
     */

    public String getVarianteUno() {
        return varianteUno;
    }
    /**
     * Obtiene segunda variante evolutiva de Eevee
     * @return
     */

    public String getVarianteDos() {
        return varianteDos;
    }
    /**
     * Obtiene tercera variante evolutiva de Eevee
     * @return
     */

    public String getVarianteTres() {
        return varianteTres;
    }

    /**
     * Metodo que retorna todos los atributos de la clase en string (reemplaza el print de la direccion de memoria por los atributos del objeto)
     * @return
     */
    @Override
    public String toString() {
        return super.getId() + " " + super.getNombre() + " " + varianteUno + " " + varianteDos + " " + varianteTres + " " + super.getEtapa() + " " + super.getTipo1() + " " + super.getTipo2();
    }
}
