import java.io.*;
import java.util.*;
class Employee
{
    int emp_id;
    String emp_name;
    int emp_salary;

    Employee(int empid, String empname, int empsalary)
    {
        emp_id = empid;
        emp_name = empname;
        emp_salary = empsalary;
    }

    void display() 
    {
        System.out.println("		ID: "+this.emp_id + "\n		Name: "+this.emp_name + "\n		Salary: " + this.emp_salary);
    }

    public static void main(String args[]) throws IOException 
    {       System.out.println("Enter no of employees");
            Scanner sc=new Scanner(System.in);      
            int n = sc.nextInt();
         Employee detail[] = new Employee[n];
        for(int i=0; i<n; i++)
        {
            System.out.println("Enter the ID, Name and Salary of Employee:-");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("	ID-");
            int emp_id = Integer.parseInt(br.readLine());
            System.out.print("	Name-");
            String emp_name = br.readLine();
            System.out.print("	Salary-");
            int emp_salary = Integer.parseInt(br.readLine());
            detail[i] = new Employee(emp_id, emp_name, emp_salary);
        }
        System.out.println("Employee Details: \n\n\n");
        for(int i=0; i<n; i++)
        {
            detail[i].display();
            System.out.println("		================================");
        }}}