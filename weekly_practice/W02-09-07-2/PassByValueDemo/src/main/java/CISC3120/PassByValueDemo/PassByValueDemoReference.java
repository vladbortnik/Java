package CISC3120.PassByValueDemo;

public class PassByValueDemoReference {
		void changeX(int[] x){
			System.out.println("changeX: at beginning: x[0] = " + x[0]);
			x[0] = 2;
			System.out.println("changeX: at the end: x[0] = " + x[0]);
		}
}