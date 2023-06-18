import java.util.*;
import java.util.Scanner;

public final class ListaNexoDoble implements Lista {

    /**
     * La cabeza.
     */
    private NodoDoble cabeza;

    /**
     * La cola.
     */
    private NodoDoble cola;

    /**
     * La lista de nexo simple
     */
    public ListaNexoDoble() {
        this.cabeza = null;
        this.cola = null;
    }

    /**
     * Agrega un elemento a la coleccion.
     *
     * @param e el elemento (pokemon) a agregar.
     * @return true si el elemento fue agregado.
     */
    @Override
    public boolean agregarAlFinal(Elemento e) {

        // nodo a insertar.
        NodoDoble nuevo = new NodoDoble(e);

        // si la lista esta vacia
        if (isVacia()) {
            this.cabeza = nuevo;
            this.cola = nuevo;
            nuevo.setSiguiente(null);
            nuevo.setAnterior(null);
            return true;
        }
        // si la lista tiene un nodo
        else if (this.cabeza == this.cola) {
            this.cola = nuevo;
            this.cabeza.setSiguiente(this.cola);
            this.cola.setAnterior(this.cabeza);
            this.cola.setSiguiente(null);
            return true;
        }
        // si la lista tiene mas de un nodo
        else {
            nuevo.setAnterior(this.cola);
            this.cola.setSiguiente(nuevo);
            nuevo.setSiguiente(null);
            this.cola = nuevo;
            return true;
        }
    }

    /**
     * Agrega nodos al principio de la lista nexo doble
     * @param e the elemento a agregar
     * @return true si agregado correctamente, false si no fue agregado
     */
    @Override
    public boolean agregarAlInicio(Elemento e){
        // nodo a insertar.
        NodoDoble nuevo = new NodoDoble(e);

        // si la lista esta vacia
        if (isVacia()) {
            this.cabeza = nuevo;
            this.cola = nuevo;
            nuevo.setSiguiente(null);
            nuevo.setAnterior(null);
            return true;
        }
        // si la lista tiene un nodo
        else if (this.cabeza == this.cola) {
            nuevo.setSiguiente(this.cabeza);
            nuevo.setAnterior(null);
            this.cabeza.setAnterior(nuevo);
            this.cabeza = nuevo;
            return true;
        }
        // si la lista tiene mas de un nodo
        else {
            nuevo.setSiguiente(this.cabeza);
            nuevo.setAnterior(null);
            this.cabeza.setAnterior(nuevo);
            this.cabeza = nuevo;
            return true;
        }
    }

    /**
     * Retorna true si el elemento esta en la coleccion.
     *
     * @param e el elemento (pokemon) a buscar.
     * @return true si lo encuentra.
     */

