/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Conn;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

/**
 *
 * @author Pedro
 */
public class Connection{
    
    static Comandos msg = null;
    
    public static void main(String[] args) {
        try {
            //System.setSecurityManager(new RMISecurityManager());
            msg = (Comandos) Naming.lookup("//" + "192.168.0.14" + "/host");
            System.out.println("Mensagem no servidor RMI de: " + msg.Login("pedro","senha123"));
        } catch (Exception e) {
            System.out.println("HelloClient exception: " + e.getMessage());
            e.printStackTrace();
        }
        
    }
    
    public void login(){
        
    }
}
