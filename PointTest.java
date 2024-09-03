/*
 * @author Braden S
 * Date 2024 August
 * Description: Tests a point class and allows the user at
 *              runtime to set values and compare points
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PointTest {

    private static ArrayList<Point> points;
    private static Scanner inputScanner;

    Point point3D = new Point3D();

    public PointTest() {
        points = new ArrayList<>();
        inputScanner = new Scanner(System.in);
    }

    public void mainMenu() {
        System.out.println("*** Point Class Tester ***");
        System.out.println("1. Add Points");
        System.out.println("2. Change Point Quantity");
        System.out.println("3. Change Point Value");
        System.out.println("4. View Point");
        System.out.println("5. Compare Points");
        System.out.println("6. Exit");

        int input = inputScanner.nextInt();

        switch (input) {
            case 1: askToAddPoints(); break;
            case 2: askToAddQuantityToPoint(); break;
            case 3: askToAddPriceToPoint(); break;
            case 4: askToPrintPoint(); break;
            case 5: comparePoints(); break;
            case 6: System.exit(0); break;
            default: System.out.println("Invalid Selection!\ntry again!\n"); mainMenu(); break;
        }
    }

    private int getIndex() {
        int i;

        System.out.print("Input index of point: ");
        i = inputScanner.nextInt();

        if (i > points.size() - 1) {
            System.out.println("index is higher then number of points!\ntry again!\n");
            i = getIndex();
        }

        return i;
    }

    private void askToAddPoints() {
        Random random = new Random();

        System.out.println("Generate random price and quantity values? (y/n)");
        String rand = inputScanner.next();

        if (rand.equals("N") || rand.equals("n") || rand.equals("no") || rand.equals("No")) {
            rand = "n";
        } else if (rand.equals("Y") || rand.equals("y") || rand.equals("yes") || rand.equals("Yes")) {
            rand = "y";
        } else {
            System.out.println("Invalid entry!");
            askToAddPoints();
        }

        System.out.print("Input number of points to add: ");
        int num = inputScanner.nextInt();

        for (int i = 0; i < num; i++) {
            if (rand.equals("n")) {
                points.add(new Point());
            }
            if (rand.equals("y")) {
                points.add(new Point(random.nextInt(), random.nextDouble()));
            }
        }

        mainMenu();
    }

    private void askToPrintPoint() {
        int i = getIndex();

        System.out.println("Point: " + i + " " + points.get(i).toString());

        mainMenu();
    }

    private void askToAddPriceToPoint() {
        int i = getIndex();

        System.out.print("Input Price to Set: ");
        points.get(i).setPrice(inputScanner.nextDouble());

        mainMenu();
    }

    private void askToAddQuantityToPoint() {
        int i = getIndex();

        System.out.print("Input quantity to set: ");
        points.get(i).setQuantity(inputScanner.nextInt());

        mainMenu();
    }

    private void comparePoints() {
        int i1 = getIndex();
        int i2 = getIndex();

        if (i1 == i2) {
            System.out.println("Indexes are the same!\ntry again!\n");
            comparePoints();
        }

        if (points.get(i1).equals((Object) points.get(i2))) {
            System.out.println("Points are the same!");
        } else {
            System.out.println("Points are NOT the same!");
        }

        mainMenu();
    }

    public static void main(String[] args) {
        PointTest pointTest = new PointTest();

        pointTest.mainMenu();
    }

}
