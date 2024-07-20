package package_quadrilateral;
public class Rectangle implements IShape{
	double l,b,Area;
	public Rectangle(double l, double b){
		this.l=l;
		this.b=b;
	}
	public void Area()
	{
		Area=l*b;
	}
	public void display()
	{
		System.out.println("Area(Rectangle)= "+Area);
	}
}