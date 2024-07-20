package package_shape;
public class Square implements IShape
{
	double side,area;
	public Square(double side)
	{
		this.side=side;
	}
	public void area()
	{
		area=side*side;
	}
	public void display()
	{
		System.out.println("The area of Square=" +area);
	}
}