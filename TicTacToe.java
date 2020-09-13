import java.util.*;
class TicTacToe
{
        static final int END_POSITION = 9;
        static final int START_POSITION = 0;
        static char[] board =  {'-','-','-','-','-','-','-','-','-'};
        static int count;
        static char Player_Symbol;
        static char Computer_Symbol;
        static final int P_NUM = 1;
        static Scanner scan = new Scanner(System.in);
        static Random random = new Random();
        static char X = 'X';
        static char O = 'O';
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
        public void SymbolChoice()
        {
                int toss = toss();
                if( toss == P_NUM)
                {
                        System.out.print("Select Letter as your choice X and O : ");
                        Player_Symbol = scan.next().charAt(0);
                        System.out.println();
                        if( Player_Symbol == X )
                        {
                                Computer_Symbol = O;
                        }
                        else
                        {
                                Computer_Symbol = X;
                        }
                }
                else
                {
                        int computer_random = random.nextInt(2);
                        if( computer_random == P_NUM )
                        {
                                Computer_Symbol = X;
                                Player_Symbol = O;
                        }
                        else
                        {
                                Computer_Symbol = O;
                                 Player_Symbol = X;
                        }
                }
                System.out.println("Player Letter : "+Player_Symbol);
                System.out.println("Computer Letter : "+Computer_Symbol);
        }


        public static void main(String[] args)
        {
                TicTacToe Game = new TicTacToe();
                Game.resetBoard();
                Game.SymbolChoice();
        }
}
