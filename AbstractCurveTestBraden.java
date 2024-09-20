/*
 * @authors Emma Holt, Ian McGinness, Braden Samson
 * Date: September 2024
 * Description: Tests the AbstractCurve class
 */

package phaseTwo;

public class AbstractCurveTest extends AbstractCurve {
	// left empty because not in use!
    public void sort() {

    }
    
    public AbstractCurveTest() {
    	//super(); // basic curve with 10 points and a slope of 1
    	
    	super(20, new Point(5, 20), 2, 4); // creates a curve with 20 points and a start point at (5, 20)
    	  							       // and with a x slope of 2 and a y slope of 4
    }
    
    public static void main(String[] args) {
    	AbstractCurveTest tester = new AbstractCurveTest();

    	tester.add(new Point(7, 8.0)); // replace
        //tester.add(new Point(11, 15.0)); // add new point at correct index in the curve

        System.out.println(tester.isOnCurve(new Point(7, 8.0))); // is on the curve
        System.out.println(tester.isOnCurve(new Point(99, 23.0))); // NOT on the curve

        System.out.println(tester.toString());

        tester.remove(new Point(7, 8.0)); // added point

    	System.out.println(tester.toString());
    }
}
