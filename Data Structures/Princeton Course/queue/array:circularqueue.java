//circular queue
class arrayqueue{

    private int first, last, size; 
    private String[] q;

    public arrayqueue(){
        q = new String[2];
        size = 0;
        first = 0;
        last = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    private void resize(int capacity){
        //Assert will throw a runtime error (AssertionError) if its condition is false.
        //use assert in private methods only 
        assert capacity >= size;
        String[] temp = new String[capacity];
    }
}