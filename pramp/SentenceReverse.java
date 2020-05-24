import java.io.*;
import java.util.*;

class Solution {

  static char[] reverseWords(char[] arr) {
    // O(n) complexity
    // [ "m", "a", "n", " ", "h", "e", "y"] -- reverse whole array first
    // ["y", "e", "h", " ", n, a, m] -- use reverse function to reverse letters before space

    reverse(0, arr.length - 1, arr);
    
    int startWord = 0;
    for(int i = 0; i < arr.length; i++){
      if(arr[i] == ' '){
        reverse(startWord , i - 1, arr);
        startWord = i +  1;
      } else if (i == arr.length - 1) {
        reverse(startWord , i, arr);
      }
    }
    return arr;
  }
  
  static void reverse(int start, int end, char[] arr){
    while(start<end){
      char temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }
}