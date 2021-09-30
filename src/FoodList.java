import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.time.LocalDate;

public class FoodList extends ArrayList<Food> implements iFood {
    ArrayList<Food> list = new ArrayList<Food>();

    public FoodList() {
    }

    public FoodList(ArrayList<Food> list) {
        this.list = list;
    }

    public int searchID(String ID) {
        ID = ID.trim().toUpperCase();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID().equals(ID))
                return i;
        }
        return -1;
    }

    private boolean isIDDuplicated(String ID) {
        ID = ID.trim().toUpperCase();
        return searchID(ID) != -1;
    }

    public void addFood() {
        String newID, newName, newType, newPlace;
        LocalDate newExpiredDate;
        double newWeight;
        do {
            newID = Inputter.inputNonBlankStr("Input FoodID: ");
            if (isIDDuplicated(newID)) {
                System.out.println("This ID is duplicated! Please try again.");
            }
        } while (isIDDuplicated(newID));
        newName = Inputter.inputNonBlankStr("Input Name: ");
        newWeight = Inputter.inputPositiveDouble("Input Weight (kg): ");
        newType = Inputter.inputNonBlankStr("Input Type: ");
        newPlace = Inputter.inputNonBlankStr("Input Place of Food: ");
        newExpiredDate = Inputter.inputDate("Input ExpiredDate [dd-mm-yyyy]: ");
        list.add(new Food(newID, newName, newWeight, newType, newPlace, newExpiredDate));
        System.out.println("FoodID " + newID + " has been added.");
    }

    public void searchFoodByKeyword() {
        String sName = Inputter.inputNonBlankStr("Input Keyword: ");
        System.out.println("Result:");
        int t = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().contains(sName)) {
                System.out.println(list.get(i).toString());
                t++;
            }
        }
        if (t == 0) {
            System.out.println("The food does not exist.");
        }
    }

    public void removeFoodByID() {
        String rID;
        do {
            rID = Inputter.inputNonBlankStr("Input removeID: ");
            if (!isIDDuplicated(rID)) {
                System.out.println("This ID does not exist! Please try again.");
            }
        } while (!isIDDuplicated(rID));
        int pos = searchID(rID);
        list.remove(list.get(pos));
        System.out.println("FoodID " + rID + " has been removed.");
    }

    public void printAll() {
        Collections.sort(list);
        for (Food food : list) {
            System.out.println(food.toString());
        }
    }

    public void saveToBinaryFile() {
        String filename = "FoodList.dat";
        File file = new File(filename);
        try {
            for (Food food : list) {
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(food);
                oos.close();
                fos.flush();
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The list has been saved successfully.");
    }

    public void data() {
        LocalDate date1 = LocalDate.parse("2021-12-20");
        list.add(new Food("A123", "Apple", 0.1, "fruit", "1st floor", date1));
        LocalDate date2 = LocalDate.parse("2022-03-18");
        list.add(new Food("B018", "Banana", 0.2, "fruit", "2nd floor", date2));
        LocalDate date3 = LocalDate.parse("2022-01-16");
        list.add(new Food("W111", "Watermelon", 0.5, "fruit", "3rd floor", date3));
        LocalDate date4 = LocalDate.parse("2021-11-22");
        list.add(new Food("M221", "Mango", 0.2, "fruit", "3rd floor", date4));
        LocalDate date5 = LocalDate.parse("2022-01-18");
        list.add(new Food("C701", "Coca", 0.2, "soft drink", "1rd floor", date5));
    }
}
