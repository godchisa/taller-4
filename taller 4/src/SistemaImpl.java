import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SistemaImpl implements Sistema {
    /**
     * Lista donde se guardan los nodos con elementos (pokemons) dentro
     */
    private ListaNexoDoble pokemones;

    /**
     * Metodo para llamar a la clase SistemaImpl y sus metodos (@Overrides's)
     */
    public SistemaImpl() {

    }

    /**
     * Metodo que despliega pokemons en un rango segun id en orden creciente
     * @return
     */
    @Override
    public String desplegarIdRangos() {
        return null;
    }

    /**
     * Metodo que despliega todos los pokemons alfabeticamente
     * @return
     */
    @Override
    public String desplegarAlf() {
        return null;
    }

    /**
     * Metodo que despliega todos los pokemons del tipo que se pida
     * @param tipo
     * @return
     */
    @Override
    public String desplegarTipo(String tipo) {
        return null;
    }

    /**
     * Metodo que despliega todos los pokemons de primera evolucion segun su id en orden decreciente
     */
    @Override
    public void desplegarPrimeraEvo() {

    }

    /**
     * Metodo que despliega los pokemons segun su id o nombre y sobre sus evoluciones
     * @param nombre
     * @param id
     * @return
     */
    @Override
    public String buscar(String nombre, int id) {
        return null;
    }

    /**
     * Metodo donde se manejan todos los metodos y el programa principal
     */
    @Override
    public void principal() {

        //Instancias de listas a ocupar en el ordenamiento creciente y alfabetico
        LectorCSV LectorCSV = new LectorCSV();
        ListaNexoDoble pokemones = new ListaNexoDoble();
        ListaNexoDoble pokemonesOrdenadosCreciente = new ListaNexoDoble();
//        ArrayList<String> pokemonesOrdenadosAlfabeticamente = new ArrayList<>();                <--- solo para imprimir el nombre del pokemon, no con el pokemon entero
        ListaNexoDoble pokemonesOrdenadosAlfabeticamente1 = new ListaNexoDoble();
        ListaNexoDoble pokemonesOrdenadosDecreciente = new ListaNexoDoble();
        Scanner scanner = new Scanner(System.in);
        LectorCSV.Lectura(pokemones);

        //Agrega pokemones de la Lista Nexo Doble a las listas para ordenar por id creciente y orden alfabetico
        for (int i = 1; i <= pokemones.tamanio(); i++) {
            pokemonesOrdenadosCreciente.agregarAlFinal(pokemones.buscarId(i));
//            pokemonesOrdenadosAlfabeticamente.add(pokemones.buscarId(i).getNombre());           <--- solo para imprimir el nombre del pokemon, no con el pokemon entero
            pokemonesOrdenadosAlfabeticamente1.agregarAlFinal(pokemones.buscarId(i));
            pokemonesOrdenadosDecreciente.agregarAlInicio(pokemones.buscarId(i));
        }

        //Ordena arraylist de pokemones alfabeticamente
//        Collections.sort(pokemonesOrdenadosAlfabeticamente);                                    <--- solo para imprimir el nombre del pokemon, no con el pokemon entero

        //Menu
        ArrayList<String> opciones = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6"));
        String opcion = "";
        while(!opciones.contains(opcion)){
            System.out.println("\n" +
                    "### Bienvenido/a a tu pokedex ###\n" +
                    "1.- Buscar un rango de pokemons por su id.\n" +
                    "2.- Pokemons en orden alfabetico.\n" +
                    "3.- Buscar pokemons por tipo.\n" +
                    "4.- Mostrar todos tus pokemons de Primera Evolucion.\n" +
                    "5.- Busqueda Personalizada.\n" +
                    "6.- Salir. \n" +
                    "v");
            opcion = scanner.nextLine().trim();
            switch (opcion){
                case "1":
                    pokemonesOrdenadosCreciente.desplegarIdRangos();
                    break;
                case "2":
                    pokemonesOrdenadosAlfabeticamente1.desplegarAlf();
//                    for(String index : pokemonesOrdenadosAlfabeticamente){                    <--- solo para imprimir el nombre del pokemon, no con el pokemon entero
//                        System.out.println(index);
//                    }
//                    principal();
                    break;
                case "3":
                    pokemones.desplegarTipo();
                    break;
                case "4":
                    pokemonesOrdenadosDecreciente.desplegarPrimeraEvo();
                    break;
                case "5":
                    pokemonesOrdenadosCreciente.busquedaPersonalizada(pokemonesOrdenadosCreciente);
                    break;
                case "6":
                    System.out.println("Saliendo...");
                    opcion = "6";
                    break;
            }
        }
    }
}
