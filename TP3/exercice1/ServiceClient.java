package exercice1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServiceClient implements Runnable{
	
	private static final CharSequence Finish = "Finish";
	Socket socket;
	int port;
	String name="default";
	


	public ServiceClient(Socket socket, int port, String name) {
		this.socket=socket;
		this.port=port;
		this.name=name;
	}

	@Override
	public void run() {
		try {
			Service_Client(socket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	  private Boolean Service_Client(Socket la_connection) throws IOException {
          /* On Associe une file d'entr�e a la connection */
          InputStreamReader isr = new InputStreamReader(la_connection.getInputStream());
          /* On transforme cette file en file avec tampon */
          BufferedReader flux_entrant = new BufferedReader(isr);
          System.out.println("Tampon entree attache ");
          PrintWriter ma_sortie = new PrintWriter(la_connection.getOutputStream(), true);
          System.out.println("Sortie attach�e");
          System.out.println("Pr�t � servir le Client : "+ la_connection.getRemoteSocketAddress());

          String clientName = la_connection.getRemoteSocketAddress().toString();
          String message_lu = new String();
          int line_num = 0;

          /*
           * On lit le flux_entrant ligne � ligne ATTENTION : La fonction readline
           * est Bloquante readline retourne null si il y a souci avec la
           * connexion On s arrete aussisi connexion_non_terminee est vraie
           */
          ma_sortie.format("Bonjour %s j attends tes donnees  \n",clientName);
          while  (  (message_lu = flux_entrant.readLine()) != null)  {
        	  	System.out.println(name+" :");
                  System.out.format("%d: ->  [%s]\n", line_num, message_lu);
                  line_num++;
                  /* si on recoit Finish on clot et annonce cette terminaison */
                  if (message_lu.contains(Finish)) {
                          System.out.println("Reception de  " + Finish
                                          + " -> Transmission finie");
                          // On ferme la connection
                          System.out.format("Je clos la connection  %s :\n",clientName);
                          terminer(la_connection);
                          return (true);
                  }
          }
          return false;

	  	}
	  
	  private  void terminer(Socket ma_connection){
		    if (ma_connection != null)       	
		    {
			    try 	{
				ma_connection.close(); 
				System.out.format("Socket fermee \n"); 
			    }
			    catch ( IOException e )   { System.out.println("weird, nawak .... \n ");}     // do nothiing } 
			}}
	  
}
