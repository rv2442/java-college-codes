import java.util.*;
import package_quadrilateral.Square;
import package_quadrilateral.Rectangle;

class Main{
	public static void main(String[] args){
		double l,b,side;
		Scanner sc=new Scanner(System.in);
		System.out.println("Length and Breadth of Reactangle are ");
		l=sc.nextDouble();
		b=sc.nextDouble();
		
		Rectangle rect=new Rectangle(l,b);
		rect.Area();
		rect.display();
		
		
		System.out.println("Side of Square =");
		side=sc.nextDouble();
		Square sq=new Square(side);
		sq.Area();
		sq.display();
	}
}
