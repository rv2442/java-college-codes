import java.io.*;
import java.util.Scanner;
class student
{
    String name;
    int age;
    String address;

    student()
    {
        name = "Unknown";
        age = 0;
        address = "Not available";
    }

    void setInfo(String name , int age){
        this.name = name;
        this.age = age;
    }

    void setInfo(String name,int age,String address){
        this.name = name;
        this.age = age;
        this.address = address;
    }

    void display(){
        System.out.println("				Name: "+name+"\n				Age: "+age+"\n				Address: "+address);
        System.out.println("				======================================================");
    }

    public static void main(String[] args) throws IOException{
        String name , address;
        int age;
        int i;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of students:");
        int n = sc.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        student Info[] = new student[n];
        for(i=0; i<n; i++)
        {
            System.out.println("Enter the Name,age,address of student:");
            System.out.println("\n\nStudent name:");
            name = br.readLine();
            System.out.println("Student Age:");
            age = Integer.parseInt(br.readLine());
            System.out.println("Student Address:");
            address = br.readLine();
            Info[i] = new student();
            Info[i].setInfo(name,age,address);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        }
        System.out.println("\n\n\nThe Details of Students are:-");
        for(i=0; i<n; i++)
        {
            Info[i].display();
        }

    }
}