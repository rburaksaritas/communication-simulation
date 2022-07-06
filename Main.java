
package question;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {


	public static void main(String args[]) {

		Customer[] customers;
		Operator[] operators;

		int C, O, N;

		File inFile = new File(args[0]);  // args[0] is the input file
		File outFile = new File(args[1]);  // args[1] is the output file
		try {
			PrintStream outstream = new PrintStream(outFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		Scanner reader;
		try {
			reader = new Scanner(inFile);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find input file");
			return;
		}

		C = reader.nextInt();
		O = reader.nextInt();
		N = reader.nextInt();

		customers = new Customer[C];
		operators = new Operator[O];

		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		
		// Fields for the program to store input in an array.
		int currentCustomerID = 0;
		int currentOperatorID = 0;
		int currentActionID = 0;
		String[] customerData = new String[C];
		String[] operatorData = new String[O];
		String[] actionData = new String[N-C-O];
		
		// I have no idea why but it worked this way.
		reader.nextLine();
		
		// Store input lines in an array
		for (int i = 0; i < N; i++) {
			
			String inputLine = reader.nextLine();
			String[] tempArray = inputLine.split(" ");
			
	        if (Integer.parseInt(tempArray[0])==1) {		// inputs with number 1
	        	customerData[currentCustomerID] = inputLine;
	        	currentCustomerID += 1;
	        }
	        	
	        else if (Integer.parseInt(tempArray[0])==2) {	// inputs with number 2
	        	operatorData[currentOperatorID] = inputLine;
	        	currentOperatorID += 1;
        	}
        										
	        else {											// inputs with number 3, 4, 5, 6, 7, 8
        		actionData[currentActionID] = inputLine;
        		currentActionID += 1;
        	}	    
		}
		
		// Create OPERATOR objects
		for (int i = 0; i < operatorData.length; i++) {
			
			operators[i] = new Operator(i, 								//ID
					Double.parseDouble(operatorData[i].split(" ")[1]),  //talkingCharge
					Double.parseDouble(operatorData[i].split(" ")[2]), 	//messageCost
					Double.parseDouble(operatorData[i].split(" ")[3]),	//networkCharge
					Integer.parseInt(operatorData[i].split(" ")[4]));	//discountRate
		}
		
		// Create CUSTOMER objects
		for (int i = 0; i < customerData.length; i++) {
					
			customers[i] = new Customer(i, 										//ID
					customerData[i].split(" ")[1], 								//name
					Integer.parseInt(customerData[i].split(" ")[2]), 			//age
					operators[Integer.parseInt(customerData[i].split(" ")[3])],	//operator
					Double.parseDouble(customerData[i].split(" ")[4]));			//limitingAmount
		}

		// Actions
		for (int i = 0; i < actionData.length; i++) {
			
			// Simulate talking
			if (Integer.parseInt(actionData[i].split(" ")[0]) == 3) {
				if (Integer.parseInt(actionData[i].split(" ")[1]) != Integer.parseInt(actionData[i].split(" ")[2])) {
				customers[Integer.parseInt(actionData[i].split(" ")[1])].talk(Integer.parseInt(actionData[i].split(" ")[3]), 
																	customers[Integer.parseInt(actionData[i].split(" ")[2])]);
				}
			}
			
			// Simulate sending message
			else if (Integer.parseInt(actionData[i].split(" ")[0]) == 4) {
				if (Integer.parseInt(actionData[i].split(" ")[1]) != Integer.parseInt(actionData[i].split(" ")[2])) {
				customers[Integer.parseInt(actionData[i].split(" ")[1])].message(Integer.parseInt(actionData[i].split(" ")[3]),
																	customers[Integer.parseInt(actionData[i].split(" ")[2])]);
				}
			}
			
			// Simulate connecting to Internet
			else if (Integer.parseInt(actionData[i].split(" ")[0]) == 5) {
				customers[Integer.parseInt(actionData[i].split(" ")[1])].connection(Double.parseDouble(actionData[i].split(" ")[2]));
			}
			
			// Simulate paying bill
			else if (Integer.parseInt(actionData[i].split(" ")[0]) == 6) {
				customers[Integer.parseInt(actionData[i].split(" ")[1])].getBill().pay(Double.parseDouble(actionData[i].split(" ")[2]));	
			}
			
			// Simulate changing operator
			else if (Integer.parseInt(actionData[i].split(" ")[0]) == 7) {
				customers[Integer.parseInt(actionData[i].split(" ")[1])].setOperator(operators[Integer.parseInt(actionData[i].split(" ")[2])]);
			}
			
			// Simulate changing bill limit
			else if (Integer.parseInt(actionData[i].split(" ")[0]) == 8) {
				
				if (Double.parseDouble(actionData[i].split(" ")[2]) >= customers[Integer.parseInt(actionData[i].split(" ")[1])].getBill().getCurrentDebt()) {
				customers[Integer.parseInt(actionData[i].split(" ")[1])].setLimitingAmount(Double.parseDouble(actionData[i].split(" ")[2]));
				}
			}
		}
		
		// Collecting total usage data for each customer into an array 
		int[] talkingStats = new int[C];
		int[] messageStats = new int[C];
		double[] networkStats = new double[C];
		
		for (Customer customer : customers) {
			talkingStats[customer.getID()] = customer.getTalkDuration();
			messageStats[customer.getID()] = customer.getMessageQuantity();
			networkStats[customer.getID()] = customer.getConnectionAmount();
		}

		// Find the highest talking time
        int maxTalking = 0;
        int maxTalkingIndex = 0;
        for (int i = 0; i < talkingStats.length; i++) {
            if (talkingStats[i] > maxTalking) {
                maxTalking = talkingStats[i];
            	maxTalkingIndex = i;           
            }
        }
        
        // Find the highest number of messages sent
        int maxMessage = 0;
        int maxMessageIndex = 0;
        for (int i = 0; i < messageStats.length; i++) {
            if (messageStats[i] > maxMessage) {
                maxMessage = messageStats[i];
            	maxMessageIndex = i;         
            }
        }
        
        // Find the highest network usage
        double maxNetworkUsage = 0;
        int maxNetworkIndex = 0;
        for (int i = 0; i < networkStats.length; i++) {
            if (networkStats[i] > maxNetworkUsage) {
                maxNetworkUsage = networkStats[i];
            	maxNetworkIndex = i;            	
            }
        }
		
		PrintStream outstream1;
		try {
		        outstream1 = new PrintStream(outFile);
		}catch(FileNotFoundException e2) {
		        e2.printStackTrace();
		        return;
		}
		
		// Output
		for (Operator operator : operators) {
			outstream1.printf("Operator %d : %d %d %.2f\n", operator.getID(), operator.getTalkDuration(), 
					operator.getMessageQuantity(), operator.getConnectionAmount());
		}
		for (Customer customer : customers) {
			outstream1.printf("Customer %d : %.2f %.2f\n", customer.getID(), customer.getBill().getAmountPaid(), 
					customer.getBill().getCurrentDebt());
		}
		outstream1.print(customers[maxTalkingIndex].getName());
		outstream1.printf(" : %d\n", maxTalking);
		outstream1.print(customers[maxMessageIndex].getName());
		outstream1.printf(" : %d\n", maxMessage);
		outstream1.print(customers[maxNetworkIndex].getName());
		outstream1.printf(" : %.2f", maxNetworkUsage);
		
		
		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	} 
}

