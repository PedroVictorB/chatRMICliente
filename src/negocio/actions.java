/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import Conn.Comandos;
import java.rmi.Naming;

/**
 *
 * @author Pedro
 */
public class actions {
    Comandos com;
    public void cadastrar(){
        try {
            //System.setSecurityManager(new RMISecurityManager());
            com = (Comandos) Naming.lookup("//" + "192.168.0.14" + "/host");
            System.out.println("Mensagem no servidor RMI de: " + com.Login("pedro","senha123"));
        } catch (Exception e) {
            System.out.println("HelloClient exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
