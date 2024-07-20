import java.util.*;
class duplicateRemove{
    public static void main(String [] args){
        System.out.println("Enter the no. elements in array:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        System.out.println("Enter the array elements");
        for(int i=0;i<n;i++){
            ar[i] = sc.nextInt();
        }

        System.out.println("Original Array Length : "+ar.length);
        System.out.print("Array elements are: ");
        for(int i=0;i<ar.length;i++){
            System.out.print(ar[i]+" ");
		}
        int k=0;		
		for(int i=0;i<ar.length;i++){
			for(int j=i+1;j<ar.length;j++){
				if(ar[i]>ar[j]){
					k=ar[i];
					ar[i]=ar[j];
					ar[j]=k;
				}
			}	
		}	
       
        int len1 =ar.length;
        int[] temp = new int[len1];
        int j = 0;
        for (int i=0; i<len1-1; i++){
            if (ar[i] != ar[i+1]){
                temp[j++] = ar[i];
            }
        }
        temp[j++] = ar[len1-1];
        System.out.println("\nThe new length of array is : "+j);

    }
}