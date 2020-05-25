import java.io.*;
import java.util.*;

class Solution {

  static int calcDroneMinEnergy(int[][] route) { //O(n) complexity 
/* 
    [ [0,   2, 10], //
    [3,   5,  0], //10
    [9,  20,  6], // 4
    [10, 12, 15], // 15 - 6 = 9 -> 4-9 = -5
    [10, 10,  8] ] // -5+7=2
    [10,10,17] // 17 - 8 = 9 -> 2-9 = -7
*/

    if(route == null) {
      return 0;
    }
    
    int min = 0;
    int curr_height = route[0][2];
    int energy = 0;
    
    for(int i = 1; i<route.length; i++){
      for(int j = 0; j<3; j++){
        int new_height = route[i][2];
        int diff = new_height-curr_height;
        if(diff<0){
          energy += Math.abs(diff);
        } else {
          energy-=diff;
        }
        min = Math.min(min, energy);
        curr_height = new_height;
      }
    }
    return Math.abs(min);
  }
}