import java.util.*; class TicTacToe {
	static final int END_POSITION = 9;
	static final int START_POSITION = 0;
	static char[] board =  {'-','-','-','-','-','-','-','-','-','-'};
	static int count;
	static int position;
	static char Player_Symbol;
	static char Computer_Symbol;
	static final int P_NUM = 1;
	static final int C_NUM = 2;
	static Scanner scan = new Scanner(System.in);
	static Random random = new Random();
	static char X = 'X';
	static char O = 'O';
	static int toss;
	static int AllowComp = 1 ;
	static int win = 0;
	static final int ONE = 0, TWO = 1, THREE = 2, FOUR = 3, FIVE = 4, SIX = 5, SEVEN = 6, EIGHT = 7, NINE = 8;
	public void resetBoard()
	{
		System.out.println("********************** Wellcome To Tic Tac Toe **********************");
		 int position;
		for(position = START_POSITION ; position <= END_POSITION ; position++ )
		{
			board[position] = '-';
		}
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

	public void PlayerPlay()
	{
		CheckWon(P_NUM);
		System.out.print("  Enter number to play  1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 - 9 :");
		position = scan.nextInt();
		position--;
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

	}

        public void CompWinningMove()
        {
                if( AllowComp == TWO )
                {
                        if((board[ONE] == board[NINE] && board[NINE] == Computer_Symbol) || (board[THREE] == board[SEVEN] && board[SEVEN] == Computer_Symbol) || (board[TWO] == board[EIGHT] && board[EIGHT] == Computer_Symbol) ||(board[FOUR] == board[SIX] && board[SIX] == Computer_Symbol) && ( board[FIVE] == '-' ))
                        {
                                 board[FIVE] = Computer_Symbol;
                                AllowComp = ONE;
                        }

                        else if((board[TWO] == board[THREE] && board[THREE] == Computer_Symbol) || (board[FOUR] == board[SEVEN] && board[SEVEN] == Computer_Symbol) || (board[FIVE] == board[NINE] && board[NINE] == Computer_Symbol) && ( board[ONE] == '-') )
                        {
                                board[ONE] = Computer_Symbol;
                                AllowComp = ONE;
                        }

                        else if((board[ONE] == board[TWO] && board[TWO] == Computer_Symbol) || (board[SIX] == board[NINE] && board[NINE] == Computer_Symbol) || (board[FIVE] == board[SEVEN] && board[SEVEN] == Computer_Symbol) && ( board[THREE] == '-'))
                        {
                                 board[THREE] = Computer_Symbol;
                                AllowComp = ONE;
                        }

                        else if((board[ONE] == board[FOUR] && board[FOUR] == Computer_Symbol) || (board[EIGHT] == board[NINE] && board[NINE] == Computer_Symbol) || (board[FIVE] == board[THREE] && board[FIVE] == Computer_Symbol) && ( board[SEVEN] == '-'))
                        {
                                 board[SEVEN] = Computer_Symbol;
                                AllowComp = ONE;
                        }

                        else if((board[THREE] == board[SIX] && board[THREE] == Computer_Symbol) || (board[EIGHT] == board[SEVEN] && board[SEVEN] == Computer_Symbol) || (board[FIVE] == board[ONE] && board[ONE] == Computer_Symbol) && ( board[NINE] == '-'))
                        {
                                board[NINE] = Computer_Symbol;
                                AllowComp = ONE;
                        }

                        else if((board[ONE] == board[THREE] && board[THREE] == Computer_Symbol) || (board[FIVE] == board[EIGHT] &&  board[EIGHT] == Computer_Symbol ) )
                        {
                                if( board[TWO] == '-')
                                {
                                board[TWO] = Computer_Symbol;
                                }
                                AllowComp = ONE;
                        }
                        else if(( board[ONE] == board[SEVEN] && board[SEVEN] == Computer_Symbol ) || (board[FIVE] == board[SIX] && board[SIX] == Computer_Symbol)&& (board[FOUR] == '-'))
                        {
                                board[FOUR] = Computer_Symbol;
                                AllowComp = ONE;
                        }
                        else if((board[FIVE] == board[TWO] && board[TWO] == Computer_Symbol) || (board[SEVEN] == board[NINE] && board[NINE] == Computer_Symbol) && board[EIGHT] == '-')
                        {
                                board[EIGHT] = Computer_Symbol;
                                AllowComp = ONE;
                        }
                        else if((board[FIVE] == board[FOUR] && board[FOUR] == Computer_Symbol) || (board[THREE] == board[NINE] && board[NINE] == Computer_Symbol) && board[SIX] == '-')
                        {
                                board[SIX] = Computer_Symbol;
                                AllowComp = ONE;
                        }

                }

        }



        public void CompDefendingMove()
        {
                if(AllowComp == TWO )
                {

                        if((board[ONE] == board[NINE] && board[NINE] == Player_Symbol) || (board[THREE] == board[SEVEN] && board[SEVEN] == Player_Symbol) || (board[TWO] == board[EIGHT] && board[EIGHT] == Player_Symbol) ||(board[FOUR] == board[SIX] && board[SIX] == Player_Symbol) && board[FIVE] == '-'  )
                        {
                                 board[FIVE] = Computer_Symbol;
                                AllowComp = ONE;
                        }

                        else if((board[TWO] == board[THREE] && board[THREE] == Player_Symbol) || (board[FOUR] == board[SEVEN] && board[SEVEN] == Player_Symbol) || (board[FIVE] == board[NINE] && board[NINE] == Player_Symbol) && board[ONE] == '-' )
                        {
                                board[ONE] = Computer_Symbol;
                                AllowComp = ONE;
                        }

                        else if((board[ONE] == board[TWO] && board[TWO] == Player_Symbol) || (board[SIX] == board[NINE] && board[NINE] == Player_Symbol) || (board[FIVE] == board[SEVEN] && board[SEVEN] == Player_Symbol) && board[THREE] == '-')
                        {
                                 board[THREE] = Computer_Symbol;
                                AllowComp = ONE;
                        }

                        else if((board[ONE] == board[FOUR] && board[FOUR] == Player_Symbol) || (board[EIGHT] == board[NINE] && board[NINE] == Player_Symbol) || (board[FIVE] == board[THREE] && board[FIVE] == Player_Symbol) && board[SEVEN] == '-')
                        {
                                board[SEVEN] = Computer_Symbol;
                                AllowComp = ONE;
                        }

                        else if((board[THREE] == board[SIX] && board[THREE] == Player_Symbol) || (board[EIGHT] == board[SEVEN] && board[SEVEN] == Player_Symbol) || (board[FIVE] == board[ONE] && board[ONE] == Player_Symbol) && board[NINE] == '-' )
                        {
                                board[NINE] = Computer_Symbol;
                                AllowComp = ONE;
                        }


                        else if((board[ONE] == board[THREE] && board[THREE] == Player_Symbol) || (board[FIVE] == board[EIGHT] && board[EIGHT] == Player_Symbol) && board[TWO] == '-')
                        {
                                board[TWO] = Computer_Symbol;
                                AllowComp = ONE;
                        }
                        else if((board[ONE] == board[SEVEN] && board[SEVEN] == Player_Symbol) || (board[FIVE] == board[SIX] && board[SIX] == Player_Symbol) && board[FOUR] == '-')
                        {
                                board[FOUR] = Computer_Symbol;
                                AllowComp = ONE;
                        }
                        else if((board[FIVE] == board[TWO] && board[TWO] == Player_Symbol) || (board[SEVEN] == board[NINE] && board[NINE] == Player_Symbol)&& board[EIGHT] == '-' )
                        {
                                board[EIGHT] = Computer_Symbol;
                                AllowComp = ONE;
                        }
                        else if((board[FIVE] == board[FOUR] && board[FOUR] == Player_Symbol) || (board[THREE] == board[NINE] && board[NINE] == Player_Symbol) && board[SIX] == '-' )
                        {
                                board[SIX] = Computer_Symbol;
                                AllowComp = ONE;
                        }
                }
        }



        public void ComputerPlay()
        {
                System.out.println("++++++ Computer Turn ++++++");

                try
                {

                         if( AllowComp == TWO )
                        {
                                Thread.sleep(1000);
                                CompWinningMove();
				CompDefendingMove();
                                DisplayBoard();
                                System.out.println();
                        }

                }

                catch(InterruptedException e)
                {
                        System.out.println(e);
                }

                CheckWon(C_NUM);

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
		else
		{
			System.out.println("************ Match Tie ************ ");
			System.exit(0);
		}
	}

	public void CheckWon(int num)
        {
                if( board[ONE] == board[TWO] && board[TWO] == board[THREE] && board[THREE] != '-' )
                {
                       DisplayWinner(num);
                }
                if( board[FOUR] == board[FIVE] && board[FIVE] == board[SIX] && board[SIX] != '-' )
                {
                         DisplayWinner(num);
                }
                if( board[SEVEN] == board[EIGHT] && board[EIGHT]  == board[NINE] && board[NINE] != '-' )
                {
			 DisplayWinner(num);
                }
                if( board[ONE] == board[FIVE] && board[FIVE]  == board[NINE] && board[NINE] != '-' )
                {
                        DisplayWinner(num);
                }
                if( board[THREE] == board[FIVE] && board[FIVE] == board[SEVEN] && board[SEVEN] != '-' )
                {
                         DisplayWinner(num);
                }

                if( board[TWO] == board[FIVE] && board[FIVE] == board[EIGHT] && board[EIGHT] != '-' )
                {
                        DisplayWinner(num);

                }
                if( board[ONE] == board[FOUR] && board[FOUR] == board[SEVEN] && board[SEVEN] != '-' )
                {
			 DisplayWinner(num);
                }
                if( board[THREE] == board[SIX] && board[SIX] == board[NINE] && board[NINE] != '-' )
                {
			 DisplayWinner(num);

                }
        }


	public void GamePlayed()
	{
		if( toss == P_NUM)
		{
			for(count = START_POSITION ; count < END_POSITION ; count++ )
			{
				PlayerPlay();
				ComputerPlay();

			}
		}
		else
		{
			for(count = START_POSITION ; count < END_POSITION ; count++ )
			{
				ComputerPlay();
				PlayerPlay();
			}
		}
	}

	public static void main(String[] args)
	{

		TicTacToe Game = new TicTacToe();
		Game.resetBoard();
		Game.tossRandom();
		Game.SymbolChoice();
		Game.DisplayBoard();
		Game.GamePlayed();
	//	Game.DisplayWinner();
	}
}

