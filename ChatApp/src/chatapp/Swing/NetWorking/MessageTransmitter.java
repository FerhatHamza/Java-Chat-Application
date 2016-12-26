/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatapp.Swing.NetWorking;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ferhat
 */
public class MessageTransmitter extends Thread {

    String Message, hostname;
    int Port;
    
    public MessageTransmitter() {
    }

    public MessageTransmitter(String Message, String hostname, int Port) {
        this.Message = Message;
        this.hostname = hostname;
        this.Port = Port;
    }

    
    @Override
    public void run() {
        try {
            Socket s = new Socket(hostname, Port);
            s.getOutputStream().write(Message.getBytes());
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(MessageTransmitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
