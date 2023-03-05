import java.util.Scanner;

/**
 * Clase Criba
 * @author Simeón París
 * @version 2.2
 * @see <a href ="http://www.juntadeandalucia.es/averroes/centros-tic/18601059/helvia/aula/archivos/repositorio/250/354/html/Plan%204-6-09/criba.htm> Criba Erastotenes</a>
 */
public class Criba {
    //Generar primos de 1 a max

    /**
     * Empieza por el numero 2, que lo marca como primo pero tacha sus multiplos
     * @param max determina el num más alto
     * @return devuelve 0 si el vector es menor a 2
     *
     */
    public static int[] generarPrimos(int max) {
        int i, j;
        if (max >= 2) {
            //DEclaraciones
            int dim = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[dim];
            //Inicializar el array
            inicializarArray(dim, esPrimo);
            //Criba
            criba(dim, esPrimo);
            //Cuantos primos hay?
            int cuenta = cuantosPrimos(dim, esPrimo);
            //Rellenar el vector de numeros primos
            int[] primos = new int[cuenta];

            rellenarVector(dim, esPrimo, primos);
            return primos;
        } else { // max < 2
            return new int[0];//Vector Vacío

        }
    }

    /**
     *
     * @param dim para determinar el tamaño del array
     * @param esPrimo Determinamos con un boolean si es primo o no
     * @param primos array de numeros primos obtenidos
     */
    public static void rellenarVector(int dim, boolean[] esPrimo, int[] primos) {
        int j;
        int i;
        for (i = 0, j = 0; i < dim; i++) {
            if (esPrimo[i])
                primos[j++] = i;

        }
    }

    /**
     *Rellenamos el vector
     */

    public static int cuantosPrimos(int dim, boolean[] esPrimo) {
        int i;
        int cuenta = 0;
        for (i = 0; i < dim; i++) {
            if (esPrimo[i]) {
                cuenta++;
            }
        }
        return cuenta;
    }

    /**
     * Esta funcion cuenta los numeros primos
     * @return devuelve la ceunta de numeros primos
     */
    public static void criba(int dim, boolean[] esPrimo) {
        int i;
        int j;
        for (i = 2; i < Math.sqrt(dim) + 1; i++) {
            if (esPrimo[i])
                //Eliminar los multiplos de i
                for (j = 2 * i; j < dim; j += i) {
                    esPrimo[j] = false;
                }

        }
    }

    /**
     * @criba elimina los multiplos de i
     *
     */

    public static void inicializarArray(int dim, boolean[] esPrimo) {
        int i;
        for (i = 0; i < dim; i++) {
            esPrimo[i] = true;
            //Eliminar el 0 y el 1 que no son primos
            esPrimo[0] = esPrimo[1] = false;

        }
    }

    /**
     *
     * @inicializarArray inicializa el array y elimina el 0 y el 1 que no son primos
     */

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el numero para la criba de Erastotenes");
        int dato = teclado.nextInt();
        int vector[]= new int[dato];
        System.out.println("\nVector inicial hasta : " + dato);
        for (int i = 0; i < vector.length; i++){
            if (i % 10 == 0)
                System.out.println();
            System.out.println(i+1+"\t");

        }
        /**
         * Esta funcion nos pide introducir por teclado hasta qué número queremos calcular los primos
         */
        vector = generarPrimos(dato);
        System.out.println("\nVector de primos hasta: " + dato);
        for (int i = 0; i < vector.length; i++){
            if (i%10==0)
                System.out.println();
            System.out.println(vector[i]+"\t");

        }
        /**
         * Aquí nos devuleve todos los números primos comprendidos entre 1 y el  n introducido
         */
    }
}
