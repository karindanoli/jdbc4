package aplication; //classe da mensagem do ioexception

public class dbException extends RuntimeException{

    private static final long serialVersionUID = 1l;

    public dbException(String msg){
        super(msg);

    }
}
