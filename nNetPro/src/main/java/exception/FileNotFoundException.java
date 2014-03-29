package exception;

//없는 정보 Exception
public class FileNotFoundException extends Exception{
	public FileNotFoundException(){}
	public FileNotFoundException(String message){
		super(message);
	}
}
