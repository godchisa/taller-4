public interface Sistema {

     /**
     * Metodo que despliega pokemons en un rango segun id en orden creciente
     * @return
     */
    String desplegarIdRangos();

    /**
     * Metodo que despliega todos los pokemons alfabeticamente
     * @return
     */
    String desplegarAlf();

    /**
     * Metodo que despliega todos los pokemons del tipo que se pida
     * @param tipo
     * @return
     */
    String desplegarTipo(String tipo);

    /**
     * Metodo que despliega todos los pokemons de primera evolucion segun su id en orden decreciente
     * @return
     */
    void desplegarPrimeraEvo();

    /**
     * Metodo que despliega los pokemons segun su id o nombre y sobre sus evoluciones
     * @return
     */
    String buscar(String nombre, int id);

    /**
     * Metodo donde se manejan todos los metodos
     */
    void principal();

}
