import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.time.*;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }
    //Task 1.2 Completed
    public boolean isRestaurantOpen() {
        return getCurrentTime().isAfter(openingTime) && getCurrentTime().isBefore(closingTime);
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    // Task 1.1 Completed
    public List<Item> getMenu() {
        return this.menu;

    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }
	
	//Part 3/ TDD Part - Task Completed
    public int calculateAmount (List<String> selectedItems){
        int totalAmount=0;
        for (String itemName : selectedItems) {
            Item item = findItemByName(itemName);
            totalAmount +=item.getPrice();
        }
        return totalAmount;
    }

}