package MyFirstRestaurant;

import java.time.LocalDate;
import java.util.Iterator;

public class Beer extends Drinks {
	//�������ƾ�������float��
private float alcoholDegree;
public Beer(String drinksName, double cost, LocalDate productionDate, int storageLife,float alcoholDegree) {
		super(drinksName, cost, productionDate, storageLife);
		//������30��
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
	String description="���ϣ�����--ơ��\n���ƣ� "+this.drinksName+"  �۸�"+this.cost+"Ԫ  ������"+this.alcoholDegree;
	return description;
}
}

