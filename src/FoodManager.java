public class FoodManager {
    public static void main(String[] args) {
        String[] options = { "Add a new food", "Search a food by name", "Remove the food by ID",
                "Print the food list in the descending order of expired date", "Save the list to binary file", "Quit" };
        int choice = 0;
        FoodList list = new FoodList();
        list.data();
        System.out.println("Welcome to Food Management - @ 2021 by SE161817 - Vu Thi Ngoc Mai");
        do {
            System.out.println("Select the options below: ");
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    int c = 0;
                    do {
                        list.addFood();
                        String[] opt = { "Yes!", "Nope! Back to the Menu." };
                        System.out.println("Do you want to continue?");
                        c = Menu.getChoice(opt);
                    } while (c < 2);
                    break;
                case 2:
                    list.searchFoodByKeyword();
                    break;
                case 3:
                    list.removeFoodByID();
                    break;
                case 4:
                    list.printAll();
                    break;
                case 5:
                    list.saveToBinaryFile();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    break;
            }
        } while (choice > 0 && choice < 6);
    }
}
