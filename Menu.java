import java.util.Scanner;

import java.lang.Math;


class Menu {

    public static void main(String []args)
 {
        
Scanner sc=new Scanner(System.in);

        System.out.print("Enter x:");

        double n=sc.nextInt();


        System.out.println(">>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<");

        System.out.println("Select an option from the following");

        System.out.println("1) Cube of x");

        System.out.println("2) Square root of x");

        System.out.println("3) Expn of e^x");
 
        System.out.println("============================================");

        System.out.print("Enter your choice");

        int choice=sc.nextInt();


        switch(choice){

            case 1:

                double x=n*n*n;

                System.out.println("cube of "+n+" is "+x);

                break;


            case 2:

                System.out.println("the sq root of "+n+" is "+ Math.sqrt(n));

                break;


            case 3:

                System.out.println("the exponential of "+n+" is "+ Math.exp(n));

                break;


            default:

                System.out.print("invalid choice");

        }

    }

}