package prs.util;
import java.util.Scanner;

public class Console {
    
    private static Scanner sc = new Scanner(System.in);

    // Make every entry required
    public static String getString(String prompt) {
    	boolean isValid = false;
    	String s = "";
    	while (!isValid) {
            System.out.print(prompt);
            s = sc.nextLine();  // read user entry
            if (s.equals("")) {
            	System.out.println("Error!  This entry is required!");
            }
            else {
            	isValid = true;
            }
    	}
        return s;
    }

    public static String getString(String prompt, String v1, String v2) {
        boolean isValid = false;
        String s = "";
        while (!isValid) {
            s = getString(prompt);  // read user entry
	        if (s.equalsIgnoreCase(v1) || s.equalsIgnoreCase(v2)) {
	        	isValid = true;
	        }
	        else {
	        	System.out.println("Error! Entry must be 'y' or 'n'. Try again.");
	        }
        }
        return s;
    }

    public static int getInt(String prompt) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Error! Invalid integer. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

    public static int getInt(String prompt, int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            i = getInt(prompt);
            if (i <= min) {
                System.out.println(
                        "Error! Number must be greater than " + min + ".");
            } else if (i >= max) {
                System.out.println(
                        "Error! Number must be less than " + max + ".");
            } else {
                isValid = true;
            }
        }
        return i;
    }

    public static double getDouble(String prompt) {
        double d = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("Error! Invalid number. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }

    public static double getDouble(String prompt, double min, double max) {
        double d = 0;
        boolean isValid = false;
        while (!isValid) {
            d = getDouble(prompt);
            if (d <= min) {
                System.out.println(
                        "Error! Number must be greater than " + min + ".");
            } else if (d >= max) {
                System.out.println(
                        "Error! Number must be less than " + max + ".");
            } else {
                isValid = true;
            }
        }
        return d;
    }
}
