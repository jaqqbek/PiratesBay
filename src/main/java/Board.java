import java.util.Random;

/**
 * Created by qba on 25.06.17.
 */
public class Board {
    private int[][] board;


    public Board(int x, int y){
        board = new int[x][y];
    }

    public void printBoard(){
        for (int[] row:board){

            for (int cell:row){
                printCell(cell);
            }
            System.out.println();
        }
    }

    public void setAllShipsRandomly(){



        Random randm = new Random();


        boolean found=false;

        do {
            int x = randm.nextInt(board.length);
            int y = randm.nextInt(board.length);

            int direction = randm.nextInt(4);
            // 0 - w lewo, 1 gora, 2 prawo, 3 dol
            found=canPut4(x,y,direction);

            if (found) put4(x,y,direction);


        }while (!found);



    }

    private boolean canPut4(int x, int y, int direction){

        if (direction == 0) {
            if (x - 3 >= 0) {
                if (board[x][y]!=0) return false;
                if (board[x-1][y]!=0) return false;
                if (board[x-2][y]!=0) return false;
                if (board[x-3][y]!=0) return false;

                //jeszcze sprawdz czy nie moga sie stykac

                return true;
            } else {
                return false;
            }

        }
        if (direction == 1) {
            if (y + 3 >= 0) {
                if (board[x][y]!=0) return false;
                if (board[x][y+1]!=0) return false;
                if (board[x][y+2]!=0) return false;
                if (board[x][y+3]!=0) return false;

                //jeszcze sprawdz czy nie moga sie stykac

                return true;
            } else {
                return false;
            }

        }
        if (direction == 2) {
            if (x + 3 <= 9) {
                if (board[x][y]!=0) return false;
                if (board[x+1][y]!=0) return false;
                if (board[x+2][y]!=0) return false;
                if (board[x+3][y]!=0) return false;

                //jeszcze sprawdz czy nie moga sie stykac

                return true;
            } else {
                return false;
            }

        }
        if (direction == 3) {
            if (y +3 <=9) {
                if (board[x][y]!=0) return false;
                if (board[x][y-1]!=0) return false;
                if (board[x][y-2]!=0) return false;
                if (board[x][y-3]!=0) return false;

                //jeszcze sprawdz czy nie moga sie stykac

                return true;
            } else {
                return false;
            }

        }

        return false;
    }

    //unsafe
    private void  put4(int x, int y, int direction){
        if (direction == 0) {
            board[x][y] = 4;
            board[x - 1][y] = 4;
            board[x - 2][y] = 4;
            board[x - 3][y] = 4;
        }
        if (direction == 1) {
            board[x][y] = 4;
            board[x][y+1] = 4;
            board[x][y+2] = 4;
            board[x][y+3] = 4;
        }
        if (direction == 2) {
            board[x][y] = 4;
            board[x + 1][y] = 4;
            board[x + 2][y] = 4;
            board[x + 3][y] = 4;
        }
        if (direction == 3) {
            board[x][y] = 4;
            board[x][y-1] = 4;
            board[x][y-2] = 4;
            board[x][y-3] = 4;
        }
    }

    public void setShip(int x, int y, int ship){
        board[x][y]=ship;
    }
    private void printCell(int cell){
        if (cell==0) System.out.print("\u001B[30m _");
        else if (cell>0) System.out.print("\u001B[30m x");
        else if (cell<0) System.out.print("\u001B[31m x");
    }
}
