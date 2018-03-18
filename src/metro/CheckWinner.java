package metro;

import java.util.ArrayList;

public class CheckWinner
{

  private static class SingletonHelper
  {
    private static final CheckWinner INSTANCE = new CheckWinner();
  }

  public static CheckWinner getInstance()
  {
    return SingletonHelper.INSTANCE;
  }

  public String checkWinner( ArrayList<Object> boardPositions, int numerOfRowAndColumn )
  {
    if( numerOfRowAndColumn == 3 )
    {
      return checkWinnerForRowAndColumn3( boardPositions, numerOfRowAndColumn );
    }

    if( numerOfRowAndColumn == 4 )
    {
      return checkWinnerForRowAndColumn4( boardPositions, numerOfRowAndColumn );
    }

    if( numerOfRowAndColumn == 5 )
    {
      return checkWinnerForRowAndColumn5( boardPositions, numerOfRowAndColumn );
    }

    if( numerOfRowAndColumn == 6 )
    {
      return checkWinnerForRowAndColumn6( boardPositions, numerOfRowAndColumn );
    }

    return null;
  }

  private String checkWinnerForRowAndColumn3( ArrayList<Object> boardPositions, int numerOfRowAndColumn )
  {

    for( int a = 0; a < checkPossibleWinningLines( numerOfRowAndColumn ); a++ )
    {
      String line = null;
      StringBuilder pattern = new StringBuilder();
      switch( a )
      {
        case 0:
          line = pattern.append( boardPositions.get( 0 ) ).append( boardPositions.get( 1 ) ).append( boardPositions.get( 2 ) )
              .toString();
          break;
        case 1:
          line = pattern.append( boardPositions.get( 3 ) ).append( boardPositions.get( 4 ) ).append( boardPositions.get( 5 ) )
              .toString();
          break;
        case 2:
          line = pattern.append( boardPositions.get( 6 ) ).append( boardPositions.get( 7 ) ).append( boardPositions.get( 8 ) )
              .toString();
          break;
        case 3:
          line = pattern.append( boardPositions.get( 0 ) ).append( boardPositions.get( 3 ) ).append( boardPositions.get( 6 ) )
              .toString();
          break;
        case 4:
          line = pattern.append( boardPositions.get( 1 ) ).append( boardPositions.get( 4 ) ).append( boardPositions.get( 7 ) )
              .toString();
          break;
        case 5:
          line = pattern.append( boardPositions.get( 2 ) ).append( boardPositions.get( 5 ) ).append( boardPositions.get( 8 ) )
              .toString();
          break;
        case 6:
          line = pattern.append( boardPositions.get( 0 ) ).append( boardPositions.get( 4 ) ).append( boardPositions.get( 8 ) )
              .toString();
          break;
        case 7:
          line = pattern.append( boardPositions.get( 2 ) ).append( boardPositions.get( 4 ) ).append( boardPositions.get( 6 ) )
              .toString();
          break;
        default:
          System.out.println( "Something has been wrong. Play again." );
          break;
      }
      if( line.equals( "XXX" ) )
      {
        return "X";
      }
      else if( line.equals( "OOO" ) )
      {
        return "O";
      }
    }
    return null;
  }

  private String checkWinnerForRowAndColumn4( ArrayList<Object> boardPositions, int numerOfRowAndColumn )
  {

    for( int a = 0; a < checkPossibleWinningLines( numerOfRowAndColumn ); a++ )
    {
      String line = null;
      StringBuilder pattern = new StringBuilder();
      switch( a )
      {
        case 0:
          line = pattern.append( boardPositions.get( 0 ) ).append( boardPositions.get( 1 ) ).append( boardPositions.get( 2 ) )
              .append( boardPositions.get( 3 ) ).toString();
          break;
        case 1:
          line = pattern.append( boardPositions.get( 4 ) ).append( boardPositions.get( 5 ) ).append( boardPositions.get( 6 ) )
              .append( boardPositions.get( 7 ) ).toString();
          break;
        case 2:
          line = pattern.append( boardPositions.get( 8 ) ).append( boardPositions.get( 9 ) ).append( boardPositions.get( 10 ) )
              .append( boardPositions.get( 11 ) ).toString();
          break;
        case 3:
          line = pattern.append( boardPositions.get( 12 ) ).append( boardPositions.get( 13 ) )
              .append( boardPositions.get( 14 ) ).append( boardPositions.get( 15 ) ).toString();
          break;
        case 4:
          line = pattern.append( boardPositions.get( 0 ) ).append( boardPositions.get( 4 ) ).append( boardPositions.get( 8 ) )
              .append( boardPositions.get( 12 ) ).toString();
          break;
        case 5:
          line = pattern.append( boardPositions.get( 1 ) ).append( boardPositions.get( 5 ) ).append( boardPositions.get( 9 ) )
              .append( boardPositions.get( 13 ) ).toString();
          break;
        case 6:
          line = pattern.append( boardPositions.get( 2 ) ).append( boardPositions.get( 6 ) ).append( boardPositions.get( 10 ) )
              .append( boardPositions.get( 14 ) ).toString();
          break;
        case 7:
          line = pattern.append( boardPositions.get( 3 ) ).append( boardPositions.get( 7 ) ).append( boardPositions.get( 11 ) )
              .append( boardPositions.get( 15 ) ).toString();
          break;
        case 8:
          line = pattern.append( boardPositions.get( 0 ) ).append( boardPositions.get( 5 ) ).append( boardPositions.get( 10 ) )
              .append( boardPositions.get( 15 ) ).toString();
          break;
        case 9:
          line = pattern.append( boardPositions.get( 3 ) ).append( boardPositions.get( 6 ) ).append( boardPositions.get( 9 ) )
              .append( boardPositions.get( 12 ) ).toString();
          break;
        default:
          System.out.println( "Something has been wrong. Play again." );
          break;
      }
      if( line.equals( "XXXX" ) )
      {
        return "X";
      }
      else if( line.equals( "OOOO" ) )
      {
        return "O";
      }
    }
    return null;
  }

