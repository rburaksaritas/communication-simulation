
package question;

public class Operator {
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	private int ID;
	private double talkingCharge;
	private double messageCost;
	private double networkCharge;
	private int discountRate;
	
	private int talkDuration = 0;
	private int messageQuantity = 0;
	private double connectionAmount = 0;
	
	// Constructor
	public Operator(int ID, double talkingCharge, double messageCost, 
			double networkCharge, int discountRate) {
		
		this.ID = ID;
		this.talkingCharge = talkingCharge;
		this.messageCost = messageCost;
		this.networkCharge = networkCharge;
		this.discountRate = discountRate;
		
	}
	// Talking Cost Calculator
	public double calculateTalkingCost(int minute, Customer customer) {
		
		if (customer.getAge() < 18 || customer.getAge() > 65) {
			return (minute * this.talkingCharge * ((double)(100-discountRate)/100));
		}
		else {
			return (minute * this.talkingCharge);
		}
			
	}
	
	// Messaging Cost Calculator
	public double calculateMessageCost(int quantity, Customer customer, Customer 
			other)	{
		if (customer.getOperator() == other.getOperator()) {
			return quantity * this.messageCost * ((double)(100-discountRate)/100);
		}
		else {
			return quantity * this.messageCost;
		}
		
		
	}
	
	// Network Cost Calculator
	public double calculateNetworkCost(double amount) {
		
		return amount * networkCharge;
		
	}
	/**
	 * @return the talkingCharge
	 */
	public double getTalkingCharge() {
		return talkingCharge;
	}
	/**
	 * @param talkingCharge the talkingCharge to set
	 */
	public void setTalkingCharge(double talkingCharge) {
		this.talkingCharge = talkingCharge;
	}
	/**
	 * @return the messageCost
	 */
	public double getMessageCost() {
		return messageCost;
	}
	/**
	 * @param messageCost the messageCost to set
	 */
	public void setMessageCost(double messageCost) {
		this.messageCost = messageCost;
	}
	/**
	 * @return the networkCharge
	 */
	public double getNetworkCharge() {
		return networkCharge;
	}
	/**
	 * @param networkCharge the networkCharge to set
	 */
	public void setNetworkCharge(double networkCharge) {
		this.networkCharge = networkCharge;
	}
	/**
	 * @return the discountRate
	 */
	public int getDiscountRate() {
		return discountRate;
	}
	/**
	 * @param discountRate the discountRate to set
	 */
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
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

