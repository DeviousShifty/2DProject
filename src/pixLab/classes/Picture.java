
package pixLab.classes;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */

public class Picture extends SimplePicture 
{
  private static final SimplePicture replacement = null;




///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
 * @param pixel 
   */
  public Picture (Pixel pixel)
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  public void zeroRed()
  {
	  Pixel [][] pixels = this.getPixels2D();
	  for (Pixel [] row : pixels)
	  {
		  for(Pixel pix : row)
		  {
			  pix.setRed(0);
		  }
	  }
  }
  
  public void hidePicture(Picture hidden)
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel[][] hiddenPixels = hidden.getPixels2D();
	  
	  for(int row = 0; row < pixels.length && row < hiddenPixels.length; row++)
	  {
		  for(int col = 0; col < pixels[0].length && col < hiddenPixels[0].length; col++)
		  {
			  if(hiddenPixels[row][col].colorDistance(Color.WHITE)> 5)
			  {
				  if(pixels[row][col].getRed() > 0 && pixels [row][col].getRed()% 2 !=1)
				  {
					  pixels[row][col].setRed(pixels[row][col].getRed() -1);
				  }
				  
			  }
			  else if (pixels[row][col].getRed() > 0 && pixels[row][col].getRed() %2 ==1)
			  {
				  pixels[row][col].setRed(pixels[row][col].getRed() -1);
			  }
		  }
	  }
  }
  
  
  
  public void revealPicture()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for(int col = 0; col < pixels[0].length; col++)
		  {
			  if (pixels[row][col].getRed() > 0 && pixels[row][col].getRed() % 2 !=1)
			  {
				  pixels[row][col].setColor(Color.CYAN);
			  }
			  else if(pixels[row][col].getRed() > 0 && pixels[row][col].getRed() % 2 ==1)
			  {
				  pixels[row][col].setColor(Color.MAGENTA);
			  }
		  }
	  }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorHorizontal()
  {
	  Pixel [][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  int height = pixels.length;
	  for (int row = 0; row < pixels[0].length; row++)
	    {
	      for (int col = 0; col < height / 2; col++)
	      {
	        topPixel = pixels[row][col];
	        bottomPixel = pixels[row][height - 1 - col];
	        bottomPixel.setColor(topPixel.getColor());
	      }
	    } 
	  }
	  
  public void mirrorVerticalRTol()
  {
	  
  }
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  public void mirrorGull()
  {
  int mirrorPoint = 276;
  Pixel leftPixel = null;
  Pixel rightPixel = null;
  int count = 0;
  Pixel[][] pixels = this.getPixels2D();
  
  // loop through the rows
  for (int row = 27; row < 97; row++)
  {
    // loop from 13 to just before the mirror point
    for (int col = 13; col < mirrorPoint; col++)
    {
      
      leftPixel = pixels[row][col];      
      rightPixel = pixels[row]                       
                       [mirrorPoint - col + mirrorPoint];
      rightPixel.setColor(leftPixel.getColor());
    }
  }
}
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("widowmaker.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }

  public void shiftLeftRight(int amount)
  {
	  Pixel[][] pixels = this.getPixels2D();
	 Picture temp = new Picture(this);
	 Pixel [][] copied = temp.getPixels2D();
	 
	 int shiftedValue = amount;
	 int width = pixels[0].length;
	 
	 for(int row = 0; row < pixels.length; row++)
	 {
		 for(int col = 0; col < pixels[0].length; col++)
		 {
			 shiftedValue = (col + amount) % width;
			if(amount < 0)
			{
				shiftedValue = ((col + amount)% width + width) % width;
			}
			 copied[row][col].setColor(pixels[row][shiftedValue].getColor());
		 }
	 }
		for (int row = 0; row < pixels.length; row++)	 
		{
			for(int col = 0; col < pixels[0].length; col++)
			{
				pixels[row][col].setColor(copied[row][col].getColor());
			}
		}
  }
  
  public void shiftUpDown(int amount)
  {
	  Pixel[][] pixels = this.getPixels2D();
	 Picture temp = new Picture(this);
	 Pixel [][] copied = temp.getPixels2D();
	 
	 int shiftedValue = amount;
	 int height = pixels[0].length;
	 
	 for(int row = 0; row < pixels.length; row++)
	 {
		 for(int col = 0; col < pixels[0].length; col++)
		 {
			 shiftedValue = (col + amount) % height;
			 copied[row][col].setColor(pixels[row][shiftedValue].getColor());
		 }
	 }
		for (int row = 0; row < pixels.length; row++)	 
		{
			for(int col = 0; col < pixels[0].length; col++)
			{
				pixels[row][col].setColor(copied[row][col].getColor());
			}
		}
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  public static void testZeroRed()
  {
	  Picture arch = new Picture("arch.jpg");
	  arch.explore();
	  arch.zeroRed();
	  arch.explore();
  }
 
  /** Method to test mirrorVertical */
  public void glitchify()
  {
	  {
		  Pixel[][] pixels = this.getPixels2D();
		 Picture temp = new Picture(this);
		 Pixel [][] copied = temp.getPixels2D();
		 
		 int amount = 250;
		int shiftedValue = amount;
		 int height = pixels[0].length;
		 
		 for(int row = 0; row < pixels.length; row++)
		 {
			 for(int col = 0; col < pixels[0].length; col++)
			 {
				 shiftedValue = (col + amount) % height;
				 copied[row][col].setColor(pixels[row][shiftedValue].getColor());
			 }
		 }
			for (int row = 0; row < pixels.length; row++)	 
			{
				for(int col = 0; col < pixels[0].length; col++)
				{
					pixels[row][col].setColor(copied[row][col].getColor());
				}
			}
	  }//shift up down
	  {
		  Pixel[][] pixels = this.getPixels2D();
		 Picture temp = new Picture(this);
		 Pixel [][] copied = temp.getPixels2D();
		 
		 int amount = 250;
		int shiftedValue = amount;
		 int width = pixels[0].length;
		 
		 for(int row = 0; row < pixels.length; row++)
		 {
			 for(int col = 0; col < pixels[0].length; col++)
			 {
				 shiftedValue = (col + amount) % width;
				if(amount < 0)
				{
					shiftedValue = ((col + amount)% width + width) % width;
				}
				 copied[row][col].setColor(pixels[row][shiftedValue].getColor());
			 }
		 }
			for (int row = 0; row < pixels.length; row++)	 
			{
				for(int col = 0; col < pixels[0].length; col++)
				{
					pixels[row][col].setColor(copied[row][col].getColor());
				}
			}
	  } //shift left right
	  {
		  Pixel [][] pixels = this.getPixels2D();
		  Pixel topPixel = null;
		  Pixel bottomPixel = null;
		  int height = pixels.length;
		  for (int row = 0; row < pixels[0].length; row++)
		    {
		      for (int col = 0; col < height / 2; col++)
		      {
		        topPixel = pixels[row][col];
		        bottomPixel = pixels[row][height - 1 - col];
		        bottomPixel.setColor(topPixel.getColor());
		      }
		    } 
		  } //mirror horizontal
	  
		    Picture vulcan = new Picture("vulcan.jpg");
		    Picture widowmaker = new Picture("widowmaker.jpg");
		    this.copy(vulcan,800,800);
		    this.copy(widowmaker,900,900);
		    this.copy(vulcan,200,500);
		    Picture vulcanNoBlue = new Picture(widowmaker);
		    vulcanNoBlue.zeroBlue();
		    this.copy(vulcanNoBlue,300,800);
		    this.copy(vulcan,400,800);
		    this.copy(widowmaker,500,800);
		    this.mirrorVertical();
		    this.write("widowmaker.jpg");}
		  //collage
		    
		    	public void chromakey(Picture replacement, Color changeColor)
		    	{
		    		Pixel [][] mainPixels = this.getPixels2D();
		    		Pixel[][] replacementPixels = replacement.getPixels2D();
		    		
		    		for(int row = 0; row < mainPixels.length; row++)
		    		{
		    			for (int col = 0; col < mainPixels[0].length; col++)
		    		{
		    		if(mainPixels[row][col].colorDistance(changeColor)<10)
		    		{
		    			mainPixels[row][col].setColor(replacementPixels[row][col].getColor());
		    		}
		    		}
		    		}
		    	}

		    
		    
		    
  

private void randomize(int randomRow, int endRow, int randomCol, int endCol) 
{
	
	
}

	

  
//public void chromakey(Picture replacement, Color changeColor)
{
//	Pixel [][] mainPixels = this.getPixels2D();
//	Pixel[][] replacementPixels = replacement.getPixels2D();
	
//	for(int row = 0; row < mainPixels.length; row++)
//	{
//		for (int col = 0; col < mainPixels[0].length; col++)
//	{
//	if(mainPixels[row][col].colorDistance(changeColor)<10)
//	{
//		mainPixels[row][col].setColor(replacementPixels[row][col].getColor());
//	}
//	}
//	}
}


}







