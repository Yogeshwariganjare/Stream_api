package API;

public class StreamMain {private String name;
private int calories;
private int price;
private String color;

StreamMain(String name,int calories,int price,String color)
{
    this.name = name;
    this.calories = calories;
    this.price = price;
    this.color = color;
}

public int getCalories() {
    return calories;
}

public void setCalories(int calories) {
    this.calories = calories;
}

public String getColor() {
    return color;
}

public void setColor(String color) {
    this.color = color;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public int getPrice() {
    return price;
}

public void setPrice(int price) {
    this.price = price;
}

@Override
public String toString() {
    return "Fruit{" +
            "name='" + name + '\'' +
            ", calories=" + calories +
            ", price=" + price +
            ", color='" + color + '\'' +"";
  }
}
public class StreamMain {

	public static void main(String[] args) {
		
		List<Fruits> fruitslist=Arrays.asList(new Fruits("Mango",95, 90,"Yellow"),
		new Fruits("Apple", 105, 30, "Red"),
	    new Fruits("Strawberry", 25, 10,"Red"),
		new Fruits("Cherry", 10, 10, "Red"),
		new Fruits("Grapes", 15, 20, "Green"));
		
	
		List<Fruits> sortedList=fruitslist.stream()
				//.filter(x->x<100)
				.sorted(Comparator.comparingInt(Fruits::getCalories).reversed())
				.collect(Collectors.toList());
		System.out.println("Fruits with calories<100 are:");
		sortedList.forEach(System.out::println);	

		System.out.println("-----------------------------------------------------");
		List<Fruits> colorList=fruitslist.stream()
				.sorted(Comparator.comparing(Fruits::getColor))
				.collect(Collectors.toList());
		System.out.println("Colorwise sorting of fruits is:");
		colorList.forEach(System.out::println);
	}

}