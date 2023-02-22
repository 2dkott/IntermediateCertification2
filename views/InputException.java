package views;

public class InputException extends Exception{
    public InputException(){
        super("Введена неверная команда!");
    }
}
