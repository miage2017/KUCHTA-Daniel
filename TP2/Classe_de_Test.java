
public class Classe_de_Test implements Runnable{
	
	public int direction;

	
	public Classe_de_Test(int i) {
		//si -1 decremente
		//si 1 incremente
		direction=i;
	}
	
	@Override
	public void run() {
		if(direction==1) {
			int i=0;
			while(i!=1000) {
				System.out.println("Incrémentation : "+i);
				i++;
			}
			System.out.println("Fin de l'incrémentation");
		}
		
		if(direction==-1) {
			int i=1000;
			while(i!=0) {
				System.out.println("Decrémentation : "+i);
				i--;
			}
			System.out.println("Fin de la Décrémentation");
		}
	}
	
	public static void main(String[] args) {
		Classe_de_Test mon_objet_executable = new Classe_de_Test(1);
		Thread monJob = new Thread(mon_objet_executable);
		monJob.start();
		
		Classe_de_Test mon_objet_executable2 = new Classe_de_Test(-1);
		Thread monJob2 = new Thread(mon_objet_executable2);
		monJob2.start();
	}

}
