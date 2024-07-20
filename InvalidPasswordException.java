//package package_InvalidPasswordException;
public class InvalidPasswordException extends Exception{
	public InvalidPasswordException(){
		super("Please enter valid password of length 8 containing one digit and one special symbol");
	}
	public InvalidPasswordException(String message){
		super(message);
	}
}