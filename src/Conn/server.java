/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Conn;

import Entidades.Mensagem;
import Entidades.UsuarioLogado;
import GUI.ChatGrupo;
import GUI.ChatIndividual;
import GUI.Principal;
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
    ChatGrupo chatg;
    ChatIndividual chati;
    
    public String login = "";
    
    public server() throws RemoteException{
        
    } 
    
    public void startCliente(){
        try {
            obj = new server(); 
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
    public void mensagemGrupo(String msg) throws RemoteException {
        chatg = ChatGrupo.getInstance();
        chatg.addTexto(msg);
    }
    
    public void chatGrupoWindow(){
        chatg = ChatGrupo.getInstance();
        chatg.setVisible(true);
    }

    @Override
    public void mensagemIndividual(Mensagem m) throws RemoteException {
        Principal p = Principal.getInstance();
        UsuarioLogado usuario = p.usuario;
        boolean found = false;
        for(ChatIndividual l : p.lista){
            if(m.getTo().equals(l.toNome)){
                l.addTexto(m.getMensagem());
                found = true;
            }
        }
        if(found == false){
            ChatIndividual c = new ChatIndividual();
            c.id = usuario.getId();
            c.login = usuario.getLogin();
            c.nome = usuario.getNome();
            c.toLogin = m.getFrom();
            //c.toId
            p.lista.add(c);
            c.setVisible(true);
            c.addTexto(m.getMensagem());
        }
    }
}
