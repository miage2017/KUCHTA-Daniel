
public class Decrement implements Runnable{

	
	public void run() {
		// TODO Auto-generated method stub
		int i=1000;
		while(i!=0) {
			System.out.println("Decr�mentation : "+i);
			i--;
		}
		System.out.println("Fin de la D�cr�mentation");
	}
}
