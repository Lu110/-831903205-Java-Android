package MyFirstRestaurant;

public class OverdraftBalanceException extends RuntimeException{
	private String information;
	public OverdraftBalanceException() {
	}
	public OverdraftBalanceException(String information) {
		super(information);
	}
}
