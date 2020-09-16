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
	static int AllowComp = 2;
	static int position = 1 ;
	static int tiecount = 0;
	static int win = 0;
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
		 System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
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
	                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
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
	                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }
        }
//Player Playing Moves
        public void PlayerPlay()
        {
		System.out.println("++++++ Your Turn ++++++");
                System.out.print("  Enter number to play  1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 - 9 :");
         	System.out.println();
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
                AllowComp = TWO;
		CheckWon(P_NUM, Player_Symbol);
		count++;
        }
//Winning and Defending Moves of Computer
	public void WinBlockMove( char Symbol )
	{
		int temp;
		if(AllowComp == TWO )
		{
	//Winning or Defending move in Rows
			for(int row = ONE; row <= EIGHT ; row += THREE )
	                {
	                        if( board[row + ONE] == board[row + TWO] && board[row + TWO ] == Symbol && board[row] == '-' )
	                        {
	                                board[row] = Computer_Symbol;
					AllowComp--;
	                        }
	                        else if( board[row] ==  board[row + TWO ] && board[row] == Symbol && board[row + ONE ] == '-')
	                        {
	                                 board[row + ONE] = Computer_Symbol;
					 AllowComp--;
	                        }
	                        else if( board[row] == board[row + ONE] && board[row] == Symbol && board[row + TWO] == '-')
	                        {
	                                board[row + TWO ] = Computer_Symbol;
					AllowComp--; 
	                        }
	                }
		}
	//Winning or Defending move in Column
                if(AllowComp == TWO )
		{
			for(int col = ONE; col <= THREE ; col++)
	                {
	                        if( board[col + THREE] == board[col + SIX] && board[col + THREE ] == Symbol && board[col] == '-' )
	                        {
	                                board[col] = Computer_Symbol;
					AllowComp--;
	                        }
	                        else if( board[col] ==  board[col + SIX ] && board[col] == Symbol && board[col + THREE ] == '-')
	                        {
	                                 board[col + THREE] = Computer_Symbol;
					 AllowComp--;
	                        }
	                        else if( board[col] == board[col + THREE] && board[col] == Symbol && board[col + SIX] == '-')
	                        {
	                                board[col + SIX] = Computer_Symbol;
					AllowComp--;
	                        }
	                }
		}
	//Winning of Defending move in Diagonal
		if(AllowComp == TWO)
		{
	                if(((board[ONE] == board[NINE] && board[NINE] == Symbol ) || (board[THREE] == board[SEVEN] && board[SEVEN] == Symbol)) && ( board[FIVE] == '-'))
			{
				board[FIVE] = Computer_Symbol; 
				AllowComp--;
			}
			else if(board[FIVE] == board[NINE] && board[NINE] == Symbol && board[ONE] == '-' )
			{
				board[ONE] = Computer_Symbol;
	                        AllowComp--;
			}
			else if(board[FIVE] == board[ONE] && board[FIVE] == Symbol && board[NINE] == '-')
	                {
	                        board[NINE] = Computer_Symbol;
	                        AllowComp--;
		        }
			else if(board[FIVE] == board[SEVEN] && board[SEVEN] == Symbol && board[THREE] == '-')
	                {
	                        board[THREE] = Computer_Symbol;
		                AllowComp--;
	                }
	                else if(board[FIVE] == board[THREE] && board[FIVE] == Symbol && board[SEVEN] == '-' )
	                {
	                        board[SEVEN] = Computer_Symbol;
	                      	AllowComp--;
	                }
		}
	}
	public void CompCornerMove()
	{
//choose Corners move
		int compposition ;
		if(AllowComp == TWO)
		{
			if((board[ONE] == '-') || (board[THREE] == '-') || (board[SEVEN] == '-') || (board[NINE] == '-')  )
			{
				compposition = (random.nextInt(4)+1);
				if( compposition == ONE && board[ONE] == '-' )
				{
					board[ONE] = Computer_Symbol;
					AllowComp--;
				}
				else if( compposition == TWO  && board[THREE] == '-' )
				{
					board[THREE] = Computer_Symbol;
					AllowComp--;
				}
				else if( compposition == THREE  && board[SEVEN] == '-' )
				{
					board[SEVEN] = Computer_Symbol;
					AllowComp--;
				}
				else if( compposition == FOUR  && board[NINE] == '-' )
				{
					board[NINE] = Computer_Symbol;
					AllowComp--;
				}
				else
				{
					CompCornerMove();
				}
			}
		}
	}
