package pixLab.classes;
public class IntArrayWorker
{
  /** two dimensional matrix */
  private int[][] matrix = null;
  
  /** set the matrix to the passed one
    * @param theMatrix the one to use
    */
  public void setMatrix(int[][] theMatrix)
  {
    matrix = theMatrix;
  }
  
  /**
   * Method to return the total 
   * @return the total of the values in the array
   */
  public int getTotal()
  {
    int total = 0;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        total = total + matrix[row][col];
      }
    }
    return total;
  }
  
public  int getCount(int numberToFind)
{
	int count =0;
	
	for(int [] row : matrix)
	{
		for (int item : row)
		{
			if(item == numberToFind)
			{
				count++;
			}
		}
	}
	
	return count;
}

/**


  public int getTotalNested() //cant change a 2D array in a for each loop
  {
    int total = 0;
    for (int[] rowArray : matrix) //for each array called int array in the matrix I add to the total. Array is in outerloop.
    {
      for (int item : rowArray)    //can only take value out of the row not the matrix. 
      {
        total = total + item;
      }
    }
    return total;
  }
  
  /**
   * Method to fill with an increasing count
   */
  public void fillCount()
  {
    int numCols = matrix[0].length;
    int count = 1;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < numCols; col++)
      {
        matrix[row][col] = count;
        count++;
      }
    }
  }
  
  /**
   * print the values in the array in rows and columns
   */
  public void print()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        System.out.print( matrix[row][col] + " " );
      }
      System.out.println();
    }
    System.out.println();
  }
  
  
  /** 
   * fill the array with a pattern
   */
  public void fillPattern1()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; 
           col++)
      {
        if (row < col)
          matrix[row][col] = 1;
        else if (row == col)
          matrix[row][col] = 2;
        else
          matrix[row][col] = 3;
      }
    }
  }

public int getTotalNested() {

	return 0;
}

public int getLargest() 
{
	int largest = Integer.MIN_VALUE;
	for (int col =0; col < matrix[0].length; col++ )
	{
		for (int row = 0; row <matrix.length; row++)
		{
			if(matrix[row][col] > largest) //row is always the first parameter in an array address.
			{
				largest = matrix[row][col];
			}
		}
	}
	
	return largest;
}

public int getColTotal(int column)
{
	int total =0;
	
	for  (int row = 0; row < matrix.length; row++) //if given a parameter use it in the code
	{
		total += matrix[row][column];
	}
	return total;
	
}
 
}