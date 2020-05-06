
/* 

This problem was asked by Google.

Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so that all the Rs come first, the Gs come second, and the Bs come last. You can only swap elements of the array.

Do this in linear time and in-place.

For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].

*/

import java.util.Arrays;

public class GoogleRGBSegregation {

    public static char[] result(char[] arr) {

        int l = 0;
        int r = arr.length - 1;
        char letter;

        for (int i = 0; i < r;) {
            if (arr[i] == 'R') {

                letter = arr[i]; // letter = 'R' now
                arr[i] = arr[l]; // arr[i] = first char of arr
                arr[l] = letter; // first index of arr is 'R'
                l++; //move left pointer
                i++; //iterate array 

            } else if (arr[i] == 'B') {
                letter = arr[i]; //letter = 'B' now
                arr[i] = arr[r]; //arr[i] = last char of arr 
                arr[r] = letter; //last char of arr is 'B'
                r--; //move right pointer
            } else {
                i++;
            }
        }
        return arr;

    }

    public static void main(String args[]) {

        char[] rgb = { 'G', 'B', 'R', 'R', 'B', 'R', 'G' };

        System.out.println(Arrays.toString(result(rgb)));

    }

}