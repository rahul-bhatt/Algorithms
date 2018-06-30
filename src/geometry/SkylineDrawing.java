/**
 * 
 */
package geometry;

/**
 * @author rahulbhatt
 *
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. 
 * Now suppose you are given the locations and height of all the buildings, 
 * write a program to output the skyline formed by these buildings collectively.
 * 
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], 
 * where Li and Ri are the x coordinates of the left and right edge of the the building, respectively, 
 * and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. 
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 * 
 * The output is a list of "key points" in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. 
 * A key point is the left endpoint of a horizontal line segment. 
 * Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, 
 * and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
 * 
 * 
 *       E****
 * 		 *	 *				E********
 * 		 *	*E*******		*		*
 * 		 *	*		*		*		*
 * 	   E********	*		*	****E****
 * 	   *	*  *	*		*	*	*	*
 * 	   *	*  *	*		*	*	*	*
 * 	   *	*  *	*		*	*	*	*
 * 	   *	*  *	*		*	*	*	*
 * 	   *	*  *	E		*	*	*	E
 * ******************************************************
 */
public class SkylineDrawing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
