package MyFirstRestaurant;

import java.time.LocalDate;

public class Juice extends Drinks {

	public Juice(String drinksName, double cost, LocalDate productionDate, int storageLife) {
		super(drinksName, cost, productionDate, storageLife);
		//������2��
		this.StorageLife=2;
	}

	public String toString() {
		String description="���ϣ�����--��֭\n���ƣ� "+this.drinksName+"  �۸�"+this.cost+"Ԫ ";
		return description;
	}

}
