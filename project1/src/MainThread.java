
public class MainThread {
	
	/*
	 * TestThread extends the Thread class in order to override the Run method 
	 */
	class TestThread extends Thread {
		  Thread t;
		  public TestThread(String name){
		    super(name);
		    System.out.println("statut du thread " + name + " = " +this.getState());
		    this.start();
		    System.out.println("statut du thread " + name + " = " +this.getState());
		  }
		 
		  public TestThread(String name, Thread t){
		    super(name);
		    this.t = t;
		    System.out.println("statut du thread " + name + " = " +this.getState());
		    this.start();
		    System.out.println("statut du thread " + name + " = " +this.getState());
		  }
		 
		  public void run(){
		    for(int i = 0; i < 10; i++){
		      System.out.println("statut " + this.getName() + " = " +this.getState());
		      if(t != null)
		        System.out.println("statut de " + t.getName() + " pendant le thread " + this.getName() +" = " +t.getState());
		    }
		  }
		 
		  public void setThread(Thread t){
		    this.t = t;
		  }
		  
	} //End of TestThread		

	
	/**
	 * Entry point
	 */
	public static void main(String[] args) {
				MainThread mt = new MainThread();
			    TestThread t1 = mt.new TestThread("A");
			    TestThread t2 = mt.new TestThread("  B", t1);
			    try {
			      Thread.sleep(1000);
			    } catch (InterruptedException e) {
			      e.printStackTrace();
			    }
			    System.out.println("statut du thread " + t1.getName() + " = " + t1.getState());
			    System.out.println("statut du thread " + t2.getName() + " = " +t2.getState());                
			  
	} // End of main 

} //End of MainThread 

