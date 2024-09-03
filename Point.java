/*
 * @author Braden S
 * Date: 2024 August
 * Description: a class that represents a point on a graph,
 *              has a price variable, and a quantity variable
 */

public class Point {
    private int                 quantity;
    private double              price;
    private static final double tolerance = 0.01;

    /*
     * Constructor that gives "default" values to the
     * price and quantity variables
     */
    public Point() {
        this.quantity = 0;
        this.price = 0.0;
    }

    /*
     * Constructor that gives values to the
     * price and quantity variables based on
     * the constructors parameters
     */
    public Point(int quantity, double price) {
        setQuantity(quantity);
        setPrice(price);
    }

    /*
     * returns the value in the quantity variable
     */
    public int getQuantity() {
        return quantity;
    }

    /*
     * sets the quantity variable based on the function parameter
     * and checks if the quantity is below zero, if it is then set
     * quantity to zero
     */
    public void setQuantity(int quantity) {
        if (quantity < 0) quantity = 0;

        this.quantity = quantity;
    }

    /*
     * returns the value in the price variable
     */
    public double getPrice() {
        return price;
    }

    /*
     * sets the price variable based on the function parameter
     */
    public void setPrice(double price) {
        if (price < 0.0) price = 0.0;

        this.price = price;
    }

    /*
     * returns a string with the values of the quantity and price
     * variable
     */
    @Override
    public String toString() {
        return "(" + quantity + ", " + price + ")";
    }

    /*
     * returns if an object is equal to this point
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof Point) {
            return equals((Point) object);
        }
        return false;
    }

    /*
     * returns if two points are equal to each other
     */
    public boolean equals(Point point) {
        return ((Math.abs(this.price - point.price) < tolerance) && this.quantity == point.quantity);
    }
}
