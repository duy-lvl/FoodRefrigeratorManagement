package food_management;

import data.FoodList;
import util.Utils;

public class Refrigerator {

    public static void main(String[] args) {
        final String INPUT_FILE_NAME = "FoodListFileInput.txt",
                    OUTPUT_FILE_NAME = "FoodListFileOutput.txt";
        FoodList refrigerator = new FoodList();
        System.out.println("Welcome to refrigerator management application!");

        int choice;
        do {
            Utils.printMenu();
            choice = Utils.getChoice("Enter your choice: ", 0, 6, "Please enter again!");
            switch (choice) {
                case 0: //0. Read from file.
                    refrigerator.readFromFile(INPUT_FILE_NAME);
                    break;
                case 1: //1. Add a new food.
                    refrigerator.addNewFood();
                    break;
                case 2: //2. Search a food by name.
                    refrigerator.searchFoodByName();
                    break;
                case 3: //3. Remove the food by ID.
                    refrigerator.removeFoodByID();
                    break;
                case 4: //4. Print the food list in the descending order of expired date.
                    refrigerator.printFoodListInDescendingOrderOfExpiredDay();
                    break;
                case 5: //5. Store the food list to file.
                    refrigerator.writeToFile(OUTPUT_FILE_NAME);
                    break;
                case 6: //6. Quit
                    System.out.println("Have a nice day!");
                    break;
            }
        } while (choice >= 0 && choice < 6);

    }

}
