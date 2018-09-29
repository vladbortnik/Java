package CISC3120.PassByValueDemo;

public class PassByValueDemoReferenceTestDrive {
	public static void main(String[] args) {
		
		PassByValueDemoReference demo = new PassByValueDemoReference();
		int[] x = {3};
		System.out.println("main: before calling changeX: x[0] = " + x[0]);
		demo.changeX(x);
		System.out.println("main: after calling changeX: x[0] = " + x[0]);
		
		
		// Learning objective: these two programs show that Pass-By-Value doesn't change 
		// value of the variable in main, when Pass-By-Reference does.
		
	}
}
