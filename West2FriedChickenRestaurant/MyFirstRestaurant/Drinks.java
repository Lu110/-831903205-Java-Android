package MyFirstRestaurant;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

abstract class Drinks {
	//�������ϵĻ�������
protected String drinksName;
protected double cost;
protected LocalDate ProductionDate;
protected int StorageLife;
public Drinks(String drinksName, double cost, LocalDate productionDate, int storageLife) {
	//ȫ�ι��캯��
	this.drinksName = drinksName;
	this.cost = cost;
	this.ProductionDate = productionDate;
	this.StorageLife = storageLife;
}
public String getDrinksName() {
	return drinksName;
}
public void setDrinksName(String drinksName) {
	this.drinksName = drinksName;
}
public double getCost() {
	return cost;
}
public void setCost(double cost) {
	this.cost = cost;
}
public LocalDate getProductionDate() {
	return ProductionDate;
}
public void setProductionDate(LocalDate productionDate) {
	this.ProductionDate = productionDate;
}
public int getStorageLife() {
	return StorageLife;
}
public void setStorageLife(int storageLife) {
	this.StorageLife = storageLife;
}
public boolean isStale() {
	//�жϵ�ǰ�Ƿ���ڷ���
	DateTimeFormatter fmt=DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate endDate=LocalDate.now();
	int timeSpan=(int) ProductionDate.until(endDate,ChronoUnit.DAYS);
	if(timeSpan>StorageLife)
		return true;
	else
		return false;
	
	
}
//�����toString����
public abstract String toString();
}
