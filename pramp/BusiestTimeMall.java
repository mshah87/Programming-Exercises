import java.io.*;
import java.util.*;

class Solution {
  static int findBusiestPeriod(int[][] data) {
    // O(n) complexity
    if(data.length == 1) return data[0][0];
    
    int maxTime = Integer.MIN_VALUE;
    int currPeople = 0;
    int maxPeople = Integer.MIN_VALUE; 
    for(int i = 0; i<data.length; i++){
      if (data[i][2] == 1) {
        currPeople += data[i][1];
      } else {
        currPeople -= data[i][1];
      }
      
      if (i == data.length-1 || data[i][0] != data[i+1][0]) {
        if (currPeople > maxPeople) {
          maxPeople = currPeople;
          maxTime = data[i][0];
        }
      }
    }
    return maxTime;
  }
} 

/*
input:  data = [ [1487799425, 14, 1], //14
                 [1487793425, 4,  0], //10
                 [1487798425, 2,  0], //8


input:  data = [ [1487799425, 14, 1], //14
                 [1487799425, 4,  0], //10
                 [1487799425, 2,  0], //8
                 
                 [1487800378, 10, 1], //18
                 
                 [1487801478, 18, 0], //0
                 [1487801478, 18, 1], //18
                 
                 [1487901013, 1,  0], //17
                 
                 [1487901211, 7,  1], //24
                 [1487901211, 7,  0] ] //17
*/