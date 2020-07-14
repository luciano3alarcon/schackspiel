package schach;

import boardgame.Brett;
import boardgame.Stein;

public abstract class SchachStein extends Stein {

    private Color color;

    public SchachStein(Brett brett, Color color) {
        super(brett);
        this.color = color;
    }

    public Color getColor(){
        return  color;
    }
}
