class Solution {
    public String[] reorderLogFiles(String[] logs) { // O(nlogn) time, O(n) space because of split
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            
            if(!isDigit1 && !isDigit2){ //if both letter logs
                int compare = split1[1].compareTo(split2[1]);
                if(compare == 0){
                    return split1[0].compareTo(split2[0]); //compare identifier since tie
                } else {
                    return compare; // not a tie
                }
            } else if (isDigit1 && isDigit2){
                return 0; // both digit-logs, so keep them in original order
            } else if (isDigit1 && !isDigit2){
                return 1; // first is digit, second is letter, bring letter to forward.
            } else {
                return -1; //first is letter, second is digit, keep them in this order.
            }
        });
        return logs;
    }
}