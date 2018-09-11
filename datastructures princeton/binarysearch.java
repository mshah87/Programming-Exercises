//logn order of growth
public static int binarysearch(int[] n, int key) {

    //both variables are indicies
    //lo goes right when key is bigger than mid 
    //hi goes left when key is smaller than mids
    int lo = 0;
    int hi = n.length - 1;
    
    while(lo<=hi){

        //middle index
        int mid = lo + (hi-lo)/2; 

        if(key< n[mid]) {
            hi = mid -1;
        } else if (key>n[mid]){
            lo = mid +1; 
        } else{

            //if key is not less than or greater than mid, return middle index
            //which is index of the key
            return mid;
        }
    }

    //key not found
    return -1;

}