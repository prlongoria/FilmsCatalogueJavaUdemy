package mx.com.gm.films.exceptions;

public class DataAccessEx extends Exception{ //como estoy aprendiendo escojo que me pida try y catch

    //constructor:
    public DataAccessEx(String messageDataAccess) {
        super(messageDataAccess); //propago el mensaje a la clase padre para que sea una clase de excepción

    }

}
