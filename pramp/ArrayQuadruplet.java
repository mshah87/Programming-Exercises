import java.io.*;
import java.util.*;

class Solution {
  static int[] findArrayQuadruplet(int[] arr, int s) {
    // O(n^3) complexity, two pointer approach
    List<Integer> result = new ArrayList<>();

    Arrays.sort(arr);
    
    for(int i = 0; i <arr.length - 3; i++){
      for(int j = i + 1; j<arr.length - 2 ; j++){
        int low = j + 1;
        int high = arr.length - 1;
        while(low < high) {
          int sum = arr[i] + arr[j] + arr[low] + arr[high];
          if(sum == s){
            result.add(arr[i]);
            result.add(arr[j]);
            result.add(arr[low]);
            result.add(arr[high]);
            return result.stream().mapToInt(Integer::intValue).toArray();
          } else if(sum<s){
            low++;
          } else {
            high--;
          }
        }
      }
    }
    return result.stream().mapToInt(Integer::intValue).toArray();
  }
}