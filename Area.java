class Area{

    int aaa(int b, int h){

    System.out.println("Area Triangle:"+ 0.5*b*h);

    }

    int aaa(int s){
    
    System.out.println("Area Square:"+s*s);

    }

    double aaa(double l, double b){

    System.out.println("Area Rectangle:"+l*b );

    }

}
    

class Solution{
   
 public void Solution(String[] args){

        Area ar = new Area();

        ar.aaa(5,10);
        ar.aaa(5);

        ar.aaa(5.0,6.0);

    }

}
