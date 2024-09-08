package firstPackage;
/**
 * @author EMHolt
 * Date: September 2024
 * Hour: 3rd Hour AP CSA
 * Description: TestProducerCurve prints all public methods
 * in ProducerCurve.  
 */

public class TestProducerCurve {
	public static void main(String[] args) {
		
		/**
		 * Tests the basic constructor method
		 */
		ProducerCurve pCurve1 = new ProducerCurve();
		System.out.println(pCurve1.toString());

		/**
		 * Takes certain requirements (slope, start quanities, and numbe of points)
		 * and creates an array.
		 */
		ProducerCurve pCurve2 = new ProducerCurve(-0.125,5,7.5,10);
		System.out.println(pCurve2.toString());
		
		/**
		 * Adds a new point
		 */
		Point newPoint = new Point(5, 5.5);
		pCurve2.add(newPoint);
		System.out.println(pCurve2.toString());

		/**
		 * removes the new point
		 */
		Point removePoint = new Point (5, 9.5);
		pCurve2.remove(removePoint);
		System.out.println(pCurve2.toString());

		/**
		 * should return false; it is not on the curve
		 */
		Point fTest = new Point (11,1.0);
		System.out.println(pCurve2.isOnCurve(fTest));
		
		/**
		 * should return true; is on curve
		 */
		Point tTest = new Point (13, 6.5);
		System.out.println(pCurve2.isOnCurve(tTest));

   }
}