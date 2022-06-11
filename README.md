# This is my first Java-based console project

### Program Specifications

- Program's menu:
	+ Welcome to Food Management - @2021 by DuyLVL
	+ Select the options below:
		1. Add a new food
		2. Search a food by name
		3. Remove the food by ID
		4. Print the food list in the descending order of expired date
		5. Quit

- Each menu choice should invoke an appropriate function to perform the selected menu item. My program will display
the menu after each task and wait for the user to select another option until the user chooses to quit the program. Each
food has the following information: ID (cannot be modified, cannot be duplicated), name, weight, type, place (where you
put this food in refrigerator), expired date. 

### Function details

1. Function 1: Show menu
- The program displays a menu and asks users to input an option from 1 to 5.

2. Function 2: Add a food to the list
- User inputs new food’s information
- Remember to check the id cannot be duplicated. Other information must be validating.
- Add the new a food to the collection.
- After adding, the program asks whether you want to continue adding another food or return to the menu.

3. Function 3: Search a phone by name
- User inputs the key word want to search. The program returns all food that has name contain the search
string.
- If the food is not existed, the screen shows message “This food does not exist”. Otherwise, the screen shows
the foods information.
- After searching, the program asks if the user wants to continue searching for another food or return to the
menu.

4. Function 4: Remove the food by ID
- User can remove any food in the refrigerator by ID.
- Before the remove, the program must show confirm message.o Show the result of the remove: success or fail.
- After removing, the program returns to the menu.

5. Function 5: Print the food
- The program will print the food list in the descending order of expired date.
- After printing, the program returns to the menu.

6. Function 6: Store the food list to text file
- The user store food to a text file
- The program will save all information of the food in the refrigerator to the file.
- After save, the program returns to the menu.