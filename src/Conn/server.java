/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Conn;

import GUI.Chat;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Pedro
 */
public class server extends UnicastRemoteObject implements ReceiveMessage{
    server obj;
    Registry r;
    public String login = "";
    Chat chat;
    
    public server() throws RemoteException{
        
    } 
    
    public void startCliente(){
        try { // Creates an object of the HelloServer class. 
            obj = new server(); // Bind this object instance to the name "HelloServer". 
            r = LocateRegistry.getRegistry();
            r.bind(login, obj);
            //Naming.rebind("sendMessage", obj);
            System.out.println("Ligado no registro / "+login);
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void mensagem(String msg) throws RemoteException {
        chat = Chat.getInstance();
        chat.login = this.login;
        System.out.println(""+msg);
        chat.addTexto(msg);
    }
    
    public void chatWindow(){
        chat = Chat.getInstance();
        chat.login = this.login;
        chat.setVisible(true);
    }
}
