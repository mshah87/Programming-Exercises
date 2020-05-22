import java.io.*;
import java.util.*;

class Solution {
  static int[] findDuplicates(int[] arr1, int[] arr2) {
    // O(n) complexity
    int i = 0, j = 0;
    List<Integer> list = new ArrayList<>();
    while(i<arr1.length && j<arr2.length){
      if(arr1[i] < arr2[j]){
        i++;
      } else if (arr1[i] > arr2[j]){
        j++;
      } else {
        list.add(arr1[i]);
        i++;
        j++;
      }
    }
    return list.stream().mapToInt(inval->inval).toArray();
  }
}