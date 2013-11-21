


public class MainBank {

	/**
	 * Example of the Runnable interface usage
	 */
	/*
	 * BankAccount class define the Back Account object
	 */
	public class BankAccount {
		  private int solde = 100;
		 
		  public int getSolde(){
		    if(this.solde < 0)
		      System.out.println("You are broke !");
		 
		    return this.solde;
		  }
		 
		  public void setSolde(int s){
			  this.solde = this.solde + s;
			  System.out.println("New amount in account: "+s);
		  }
		  public synchronized void retraitArgent(int retrait){
		    solde = solde - retrait; 
		    System.out.println("Solde = " + solde);                 
		  }
	} // End of BankAccount
	
	/*
	 * Runimpl implements the Runnable interface
	 */
	public class RunImpl implements Runnable {
		  private BankAccount ba;
		  private String name;
		 
		  public RunImpl(BankAccount ba, String n){
		    this.ba = ba;
		    this.name = n;
		  }
		  public synchronized void run() {
		    for(int i = 0; i < 25; i++){
		      if(ba.getSolde() > 0){
		        ba.retraitArgent(2);
		        System.out.println("Withdrawal by"+this.name);
		      }                       
		    }               
		  }
		}
	/*
	 * Entry point 
	 */
	public static void main(String[] args) {
				MainBank mb = new MainBank();
				MainBank mb2 = new MainBank();
				
				// This section executes two users withdrawing cash from the same account
				// one after the other. Note that the order in which each occurrence of the
				// run loop is executed in each thread depends on the Java scheduler and may
				// vary from one execution to the next.
			    BankAccount ba = mb.new BankAccount();
			    Thread t = new Thread(mb.new RunImpl(ba, "UserA"));
			    Thread t2 = new Thread(mb.new RunImpl(ba, "UserB"));
			    
			    t.start();
			    t2.start();
			    
			    ba.setSolde(200);

	} // End of main

} // End of MainBank class 
