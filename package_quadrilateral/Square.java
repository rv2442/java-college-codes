package package_quadrilateral;
public class Square implements IShape
{
	double side,Area;
	public Square(double side)
	{
		this.side=side;
	}
	public void Area()
	{
		Area=side*side;
	}
	public void display()
	{
		System.out.println("The area of Square=" +Area);
	}
}