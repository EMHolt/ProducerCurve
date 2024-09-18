/*
 * @authors Braden Samson, Emma Holt, Ian McGinness
 * Date: September 2024
 * Description: An Abstract Curve that can be extended to create
 * curves such as a Producer Curve or a Consumer Curve.
 */

package phaseTwo;

import java.util.ArrayList;

public abstract class AbstractCurve {
	
	private final ArrayList<Point> myCurve;
	
	/*
	 * Creates a curve with a size set by "n" and with a
	 * linear slope based on the "dX" and "dY" parameters
	 *
	 * @param startPoint: the point which the curve starts
	 * @param n:          number of points on the curve
	 * @param dx:         change in x value
	 * @param dy:         change in y value
	 */
	public AbstractCurve(Point startPoint, int n, int dX, double dY) {
		myCurve = new ArrayList<Point>();
		
		myCurve.add(startPoint);
		
		for (int i = 1; i <= n; i++) {
			myCurve.add(new Point((dX * i) + startPoint.getQuantity(), (dY * i) + startPoint.getPrice()));
		}
	}

	/*
	 * Creates a basic linear curve with a slope of one
	 */
	public AbstractCurve() {
		myCurve = new ArrayList<Point>();

		for (int i = 1; i <= 10; i++) {
            myCurve.add(new Point(i, (double) i));
		}
	}

	/*
	 * Adds a point to the curve in the correct spot based
	 * on the points quantity, if the point already is on
	 *
	 * @param p: the point that will be added to the curve
	 */
	public boolean add(Point p) {
		if (contains(p)) {
			return false;
		}

		int low = 0;
		int mid;
		int high = myCurve.size();

		while (low < high) {
			mid = low + (high - low) / 2;

			if (myCurve.get(mid).getQuantity() < p.getQuantity()) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		myCurve.add(low, p);
		return true;
	}

	/*
	 * Returns the index of where a point is on the curve
	 *
	 * @param p: the point that will be checked if on the curve
	 */
	private int getPointIndex(Point p) {
		int index = -1;
		int low = 0;
		int mid;
		int high = myCurve.size() - 1;
		
		while (low <= high) {
			mid = low + (high - low) / 2;

			if (myCurve.get(mid).getQuantity() == p.getQuantity()) {
				index = mid;
				break;
			}
			
			if (myCurve.get(mid).getQuantity() < p.getQuantity()) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		if (index != -1 && !myCurve.get(index).equals(p)) {
			index = -1;
		}

		return index;
	}

	/*
	 * Returns true or false if the point that is passed
	 * through is on the curve
	 *
	 * @param p: the point that will be checked
	 */
	public boolean contains(Point p) {
		return getPointIndex(p) != -1;
	}

	/*
	 * Removes a point if it is on the curve
	 *
	 * @param p: the point that will be removed
	 */
	public boolean remove(Point p) {
		int index = getPointIndex(p);

		if (index == -1) {
			return false;
		}

		myCurve.remove(index);
		
		return true;
	}
	
	/*
	 * Returns a string with all the points values in an "ordered pair"
	 */
	@Override
	public String toString() {
		String str = "(";
		
		for (Point p : myCurve) {
			str = str.concat(p.toString() + " ");
		}
		
		return str.concat(")");
	}
	
	public abstract void sort();
}
