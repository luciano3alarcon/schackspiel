package schach;
import boardgame.Position;

public class SchachPosition {

    // Erklärung: matrix_row = 8 - chess_row
// matrix_column = chess_column - 'a' weil,
// char 'a' - 'a' = 0;
// char 'b' - 'a' = 1;
// char 'c' - 'a' = 2;

// Die untere Logik wird implementiert.
// matrix_row = 8 - chess_row
// matrix_column = chess_column - 'a'


    private char column;
    private int row;

    public SchachPosition(char column, int row) {
        //Defensive Programming.
        // Hier wird überprüft, dass die Column von A bis H und Row von 1 bis 8 sind.
        if(column < 'a' || column > 'h' || row < 1 || row > 8){
            throw new SchachException("Fehler bei der Instazierung der SchachPosition" +
                    "Gültige Eingabe sind a1 bis h8.");
        }

        this.column = column;
        this.row = row;
    }

    //Hier wird die Methode SET gelöscht. Es ist nicht erwünscht, dass die Row und Colummn geändert werden.
    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

        //Siehe Erklärung oben
    protected Position toPosition(){
        return new Position(8 - row, column - 'a');
    }

    protected static SchachPosition fromPosition(Position position){
        return new SchachPosition((char) ('a' - position.getColumn()), 8 - position.getRow());
    }

    //Hier wird mein Brett auf dem Console gedrückt.
    //just for Info: Hier wird ein leers String gesetzt "". So versteht der Compiler,
    //dass hier Strings konkatenieren werden
    @Override
    public String toString() {
        return "" + column + row;
    }
}
