package exception;

//중복 Exception
public class DuplicateException extends Exception{
	public DuplicateException(){}
	public DuplicateException(String message){
		super(message);
	}
}
