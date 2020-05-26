import java.io.*;
import java.util.*;

class Solution {
  
  static int[] arrayOfArrayProducts(int[] arr) {
    // O(n) complexity  
    if(arr == null || arr.length == 1){
      return new int[]{};
    }
    
    int[] result = new int[arr.length];
    
    int product = 1;
    for(int i = 0; i<arr.length; i++){
      result[i] = product;
      product *= arr[i];
    }
    
    product = 1;
    for(int j = arr.length - 1; j>=0; j--){
      result[j] *= product;
      product *= arr[j];
    }
    return result;
  }
}

/*
input:  arr = [8, 10, 2]
output: [20, 16, 80] # by calculating: [10*2, 8*2, 8*10]

arr = [1, 8, 80, ]
int product = 1; 
for(i++){
  arr[i] = product;
  product = product*arr[i] //1*8 = 8*10 = 80
}
*/


