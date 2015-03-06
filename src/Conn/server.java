/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Conn;

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
    public String login;
    
    public server() throws RemoteException{
        
    } 
    
    public void startCliente(){
        try { // Creates an object of the HelloServer class. 
            obj = new server(); // Bind this object instance to the name "HelloServer". 
            r = LocateRegistry.createRegistry(1099);
            r.bind(login, obj);
            //Naming.rebind("sendMessage", obj);
            System.out.println("Ligado no registro");
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void mensagem(String msg) throws RemoteException {
        
    }
    
}
