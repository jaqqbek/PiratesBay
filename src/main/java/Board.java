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
int cnt=0;
        do {
            int x = randm.nextInt(board.length);
            int y = randm.nextInt(board.length);

            int direction = randm.nextInt(4);
            // 0 - w lewo, 1 gora, 2 prawo, 3 dol

            found=canPutN(x,y,direction,4);
            if (found) {
                put(x,y,direction,4);
                cnt++;
            }


        }while (cnt<40);



    }

    private boolean canPutN(int x, int y, int direction,int size){

        if (board[x][y]!=0) return false;

        if (direction == 0) {
            if (x - size-1 >= 0) {

                for (int step=0; step<=size-1;step++){
                    if (board[x-step][y]!=0) return false;
                }
                //jeszcze sprawdz czy nie moga sie stykac

                return true;
            } else {
                return false;
            }

        }
        if (direction == 1) {
            if (y + size-1 <= 9) {
                for (int step=0; step<=size-1;step++){
                    if (board[x][y+step]!=0) return false;
                }
                //jeszcze sprawdz czy nie moga sie stykac

                return true;
            } else {
                return false;
            }

        }
        if (direction == 2) {
            if (x + size-1 <= 9) {
                for (int step=0; step<=size-1;step++){
                    if (board[x+step][y]!=0) return false;
                }

                //jeszcze sprawdz czy nie moga sie stykac

                return true;
            } else {
                return false;
            }

        }
        if (direction == 3) {
            if (y -size-1 >=0) {
                for (int step=0; step<=size-1;step++){
                    if (board[x][y-step]!=0) return false;
                }

                //jeszcze sprawdz czy nie moga sie stykac

                return true;
            } else {
                return false;
            }

        }

        return false;
    }

    //unsaf
    private void  put(int x, int y, int direction,int size){
        if (direction == 0) {
            for (int step=0; step<=size-1;step++){
                board[x-step][y]=size;
            }
        }
        if (direction == 1) {

            for (int step=0; step<=size-1;step++){
                board[x][y+step]=size;
            }


        }
        if (direction == 2) {
            for (int step=0; step<=size-1;step++){
               board[x+step][y]=size;
            }

        }
        if (direction == 3) {

            for (int step=0; step<=size-1;step++){
                board[x][y-step]=size;
            }

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
