package schach;

import boardgame.Brett;
import boardgame.Position;
import boardgame.Stein;
import steine.King;
import steine.Rook;

public class SchachMatch {

    private Brett brett;

    public SchachMatch(){
        brett = new Brett(8,8);
        initialSetup(); //Wenn ein Spiel beginnt, wrid die Methode aufrufen und setzt die Steine auf dem Brett

    }

    //Hier möchte man nicht mit den Steinen direkt arbeit, sonder mit den SchachSteine
    //Mein Programm kennt nicht die Steine, sondern die Schachsteine.
    public SchachStein[][] getSteine(){
        SchachStein[][] matrix = new SchachStein[brett.getRows()][brett.getColummns()];

        //Hier wird ein Downcast gemacht, damit der Compiler mein Stein
        // als ein DameStein interpretieren kann

        for(int i = 0; i< brett.getRows(); i++){
            for (int j = 0; j< brett.getColummns(); j++){
                matrix[i][j] = (SchachStein) brett.stein(i,j);
            }
        }
        return matrix;
    }

    //Beweg eine Stein.
    public SchachStein perfomSchachMoving(SchachPosition ursprungPosition, SchachPosition zielPosition){
        //
        Position source = ursprungPosition.toPosition();
        Position target = zielPosition.toPosition();
        validateSourcePosition(source);
        Stein capturedSteine = makeMove(source, target);

        return (SchachStein) capturedSteine;
    }

    private Stein makeMove(Position ursprungPosition, Position zielPosition){
        Stein s = brett.removeStein(ursprungPosition); //Hier wird der Stein aus der ursprung. Stelle genommen.
        Stein capturedSteind = brett.removeStein(zielPosition); //Der Stein auf dieser Postion wird "gefressen"
        brett.placeStein(s, zielPosition); //hier wird mein Stein s in die neue Stelle gesetzt.

        return  capturedSteind; //

    }

    private void validateSourcePosition(Position position){
        if(!brett.thereIsAStein(position)){
            throw new SchachException("Es gibt keinen Stein auf der ursprünglichen Position.");
        }
        //Wenn es KEINE Bewegung möglich, wird dann eine Exception geworfen
        if(!brett.stein(position).isThereAnyPossibleMove()){
            throw new SchachException("Es gibt keine mögliche Bewergung für diesen Stein.");
        }
    }

    //Die Methode wird mein Brett, wie ein Schachbrett instanzieren (Colummn, Row)
    // und nicht wie mein Matrix in der Klasse Positon (row , column).
    private void placeNewPiece(char column, int row, SchachStein stein){
        brett.placeStein(stein, new SchachPosition(column, row).toPosition());
    }

    //Die Methode startet das Spiel/Match und setzt die Steine auf dem Brett.
    private void initialSetup(){

        //Mit der neuen Methode placeNewPiece kann ich meine Steine auf Brett mit der Koordinaten
        // des Brettes plazieren,
        placeNewPiece('b', 1, new Rook(brett, Color.WHITE));
        placeNewPiece('b', 2, new Rook(brett, Color.WHITE));
        placeNewPiece('c', 1, new Rook(brett, Color.WHITE));
        placeNewPiece('c', 2, new Rook(brett, Color.WHITE));
        placeNewPiece('d', 1, new Rook(brett, Color.WHITE));
        placeNewPiece('d', 2, new Rook(brett, Color.WHITE));
        placeNewPiece('e', 1, new King(brett, Color.WHITE));

        placeNewPiece('c', 7, new Rook(brett, Color.BLACK));
        placeNewPiece('c', 8, new Rook(brett, Color.BLACK));
        placeNewPiece('d', 7, new Rook(brett, Color.BLACK));
        placeNewPiece('e', 7, new Rook(brett, Color.BLACK));
        placeNewPiece('e', 8, new Rook(brett, Color.BLACK));
        placeNewPiece('d', 8, new King(brett, Color.BLACK));
    }
}
