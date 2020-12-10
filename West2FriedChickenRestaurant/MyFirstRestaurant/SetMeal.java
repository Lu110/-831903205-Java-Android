package MyFirstRestaurant;

public class SetMeal {
 private String mealName;
 private double price;
 private String friedChickenName;
 private Drinks type;
 
 
 public SetMeal(String mealName, double price, String friedChickenName, Drinks type) {
	super();
	this.mealName = mealName;
	this.price = price;
	this.friedChickenName = friedChickenName;
	this.type = type;
}



public String getMealName() {
	return mealName;
}

public void setMealName(String mealName) {
	this.mealName = mealName;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public String getFriedChickenName() {
	return friedChickenName;
}

public void setFriedChickenName(String friedChickenName) {
	this.friedChickenName = friedChickenName;
}


public Drinks getType() {
	return type;
}

public void setType(Drinks type) {
	this.type = type;
}

public String toString() {
	 String s=mealName+": "+price+"ิช  "+friedChickenName+" + ฃบ"+type;
	 return s;
 }
 
}
