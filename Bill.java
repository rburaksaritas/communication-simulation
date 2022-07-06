
package question;

public class Bill {

	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	private double limitingAmount;
	private double currentDebt = 0;
	
	private double amountPaid = 0;
	
	public Bill(double limitingAmount) {
		
		this.limitingAmount = limitingAmount;
		
	}

	// Check if the limitingAmount is exceeded or not.
	public boolean check(double amount) {
		
		if (this.currentDebt + amount > limitingAmount) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	// Add debt to the bill
	public void add(double amount) {
		
		currentDebt += amount;
		
	}
	
	// Pay the bills
	public void pay(double amount) {
		
		currentDebt -= amount;
		
		if (currentDebt < 0) {
			amount += (currentDebt);
			currentDebt = 0;	
		}
		
		setAmountPaid(getAmountPaid() + amount);
	}
	
	// Change the limitingAmount 
	public void changeTheLimit(double amount) {
		this.limitingAmount = amount;
	}

	/**
	 * @return the limitingAmount
	 */
	public double getLimitingAmount() {
		return limitingAmount;
	}

	/**
	 * @return the currentDebt
	 */
	public double getCurrentDebt() {
		return currentDebt;
	}

	/**
	 * @param limitingAmount the limitingAmount to set
	 */
	public void setLimitingAmount(double limitingAmount) {
		this.limitingAmount = limitingAmount;
	}

	/**
	 * @param currentDebt the currentDebt to set
	 */
	public void setCurrentDebt(double currentDebt) {
		this.currentDebt = currentDebt;
	}

	/**
	 * @return the amountPaid
	 */
	public double getAmountPaid() {
		return amountPaid;
	}

	/**
	 * @param amountPaid the amountPaid to set
	 */
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	
	
	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

