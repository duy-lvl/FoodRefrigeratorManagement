package data;

import util.Utils;

public class Food {

    private String id;
    private String name;
    private double weight;
    private String type;
    private int place;
    private String expiredDate;
    private long longDate;

    protected int a;

    public Food() {
    }

    public Food(String id, String name, double weight, String type, int place, String date) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expiredDate = date;
        this.longDate = Utils.toDate(date);
    }

    public String getId() {
        return id;
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

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public long getLongDate() {
        return longDate;
    }

    public boolean equals(Food that) {
        return this.expiredDate.equalsIgnoreCase(that.expiredDate);
    }

    @Override
    public String toString() {
        return "Food: " + "id: " + id + ", name: " + name + ", weight: "
                + weight + ", type: " + type + ", place: " + place
                + ", expired date: " + expiredDate;
    }

    public void displayInfor() {
        System.out.printf("|%-8s|%-10s|%-6.2f|%-10s|%-5d|%-12s|\n",
                id, name, weight, type, place, expiredDate);
    }
}
