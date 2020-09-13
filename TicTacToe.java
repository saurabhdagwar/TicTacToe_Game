import java.util.*;
class TicTacToe
{
        static final int END_POSITION = 9;
        static final int START_POSITION = 0;
        static char[] board =  {'-','-','-','-','-','-','-','-','-'};
        static int count;

        public void resetBoard()
        {
                 int position;
                for(position = START_POSITION ; position < END_POSITION ; position++ )
                {
                        board[position] = '-';
                }
        }



        public static void main(String[] args)
        {
                TicTacToe Game = new TicTacToe();
                Game.resetBoard();

        }
}
