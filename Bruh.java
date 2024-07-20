class Bruh{
	public static void main(String args[]){
		int a[] ={20,20,30,40,50,50,50};
		 int[] c = new int[a.length];
		int temp;
		System.out.println("Original array length: "+a.length);
		System.out.print("Array elements are:- ");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		for(int i=0;i<a.length;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[i]>a[j]){
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}	
		}
		int k=0;
		for (int i=0; i<a.length -1; i++){
            if (a[i] != a[i+1]){
				
                c[k++] = a[i];
			}
        }
        c[k++]=a[a.length-1];		
		System.out.print(" \nThe new length of the array is: "+k);	
	}
}