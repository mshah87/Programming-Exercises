import java.io.*;
import java.util.*;

class Solution {

// source = "bit", target = "dog"
// words = ["but", "put", "big", "pot", "pog", "dog", "lot"]

// nodes: words in the list
// but -> put 
// but : put 
// put : pot
// big : bit 

  static int shortestWordEditPath(String source, String target, String[] words) {
    // your code goes here
      HashMap<String, List<String>> map = new HashMap<>();
      Queue<String> queue = new LinkedList<>();
      for(String s: words){
        if(diff(source, s)){
          if(!map.containsKey(source)){
            map.put(source, new ArrayList<>());
          }
          map.get(source).add(s);
        }
      }
      
      for(String s: words){
        for(String s2: words){
          if(diff(s,s2)){
            if(!map.containsKey(s)){
              map.put(s, new ArrayList<>());
            }
            map.get(s).add(s2);
          }
        }
      }
      
      int level = 1; 
      queue.offer(source);
      while(!queue.isEmpty()){
        int size= queue.size();
        while(size!=0){
          String word = queue.poll(); 
          if(word == target){
            return level;
          }
          for(String s: map.get(word)){
            queue.offer(s);
          }
          size--;
        }
        level++;
      }
      return -1;
    }	
   
  static boolean diff(String a, String b){
    int count = 0;
    for(int i = 0; i<a.length(); i++){
      if(a.charAt(i) != b.charAt(i)){
        count++;
      }
    }
    if(count == 1){
      return true;
    }
    return false;
  }
}