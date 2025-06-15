package practice.scanner;

import java.util.Arrays;

import static algo2025.may.Util.log;

public class ArrayPractice {
    public static void main(String[] args) {

        int[] arr = {8, 4, 1, 7, 11, 13, 5, 2};
        // arr[0] = 8;  -> arr[arr.length-8] -> [arr.length-arr.length]
        // arr[1] = 4;  arr[arr.length-7]
        // arr[2] = 1;  arr[arr.length-6]
        // arr[3] = 7;  arr[arr.length-5]
        // arr[3] = 11; arr[arr.length-4]
        // arr[5] = 13; arr[arr.length-3]
        // arr[6] = 5;  arr[arr.length-2]
        // arr[7] = 2;  arr[arr.length-1]

        /* int lastNumber    = arr[arr.length-1]
        * arr[arr.length-1]  = arr[arr.length-2]
        * arr[arr.length-2]  = arr[arr.length-3]
        * arr[arr.length-3]  = arr[arr.length-4]
        * arr[arr.length-4]  = arr[arr.length-5]
        * arr[arr.length-5]  = arr[arr.length-6]
        * arr[arr.length-6]  = arr[arr.length-7]
        * arr[arr.length-7]  = arr[arr.length-8]
        * */

        int lastNumber = arr[arr.length-1];
        for(int i = arr.length-2; i>=0; i--) {
            arr[i+1]= arr[i];
            // arr[7]=arr[6]
            // arr[6]=arr[5]
            // arr[5]=arr[4]
            // arr[4]=arr[3]
            // arr[3]=arr[2]
            // arr[2]=arr[1]
            // arr[1]=arr[0]
        }
        arr[0]=lastNumber;
        String shiftArray = Arrays.toString(arr);
        System.out.println(shiftArray);


    }
}
