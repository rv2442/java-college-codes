class Doctor {
   public void display() {
      System.out.println("Doctor type:-");
   }
}
class Dentist extends Doctor {
   public void dent_disp() {
      System.out.println("Dentist");
   }
}
class Ophthalmologist extends Doctor {
   public void eye_surgeon_disp() {
      System.out.println("Ophthalmologist");
   }
}
public class Display {
   public static void main(String[] arguments) {
      Ophthalmologist doc = new Ophthalmologist();
      Dentist doc1=new Dentist();	
      doc.display();
      doc.eye_surgeon_disp();
	  System.out.print("\n");
	  doc1.display();
      doc1.dent_disp();
   }
}