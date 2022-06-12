package refrigerator;

/**
 *
 * @author DuyLVL
 */
public interface RefrigeratorInterface {

    public void readFromFile(String fileName);

    public void addNewFood();

    public void searchFoodByName();

    public void removeFoodByID();

    public void printFoodListInDescendingOrderOfExpiredDay();

    public void writeToFile(String fileName);
}
