package util;

import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Utils {

    private static Scanner sc = new Scanner(System.in);

    public static void printMenu() {
        System.out.println("0. Read data from file.");
        System.out.println("1. Add a new food.");
        System.out.println("2. Search a food by name.");
        System.out.println("3. Remove the food by ID.");
        System.out.println("4. Print the food list in the descending order of expired date.");
        System.out.println("5. Store the food list to file.");
        System.out.println("6. Quit");
        System.out.println("================================");
    }

    public static int getChoice(String msg, int min, int max, String errorMsg) {
        int choice = 0;
        do {
            choice = getAnInteger(msg);
            if (choice < min || choice > max) {
                System.out.println(errorMsg);
            }
        } while (choice < min || choice > max);

        return choice;
    }

    public static String getChoice(String msg, String errMsg) {
        String choice;
        do {
            choice = getString(msg).toUpperCase();
            if (choice.startsWith("Y")) {
                return "y";
            }
            if (choice.startsWith("N")) {
                return "n";
            }
            System.out.println(errMsg);
        } while (choice != "n" && choice != "y");
        return choice;
    }

    public static int getAnInteger(String msg) {
        int result = 0;
        while (true) {
            try {
                System.out.print(msg);
                result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (Exception e) {
            }
        }
    }

    public static double getADouble(String msg) {
        double result = 0;
        while (true) {
            try {
                System.out.print(msg);
                result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (Exception e) {
            }
        }
    }

    public static String getString(String msg) {
        String result;

        while (true) {
            System.out.print(msg);
            result = sc.nextLine().trim();
            if (result != null && !result.isEmpty()) {
                return result;
            }
        }

    }

    public static String getString(String msg, String errorMsg) {
        String result;

        while (true) {
            System.out.print(msg);
            result = sc.nextLine().trim();
            if (result != null && !result.isEmpty()) {
                return result;
            } else {
                System.out.println(errorMsg);
            }
        }

    }

    public static boolean isLeap(int yyyy) {
        if ((yyyy % 400 == 0) || ((yyyy % 4 == 0) && !(yyyy % 100 == 0))) {
            return true;
        }
        return false;
    }

    public static boolean isValidDate(int dd, int mm, int yyyy) {
        int maxD;
        if (mm > 12 || mm < 1 || dd < 1 || dd > 31) {
            return false;
        }
        if (mm == 4 || mm == 6 || mm == 9 || mm == 11) {
            maxD = 30;
        } else if (mm != 2) {
            maxD = 31;
        } else if (isLeap(yyyy)) {
            maxD = 29;
        } else {
            maxD = 28;
        }
        return (dd <= maxD);
    }

    public static long toDate(String ddmmyyyy) {
        StringTokenizer stk = new StringTokenizer(ddmmyyyy, "/-");
        int dd = Integer.parseInt(stk.nextToken());
        int mm = Integer.parseInt(stk.nextToken());
        int yyyy = Integer.parseInt(stk.nextToken());
        if (!isValidDate(dd, mm, yyyy)) {
            return -1;
        }
        Calendar cal = Calendar.getInstance();
        cal.set(yyyy, mm - 1, dd);
        long t = cal.getTime().getTime();
        return t;
    }

    //test
    public static void main(String[] args) {
        String a = getString("Date: ");
        long date = toDate(a);
        System.out.println(a);
        System.out.println(date);
        System.out.println(System.currentTimeMillis());
    }
}
