package arrays;

public class main {

	public static void main(String[] args) {

		int[] intarray = new int [7];
		
		intarray[0] = 20;
		intarray[1] = 40;
		intarray[2] = 60;
		intarray[3] = 80;
		intarray[4] = 30;
		intarray[5] = 50;
		intarray[6] = 10;

		int index = -1;
		for(int i =0 ; i<intarray.length; i++){
			if (intarray[i] == 80){
				index = i;
			
			
			}
		}
		
		System.out.println(index);

	}

}
