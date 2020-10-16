/*--Programmer: Austin Parker    Date 10/16/2020
  --Assignment: PE 20.21
  --Description: This program will take in pre-populated arrays, calculate their Geographical Area,
  then sort the results using a Generic Comparative Method.*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

abstract class GeometricObject implements Comparable<GeometricObject> {

    public GeometricObject() {
        Date dateCr = new Date();
    }

    /*overridden compareTo method*/

    @Override
    public int compareTo(GeometricObject geoObject) {
        if (getGeoArea() > geoObject.getGeoArea()) {
            return 1;
        } else if (getGeoArea() < geoObject.getGeoArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    public abstract double getGeoArea();
}

public class UseComparator {
    public static void main(String[] args) {
        /*takes in user input to confirm execution of program otherwise closes program*/
        Scanner scanner = new Scanner(System.in);
        /*welcome message*/
        System.out.println("\nWelcome to the UseComparator program. This program will take in pre-populated " +
                "arrays, calculate their Geographical Area, \nthen sort the results using a Generic Comparative Method.\n" +
                "If you would like to run the program input \"Y\" below. " +
                "To close the program input \"N\".");
        String appStartConfirm = scanner.nextLine().toLowerCase();
        /*if statement to confirm execution of program*/
        if (appStartConfirm.equals("y")) {
            /*declare arrays */
            GeometricObject[] list = {
                    new Circle(5), new Rectangle(4, 5),
                    new Circle(5.5), new Rectangle(2.4, 5),
                    new Circle(0.5), new Rectangle(4, 65),
                    new Circle(4.5), new Rectangle(4.4, 1),
                    new Circle(6.5), new Rectangle(4, 5)
            };
            /*color array*/
            String[] list2 = {"red", "blue", "green", "yellow", "orange", "pink"};
            /*displays before sort to user*/
            System.out.println("\nData before sort: ");
            for (GeometricObject go : list) {
                System.out.println(go.getGeoArea());
            }
            System.out.println("");
            /*performs selection sort*/
            selectionSort(list, new Comparator<GeometricObject>() {
                @Override
                public int compare(GeometricObject go1, GeometricObject go2) {
                    double ob1 = go1.getGeoArea();
                    double ob2 = go2.getGeoArea();
                    if (ob1 > ob2) {
                        return 1;
                    }
                    if (ob1 == ob2) {
                        return 0;
                    } else return -1;
                }
            });
            /*displays after sort to user*/
            System.out.println("\nData after sort: ");
            for (GeometricObject o : list) {
                System.out.println(o.getGeoArea());
            }
            /*displays before sort colors*/
            System.out.println("\nColors before sort: ");
            System.out.println(Arrays.toString(list2));
            /*displays and sorts colors array*/
            System.out.println("\nColors after sort: ");
            selectionSort(list2, Comparator.naturalOrder());
            System.out.println(Arrays.toString(list2));
        } /*end if statement*/
        /*else statement closes program if user inputs anything other than "y" at execution */
        else {
            System.out.println("Thanks for using the program!");
            System.exit(0);
        }
    }/*end of main*/

    /*generic comparator method to sort arrays with*/
    public static <E> void selectionSort(E[] ar, Comparator<? super E> comparator) {
        for (int it1 = 0; it1 < ar.length - 1; it1++) {
            E currentMin = ar[it1];
            int minIndex = it1;
            for (int it2 = it1; it2 < ar.length; it2++) {
                if (comparator.compare(ar[it2], currentMin) < 0) {
                    currentMin = ar[it2];
                    minIndex = it2;
                }
            }
            if (minIndex != it1) {
                ar[minIndex] = ar[it1];
                ar[it1] = currentMin;
            }
        }
    }
}/*end of class*/







