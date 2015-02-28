/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import Conn.Comandos;
import GUI.Cadastro;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pedro
 */
public class actions {
    Comandos com;
    public boolean cadastrar(String nome, String login, String senha){
        try {
                com = (Comandos) Naming.lookup("//" + "192.168.0.14" + "/host");
                System.out.println(""+nome+" "+login+" "+senha);
                return com.Cadastrar(nome, login, senha);
            } catch (NotBoundException ex) {
                Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } catch (MalformedURLException ex) {
                Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } catch (RemoteException ex) {
                Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
    }
    
    public boolean login(String login, String senha){
        try {
            com = (Comandos) Naming.lookup("//" + "192.168.0.14" + "/host");
            return com.Login(login, senha);
        } catch (NotBoundException ex) {
            Logger.getLogger(actions.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (MalformedURLException ex) {
            Logger.getLogger(actions.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (RemoteException ex) {
            Logger.getLogger(actions.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
