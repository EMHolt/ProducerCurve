package firstPackage;

/**
 * Name: Emma Holt
 * Date: September 2024
 * Hour: 3rd Hour AP CSA
 * Description: Tests all public methods in ConsumerCurve
 */
public class TestConsumerCurve {
	public static void main(String[] args) {
		
		/**
		 * Tests basic constructor method.
		 */
		ConsumerCurve cCurve1 = new ConsumerCurve();
		System.out.println("basic curve" + cCurve1.toString());
		
		/**
		 * Takes certain requirements (slope (deltaX, deltaY), startQuantity, 
		 * 	startPrice, and number of points) and creates an ArrayList.
		 */
		ConsumerCurve cCurve2 = new ConsumerCurve(10, 5, 6, 5.0, 10);
		System.out.println("new curve" + cCurve2.toString());
		
		/**
		 * Adds a new point, since the quantity is the same as an already existing
		 * 	point the new point will replace the already existing point.
		 */
		Point addPoint = new Point(6, 6.9);
		cCurve2.add(addPoint);
		System.out.println("replaced point" + cCurve2.toString());
		
		/**
		 * Adds a new point.
		 */
		Point addPoint2 = new Point (60, 46.9);
		cCurve2.add(addPoint2);
		System.out.println("new point" + cCurve2.toString());
		
		/**
		 * Removes a point and its slot from the ArrayList.
		 */
		Point removePoint = new Point (46, 25.0);
		cCurve2.remove(removePoint);
		System.out.println("removed point" + cCurve2.toString());

		/**
		 * Should return false; the point is not in the ArrayList.
		 */
		Point fTest = new Point (11,1.0);
		System.out.println(cCurve2.isOnCurve(fTest));
		
		/**
		 * Should return true; the point is in the ArrayList.
		 */
		Point tTest = new Point (26, 15.0);
		System.out.println(cCurve2.isOnCurve(tTest));
		
	}
}
