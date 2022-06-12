package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import util.Utils;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import refrigerator.RefrigeratorInterface;

public class FoodList implements RefrigeratorInterface {

    private ArrayList<Food> foodList = new ArrayList();

    @Override
    public void addNewFood() {
        String id;
        String name;
        double weight;
        String type;
        int place;
        String date;
        long checkDate;
        String choice;
        try {
            do {
                do {
                    id = Utils.getString("Food's id: ", "ID is required!");
                    if (searchFoodByID(id) >= 0) {
                        System.out.println("Duplicated ID! Please enter ID again!");
                    }
                } while (id.isEmpty() || searchFoodByID(id) >= 0);
                name = Utils.getString("Food name: ", "Food name is required!");
                do {
                    weight = Utils.getADouble("Enter weight: ");
                    if (weight <= 0) {
                        System.out.println("Weight must be greater than 0!");
                    }
                } while (weight <= 0);

                type = Utils.getString("Type: ", "Food type is required!");

                place = Utils.getAnInteger("Place to put in: ");
                do {
                    date = Utils.getString("Expired date (day format: dd-mm-yyyy): ");
                    checkDate = Utils.toDate(date);
                    if (checkDate < System.currentTimeMillis()) {
                        System.out.println("Invalid date!");
                    }
                } while (checkDate < System.currentTimeMillis());

                foodList.add(new Food(id, name, weight, type, place, date));
                choice = Utils.getChoice("Do you want to continue adding food (y/n)? ", "y/n please!");

            } while (choice.equals("y"));

            System.out.println();
        } catch (Exception e) {
        }

    }

    @Override
    public void searchFoodByName() {
        if (foodList.isEmpty()) {
            System.out.println("The list is empty. No result found.");
            return;
        }
        String choice;
        do {
            String searchName = Utils.getString("Enter name to search: ");
            int count = 0;
            for (Food x : foodList) {
                if (x.getName().toUpperCase().contains(searchName.toUpperCase())) {
                    count += 1;
                    System.out.println(x.toString());
                }
            }

            System.out.println(count + " result(s) match.");
            choice = Utils.getChoice("Do you want to continue searching food (y/n)? ", "y/n please!");

        } while (choice.equals("y"));

        System.out.println();
    }

    public void searchFoodByID() {

        if (foodList.isEmpty()) {
            System.out.println("The list is empty. No result found.");
            return;
        }
        String searchID = Utils.getString("Enter ID to search: ");
        for (int i = 0; i < foodList.size(); i++) {
            if (foodList.get(i).getId().equalsIgnoreCase(searchID)) {
                System.out.println(foodList.get(i).getName());
                return;
            }
        }
        System.out.println("No ID matches");

    }

    public int searchFoodByID(String id) {
        if (foodList.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < foodList.size(); i++) {
            if (foodList.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void removeFoodByID() {
        if (foodList.isEmpty()) {
            System.out.println("The list is empty. There is nothing to remove.");
            System.out.println();
            return;
        }
        String removeID = Utils.getString("Enter food ID that will be remove: ");
        int tmp;
        String choice;
        if ((tmp = searchFoodByID(removeID)) >= 0) {
            choice = Utils.getChoice("Remove confirm (y/n): ", "y/n please!");
            if (choice.equals("y")) {
                foodList.remove(tmp);
                System.out.println("Food removed.");
            } else {
                System.out.println("The food is still in the fridge.");
            }
        } else {
            System.out.println("ID " + removeID + " does not exist.");
        }

        System.out.println();
    }

    @Override
    public void printFoodListInDescendingOrderOfExpiredDay() {
        if (foodList.isEmpty()) {
            System.out.println("The list is empty!\n");
            return;
        }
        Collections.sort(foodList, new SortFoodByDate());
        System.out.println("The food list in the descending order of expired date");
        System.out.printf("|%-8s|%-10s|%6s|%-10s|%5s|%-12s|\n",
                "Food ID", "Food Name", "Weight", "Food Type", "Place", "Expired Date");
        for (int i = 0; i < foodList.size(); i++) {
            foodList.get(i).displayInfor();
        }
        System.out.println();
    }

    @Override
    public void writeToFile(String file) {
        if (foodList.isEmpty()) {
            System.out.println("The list is empty.\n");
            return;
        }

        try {
            FileWriter foodFile = new FileWriter(file);
            for (Food x : foodList) {
                foodFile.write(x.toString() + "\n");

            }
            foodFile.close();
            System.out.println("Successfully wrote to the file.\n");
        } catch (Exception e) {
        }

    }

    @Override
    public void readFromFile(String fileIn) {
        try {
            File foodFile = new File(fileIn);
            if (!foodFile.exists()) {
                System.out.println("File does not exist.");
                return;
            }
            FileReader fr = new FileReader(foodFile);
            BufferedReader br = new BufferedReader(fr);
            String details;
            while ((details = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",");

                String id = stk.nextToken().trim().toUpperCase();
                String name = stk.nextToken().trim().toUpperCase();
                double weight = Double.parseDouble(stk.nextToken().trim());
                String type = stk.nextToken().trim().toUpperCase();
                int place = Integer.parseInt(stk.nextToken().trim());
                String date = stk.nextToken().trim();

                boolean check = (searchFoodByID(id) < 0 && (Utils.toDate(date) > System.currentTimeMillis()));

                if (check) {
                    foodList.add(new Food(id, name, weight, type, place, date));
                }
            }
            printFoodListInDescendingOrderOfExpiredDay();
        } catch (Exception e) {
        }
    }
}
