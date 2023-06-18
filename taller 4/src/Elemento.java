public interface Elemento {

    /**
     * Realiza la comparacion entre dos Elementos.
     *
     * @param e elemento a comparar.
     * @return true si ambos elementos son iguales.
     */
    boolean esIgual(Elemento e);

    /**
     * @return el Id del pokemon
     */
    int getId();
    /**
     * @return el nombre del pokemon
     */

    String getNombre();
    /**
     * @return la etapa del pokemon
     */

    String getEtapa();
    /**
     * @return el tipo1 del pokemon
     */

    String getTipo1();

    /**
     * @return el tipo2 del pokemon
     */
    String getTipo2();
}
