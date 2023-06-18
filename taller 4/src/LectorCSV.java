import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class LectorCSV {
    public ListaNexoDoble Lectura(ListaNexoDoble pokemones){
        /**
         * Variable de la ruta del archivo .txt
         */
        String archivo = "src\\kanto.txt";
        /**
         * El lector del archivo .txt
         */
        BufferedReader lector = null;
        /**
         * Lineas del .txt
         */
        String linea = "";

        try{
            // lectura del archivo
            lector = new BufferedReader(new FileReader(archivo));

            // lectura linea por linea
            while((linea = lector.readLine()) != null) {

                // si la linea no tiene caracteres, se omite
                if (linea.trim().isEmpty()) {
                    continue;
                }
                // divisor de las lineas
                String[] fila = linea.split(",");
                // limpia los espacios
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = fila[i].trim();
                }
                // definicion de los atributos para todos los pokemones
                int id = Integer.parseInt(fila[0]);
                String nombre = fila[1];
                String etapa = fila[2];
                // Agrega pokemon Eevee a la lista Nexo Doble
                if (nombre.equals("Eevee")) {
                    String varianteUno = fila[3];
                    String varianteDos = fila[4];
                    String varianteTres = fila[5];
                    String tipo1 = fila[6];
                    String tipo2 = fila[7];
                    Eevee eevee = new Eevee(id, nombre, etapa, tipo1, tipo2, varianteUno, varianteDos, varianteTres);
                    pokemones.agregarAlFinal(eevee);
                }
                // Agrega pokemones basicos a la lista Nexo Doble
                else if (etapa.equals("Basico")) {

                    // si no tiene evolucion
                    if (fila.length == 5) {
                        String tipo1 = fila[3];
                        String tipo2 = fila[4];
                        Basico basico = new Basico(id, nombre, etapa, tipo1, tipo2, "", "");
                        pokemones.agregarAlFinal(basico);
                    }
                    // si tiene 1 evolucion
                    else if (fila.length == 6) {
                        String evoPrimera = fila[3];
                        String tipo1 = fila[4];
                        String tipo2 = fila[5];
                        Basico basico = new Basico(id, nombre, etapa, tipo1, tipo2, evoPrimera, "");
                        pokemones.agregarAlFinal(basico);

                    }
                    //si tiene 2 evoluciones
                    else if (fila.length == 7) {
                        String evoPrimera = fila[3];
                        String evoSegunda = fila[4];
                        String tipo1 = fila[5];
                        String tipo2 = fila[6];
                        Basico basico = new Basico(id, nombre, etapa, tipo1, tipo2, evoPrimera, evoSegunda);
                        pokemones.agregarAlFinal(basico);
                    }
                }
                // Agrega pokemones de primera evolucion a la lista Nexo Doble
                else if (etapa.equals("Primera Evolucion")) {

                    // si no tiene segunda evo
                    if (fila.length == 6) {
                        String evoPrev = fila[3];
                        String tipo1 = fila[4];
                        String tipo2 = fila[5];
                        PrimeraEvo primeraEvo = new PrimeraEvo(id, nombre, etapa, tipo1, tipo2, "", evoPrev);
                        pokemones.agregarAlFinal(primeraEvo);
                    }
                    // si tiene segunda evo
                    else if (fila.length == 7) {
                        String evoSig = fila[3];
                        String evoPrev = fila[4];
                        String tipo1 = fila[5];
                        String tipo2 = fila[6];
                        PrimeraEvo primeraEvo = new PrimeraEvo(id, nombre, etapa, tipo1, tipo2, evoSig, evoPrev);
                        pokemones.agregarAlFinal(primeraEvo);
                    }
                }
                // Agrega pokemones de segunda evolucion a la lista Nexo Doble
                else if (etapa.equals("Segunda Evolucion")) {
                    String evoSegunda = fila[3];
                    String evoPrimera = fila[4];
                    String tipo1 = fila[5];
                    String tipo2 = fila[6];
                    SegundaEvo segundaEvo = new SegundaEvo(id, nombre, etapa, tipo1, tipo2, evoPrimera, evoSegunda);
                    pokemones.agregarAlFinal(segundaEvo);
                }

//                imprime el txt de manera limpia
//                for(String index : fila){
//                    String indexSinEspacio = index.trim();
//                    System.out.printf("%20s",indexSinEspacio);
//                }
//                System.out.println();

                }
            }
        // agarra un error que pueda ocurrir y lo imprime
        catch(Exception e){
            e.printStackTrace();
        }
        // cierra el lector y archivo
        finally{
            try {
                lector.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    return pokemones;
    }
}