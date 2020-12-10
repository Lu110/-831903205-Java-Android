package MyFirstRestaurant;

public class IngredientSortOutException extends RuntimeException {
	private String information;
	public IngredientSortOutException() {
	}
	public IngredientSortOutException(String information) {
		super(information);
	}
}
