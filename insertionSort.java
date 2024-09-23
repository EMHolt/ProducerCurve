	/**
	 * Sorts the Points in an array using insertion sort
	 * @param pCurve
	 */
	public static void insertionSort(Point[] pCurve) 
	{    
		int l = pCurve.length;
		
        for (int j=1; j<l; j++)
        {  
            Point current = pCurve[j];  
            int i = j-1;  
            
            while ((i > -1) && (pCurve[i].getQuantity() > current.getQuantity())) 
            {  
                pCurve[i+1] = pCurve[i];  
                i--;
            }
            pCurve[i+1] = current;
        }
    }
	
	/**
	 * tests the insertion sort
	 */
	Point p1 = new Point(3,3.0);
    Point p2 = new Point(1,1.0);
	Point p3 = new Point(2,2.0);
	 
    Point[] pArray = new Point[]{p1,p2,p3};  
	 
    System.out.println("Before");    
    for(Point i:pArray){    
    	System.out.print(i+" ");    
    }    
    System.out.println();    
            
    insertionSort(pArray); //sorting array using insertion sort    
           
    System.out.println("After");    
    for(Point i:pArray){    
    	System.out.print(i+" ");    
    }    
