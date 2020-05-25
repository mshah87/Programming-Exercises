import java.io.*;
import java.util.*;

class Solution {

  static int[] pancakeSort(int[] arr) {
    // O(n^2) complexity
    int i = arr.length;
    int length = arr.length;
    while( i >= 0){
      int position = findMax(arr, 0 , length);
      flip(arr, position);
      flip(arr, length - 1);
      length--;
      i--;
    }
    return arr;
  }
  
  static int findMax(int[] arr, int start, int end){
    int max = Integer.MIN_VALUE;
    int maxIndex = 0;
    for(int i=start; i<end; i++){
      if(arr[i]>=max) {
        max=arr[i];
        maxIndex = i;
      }
    }
    return maxIndex;
  }
  
  static void flip(int[] arr, int k){
    int i = 0, j = k;
    while(i<k){
       int temp = arr[j];
       arr[j--] = arr[i];
       arr[i++] = temp;
    }
  }
}