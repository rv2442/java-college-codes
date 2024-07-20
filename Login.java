import java.io.File; 
import java.io.*; 
import java.io.FileWriter;  
import java.util.Scanner; 
class InvalidPasswordException extends Exception{
	public InvalidPasswordException(){
		super("Invalid Password");   
	}
	public String printMsg(){
		return "Please enter valid password of length 8 containing one digit and one Special Symbol.";
	}
	}
class Login_Error extends Exception{
	public Login_Error(){
		super("Invalid UserId or Password");   
	}
	public String printMsg_Error(){
		return "Invalid UserId or Password";
	}
	}
public class Login{
    static void check(String UserId,String Password)throws Exception{
		int c=0 ;
		int sp=0;
		if(!(Password.length()>8)){throw new InvalidPasswordException();}
		String str="@#!~$%^&*()-+/:.,<>?|";
		char[] str1=str.toCharArray();
		char[] a=Password.toCharArray();
		for(int i=0;i<Password.length();i++){
			if(Character.isDigit(a[i])){c++;}
			for(int j=0;j<str.length();j++){
			if(str1[j]==a[i]){sp++;}
			}	
		}
		if((c==0)||(sp==0)){
			throw new InvalidPasswordException();
		}
	}
	static void Login(String UserId,String Password,String Username,String Pw)throws Exception{
		if(!((UserId.equals(Username))&&(Pw.equals(Password)))){throw new Login_Error();}
	}
    public static void main(String[] args) throws Exception{
        String UserId,Password,Username,Pw,Info;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nSet UserId and Password:-");
        System.out.print("\n\t\tUser Id :");
        UserId = br.readLine();
        System.out.print("\n\t\tPassword :");
        Password = br.readLine();
		try{
			check(UserId,Password);
			System.out.println("Account created");	
		}
		catch(InvalidPasswordException e){
			System.out.println(e.getMessage());                                                   
			System.out.println(e.printMsg());	
        } 
		System.out.println("\nEnter UserId and Password:-");
        System.out.print("\n\t\tUser Id :");
        Username = br.readLine();
        System.out.print("\n\t\tPassword :");
        Pw = br.readLine();
		try{
			Login(UserId,Password,Username,Pw);
			System.out.println("Logged in Sucessfully");
			
		}
		catch(Login_Error b){
			System.out.println(b.getMessage());                                                   
			System.out.println(b.printMsg_Error());	
        }
		System.out.println("write something");
		Info = br.readLine();
		try{
			FileWriter fw=new FileWriter("C:\\Users\\Rahul\\Coding\\java\\fw.txt");
			fw.write(Info);    
			fw.close();    
        }
		catch(Exception e){System.out.println(e);}    
		System.out.println("Success");
		
		File text = new File("C:\\Users\\Rahul\\Coding\\java\\fw.txt"); 
		Scanner sc = new Scanner(text); 
		  
		while (sc.hasNextLine()) 
			System.out.println(sc.nextLine());
	
	}	 
}
