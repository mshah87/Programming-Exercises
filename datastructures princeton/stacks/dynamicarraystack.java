//push: if array is full, create new array of twice the size, and copy items
//pop: halve size of array when array is 1/4 full
public class dynamicarraystack {

    private String[] s;
    
    //size of stack and index of next open position in stack
    //keeps track of how many items are in array
    private int N = 0;

    public dynamicarraystack(){
        //start with array of size 1
        s = new String[1];
    }

    //check if list is empty
    public boolean isEmpty(){
        return N == 0;
    }

    public void push(String item){

        if(N == s.length) {
            resize(2 * s.length);
        } else {
            //put item inside array at index N (which is 0), then increment N
            s[N++] = item;
        }
    }

    private void resize(int capacity){
        String[] copy = new String[capacity];
        for(int i =0; i<N; i++){
            copy[i] = s[i];
        }
        s = copy;
    }

    //pop item at index N (most recent index), then decrement N
    public String pop(){
        
        String item = s[--N];

        //now there is no reference to old item
        s[N] = null;

        if(N>0 && N==s.length/4){
            resize(s.length/2);
        }

        return item;

    }
}