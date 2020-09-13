
import java.util.*;
class TicTacToe
{
	static final int END_POSITION = 9;
	static final int START_POSITION = 0;
	static char[] board =  {'-','-','-','-','-','-','-','-','-'};
	static int count;
	static int position;
	static char Player_Symbol;
	static char Computer_Symbol;
	static final int P_NUM = 1;
	static Scanner scan = new Scanner(System.in);
	static Random random = new Random();
	static char X = 'X';
	static char O = 'O';
	static int toss;

	public void resetBoard()
	{
		System.out.println("********************** Wellcome To Tic Tac Toe **********************");
		 int position;
		for(position = START_POSITION ; position < END_POSITION ; position++ )
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
		System.out.println("    |  "+board[0]+"  |  "+board[1]+"  |  "+board[2]+"  |");
		System.out.println("    |-----|-----|-----| ");
		System.out.println("    |  "+board[3]+"  |  "+board[4]+"  |  "+board[5]+"  |");
		System.out.println("    |-----|-----|-----| ");
		System.out.println("    |  "+board[6]+"  |  "+board[7]+"  |  "+board[8]+"  |");
		System.out.println("    |-----|-----|-----| ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	public void PlayerPlay()
	{
		System.out.println("  Enter number to play 0 - 1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 ");
		position = scan.nextInt();
		board[position] = Player_Symbol;
		DisplayBoard();

	}
	public void ComputerPlay()
	{

	}

	public void GamePlayed()
	{
		if( toss == P_NUM)
		{
			for(position = START_POSITION ; position < END_POSITION ; position++ )
			{
				PlayerPlay();
				ComputerPlay();
			}
		}
		else
		{
			for(position = START_POSITION ; position < END_POSITION ; position++ )
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
	}
}

