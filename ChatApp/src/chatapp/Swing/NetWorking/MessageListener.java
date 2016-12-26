
package chatapp.Swing.NetWorking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ferhat
 */
public class MessageListener extends Thread{
    
    
    ServerSocket Server;
    int Port;
    WritableGUI Gui;
    
    public MessageListener(WritableGUI Gui ,int Port){
        try {
            
            
            this.Port = Port;
            this.Gui = Gui;
            Server = new ServerSocket(Port);
            
            
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public  MessageListener(){
        try {
            
            
            Server = new ServerSocket(Port);
            
            
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        
        try {
            
            Socket ClientSocket;
            while ((ClientSocket = Server.accept()) != null) {
                InputStream is = ClientSocket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String Line = br.readLine();
                
                if (Line != null) {
                    Gui.write(Line);
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE, null, ex);
       
        }
        
    }
    
    
    
}
