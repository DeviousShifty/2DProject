package pixLab.classes;

import java.awt.Color;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture mountains = new Picture("mountains.jpg");
    mountains.explore();
    mountains.zeroBlue();
    mountains.explore();
  }
 
  public static void testSteganography()
  {
	  Picture source = new Picture("widowmaker.jpg");
	  Picture message = new Picture("illusion.jpg");
	  source.explore();
	  message.explore();
	  source.hidePicture(message);
	  source.explore();
	  source.revealPicture();
	  source.explore();
  }
	
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture vulcan = new Picture("vulcan.jpg");
    vulcan.explore();
   vulcan.mirrorVertical();
    vulcan.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  public static void testMirrorGull()
  {
	  Picture seagull = new Picture("seagull.jpg");
	  seagull.explore();
	  seagull.mirrorVertical();
	  seagull.explore();
	  seagull.mirrorHorizontal();
	  
 }
  public static void testGlitchify()
  {
	  Picture glitched = new Picture("vulcan.jpg");
	  glitched.explore();
	  glitched.glitchify();
	  glitched.explore();
  }

  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
   // testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
	 // testGlitchify();
	//  testChromakey();
	  //testGlitch();
	 // testSteganography();
	  testshiftLeftRight();
	 // testshiftUpDown();
  }
  public static void testGlitch() 
  {
	  Picture source = new Picture("vulcan.jpg");
	  source.explore();
	  source.explore();
	  source.glitch();
  }
	
  public static void testshiftLeftRight()
	{
	  Picture mountains = new Picture("mountains.jpg");
	  mountains.explore();
	  mountains.shiftLeftRight(500);
	  mountains.explore();
	  mountains.shiftLeftRight(500);
	}
  public static void testshiftUpDown()
  {
	  Picture vulcan = new Picture("vulcan.jpg");
	  vulcan.explore();
	  vulcan.shiftUpDown(500);
	  vulcan.explore();
	  vulcan.shiftUpDown(500);
  }
 

  
  
public static void testChromakey()
  {
	  Picture source = new Picture("vulcan.jpg");
	  Picture background = new Picture("agera.jpg");
	  source.explore();
	  background.explore();
	  source.chromakey(background, new Color(215, 200, 212));
	  source.explore();
  }
  
}