    public boolean contiene(Elemento e) {
        // busqueda desde la cabeza a la cola
        for (NodoDoble aux = this.cabeza; aux != null; aux = aux.getSiguiente()) {
            if (aux.getElemento().esIgual(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina un Elemento de la coleccion.
     *
     * @param e el elemento (pokemon) a eliminar.
     * @return true si fue posible eliminarlo.
     */

    public boolean eliminar(Elemento e) {

        //verificar si está vacía

        if (isVacia()) {
            return false;
        }

        //Si solo hay 1 elemento

        else if (this.cabeza.equals(e) && this.cola.equals(e)) {
            this.cabeza = null;
            this.cola = null;
            return true;
        }

        //Si es la cabeza;

        else if (this.cabeza.equals(e)) {
            this.cabeza = this.cabeza.getSiguiente();
            this.cabeza.setAnterior(null);
            return true;
        }

        //Si es la cola;

        else if (this.cola.equals(e)) {
            this.cola = this.cola.getAnterior();
            this.cola.setSiguiente(null);
            return true;
        }

        //Si está en medio
        else {
            NodoDoble aux = this.cabeza;
            while (!aux.getElemento().esIgual(e)) {
                aux = aux.getSiguiente();
            }
            NodoDoble before = aux.getAnterior();
            NodoDoble after = aux.getSiguiente();
            before.setSiguiente(after);
            after.setAnterior(before);
            return true;
        }
    }

    /**
     * Elimina todos los elementos de la coleccion.
     */

    public void vaciar() {
        this.cabeza = null;
    }

    /**
     * @return true si la coleccion esta vacia.
     */
    @Override
    public boolean isVacia() {
        if (this.cabeza == null)
            return true;
        return false;
    }

    /**
     * @return el numero de elementos en la coleccion.
     */
    @Override
    public int tamanio() {
        int contador = 0;
        for (NodoDoble aux = this.cabeza; aux != null; aux = aux.getSiguiente()) {
            contador++;
        }
        return contador;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (NodoDoble aux = this.cabeza; aux != null; aux = aux.getSiguiente()) {
            sb.append(aux.getElemento().toString()).append(",");
        }
        return sb.toString();
    }
    /**
     * Metodo para buscar por Id
     */
    public Elemento buscarId(int id) {
        NodoDoble aux = this.cabeza;
        for (int i = 1; i <= tamanio(); i++) {
            if (aux.getElemento().getId() == id) {
                //System.out.println(aux.getElemento());
                return aux.getElemento();
            }
            aux = aux.getSiguiente();
        }
        return null;
    }
    /**
     *Metodo que busca el nombre por el atributo nombre en cada nodo
     */
    public Elemento buscarNombre(String nombre) {
        NodoDoble aux = this.cabeza;
        for (int i = 1; i <= tamanio(); i++) {
            if (aux.getElemento().getNombre().equals(nombre)) {
                return aux.getElemento();
            }
            aux = aux.getSiguiente();
        }
        return null;
    }
    /**
     * Metodo para saber si un pokemon existe dentro de la lista por su id
     */
    public boolean existeId(int id) {
        NodoDoble aux = this.cabeza;
        for (int i = 1; i <= tamanio(); i++) {
            if (aux.getElemento().getId() == id) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    /**
     * Metodo para obtener la cabeza de la lista
     * @return
     */
    @Override
    public NodoDoble getCabeza(){
        return this.cabeza;
    }
    /**
     * Metodo que despliega id de pokemones en orden creciente dado un rango de id's
     */
    @Override
    public void desplegarIdRangos() {
        try {
            Scanner scanner = new Scanner(System.in);
            boolean paraWhile = true;
            while (paraWhile) {
                System.out.println("Ingrese el rango de ID's a buscar:  [Ejemplo: desde a hasta b (con a > b)]\ndesde:");
                int comienzo = scanner.nextInt();
                System.out.println("hasta:");
                int termino = scanner.nextInt();
                NodoDoble aux = this.cabeza;
                if (comienzo >= 0 && comienzo <= termino && termino <= this.tamanio()) {
                    System.out.println("\n|||||||||||||||||||||||||||||||||||||||\n");
                    for (int i = comienzo; i <= termino; i++) {
                        if (this.existeId(i)) {
                            System.out.println(Objects.requireNonNull(this.buscarId(i)));
                            aux = aux.getSiguiente();
                        }
                    }
                    System.out.println("\n|||||||||||||||||||||||||||||||||||||||");
                    paraWhile = false;
                    Sistema s = new SistemaImpl();
                    s.principal();
                } else {
                    System.out.println("Rango de id's invalido.");
                }
            }
        }catch (Exception e){
            System.out.println("Rango de id's invalido");
            Sistema s = new SistemaImpl();
            s.principal();
        }
    }
    /**
     * Metodo que despliega pokemones en orden alfabetico
     */
    @Override
    public void desplegarAlf(){

        //Agrega pokemones a la nueva lista de orden alfabetico
        ArrayList<Elemento> listaOrdenadaAlfabeticamente = new ArrayList<>();
        NodoDoble aux = this.cabeza;
        for (int i = 1; i <= this.tamanio(); i++){
            this.buscarNombre(aux.getElemento().getNombre());
            listaOrdenadaAlfabeticamente.add(this.buscarId(i));
        }
        //Ordena la lista alfabeticamente usando la interfaz comparator y clase collections
        Collections.sort(listaOrdenadaAlfabeticamente, (Elemento e1, Elemento e2) -> e1.getNombre().compareTo(e2.getNombre()));

        //Despliega
        System.out.println("\n|||||||||||||||||||||||||||||||||||||||\n");
        listaOrdenadaAlfabeticamente.forEach(lista -> System.out.println(lista.toString()));
        System.out.println("\n|||||||||||||||||||||||||||||||||||||||");
        Sistema s = new SistemaImpl();
        s.principal();
    }

    /**
     * Metodo que despliega pokemones segun su tipo
     */
    @Override
    public void desplegarTipo() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listaTipos = new ArrayList<>(Arrays.asList("normal","fuego","agua","electrico","hierba","planta","hielo","lucha","veneno","tierra","volador","psiquico","insecto","bicho","roca","piedra","fantasma","dragon","siniestro","oscuro","acero","hada"));
        System.out.println("Ingrese el tipo de pokemon a buscar: \nv");
        String tipo = scanner.nextLine().trim().toLowerCase();
        NodoDoble aux = this.cabeza;

        if (listaTipos.contains(tipo)) {
            System.out.println("\n|||||||||||||||||||||||||||||||||||||||\n");
            for (int i = 1; i <= this.tamanio(); i++) {
                if (aux.getElemento().getTipo1().toLowerCase().equals(tipo) || aux.getElemento().getTipo2().toLowerCase().equals(tipo)) {
                    System.out.println(aux.getElemento());
                }
                aux = aux.getSiguiente();
            }
            System.out.println("\n|||||||||||||||||||||||||||||||||||||||");
        }

        else{
            System.out.println("Este tipo no existe, intente nuevamente.");
        }
        Sistema s = new SistemaImpl();
        s.principal();
    }

    /**
     * Despliega todos los pokemones que están en la etapa Primera Evolucion
     */
    @Override
    public void desplegarPrimeraEvo(){
        //Agrega pokemones a la nueva lista de orden decreciente
        NodoDoble aux = this.cabeza;
        System.out.println("\n|||||||||||||||||||||||||||||||||||||||\n");
        for (int i = 1; i <= tamanio(); i++) {
            if (aux.getElemento().getEtapa().equals("Primera Evolucion")) {
                System.out.println(aux.getElemento());
            }
            aux = aux.getSiguiente();
        }
        System.out.println("\n|||||||||||||||||||||||||||||||||||||||");
        Sistema s = new SistemaImpl();
        s.principal();
    }

    /**
     * Metodo para obtener una busqueda personalizada, como buscar por id o nombre
     * @param listaPokemones
     */
    @Override
    public void busquedaPersonalizada(ListaNexoDoble listaPokemones){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> opciones = new ArrayList<>(Arrays.asList("1", "2", "3"));
        String opcion = "";
        while(!opciones.contains(opcion)) {
            System.out.println(
                    """

                            ### Bienvenido/a a la busqueda personalizada ###
                            1.- Buscar por id.
                            2.- Buscar por nombre.
                            3.- Volver al menu.
                            v""");
            opcion = scanner.nextLine().trim();
            switch (opcion) {
                //Busqueda por id
                case "1":
                    try {
                        System.out.println("Ingrese id a buscar\nv");
                        int idABuscar = scanner.nextInt();

                        //Si entra un pokemon basico por id
                        if (Objects.requireNonNull(buscarId(idABuscar).getEtapa().equals("Basico")))
                        {
                            NodoDoble aux = listaPokemones.getCabeza();

                            //Encuentra la posicion del pokemon a buscar en la lista
                            while (aux.getElemento().getId() != idABuscar) {
                                aux = aux.getSiguiente();
                            }

                            // pokemones basicos, sin evoluciones
                            if (aux.getElemento().getEtapa().equals("Basico") && aux.getSiguiente().equals(null))  {
                                System.out.println(aux.getElemento());
                                System.out.println("No tiene evoluciones");
                            }

                            //Busqueda para Eevee
                            else if (aux.getElemento().getNombre().equals("Eevee")) {
                                System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                System.out.println(aux.getElemento());
                                System.out.println("\n//##//##//##//##//##//##//##//##");
                                aux = listaPokemones.getCabeza();
                                while (!aux.getElemento().getNombre().equals("Eevee")) {
                                    aux = aux.getSiguiente();
                                }
                                ArrayList<String> respuestas = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
                                String rpta = "";
                                while (!respuestas.contains(rpta)) {
                                    System.out.println("""
                                            Buscar otra evolucion:
                                            1)Vaporeon
                                            2)Jolteon
                                            3)Flareon
                                            4)Eevee
                                            5)Salir
                                            v""");
                                    rpta = scanner.nextLine().trim();
                                    switch (rpta) {
                                        case "1" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getSiguiente().getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "2" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getSiguiente().getSiguiente().getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "3" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getSiguiente().getSiguiente().getSiguiente().getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "4" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getElemento());
                                            rpta = "";
                                        }
                                        case "5" -> {
                                            System.out.println("Volviendo...\n");
                                            busquedaPersonalizada(listaPokemones);
                                        }
                                    }
                                }
                            }
                            //Busqueda para pokemones con Segunda Evolucion
                            else if (aux.getSiguiente().getSiguiente().getElemento().getEtapa().equals("Segunda Evolucion")) {
                                System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                System.out.println(aux.getElemento());
                                System.out.println("\n//##//##//##//##//##//##//##//##");
                                aux = listaPokemones.getCabeza();
                                while (aux.getElemento().getId() != idABuscar) {
                                    aux = aux.getSiguiente();
                                }
                                ArrayList<String> respuestas = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
                                String rpta = "";
                                while (!respuestas.contains(rpta)) {
                                    System.out.println("Buscar otra evolucion:\n" +
                                            "1)" + aux.getElemento().getNombre() + "\n" +
                                            "2)" + aux.getSiguiente().getElemento().getNombre() + "\n" +
                                            "3)" + aux.getSiguiente().getSiguiente().getElemento().getNombre() + "\n" +
                                            "4)Salir.\n" +
                                            "v");
                                    rpta = scanner.nextLine().trim();
                                    switch (rpta) {
                                        case "1" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "2" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getSiguiente().getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "3" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getSiguiente().getSiguiente().getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "4" -> {
                                            System.out.println("Volviendo...\n");
                                            busquedaPersonalizada(listaPokemones);
                                        }
                                    }
                                }
                            }

                            //Busqueda para pokemones con solamente Primera Evolucion
                            else if (aux.getSiguiente().getElemento().getEtapa().equals("Primera Evolucion")) {
                                System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                System.out.println(aux.getElemento());
                                System.out.println("\n//##//##//##//##//##//##//##//##");
                                aux = listaPokemones.getCabeza();
                                while (aux.getElemento().getId() != idABuscar) {
                                    aux = aux.getSiguiente();
                                }
                                ArrayList<String> respuestas = new ArrayList<>(Arrays.asList("1", "2", "3"));
                                String rpta = "";
                                while (!respuestas.contains(rpta)) {
                                    System.out.println("Buscar otra evolucion:\n" +
                                            "1)" + aux.getElemento().getNombre() + "\n" +
                                            "2)" + aux.getSiguiente().getElemento().getNombre() + "\n" +
                                            "3)Salir.\n" +
                                            "v");
                                    rpta = scanner.nextLine().trim();
                                    switch (rpta) {
                                        case "1" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "2" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getSiguiente().getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "3" -> {
                                            System.out.println("Volviendo...\n");
                                            busquedaPersonalizada(listaPokemones);
                                        }
                                    }
                                }
                            }
                        }
                        //Si entra un pokemon de Primera Evolucion por id
                        else if (Objects.requireNonNull(buscarId(idABuscar)).getEtapa().equals("Primera Evolucion"))
                        {
                            NodoDoble aux = listaPokemones.getCabeza();
                            while (aux.getElemento().getId() != idABuscar) {
                                aux = aux.getSiguiente();
                            }
                            if (aux.getElemento().getNombre().equals("Vaporeon")
                                    || aux.getElemento().getNombre().equals("Jolteon")
                                    || aux.getElemento().getNombre().equals("Flareon")) {
                                System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                System.out.println(aux.getElemento());
                                System.out.println("\n//##//##//##//##//##//##//##//##");
                                aux = listaPokemones.getCabeza();
                                while (!aux.getElemento().getNombre().equals("Eevee")) {
                                    aux = aux.getSiguiente();
                                }
                                ArrayList<String> respuestas = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
                                String rpta = "";
                                while (!respuestas.contains(rpta)) {
                                    System.out.println("""
                                            Buscar otra evolucion:
                                            1)Vaporeon
                                            2)Jolteon
                                            3)Flareon
                                            4)Eevee
                                            5)Salir.
                                            v""");
                                    rpta = scanner.nextLine().trim();
                                    switch (rpta) {
                                        case "1" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getSiguiente().getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "2" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getSiguiente().getSiguiente().getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "3" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getSiguiente().getSiguiente().getSiguiente().getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "4" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "5" -> {
                                            System.out.println("Volviendo...\n");
                                            busquedaPersonalizada(listaPokemones);
                                        }
                                    }
                                }
                            } else if (aux.getSiguiente().getElemento().getEtapa().equals("Segunda Evolucion")) {
                                System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                System.out.println(aux.getElemento());
                                System.out.println("\n//##//##//##//##//##//##//##//##");
                                aux = listaPokemones.getCabeza();
                                while (aux.getElemento().getId() != (idABuscar - 1)) {
                                    aux = aux.getSiguiente();
                                }
                                ArrayList<String> respuestas = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
                                String rpta = "";
                                while (!respuestas.contains(rpta)) {
                                    System.out.println("Buscar otra evolucion:\n" +
                                            "1)" + aux.getElemento().getNombre() + "\n" +
                                            "2)" + aux.getSiguiente().getElemento().getNombre() + "\n" +
                                            "3)" + aux.getSiguiente().getSiguiente().getElemento().getNombre() + "\n" +
                                            "4)Salir.\n" +
                                            "v");
                                    rpta = scanner.nextLine().trim();
                                    switch (rpta) {
                                        case "1" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "2" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getSiguiente().getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "3" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getSiguiente().getSiguiente().getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "4" -> {
                                            System.out.println("Volviendo...\n");
                                            busquedaPersonalizada(listaPokemones);
                                        }
                                    }
                                }
                            } else if (aux.getElemento().getEtapa().equals("Primera Evolucion")) {
                                System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                System.out.println(aux.getElemento());
                                System.out.println("\n//##//##//##//##//##//##//##//##");
                                aux = listaPokemones.getCabeza();
                                while ((aux.getElemento().getId()) != (idABuscar - 1)) {
                                    aux = aux.getSiguiente();
                                }
                                ArrayList<String> respuestas = new ArrayList<>(Arrays.asList("1", "2", "3"));
                                String rpta = "";
                                while (!respuestas.contains(rpta)) {
                                    System.out.println("Buscar otra evolucion:\n" +
                                            "1)" + aux.getElemento().getNombre() + "\n" +
                                            "2)" + aux.getSiguiente().getElemento().getNombre() + "\n" +
                                            "3)Salir.\n" +
                                            "v");
                                    rpta = scanner.nextLine().trim();
                                    switch (rpta) {
                                        case "1" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "2" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getSiguiente().getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "3" -> {
                                            System.out.println("Volviendo...\n");
                                            busquedaPersonalizada(listaPokemones);
                                        }
                                    }
                                }
                            }
                        }
                        //Si entra un pokemon de Segunda Evolucion por id
                        else if (Objects.requireNonNull(buscarId(idABuscar).getEtapa().equals("Segunda Evolucion")))
                        {
                            NodoDoble aux = listaPokemones.getCabeza();
                            while (aux.getElemento().getId() != idABuscar) {
                                aux = aux.getSiguiente();
                            }
                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                            System.out.println(aux.getElemento());
                            System.out.println("\n//##//##//##//##//##//##//##//##");
                            aux = listaPokemones.getCabeza();
                            while (aux.getElemento().getId() != (idABuscar - 2)) {
                                aux = aux.getSiguiente();
                            }
                            ArrayList<String> respuestas = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
                            String rpta = "";
                            while (!respuestas.contains(rpta)) {
                                System.out.println("Buscar otra evolucion:\n" +
                                        "1)" + aux.getElemento().getNombre() + "\n" +
                                        "2)" + aux.getSiguiente().getElemento().getNombre() + "\n" +
                                        "3)" + aux.getSiguiente().getSiguiente().getElemento().getNombre() + "\n" +
                                        "4)Salir.\n" +
                                        "v");
                                rpta = scanner.nextLine().trim();
                                switch (rpta) {
                                    case "1" -> {
                                        System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                        System.out.println(aux.getElemento());
                                        System.out.println("\n//##//##//##//##//##//##//##//##");
                                        rpta = "";
                                    }
                                    case "2" -> {
                                        System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                        System.out.println(aux.getSiguiente().getElemento());
                                        System.out.println("\n//##//##//##//##//##//##//##//##");
                                        rpta = "";
                                    }
                                    case "3" -> {
                                        System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                        System.out.println(aux.getSiguiente().getSiguiente().getElemento());
                                        System.out.println("\n//##//##//##//##//##//##//##//##");
                                        rpta = "";
                                    }
                                    case "4" -> {
                                        System.out.println("Volviendo...\n");
                                        busquedaPersonalizada(listaPokemones);
                                    }
                                }
                            }
                        }
                    }catch(Exception e){
                        System.out.println("\nERROR: Id Invalida.");
                        SistemaImpl s = new SistemaImpl();
                        s.principal();
                    }
                    break;
                //Busqueda por nombre
                case "2":
                    try {
                        System.out.println("Ingrese nombre del pokemon a buscar:\n"+"v");

                        //Validacion de todas las combinaciones de mayusculas y minusculas
                        String nombreABuscar = scanner.nextLine().trim().toLowerCase();
                        nombreABuscar = nombreABuscar.toUpperCase().charAt(0) + nombreABuscar.substring(1);
                        //Si entra un pokemon basico por id
                        if (Objects.requireNonNull(buscarNombre(nombreABuscar)).getEtapa().equals("Basico"))
                        {
                            NodoDoble aux = listaPokemones.getCabeza();

                            //Encuentra la posicion del pokemon a buscar en la lista
                            while (!aux.getElemento().getNombre().equals(nombreABuscar)) {
                                aux = aux.getSiguiente();
                            }

                            //Busqueda para Eevee
                            if (aux.getElemento().getNombre().equals("Eevee")) {
                                System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                System.out.println(aux.getElemento());
                                System.out.println("\n//##//##//##//##//##//##//##//##");
                                aux = listaPokemones.getCabeza();
                                while (!aux.getElemento().getNombre().equals("Eevee")) {
                                    aux = aux.getSiguiente();
                                }
                                ArrayList<String> respuestas = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
                                String rpta = "";
                                while (!respuestas.contains(rpta)) {
                                    System.out.println("""
                                            Buscar otra evolucion:
                                            1)Vaporeon
                                            2)Jolteon
                                            3)Flareon
                                            4)Eevee
                                            5)Salir.
                                            v""");
                                    rpta = scanner.nextLine().trim();
                                    switch (rpta) {
                                        case "1" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getSiguiente().getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "2" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getSiguiente().getSiguiente().getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "3" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getSiguiente().getSiguiente().getSiguiente().getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "4" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "5" -> {
                                            System.out.println("Volviendo...\n");
                                            busquedaPersonalizada(listaPokemones);
                                        }
                                    }
                                }
                            }
                            //Busqueda para pokemones con Segunda Evolucion
                            else if (aux.getSiguiente().getSiguiente().getElemento().getEtapa().equals("Segunda Evolucion")) {
                                System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                System.out.println(aux.getElemento());
                                System.out.println("\n//##//##//##//##//##//##//##//##");
                                aux = listaPokemones.getCabeza();
                                while (!aux.getElemento().getNombre().equals(nombreABuscar)) {
                                    aux = aux.getSiguiente();
                                }
                                ArrayList<String> respuestas = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
                                String rpta = "";
                                while (!respuestas.contains(rpta)) {
                                    System.out.println("Buscar otra evolucion:\n" +
                                            "1)" + aux.getElemento().getNombre() + "\n" +
                                            "2)" + aux.getSiguiente().getElemento().getNombre() + "\n" +
                                            "3)" + aux.getSiguiente().getSiguiente().getElemento().getNombre() + "\n" +
                                            "4)Salir.\n" +
                                            "v");
                                    rpta = scanner.nextLine().trim();
                                    switch (rpta) {
                                        case "1" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "2" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getSiguiente().getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "3" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getSiguiente().getSiguiente().getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "4" -> {
                                            System.out.println("Volviendo...\n");
                                            busquedaPersonalizada(listaPokemones);
                                        }
                                    }
                                }
                            }
                            //Busqueda para pokemones con solamente Primera Evolucion
                            else if (aux.getSiguiente().getElemento().getEtapa().equals("Primera Evolucion")) {
                                System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                System.out.println(aux.getElemento());
                                System.out.println("\n//##//##//##//##//##//##//##//##");
                                aux = listaPokemones.getCabeza();
                                while (!aux.getElemento().getNombre().equals(nombreABuscar)) {
                                    aux = aux.getSiguiente();
                                }
                                ArrayList<String> respuestas = new ArrayList<>(Arrays.asList("1", "2", "3"));
                                String rpta = "";
                                while (!respuestas.contains(rpta)) {
                                    System.out.println("Buscar otra evolucion:\n" +
                                            "1)" + aux.getElemento().getNombre() + "\n" +
                                            "2)" + aux.getSiguiente().getElemento().getNombre() + "\n" +
                                            "3)Salir.\n" +
                                            "v");
                                    rpta = scanner.nextLine().trim();
                                    switch (rpta) {
                                        case "1" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "2" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getSiguiente().getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "3" -> {
                                            System.out.println("Volviendo...\n");
                                            busquedaPersonalizada(listaPokemones);
                                        }
                                    }
                                }
                            }
                            // pokemones basicos, sin evoluciones
                            else {
                                System.out.println(aux.getElemento());
                                System.out.println("No tiene evoluciones");
                            }
                        }
                        //Si entra un pokemon de Primera Evolucion por id
                        else if (Objects.requireNonNull(buscarNombre(nombreABuscar)).getEtapa().equals("Primera Evolucion"))
                        {
                            NodoDoble aux = listaPokemones.getCabeza();
                            while (!aux.getElemento().getNombre().equals(nombreABuscar)) {
                                aux = aux.getSiguiente();
                            }
                            if (aux.getElemento().getNombre().equals("Vaporeon")
                                    || aux.getElemento().getNombre().equals("Jolteon")
                                    || aux.getElemento().getNombre().equals("Flareon")) {
                                System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                System.out.println(aux.getElemento());
                                System.out.println("\n//##//##//##//##//##//##//##//##");
                                aux = listaPokemones.getCabeza();
                                while (!aux.getElemento().getNombre().equals("Eevee")) {
                                    aux = aux.getSiguiente();
                                }
                                ArrayList<String> respuestas = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
                                String rpta = "";
                                while (!respuestas.contains(rpta)) {
                                    System.out.println("""
                                            Buscar otra evolucion:
                                            1)Vaporeon
                                            2)Jolteon
                                            3)Flareon
                                            4)Eevee
                                            5)Salir.
                                            v""");
                                    rpta = scanner.nextLine().trim();
                                    switch (rpta) {
                                        case "1" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getSiguiente().getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "2" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getSiguiente().getSiguiente().getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "3" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getSiguiente().getSiguiente().getSiguiente().getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "4" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "5" -> {
                                            System.out.println("Volviendo...\n");
                                            busquedaPersonalizada(listaPokemones);
                                        }
                                    }
                                }
                            } else if (aux.getSiguiente().getElemento().getEtapa().equals("Segunda Evolucion")) {
                                System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                System.out.println(aux.getElemento());
                                System.out.println("\n//##//##//##//##//##//##//##//##");
                                aux = listaPokemones.getCabeza();
                                while (!aux.getSiguiente().getElemento().getNombre().equals(nombreABuscar)) {
                                    aux = aux.getSiguiente();
                                }
                                ArrayList<String> respuestas = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
                                String rpta = "";
                                while (!respuestas.contains(rpta)) {
                                    System.out.println("Buscar otra evolucion:\n" +
                                            "1)" + aux.getElemento().getNombre() + "\n" +
                                            "2)" + aux.getSiguiente().getElemento().getNombre() + "\n" +
                                            "3)" + aux.getSiguiente().getSiguiente().getElemento().getNombre() + "\n" +
                                            "4)Salir.\n" +
                                            "v");
                                    rpta = scanner.nextLine().trim();
                                    switch (rpta) {
                                        case "1" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "2" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getSiguiente().getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "3" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getSiguiente().getSiguiente().getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "4" -> {
                                            System.out.println("Volviendo...\n");
                                            busquedaPersonalizada(listaPokemones);
                                        }
                                    }
                                }
                            } else if (aux.getElemento().getEtapa().equals("Primera Evolucion")) {
                                System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                System.out.println(aux.getElemento());
                                System.out.println("\n//##//##//##//##//##//##//##//##");
                                aux = listaPokemones.getCabeza();
                                while (!aux.getSiguiente().getElemento().getNombre().equals(nombreABuscar)) {
                                    aux = aux.getSiguiente();
                                }
                                ArrayList<String> respuestas = new ArrayList<>(Arrays.asList("1", "2", "3"));
                                String rpta = "";
                                while (!respuestas.contains(rpta)) {
                                    System.out.println("Buscar otra evolucion:\n" +
                                            "1)" + aux.getElemento().getNombre() + "\n" +
                                            "2)" + aux.getSiguiente().getElemento().getNombre() + "\n" +
                                            "3)Salir.\n" +
                                            "v");
                                    rpta = scanner.nextLine().trim();
                                    switch (rpta) {
                                        case "1" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "2" -> {
                                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                            System.out.println(aux.getSiguiente().getElemento());
                                            System.out.println("\n//##//##//##//##//##//##//##//##");
                                            rpta = "";
                                        }
                                        case "3" -> {
                                            System.out.println("Volviendo...\n");
                                            busquedaPersonalizada(listaPokemones);
                                        }
                                    }
                                }
                            }
                        }
                        //Si entra un pokemon de Segunda Evolucion por id
                        else if (Objects.requireNonNull(buscarNombre(nombreABuscar)).getEtapa().equals("Segunda Evolucion"))
                        {
                            NodoDoble aux = listaPokemones.getCabeza();
                            while (!aux.getElemento().getNombre().equals(nombreABuscar)) {
                                aux = aux.getSiguiente();
                            }
                            System.out.println("\n//##//##//##//##//##//##//##//##\n");
                            System.out.println(aux.getElemento());
                            System.out.println("\n//##//##//##//##//##//##//##//##");
                            aux = listaPokemones.getCabeza();
                            while (!aux.getAnterior().getAnterior().getElemento().getNombre().equals(nombreABuscar)) {
                                aux = aux.getSiguiente();
                            }
                            ArrayList<String> respuestas = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
                            String rpta = "";
                            while (!respuestas.contains(rpta)) {
                                System.out.println("Buscar otra evolucion:\n" +
                                        "1)" + aux.getElemento().getNombre() + "\n" +
                                        "2)" + aux.getSiguiente().getElemento().getNombre() + "\n" +
                                        "3)" + aux.getSiguiente().getSiguiente().getElemento().getNombre() + "\n" +
                                        "4)Salir.\n" +
                                        "v");
                                rpta = scanner.nextLine().trim();
                                switch (rpta) {
                                    case "1" -> {
                                        System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                        System.out.println(aux.getElemento());
                                        System.out.println("\n//##//##//##//##//##//##//##//##");
                                        rpta = "";
                                    }
                                    case "2" -> {
                                        System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                        System.out.println(aux.getSiguiente().getElemento());
                                        System.out.println("\n//##//##//##//##//##//##//##//##");
                                        rpta = "";
                                    }
                                    case "3" -> {
                                        System.out.println("\n//##//##//##//##//##//##//##//##\n");
                                        System.out.println(aux.getSiguiente().getSiguiente().getElemento());
                                        System.out.println("\n//##//##//##//##//##//##//##//##");
                                        rpta = "";
                                    }
                                    case "4" -> {
                                        System.out.println("Volviendo...\n");
                                        busquedaPersonalizada(listaPokemones);
                                    }
                                }
                            }
                        }
                    }catch(Exception e){
                        System.out.println("\nERROR: Pokemon invalido.");
                        Sistema s = new SistemaImpl();
                        s.principal();
                    }
                    Sistema s = new SistemaImpl();
                    s.principal();
                    break;
                case "3":
                    System.out.println("Volviendo...");
                    s = new SistemaImpl();
                    s.principal();
                    break;
            }
        }
    }
}