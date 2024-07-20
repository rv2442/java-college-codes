import static java.lang.System.out;

class Box
{
 double width, height, depth;
Box(Box parameter)
{
  width  = parameter.width;
  height = parameter.height;
  depth  = parameter.depth;
}

Box(double w, double h, double d)
{
 width = w;
 height = h;
 depth = d;
}
double Vol()
 {
  return width*height*depth;
 }
}


 class Overloading{
  public static void main(String []args){
    Box i = new Box(20, 10, 5);
    Box j = new Box(i);
    double V;
    V= i.Vol();
     System.out.println("\nVolume of a is :- "+V);
    V= j.Vol();
     System.out.println("\nVolume of b is :- "+V);
}
}