  private String checkWinnerForRowAndColumn5( ArrayList<Object> boardPositions, int numerOfRowAndColumn )
  {
    for( int a = 0; a < checkPossibleWinningLines( numerOfRowAndColumn ); a++ )
    {
      String line = null;
      StringBuilder pattern = new StringBuilder();
      switch( a )
      {
        case 0:
          line = pattern.append( boardPositions.get( 0 ) ).append( boardPositions.get( 1 ) ).append( boardPositions.get( 2 ) )
              .append( boardPositions.get( 3 ) ).append( boardPositions.get( 4 ) ).toString();
          break;
        case 1:
          line = pattern.append( boardPositions.get( 5 ) ).append( boardPositions.get( 6 ) ).append( boardPositions.get( 7 ) )
              .append( boardPositions.get( 8 ) ).append( boardPositions.get( 9 ) ).toString();
          break;
        case 2:
          line = pattern.append( boardPositions.get( 10 ) ).append( boardPositions.get( 11 ) )
              .append( boardPositions.get( 12 ) ).append( boardPositions.get( 13 ) ).append( boardPositions.get( 14 ) )
              .toString();
          break;
        case 3:
          line = pattern.append( boardPositions.get( 15 ) ).append( boardPositions.get( 16 ) )
              .append( boardPositions.get( 17 ) ).append( boardPositions.get( 18 ) ).append( boardPositions.get( 19 ) )
              .toString();
          break;
        case 4:
          line = pattern.append( boardPositions.get( 20 ) ).append( boardPositions.get( 21 ) )
              .append( boardPositions.get( 22 ) ).append( boardPositions.get( 23 ) ).append( boardPositions.get( 24 ) )
              .toString();
          break;
        case 5:
          line = pattern.append( boardPositions.get( 0 ) ).append( boardPositions.get( 1 ) ).append( boardPositions.get( 2 ) )
              .append( boardPositions.get( 3 ) ).append( boardPositions.get( 4 ) ).toString();
          break;
        case 6:
          line = pattern.append( boardPositions.get( 5 ) ).append( boardPositions.get( 6 ) ).append( boardPositions.get( 7 ) )
              .append( boardPositions.get( 8 ) ).append( boardPositions.get( 9 ) ).toString();
          break;
        case 7:
          line = pattern.append( boardPositions.get( 10 ) ).append( boardPositions.get( 11 ) )
              .append( boardPositions.get( 12 ) ).append( boardPositions.get( 13 ) ).append( boardPositions.get( 14 ) )
              .toString();
          break;
        case 8:
          line = pattern.append( boardPositions.get( 15 ) ).append( boardPositions.get( 16 ) )
              .append( boardPositions.get( 17 ) ).append( boardPositions.get( 18 ) ).append( boardPositions.get( 19 ) )
              .toString();
          break;
        case 9:
          line = pattern.append( boardPositions.get( 20 ) ).append( boardPositions.get( 21 ) )
              .append( boardPositions.get( 22 ) ).append( boardPositions.get( 23 ) ).append( boardPositions.get( 24 ) )
              .toString();
          break;
        case 10:
          line = pattern.append( boardPositions.get( 0 ) ).append( boardPositions.get( 6 ) ).append( boardPositions.get( 12 ) )
              .append( boardPositions.get( 18 ) ).append( boardPositions.get( 24 ) ).toString();
          break;
        case 11:
          line = pattern.append( boardPositions.get( 4 ) ).append( boardPositions.get( 8 ) ).append( boardPositions.get( 12 ) )
              .append( boardPositions.get( 16 ) ).append( boardPositions.get( 20 ) ).toString();
          break;
        default:
          System.out.println( "Something has been wrong. Play again." );
          break;
      }
      if( line.equals( "XXXXX" ) )
      {
        return "X";
      }
      else if( line.equals( "OOOOO" ) )
      {
        return "O";
      }
    }
    return null;
  }

