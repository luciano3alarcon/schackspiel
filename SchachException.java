package schach;

import boardgame.BrettException;

//Hier werden die Brett und SchachException behandelt.
public class SchachException extends BrettException {
    private static final long serialVersionUID = 1l;

    public SchachException(String msg){
        super(msg);
    }

}
