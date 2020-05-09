class Solution {
        public List<String> letterCombinations(String digits) {
        //BFS METHOD
         ArrayList<String> result = new ArrayList<String>();
         if(digits == null || digits.length() == 0){
             return result;
         }

         HashMap<Character, String> map = new HashMap<Character, String>();   
         map.put('2', "abc");
         map.put('3', "def") ;
         map.put('4', "ghi");
         map.put('5', "jkl");
         map.put('6', "mno");
         map.put('7', "pqrs");
         map.put('8', "tuv");
         map.put('9', "wxyz");

         Queue<String> queue = new LinkedList<String>();
         char c = digits.charAt(0); //get first character of digits (key)
         String s = map.get(c); //get value of key c
         
         for (int i = 0; i < s.length(); i++) {
              queue.add(s.charAt(i) + ""); //iterate through string and add to queue
            }

          int size = 0; 
          for(int i =1; i<digits.length(); i++){
              c = digits.charAt(i);
              s = map.get(c);
              size = queue.size(); //keep track of queue's size
              for(int j = 0 ; j < size ; j++){
                  String str = queue.remove(); //removes string from queue
                  for(int k = 0; k<s.length(); k++){ 
                      queue.add(str + s.charAt(k)); // concatenates with string of other digit
                    }
                }
            }

            while(!queue.isEmpty()){
                result.add(queue.remove());
            }

            return result;

        }
    }