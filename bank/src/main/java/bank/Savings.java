package bank;

public class Savings {

	int deposit(int amount, int balance) {
		
		int result = balance + amount;
		return result;
	}
	
	int withdrawal(int amount, int balance) {
		
		int result = balance - amount;
		return result;
	}
}
