
import java.util.*;
class TicTacToe
{
        static final int END_POSITION = 9;
        static final int START_POSITION = 0;
        static char[] board =  {'-','-','-','-','-','-','-','-','-'};
        static int count;
        static char Player;
        static char Computer;
        static final int P_NUM = 1;
        static Scanner scan = new Scanner(System.in);
        static Random random = new Random();
        public void resetBoard()
        {
		System.out.println("********************** Wellcome To Tic Tac Toe **********************");
               	int position;
                for(position = START_POSITION ; position < END_POSITION ; position++ )
                {
                        board[position] = '-';
                }
        }
        public int toss()
        {

                int toss = random.nextInt(2);
                if( toss == P_NUM)
                {
                        System.out.println("You Won The Toss");
                }
                else
                {
                        System.out.println("Computer Won The Toss");
                }
                return toss;
        }

        public static void main(String[] args)
        {
                TicTacToe Game = new TicTacToe();
                Game.resetBoard();
                Game.toss();
        }
}
