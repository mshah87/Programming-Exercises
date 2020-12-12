class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        /*
        There are 8 cells in total in the array, and each cell can have 2 states, 1 and 0. 
        So the total number of possible conditions are fixed, which is 2^8. This means once the 
        number N becomes very large, the pattern will begin to repeat itself. So we keep a seen HashMap 
        mapping a state to the iteration index. Each time we meet a state that is in seen, we know that it 
        occured t steps before. Hence we could fast forward N to be N = N % t, here t = seen.get(state) - N.
        */

        HashMap<String, Integer> seen = new HashMap<>();
        while(N > 0){
            seen.put(Arrays.toString(cells), N);
            N--;
            
            int[] nextDay = new int[8]; // next state of prison

            //first and last position in the cells are always 0, so we only need to consider position 1 to 6
            for(int i = 1; i<=6; i++){
                if(cells[i - 1] == cells[i + 1]){
                    nextDay[i] = 1;
                } else {
                    nextDay[i] = 0;
                }
            }
            cells = nextDay;

            // we meet state that is in seen, we know that it occured t steps before (cycle)
            if(seen.containsKey(Arrays.toString(cells))){
                N = N % (seen.get(Arrays.toString(cells)) - N);
            }
        }
        return cells;
    }
}
