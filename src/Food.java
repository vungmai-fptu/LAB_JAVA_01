import java.time.LocalDate;
import java.io.Serializable;

public class Food implements Serializable, Comparable<Food> {
    String ID = "";
    String name = "";
    double weight = 0.0;
    String type = "";
    String place = "";
    LocalDate expiredDate = null;

    public Food() {
    }

    public Food(String ID, String name, double weight, String type, String place, LocalDate expiredDate) {
        this.ID = ID;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expiredDate = expiredDate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String toString() {
        return "FoodID: " + ID + " Name: " + name + " Weight: " + weight + " Type: " + type + " Place: " + place
                + " Expired Date: " + expiredDate;
    }

    public int compareTo(Food food) {
        return this.getName().compareTo(food.getName());
    }

}