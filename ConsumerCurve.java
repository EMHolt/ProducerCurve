package firstPackage;

import java.util.ArrayList;

/**
 * Name: Emma Holt, Ian McGinness, Braden Samson
 * Date: September 2024
 * Hour: 3rd hour AP CSA
 * Description: ConsumerCurve creates an ArrayList of points. The user can choose
 * the slope of the line, the starting point, and the number of points. It can return
 * whether or not a given point is on the curve. The user can add points 
 * or remove them.
 */
public class ConsumerCurve {
	
	private ArrayList<Point> cCurve; 
	
	/**
	 * Creates a basic ArrayList of ten points, starting at (1,1.0)
	 * with a slope of 1. It is a linear function.
	 */
	public ConsumerCurve()
	{
		cCurve = new ArrayList<>();
		
		for(int i = 1; i <= 10; i++)
		{
			Point point = new Point (i, (double) i);
			cCurve.add(point);
		}
	}
	
	/**
	 * Precondition: cCurve is a linear function, so
	 * 	the slope between each two points will be the same.
	 * @param deltaX: change in each x value
	 * @param deltaY: change in each y value
	 * @param startQuantity: start x value
	 * @param startPrice: start y value
	 * @param n: number of points
	 */
	public ConsumerCurve(int deltaX, double deltaY, int startQuantity, double startPrice, int n)
	{
		int j = 0;
		double k = 0.0;
		cCurve = new ArrayList<>();
		Point point = new Point();
		for(int i = 1; i <= n; i++)
		{
			cCurve.add(point);
		}
		Point firstPoint = new Point (startQuantity, startPrice);
		cCurve.set(0, firstPoint);
		for(int i = 1; i < n; i++)
		{
			j = j + deltaX;
			k = k + deltaY;
			int x = startQuantity + j;
			double y = startPrice + k;
			cCurve.set(i, new Point(x,y));
		}
	}

	/**
	 * Prints the points on the curve.
	 */
	public String toString() 
	{
		String str1 = "{" ;
		for(Point p: cCurve) {
			str1 = str1.concat(p.toString());
		}
		str1 = str1.concat("}");
		return str1;
	}

	/**
	 * Precondition: There are valid points already in the ArrayList.
	 * Post condition: There will be another point in the ArrayList in 
	 * 	it's sorted value from least to greatest quantity.
	 * If the quantity of the added point is already in the ArrayList,
	 * 	the point added will replace the already existing point in the
	 * 	ArrayList.
	 * @param p
	 * @return
	 */
	public boolean add(Point p)
	{
		if(p.getQuantity() < 1 || p.getPrice() <= 0) return false;
		if(searchQuantity(p) > -1)
		{
			for(int i = 0; i < cCurve.size(); i++)
			{
				if(searchQuantity(p) == i)
				{
					cCurve.set(i, p);
				}
			}
		}
		else
		{
			int insertIndex = -1;
			for(int i = 0; i<cCurve.size(); i++)
			{
				if(p.getQuantity() < cCurve.get(i).getQuantity())
				{
					insertIndex = i;
					break;
				}
				insertIndex = i + 1;
			}
			cCurve.add(insertIndex, p);
		}
		return true;
	}

	/**
	 * Precondition: there are valid points already in the ArrayList.
	 * Post Condition: It removes a specified point from the ArrayList
	 * 	and the slot it was in.
	 * @param p
	 * @return
	 */
	public boolean remove(Point p) 
	{
		int indexFound = searchIndex(p);
		if (indexFound == -1) return false;
		for(int i = 0; i<cCurve.size(); i++)
		{
			Point pC = cCurve.get(i);
			if(pC.equals(p) == true)
			{
				cCurve.remove(i);
				i--;
			}
		}
		return true;
	}
	
	/**
	 * Precondition: there are valid points in the ArrayList.
	 * Post Condition: It returns false if the result of searchIndex is
	 * 	less than 0, otherwise it returns true.
	 * @param p
	 * @return
	 */
	public boolean isOnCurve(Point p)
	{
		int index = searchIndex(p);
		if (index < 0) return false;
		else return true;
	}
	
	/** 
	 * searchIndex returns the index of the Point on cCurve that matches the 
	 * given parameter.
	 * Precondition: cCurve has valid points & parameter not null.
	 * Post condition: returns index or -1 if not found.
	 */
	private int searchIndex(Point p)
	{
		int index = -1;
		for (int i = 0; i<cCurve.size(); i++)
		{
			Point pC = cCurve.get(i);
			if(pC.equals(p) == true)
			{
				index = i;
			}
		}
		return index;
	}
	
	/** 
	 * searchQuantity returns the index of the quantity on cCurve that matches the 
	 * given parameter.
	 * Precondition: cCurve has valid points & parameter not null.
	 * Post condition: returns index the quantity is found in or -1 if not found.
	 */
	private int searchQuantity(Point p)
	{
		int qIndex = -1;
		for(int i = 0; i<cCurve.size(); i++)
		{
			Point pC = cCurve.get(i);
			if(pC.getQuantity() == p.getQuantity())
			{
				qIndex = i;
			}
		}
		return qIndex;
	}
}
	
