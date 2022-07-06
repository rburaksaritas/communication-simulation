
package question;

public class Customer {
	
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	private int ID;
	private String name;
	private int age;
	private Operator operator;
	private Bill bill;
	
	private int talkDuration;
	private int messageQuantity;
	private double connectionAmount;
	
	
	// Constructor with parameters.
	public Customer(int ID, String name, int age, Operator operator, double limitingAmount) {
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.operator = operator;
		this.bill = new Bill(limitingAmount);
	}
	
	
	// Make a Call
	public void talk(int minute, Customer other) {
		
		if (bill.check(this.operator.calculateTalkingCost(minute, this)) == false) {
			
			this.setTalkDuration(this.getTalkDuration() + minute);
			other.setTalkDuration(other.getTalkDuration() + minute);
			
			this.operator.setTalkDuration((this.operator.getTalkDuration() + minute));
			other.operator.setTalkDuration((other.operator.getTalkDuration() + minute));
			
			this.bill.setCurrentDebt(this.bill.getCurrentDebt() + this.operator.calculateTalkingCost(minute, this));
		}

	}
	
	// Send Message
	public void message(int quantity, Customer other) {
		
		if (bill.check(operator.calculateMessageCost(quantity, this, other)) == false) {
			
			this.setMessageQuantity(this.getMessageQuantity() + quantity);
			
			this.getOperator().setMessageQuantity(this.getOperator().getMessageQuantity() + quantity);
			
			this.bill.setCurrentDebt(this.bill.getCurrentDebt() + operator.calculateMessageCost(quantity, this, other));
		}
		
	}
	
	// Connect to Internet
	public void connection(double amount) {
		
		if(bill.check(operator.calculateNetworkCost(amount)) == false) {
			
			this.setConnectionAmount(this.getConnectionAmount() + amount);
			
			this.getOperator().setConnectionAmount(this.getOperator().getConnectionAmount() + amount);
			
			this.bill.setCurrentDebt(this.bill.getCurrentDebt() + operator.calculateNetworkCost(amount));;	
		}
	}

	
	// @return the age
	public int getAge() {
		return age;
	}

	// @param age the age to set
	public void setAge(int age) {
		this.age = age;
	}

	// @return the operator
	public Operator getOperator() {
		return operator;
	}

	// @param operator the operator to set
	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	// @return the bill
	public Bill getBill() {
		return bill;
	}

	// @param bill the bill to set
	public void setBill(Bill bill) {
		this.bill = bill;
	}

	/**
	 * @return the limitingAmount
	 */
	public double getLimitingAmount() {
		return this.bill.getLimitingAmount();
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param limitingAmount the limitingAmount to set
	 */
	public void setLimitingAmount(double limitingAmount) {
		this.bill.setLimitingAmount(limitingAmount);
	}


	/**
	 * @return the talkDuration
	 */
	public int getTalkDuration() {
		return talkDuration;
	}


	/**
	 * @param talkDuration the talkDuration to set
	 */
	public void setTalkDuration(int talkDuration) {
		this.talkDuration = talkDuration;
	}


	/**
	 * @return the messageQuantity
	 */
	public int getMessageQuantity() {
		return messageQuantity;
	}


	/**
	 * @param messageQuantity the messageQuantity to set
	 */
	public void setMessageQuantity(int messageQuantity) {
		this.messageQuantity = messageQuantity;
	}


	/**
	 * @return the connectionAmount
	 */
	public double getConnectionAmount() {
		return connectionAmount;
	}


	/**
	 * @param connectionAmount the connectionAmount to set
	 */
	public void setConnectionAmount(double connectionAmount) {
		this.connectionAmount = connectionAmount;
	}
	
	
	
	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

