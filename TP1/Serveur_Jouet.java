import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Serveur_Jouet {
	
	
	
	public void run() {
		
	}
	
	
	/**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(12000);
        boolean serverClosed =false;
        try {
            while (true) {
                Socket socket = listener.accept();
                System.out.println("Ouverture de la connexion");
                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("Serveur : Coucou la famille");
                    out.println("Serveur : Voici la date:");
                    out.println(new Date().toString());
                    
                    InputStreamReader isr = new InputStreamReader(socket.getInputStream(), "UTF-8");
                    BufferedReader flux_entrant = new BufferedReader(isr) ;
                    String nouveau_message;
                    
                    while(!serverClosed && ((nouveau_message = flux_entrant.readLine()) != null)) {
                    	
                    	System.out.println(nouveau_message);
                    	
                    	if(nouveau_message.equals("finish")) {
                    		serverClosed=true;
                    		//System.out.println(serverClosed);
                    	}
                    		
                	}
                   //System.out.println("fin du while");
                    
                } finally {
                	System.out.println("Fermeture de la connexion ");
                    socket.close();
                }
            }
        }
        finally {
            listener.close();
        }
    }
}
