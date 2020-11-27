class Solution { //O(n) complexity
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\."); //split on literal dot
        String[] v2 = version2.split("\\."); 
        
        int maxLength = Math.max(v1.length, v2.length); //take the max length to iterate over
        
        for(int i = 0; i<maxLength; i++){
            //add zeros to shorter version
            int num1 = i<v1.length ? Integer.parseInt(v1[i]) : 0; 
            int num2 = i<v2.length ? Integer.parseInt(v2[i]) : 0;
            if(num1<num2){ //compare 
                return -1;
            } else if(num1 > num2){
                return 1;
            }
        }
        return 0;
    }
}

/* also ignores leading zeros
7.5.2.4
7.5.3
1.) [7,5,2,4]
    [7,5,3]

2.) [7,5,2,4]
    [7,5,3,0]

3.) compare and return
*/
