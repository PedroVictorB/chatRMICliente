/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Conn;

import Entidades.UsuarioLogado;
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
    Chat chat;
    
    public String login = "";
    
    public server() throws RemoteException{
        
    } 
    
    public void startCliente(){
        try {
            System.out.println(""+login);
            obj = new server(); 
            r = LocateRegistry.getRegistry();
            if(LocateRegistry.getRegistry() == null){
                r = LocateRegistry.createRegistry(1099);
            }else{
                r = LocateRegistry.getRegistry();
            }
            r.bind(login, obj);
            System.out.println("Ligado no registro");
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void mensagem(String msg) throws RemoteException {
        chat = Chat.getInstance();
        chat.addTexto(msg);
    }
    
    public void chatWindow(){
        chat = Chat.getInstance();
        chat.setVisible(true);
    }
}