//Choose Center
	public void CompChooseCenter()
	{
		if(AllowComp == TWO)
		{
			if(board[FIVE] == '-')
			{
				board[FIVE] = Computer_Symbol;
				AllowComp--;
			}
		}
	}
	public void CompsideMove()
        {
//choose Sides move
		int compposition ;
		if(AllowComp == TWO)
		{
			if((board[TWO] == '-') || (board[FOUR] == '-') || (board[SIX] == '-') || (board[EIGHT] == '-')  )
			{
				compposition = (random.nextInt(4)+1);
				if( compposition == ONE && board[TWO] == '-' )
				{
					board[TWO] = Computer_Symbol;
					AllowComp--;
				}
				else if( compposition == TWO  && board[FOUR] == '-' )
				{
					board[FOUR] = Computer_Symbol;
					AllowComp--;
				}
				else if( compposition == THREE  && board[SIX] == '-' )
				{
					board[SIX] = Computer_Symbol;
					AllowComp--;
				}
				else if( compposition == FOUR  && board[EIGHT] == '-' )
				{
					board[EIGHT] = Computer_Symbol;
					AllowComp--;
				}
				else
				{
					CompsideMove();
				}
			}
		}
	}
	public void comprand()
	{
		if(AllowComp == TWO)
		{
			int compposition = (random.nextInt(9)+1);
			if( board[compposition] != Player_Symbol && board[compposition] != Computer_Symbol)
			{
				board[compposition] = Computer_Symbol;
				System.out.println(":");
			}
			else
			{
			comprand();
			}
		}
	}
	public void ComputerPlay()
	{
		System.out.println("++++++ Computer Turn ++++++");
		System.out.println();
		try{
			Thread.sleep(1500);
			WinBlockMove(Computer_Symbol);   //Check for Winning Moves
			WinBlockMove(Player_Symbol);	//Check for Blocking Moves
			CompCornerMove();		// Check for Corners
			CompChooseCenter();		// Check for Center
			CompsideMove();			// Check for Sides
			comprand();
			DisplayBoard();
	               	System.out.println();
			CheckWon(C_NUM,Computer_Symbol);
		}
		catch(Exception e)
		{
			 System.out.println();
		}
		count++;
	}
        public void CheckWon(int num, char Symbol)
        {

	        for(int row = ONE; row < EIGHT ; row += THREE )
	        {
//Winning in Rows
	                if(board[row] == board[row+ONE] && board[row] == board[row+TWO] && board[row] == Symbol )
	                {
	                        DisplayWinner(num);
	                }
                }
//Winning in Column
	                for(int col = ONE; col < FOUR ; col++)
	                {
	                        if(board[col] == board[col + THREE] && board[col] == board[col + SIX] && board[col] == Symbol)
	                        {
	                                DisplayWinner(num);
	                        }
	                }
//Winning in Diagonal
			if((board[ONE] == board[FIVE] && board[FIVE] == board[NINE] && board[FIVE] == Symbol ) || (board[THREE] == board[FIVE] && board[FIVE] == board[SEVEN] && board[FIVE] == Symbol ))
	                {
	                        DisplayWinner(num);
                }
        }
        public void DisplayWinner(int win)
        {
                if(win == P_NUM)
                {
                        System.out.println("************ Congrats You Won The Match ************ ");
                        System.exit(0);
                }
                else if(win == C_NUM)
                {
                        System.out.println("************ You Lose The Match ************ ");
                        System.exit(0);
                }
        }
	public void CheckTie()
	{
		if( count == NINE  )
                {
                        System.out.println("************ Match Tie ************ ");
                        System.exit(0);
		}
	}
        public void GamePlayed()
        {
		int count = START_POSITION ;
                if( toss == P_NUM)
                {
                        while(count <= END_POSITION)
                        {
                                PlayerPlay();
				CheckTie();
                                ComputerPlay();
                        }
                }
                else
                {
                        while(count <= END_POSITION)
			{
                                ComputerPlay();
				CheckTie();
                                PlayerPlay();
                        }
                }
		CheckTie();
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

