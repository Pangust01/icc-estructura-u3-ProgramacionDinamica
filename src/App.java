import java.util.HashMap;
import java.util.Map;

import Ejercicios.contorllers.Laberinto;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Programación Dinámica");

        long startime, endtime = 0;
        startime = System.nanoTime();
        System.out.println(fibonacci(40));
        endtime = System.nanoTime();
        System.out.println("Time taken: " + ((endtime - startime)/1e+9 ) + " s");

        startime = System.nanoTime();
        System.out.println(fibonacciWithCaching(40));
        endtime = System.nanoTime();
        System.out.println("Time taken: " + ((endtime - startime)/1e+9) + " s");

        startime = System.nanoTime();
        System.out.println(fibonacciCaching(40));
        endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - startime)/1e+9 + " ns");

        /// Ejericio 1
        runEjercicio();

    }

    // Normal recursive method
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci(n-1)+fibonacci(n-2);
    }

    // First caching method: Using a Map
    public static int fibonacciCaching(int n) {
        int[] cache = new int[n+1];

        return fibonacciArregloR(n, cache);
    }

    private static int fibonacciArregloR(int n, int[] cache) {
        if (n <= 1) {
            return n;
        }

        if (cache[n]!= 0) {
            return cache[n];
        }
        
        cache[n] = fibonacciArregloR(n-1, cache)+ fibonacciArregloR(n-2, cache);
        return cache[n];
    }

    // Second caching method: Using an array
    private static Map<Integer,Integer> cacheMap = new HashMap<>();
    public static int fibonacciWithCaching(int n) {
        if (n <= 1) {
            return n;
        }
        //Revisar en cache si ya se calculo
        if (cacheMap.containsKey(n)) {
            return cacheMap.get(n);
        }

        int resultado = fibonacciCaching(n-1)+fibonacciCaching(n-2);
        cacheMap.put(n, resultado);
        return resultado;
    }

    public static void runEjercicio() {

        boolean[][] grid = {
            { true, true, true, true },
            { false, false, false, true },
            { true, true, false, true },
            { true, true, false, true }
        };
        Laberinto lab = new Laberinto();
        lab.getPath(grid);
    
    }
    static class Celda {
        int x;
        int y;

        // Constructor de la clase Celda
        Celda(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // Sobrescribimos el método toString para imprimir las coordenadas de la celda
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return  "(" + x + "," + y + ")";
        }
        
    }

}

