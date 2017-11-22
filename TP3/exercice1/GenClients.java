package exercice1;

import java.io.IOException;

public class GenClients {
	public static void main(String[] args) throws IOException {
		SimpleClient client1= new SimpleClient("127.0.0.1", 12000, "Pika");
		SimpleClient client2= new SimpleClient("127.0.0.1", 12000, "Cara");
		SimpleClient client3= new SimpleClient("127.0.0.1", 12000, "Draco");
		SimpleClient client4= new SimpleClient("127.0.0.1", 12000, "Flori");
		SimpleClient client5= new SimpleClient("127.0.0.1", 12000, "Mew");

		
	    Thread t1 = new Thread(client1);
	    t1.start();
	    System.out.println("Thread 1 lancé");
	    Thread t2 = new Thread(client2);
        t2.start();
        System.out.println("Thread 2 lancé");
        Thread t3 = new Thread(client3);
        t3.start();
        System.out.println("Thread 3 lancé");
        Thread t4 = new Thread(client4);
        t4.start();
        System.out.println("Thread 4 lancé");
        Thread t5 = new Thread(client5);
        t5.start();
        System.out.println("Thread 5 lancé");
	      
	}
}
