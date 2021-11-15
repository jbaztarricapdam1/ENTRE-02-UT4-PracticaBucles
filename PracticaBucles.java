import java.util.Random;
/**
 *    @author - Julen Baztarrica
 */
public class PracticaBucles {
    private final char ESPACIO = ' ';
    private final char CARACTER = '\u0040';
    private Random generador;

    /**
     * Constructor  
     */
    public PracticaBucles()    {
        generador = new Random();
    }

    /**
     *  El método  genera  números aleatorios  entre -1000 y 5000 (inclusive)
     *  y calcula y escribe:
     *      - la media de todos los números
     *      - la suma de los impares
     *      - el máximo de los pares
     *        
     *  El proceso termina cuando sale un 0 o bien se han escrito n nºs
     *  
     *  Los números se escriben  en filas de 5 columnas 
     *  Cada nº aleatorio se muestra en un espacio de 12 posiciones en la pantalla  
     *  y al lado de cada nº se muestra otro nº con las mismas cifras y 
     *  en el mismo orden pero sin ceros (en 5 posiciones)
     *  
     *   Utiliza solo bucles while
     */
    public void generarNumeros(int n)   {

        int i = 0;
        int numero = 0;
        int contador = 0;

        double media = 0.0;
        double numSuma = 0.0;

        int imparSuma = 0;
        int parMax = -1000;

        System.out.println("\nNº máximo de aleatorios a generar " + n);
        System.out.println("o hasta que salga el 0.\n");

        while (numero != 0 && numero > i) {
            numero = generador.nextInt(6001) - 1000;
            System.out.printf("%12s:%5s", numero, obtenerNumeroSinCeros(numero));
            contador++;

            if (contador == 5) {
                contador = 0;
                System.out.println();
            }

            numSuma = numSuma + numero;
            media = numSuma / n;
            i++;

            if (numero % 2 != 0) {
                imparSuma = imparSuma + numero;
            } 
            else {
                if (numero > parMax) {
                    parMax = numero;
                }
            }
        }

        String str = String.format("\n\n%25s%10.2f", "Media: ", media);
        str += String.format("\n%25s%10s", "Suma impares: ", imparSuma);
        str += String.format("\n%25s%10s", "Máximo pares:", parMax);

        System.out.printf(str);
    }

    /**
     *  Devuelve true si numero es impar, false en otro caso
     *  Hazlo sin utilizar if
     */
    public boolean esImpar(int numero)   {
        return numero % 2 != 0;

    }

    /**
     *  Dado un nº genera y devuelve otro nuevo 
     *  con las mismas cifras y en el mismo orden pero sin 
     *  los 0
     *  Ej - si numero = 2040 devuelve  24, si numero = 1009 devuelve  19
     *  si numero = 3000 devuelve 3
     *   
     *   
     */
    public int obtenerNumeroSinCeros(int numero)   {
        int i = 0;
        int result = 0;
        int resto = 0;
        int divisor = 0;
        int potencia = 0;

        while(numero != 0) {
            resto = numero % 10;
            divisor = numero / 10;

            if (resto == 0) {
                resto = divisor % 10;

            }
            else {
                potencia = (int) Math.pow(10, i);
                result = result + potencia * resto;
                i++;
            }

            numero = numero / 10;
        }

        return result;
    }

    /**
     *  Borrar la pantalla
     *
     */
    public void borrarPantalla()    {
        System.out.println('\u000C');
    }

    /**
     *  
     *  Dibuja la letra N (ver figura en el enunciado)
     *  Con bucles for
     *  
     *  Hay que usar el método escribirCaracter()
     *  
     *  
     *   
     */
    public void escribirLetraN(int altura)    {
        System.out.println("Letra N - Altura: " + altura);
        escribirCaracter(CARACTER, altura);
        
    }

    /**
     *  escribe n veces el caracter  indicado en la misma línea
     *  con bucles for
     */
    private void escribirCaracter(char caracter, int n)    {
        String str = "";

        for (int i = 0; i < n; i++) {
            str = str + caracter;

            for (int j = 0; i > j; j++) {
                str = str + ESPACIO;
            }
            str = str + caracter;

            for (int b = n; i + 1 < b; b--) {

                str = str + ESPACIO;
            }

            str = str + caracter + "\n";       
        }

        System.out.print(str);
    }

}
