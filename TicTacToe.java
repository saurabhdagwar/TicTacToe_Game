import java.util.*;
class TicTacToe
{
	static final int END_POSITION = 9;
	static final int START_POSITION = 1;
	static char[] board =  {'-','-','-','-','-','-','-','-','-','-'};
	static int count;
	static final int ONE = 1, TWO = 2, THREE = 3, FOUR = 4, FIVE = 5, SIX = 6, SEVEN = 7, EIGHT = 8, NINE = 9;
	static final int P_NUM = 1;
        static final int C_NUM = 2;
	static char Player_Symbol;
        static char Computer_Symbol;
	static Random random = new Random();
	static Scanner scan = new Scanner(System.in);
	static final char X = 'X';
	static final char O = 'O';
	static int toss;
	static int position = 1 ;

// Program start
	public void resetBoard()
	{
		System.out.println("********************** Wellcome To Tic Tac Toe **********************");
		System.out.println("Resetting Board");

		 int position;
		for(position = START_POSITION ; position <= END_POSITION ; position++ )
		{
			board[position] = '-';
		}
	}
       
	 public void DisplayBoard()
        {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("    |-----|-----|-----| ");
                System.out.println("    |  "+board[ONE]+"  |  "+board[TWO]+"  |  "+board[THREE]+"  |");
                System.out.println("    |-----|-----|-----| ");
                System.out.println("    |  "+board[FOUR]+"  |  "+board[FIVE]+"  |  "+board[SIX]+"  |");
                System.out.println("    |-----|-----|-----| ");
                System.out.println("    |  "+board[SEVEN]+"  |  "+board[EIGHT]+"  |  "+board[NINE]+"  |");
                System.out.println("    |-----|-----|-----| ");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
	public void tossRandom()
        {

                toss = random.nextInt(2);
                if( toss == P_NUM)
                {
                        System.out.println("You Won The Toss");
                }
                else
                {
                        System.out.println("Computer Won The Toss");
                }

        }

        public void SymbolChoice()
        {

                if( toss == P_NUM)
                {
                        System.out.print("Select Letter as your choice X and O : ");
                        Player_Symbol = scan.next().charAt(0);
                        System.out.println();
                        if( Player_Symbol == X )
                        {
                                Computer_Symbol = O;
                                System.out.println("Player Letter : "+Player_Symbol);
                                System.out.println("Computer Letter : "+Computer_Symbol);

                        }
                        else if( Player_Symbol == O )
                        {
                                Computer_Symbol = X;
                                System.out.println("Player Letter : "+Player_Symbol);
                                System.out.println("Computer Letter : "+Computer_Symbol);
                        }
                        else
                        {
                                System.out.println("Not taken valid Symbol ! Try Again ! ");
                                SymbolChoice();
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
                        System.out.println("Player Letter : "+Player_Symbol);
                        System.out.println("Computer Letter : "+Computer_Symbol);

                }
        }

        public void PlayerPlay()
        {
//                CheckWon(P_NUM);
                System.out.print("  Enter number to play  1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 - 9 :");
                position = scan.nextInt();

                if(board[position] == '-' )
                {
                        board[position] = Player_Symbol;
                        DisplayBoard();
                        System.out.println();
                }
                else
                {
                        System.out.println("********** Position Already Occupied **********");
                        PlayerPlay();
                }
//                AllowComp = TWO;
        }

        public void GamePlayed()
        {
		int count;
                if( toss == P_NUM)
                {
                        for(count = START_POSITION ; count <= FIVE; count++ )
                        {
                                PlayerPlay();
//                                ComputerPlay();

                        }
                }
                else
                {
                        for(count = START_POSITION ; count <= FIVE ; count++ )
                        {
//                                ComputerPlay();
                                PlayerPlay();
                        }
                }
        }




//Main Program

	public static void main(String[] args)
	{
		TicTacToe Game = new TicTacToe();
		Game.resetBoard();
		Game.DisplayBoard();
		Game.tossRandom();
		Game.SymbolChoice();
		Game.GamePlayed();
	}
}

