/**
 * Created by qba on 25.06.17.
 */
public class PiratesGame {

    private Board myShips = new  Board(20,20);
    private Board computerShips= new  Board(20,20);
    private Board myShots= new  Board(20,20);
    private Board computerShots= new  Board(20,20);


    public void  printMyBoard(){
       myShips.printBoard();
    }

    public void  printComputerBoard(){
        computerShips.printBoard();
    }


    public void setShips(){
       myShips.setAllShipsRandomly();
    }

    public static void main(String[] args) {
        PiratesGame game1 = new PiratesGame();
        game1.setShips();
       // game1.printComputerBoard();
        game1.printMyBoard();

    }




}
