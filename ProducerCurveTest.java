package phase2;

/**
 * @authors Emma Holt, Ian McGinness, Braden Samson
 * Date: September 2024
 * Hour: 3rd AP CSA
 * Description: Tests the ProducerCurve.
 */

public class ProducerCurveTest extends ProducerCurve {
	
	/**
	 * creates the curve to be tested
	 */
	public ProducerCurveTest() {
    	super(20, new Point(5, 20), 2, 4); 
    }
 
public static void main(String[] args) {

	/**
	 * prints the curve
	 */
	ProducerCurveTest basicTester = new ProducerCurveTest();
	System.out.println("starter" + basicTester.toString());
	
	/**
	 * adds a (valid) point and sorts it into the correct (descending) index
	 */
	basicTester.add(new Point(20, 8.0));
	basicTester.sort();
	System.out.println("new point" + basicTester.toString());
	
	/**
	 * adds a not valid point (it does not actually add it) 
	 */
	basicTester.add(new Point(-3, 9.0));
	System.out.println("new (failed) point" + basicTester.toString());

	/**
	 * should return true
	 */
	System.out.println(basicTester.contains(new Point(20, 8.0))); 
	
	/**
	 * should return false
	 */
    System.out.println(basicTester.contains(new Point(99, 23.0))); 
    
    /**
     * removes the previously added point
     */
    basicTester.remove(new Point(20, 8.0));
	System.out.println(basicTester.toString());
}

}
