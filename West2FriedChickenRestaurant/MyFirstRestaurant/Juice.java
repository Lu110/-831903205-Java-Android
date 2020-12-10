package MyFirstRestaurant;

import java.time.LocalDate;

public class Juice extends Drinks {

	public Juice(String drinksName, double cost, LocalDate productionDate, int storageLife) {
		super(drinksName, cost, productionDate, storageLife);
		//保质期2天
		this.StorageLife=2;
	}

	public String toString() {
		String description="饮料：类型--果汁\n名称： "+this.drinksName+"  价格："+this.cost+"元 ";
		return description;
	}

}
