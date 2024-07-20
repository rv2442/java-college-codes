import java.io.*;
class adwait
{
    public static void main(String args[]) throws Exception
    {
      String LoginID, Password;
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("           **Enter your Login ID and Password**");
      System.out.println("       Enter your Login ID:- ");
      LoginID = br.readLine();
      System.out.println("       Enter your Password:- ");
      Password = br.readLine();
      try
      {
         check(LoginID, Password);
         System.out.println("Login is successful !!!");
      }
      catch(InvalidPasswordException e)
      {
        System.out.println(e.getMessage());                                                   
		System.out.println(e.printMsg());
      }
    }
   
     
     static void check(String LoginID,String Password) throws Exception
	{
		int c = 0;
		int sc = 0;
		if(!(Password.length()==8)){throw new InvalidPasswordException();}
		String s = "!@#$%^&*-+<>?|/";
		char[] s1 = s.toCharArray();
		char[] x = Password.toCharArray();
		for(int i=0; i<Password.length();i++)
		{
			if(Character.isDigit(x[i]))
			{
				c++;
			}
			for(int j=0; j<s.length();j++)
			{
				if(s1[j]==x[i])
				{
					sc++;
				}
			}
		}
		if((c==0)||(sc==0))
		{
			throw new InvalidPasswordException();
		}
    }
}

class InvalidPasswordException extends Exception{
	public InvalidPasswordException(){
		super("Invalid Password");   
	}
	public String printMsg(){
		return "Please enter valid password of length 8 containing one digit and one Special Symbol.";
	}
}
  