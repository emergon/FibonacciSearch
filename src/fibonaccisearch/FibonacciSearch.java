/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonaccisearch;

/**
 *
 * @author anastasios
 */
public class FibonacciSearch {
//https://iq.opengenus.org/fibonacci-search/
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array = {10, 13, 19, 20, 24, 26, 30, 34, 35, 56, 57, 60, 61};
        int index = fibonacciSearch(array, 60);
        System.out.println("index:"+index);
    }

    public static int fibonacciSearch(int[] integers, int elementToSearch) {
        int fibonacciMinus2 = 0;
        int fibonacciMinus1 = 1;
        int fibonacciNumber = fibonacciMinus2 + fibonacciMinus1;
        int arrayLength = integers.length;
        while (fibonacciNumber < arrayLength) {
            fibonacciMinus2 = fibonacciMinus1;
            fibonacciMinus1 = fibonacciNumber;
            fibonacciNumber = fibonacciMinus2 + fibonacciMinus1;
        }
        int offset = -1;
        while (fibonacciNumber > 1) {
            int i = Math.min(offset + fibonacciMinus2, arrayLength - 1);
            if (integers[i] < elementToSearch) {
                fibonacciNumber = fibonacciMinus1;
                fibonacciMinus1 = fibonacciMinus2;
                fibonacciMinus2 = fibonacciNumber - fibonacciMinus1;
                offset = i;
            } else if (integers[i] > elementToSearch) {
                fibonacciNumber = fibonacciMinus2;
                fibonacciMinus1 = fibonacciMinus1 - fibonacciMinus2;
                fibonacciMinus2 = fibonacciNumber - fibonacciMinus1;
            } else {
                return i;
            }
        }
        if (fibonacciMinus1 == 1 && integers[offset + 1] == elementToSearch) {
            return offset + 1;
        }
        return -1;
    }

}
