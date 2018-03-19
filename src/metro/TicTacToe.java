package metro;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TicTacToe
{
  private static final Log LOGGER = LogFactory.getLog( TicTacToe.class );

  private static final String SIZE_OF_BOARD = "sizeofborad";
  private static final Properties prop = new Properties();
  private static Scanner in;
  private static String winner = null;
  static boolean player1 = false;
  static boolean player2 = false;
  static boolean notOccupied = true;
  static int playerPosition;

  private static ArrayList<Object> boardPositions = new ArrayList<Object>();
  private static List<Integer> turn = new ArrayList<>();


  /**
   * Creats a Playfiled by reading size from tictactoe.properites file
   * @return {@link Integer}
   */
  public static Integer creatPlayField()
  {
    final ClassLoader loader = Thread.currentThread().getContextClassLoader();
    final InputStream input = loader.getResourceAsStream( "resources/tictactoe.properties" );

    // load a properties file
    try
    {
      prop.load( input );
    }
    catch( final IOException e )
    {
      LOGGER.error( "Define your Board Size" );
    }
    return Integer.valueOf( prop.getProperty( SIZE_OF_BOARD ) );
  }

  /**
   * Prints Tic Tac Toe board. Board size is restricted between 3 to 10.
   * 
   * @param boardPositions
   * @param numerOfRowOrColumn
   */
  private static void printBoard( final ArrayList<Object> boardPositions, final int numerOfRowOrColumn )
  {
    if( isBetween( numerOfRowOrColumn, 3, 10 ) )
    {
      final StringBuilder boardMarker = new StringBuilder();
      int count = 0;
      Iterator<Object> iter = boardPositions.iterator();
      while( iter.hasNext() )
      {
        Object next = iter.next();
        count++;
        boardMarker.append( "|\t" + next + "\t|" );
        if( count % numerOfRowOrColumn == 0 )
        {
          boardMarker.append( "\n" );
        }
      }
      System.out.println( "Playing Board:\n\n" + boardMarker.toString() );
    }
    else
    {
      LOGGER.error( "Size of the playfield shold be between 3 and 10" );
    }
  }

  /**
   * Check if the size is between 3 to 10.
   * @param value
   * @param min
   * @param max
   * @return
   */
  public static boolean isBetween( final int value, final int min, final int max )
  {
    return ( ( value >= min ) && ( value <= max ) );
  }

  public static void main( final String[] args )
  {
    startPlay();
  }

  /**
   * Play start from here.
   */
  private static void startPlay()
  {
    // Takes Input
    in = new Scanner( System.in );
    final int numerOfRowAndColumn = creatPlayField();
    populateEmptyBoard( numerOfRowAndColumn );
    selectPlayer();
    while( winner == null )
    {
      try
      {
        if( player1 )
        {
          char playerOne = 'X';

          printBoard( boardPositions, numerOfRowAndColumn );
          System.out.println( "Enter a slot number to place player 'X' in:" );

          playerPosition = in.nextInt();
          while( notOccupied )
          {
            checkAndReplacePositions( boardPositions, playerPosition, playerOne );
          }
          notOccupied = true;
          player1 = false;
          player2 = true;
          if( StringUtils.equals( checkDrawCondition(), "continue" ) )
          {
            // empty
          }
          else if (StringUtils.equals( checkDrawCondition(), "draw" ) )
          {
            winner = "draw";
            break;
          }
          winner = CheckWinner.getInstance().checkWinner( boardPositions, numerOfRowAndColumn );
        }
        else if( player2 )
        {
          char playerTwo = 'O';

          printBoard( boardPositions, numerOfRowAndColumn );
          System.out.println( "Enter a slot number to place player 'O' in:" );

          playerPosition = in.nextInt();
          while( notOccupied )
          {
            checkAndReplacePositions( boardPositions, playerPosition, playerTwo );
          }
          notOccupied = true;
          player2 = false;
          player1 = true;
          if( StringUtils.equals( checkDrawCondition(), "continue" ) )
          {
            // empty
          }
          else if (StringUtils.equals( checkDrawCondition(), "draw" ) )
          {
            winner = "draw";
            break;
          }
          winner = CheckWinner.getInstance().checkWinner( boardPositions, numerOfRowAndColumn );
        }
      }
      catch( final InputMismatchException e )
      {
        System.out.println( "Invalid input" );
        continue;
      }
    }
    // Checks who is the winner
    if( StringUtils.isNotBlank( winner ) )
    {
      if( turn.get( 0 )==1 )
        System.out.println( "Player 'X' Won the match." );
      else if( turn.get( 0 )==2 )
        System.out.println( "Player 'O' Won the match." );
      else if( StringUtils.equals( winner, "draw" ) )
        System.out.println( "Matched has been drawn." );
    }
  }

  /**
   * Selects player if player 1 or two will start the game
   * @return
   */
  private static List<Integer> selectPlayer()
  {
    int playerTurn = 0;
    System.out.println( "Press 1 if you are player X or 2 if you are player O" );

    playerTurn = in.nextInt();
    if( playerTurn == 1 )
    {
      System.out.println( "Press X will start the game" );
      player1 = true;
      turn.add( 1 );
      turn.add( 2 );
      turn.add( 3 );
      return turn;
    }
    else
    {
      System.out.println( "Press O will start the game" );
      player2 = true;
      turn.add( 2 );
      turn.add( 1 );
      turn.add( 3 );
      return turn;
    }
  }

  /**
   * Check and replaces the position given by user. It also proves if the position has been occupied by other user.
   * @param boardPositions
   * @param playerPositions
   * @param playerTurn
   */
  private static void checkAndReplacePositions( ArrayList<Object> boardPositions, int playerPositions, char playerTurn )
  {
    LOGGER.debug( "Boardpositions " + boardPositions.size() );
    for( int i = 0; i < boardPositions.size(); )
    {
      if( playerPositions == i + 1 )
      {
        String st = boardPositions.get( i ).toString();
        String check = "XOC";
        if( StringUtils.containsAny( st, check ) )
        {
          i = 0;
          System.out.println( "Slot already taken ! Try again: " );
          notOccupied = true;
          playerPosition = in.nextInt();
          break;
        }
        else
        {
          boardPositions.set( i, playerTurn );
          notOccupied = false;
          break;
        }
      }
      i++;
    }
  }

  /**
   * Puts the position of board depending on size which is mentioned in tictactoe.properties data.
   * @param numerOfRowAndColumn
   * @return
   */
  private static int populateEmptyBoard( final int numerOfRowAndColumn )
  {
    final int values = numerOfRowAndColumn * numerOfRowAndColumn;
    for( int a = 1; a <= values; a++ )
    {
      boardPositions.add( a );
    }
    return values;
  }

  /**
   * Here checks if the game has been drawn.
   * @return
   */
  public static String checkDrawCondition()
  {
    Iterator<Object> iter = boardPositions.iterator();
    ArrayList<Object> charecterList = new  ArrayList<Object>();

    while( iter.hasNext() )
    {
      Object next = iter.next();
      if(next instanceof Character)
      {
        charecterList.add( next );
        if(charecterList.size() == boardPositions.size()-1)
        {
          return "draw";
        }
      }
    }
    return "continue";
  }
}
