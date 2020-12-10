package MyFirstRestaurant;

import java.time.LocalDate;
import java.util.Iterator;

public class Beer extends Drinks {
	//变量：酒精度数（float）
private float alcoholDegree;
public Beer(String drinksName, double cost, LocalDate productionDate, int storageLife,float alcoholDegree) {
		super(drinksName, cost, productionDate, storageLife);
		//保质期30天
		this.StorageLife=30;
		this.alcoholDegree=alcoholDegree;
	}
public float getAlcoholDegree() {
	return alcoholDegree;
}
public void setAlcoholDegree(float alcoholDegree) {
	this.alcoholDegree = alcoholDegree;
}
public String toString() {
	String description="饮料：类型--啤酒\n名称： "+this.drinksName+"  价格："+this.cost+"元  度数："+this.alcoholDegree;
	return description;
}
}

