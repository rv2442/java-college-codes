import java.io.*;
    class InvalidPasswordException extends Exception{
	public InvalidPasswordException(){
		super("Invalid Password");   
	}
	public String printMsg(){
		return "Please enter valid password of length 8 containing one digit and one Special Symbol.";
	}
	}
class Login
{   String UserId,Password;
    static void check(String UserId,String Password)throws Exception{
		int c=0 ;
		int sp=0;
		if(!(Password.length()==8)){throw new InvalidPasswordException();}
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
    public static void main(String[] args) throws Exception{
        String UserId,Password;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter UserId and Password:-");
        System.out.print("\n\t\tUser Id :");
        UserId = br.readLine();
        System.out.print("\n\t\tPassword :");
        Password = br.readLine();
		try{
			check(UserId,Password);
			System.out.println("Login Sucessful");
		}
		
		catch(InvalidPasswordException e){
			System.out.println(e.getMessage());                                                   
			System.out.println(e.printMsg());
        }   
		System.out.println("Login unsucessful");
	}   
}

 