  private String checkWinnerForRowAndColumn6( ArrayList<Object> boardPositions, int numerOfRowAndColumn )
  {
    for( int a = 0; a < checkPossibleWinningLines( numerOfRowAndColumn ); a++ )
    {
      String line = null;
      StringBuilder pattern = new StringBuilder();
      switch( a )
      {
        case 0:
          line = pattern.append( boardPositions.get( 0 ) ).append( boardPositions.get( 1 ) ).append( boardPositions.get( 2 ) )
              .append( boardPositions.get( 3 ) ).append( boardPositions.get( 4 ) ).append( boardPositions.get( 5 ) ).toString();
          break;
        case 1:
          line = pattern.append( boardPositions.get( 6 ) ).append( boardPositions.get( 7 ) ).append( boardPositions.get( 8 ) )
              .append( boardPositions.get( 9 ) ).append( boardPositions.get( 10 ) ).append( boardPositions.get( 11 ) )
              .toString();
          break;
        case 2:
          line = pattern.append( boardPositions.get( 12 ) ).append( boardPositions.get( 13 ) )
              .append( boardPositions.get( 14 ) ).append( boardPositions.get( 15 ) ).append( boardPositions.get( 16 ) )
              .append( boardPositions.get( 17 ) ).toString();
          break;
        case 3:
          line = pattern.append( boardPositions.get( 18 ) ).append( boardPositions.get( 19 ) )
              .append( boardPositions.get( 20 ) ).append( boardPositions.get( 21 ) ).append( boardPositions.get( 22 ) )
              .append( boardPositions.get( 23 ) ).toString();
          break;
        case 4:
          line = pattern.append( boardPositions.get( 24 ) ).append( boardPositions.get( 25 ) )
              .append( boardPositions.get( 26 ) ).append( boardPositions.get( 27 ) ).append( boardPositions.get( 28 ) )
              .append( boardPositions.get( 29 ) ).toString();
          break;
        case 5:
          line = pattern.append( boardPositions.get( 30 ) ).append( boardPositions.get( 31 ) )
              .append( boardPositions.get( 32 ) ).append( boardPositions.get( 33 ) ).append( boardPositions.get( 34 ) )
              .append( boardPositions.get( 35 ) ).toString();
          break;
        case 6:
          line = pattern.append( boardPositions.get( 0 ) ).append( boardPositions.get( 6 ) ).append( boardPositions.get( 12 ) )
              .append( boardPositions.get( 18 ) ).append( boardPositions.get( 24 ) ).append( boardPositions.get( 30 ) )
              .toString();
          break;
        case 7:
          line = pattern.append( boardPositions.get( 1 ) ).append( boardPositions.get( 7 ) ).append( boardPositions.get( 13 ) )
              .append( boardPositions.get( 19 ) ).append( boardPositions.get( 25 ) ).append( boardPositions.get( 31 ) )
              .toString();
          break;
        case 8:
          line = pattern.append( boardPositions.get( 2 ) ).append( boardPositions.get( 8 ) ).append( boardPositions.get( 14 ) )
              .append( boardPositions.get( 20 ) ).append( boardPositions.get( 26 ) ).append( boardPositions.get( 32 ) )
              .toString();
          break;
        case 9:
          line = pattern.append( boardPositions.get( 3 ) ).append( boardPositions.get( 9 ) ).append( boardPositions.get( 15 ) )
              .append( boardPositions.get( 21 ) ).append( boardPositions.get( 27 ) ).append( boardPositions.get( 33 ) )
              .toString();
          break;
        case 10:
          line = pattern.append( boardPositions.get( 4 ) ).append( boardPositions.get( 10 ) ).append( boardPositions.get( 16 ) )
              .append( boardPositions.get( 22 ) ).append( boardPositions.get( 28 ) ).append( boardPositions.get( 34 ) )
              .toString();
          break;
        case 11:
          line = pattern.append( boardPositions.get( 21 ) ).append( boardPositions.get( 22 ) )
              .append( boardPositions.get( 23 ) ).append( boardPositions.get( 24 ) ).append( boardPositions.get( 29 ) )
              .append( boardPositions.get( 35 ) ).toString();
          break;
        case 12:
          line = pattern.append( boardPositions.get( 0 ) ).append( boardPositions.get( 7 ) ).append( boardPositions.get( 14 ) )
              .append( boardPositions.get( 21 ) ).append( boardPositions.get( 28 ) ).append( boardPositions.get( 35 ) )
              .toString();
          break;
        case 13:
          line = pattern.append( boardPositions.get( 5 ) ).append( boardPositions.get( 10 ) ).append( boardPositions.get( 15 ) )
              .append( boardPositions.get( 20 ) ).append( boardPositions.get( 25 ) ).append( boardPositions.get( 30 ) )
              .toString();
          break;
        default:
          System.out.println( "Something has been wrong. Play again." );
          break;
      }
      if( line.equals( "XXXXXX" ) )
      {
        return "X";
      }
      else if( line.equals( "OOOOOO" ) )
      {
        return "O";
      }
    }
    return null;
  }

  private Integer checkPossibleWinningLines( int numerOfRowAndColumn )
  {
    return ( numerOfRowAndColumn * 2 ) + 2;
  }

}
