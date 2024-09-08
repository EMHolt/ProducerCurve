package firstPackage;

/**
 * @author Emma Holt
 * Date: September2024
 * Hour: 3rd Hour APCSA
 * Description: ProducerCurve creates an array of points. It can return
 * the slope of the line, the starting points, the number of points in the array,
 * and whether or not a given point is on the curve. The user can add points 
 * or remove them.
 */
public class ProducerCurve {
	
	public Point[] pCurve;
	
	/**
	 * Creates an array of points.
	 * The basic pCurve produces 10 linear points
	 */
	public ProducerCurve() 
	{
		pCurve = new Point[10];
		
		double y = 10.00;
		
		for(int i = 0; i<10; i++)
		{
			pCurve[i] = new Point(i+1,y);
			y--;
		}
	}
	
	
	/**
	 * Precondition: pCurve is a linear function, so
	 * 	the slope between each two points will be the same.
	 * @param m: this is the slope of the line
	 * @param startQuantity: first point x value
	 * @param startPrice: first point y value
	 * @param n: how many points on the curve
	 */
	public ProducerCurve(double m, int startQuantity, double startPrice, int n)
	{ 
		pCurve = new Point[n];
		pCurve[0] = new Point (startQuantity, startPrice);
		for(int i = 1; i<n; i++)
		{
			int x = startQuantity + i;
			double y = startPrice + m*(x-startQuantity);
			pCurve[i] = new Point (x,y);
		}
	}
	
	
	/**
	 * Prints the points on the curve.
	 */
	public String toString() 
	{
		String str1 = "{" ;
				for(Point p: pCurve) {
					str1 = str1.concat(p.toString());
				}
				str1 = str1.concat("}");
				return str1;
	}
	
	/**
	 * Precondition: There are valid points already in the array.
	 * Post condition: There will be another point in the array in 
	 * 	it's sorted value from least to greatest quantity.
	 * @param p
	 * @return
	 */
	public boolean add(Point p) {
		
		if(p.getQuantity() < 1 || p.getPrice() < 1) return false;
		int n = pCurve.length;
		Point [] tArray = new Point [pCurve.length +1];
		
		for(int i = 0; i<pCurve.length; i++) 
		{
		    tArray[i] = pCurve[i];
		}
		
		tArray[n] = p;
		pCurve = tArray;
		sortIndex();
		return true;
	}
	
	/**
	 * Precondition: there are valid points already in the array.
	 * Post Condition: It removes a specified point from the array
	 * 	and the slot it was in.
	 * @param p
	 * @return
	 */
	public boolean remove (Point p) {
		int indexFound = searchIndex(p); 
		if (indexFound == -1) return false;
		
		Point [] tArray = new Point [pCurve.length -1];
		
		for (int i = 0; i<indexFound; i++) {
			tArray [i] = pCurve [i];
		}
		for (int i = indexFound; i<tArray.length; i++) {
			tArray [i] = pCurve [i+1];
		}
		
		pCurve = tArray;
		return true;
	}
	
	/**
	 * Precondition: there are valid points in the array.
	 * Post Condition: It returns false if the result of searchIndex is
	 * 	less than 0, otherwise it returns true.
	 * @param p
	 * @return
	 */
	public boolean isOnCurve (Point p) //return true or false
	{
		int index = searchIndex(p);
		if (index < 0) return false;
		else return true;
	}
	
	/**
	 * Precondition: pCurve is an array of valid points.
	 * Post condition: pCurve will be a sorted array of points from least 
	 * 	value of quantity to most.
	 */
	private void sortIndex() {
		for(int x=0; x<pCurve.length; x++)
	      {
	           for(int leftHandIndex = 0; leftHandIndex<pCurve.length - 1; leftHandIndex++)
	           {
	                int rightHandIndex = 1 + leftHandIndex;
	           if(pCurve[leftHandIndex].getQuantity()  
	                     > pCurve[rightHandIndex].getQuantity())
	           {
	               Point t                  = pCurve[leftHandIndex];
	               pCurve[leftHandIndex]    = pCurve[rightHandIndex];
	               pCurve[rightHandIndex]   = t;
	           }
	        }
	      }
	}
	
	/** 
	 * searchIndex returns the index of the Point on pCurve that matches the 
	 * given parameter.
	 * Precondition: pCurve has valid points & parameter not null.
	 * Post condition: returns index or -1 if not found.
	 */
	private int searchIndex(Point p) //return slot number or if not in index return -1
	{
		int index = -1;
		for (int i = 0; i<pCurve.length; i++)
		{
			if (p.equals(pCurve[i]))
			{
				index = i;
			}
		}
		return index;
	}
	
}
