/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import Conn.Comandos;
import Entidades.UsuarioLogado;
import Entidades.teste;
import GUI.Cadastro;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author Pedro
 */
public class actions {
    Comandos com;
    public boolean cadastrar(String nome, String login, String senha) throws NotBoundException, MalformedURLException, RemoteException{
                com = (Comandos) Naming.lookup("//" + "192.168.0.14" + "/host");
                System.out.println(""+nome+" "+login+" "+senha);
                return com.Cadastrar(nome, login, senha);
    }
    
    public boolean login(String login, String senha) throws NotBoundException, MalformedURLException, RemoteException{
            com = (Comandos) Naming.lookup("//" + "192.168.0.14" + "/host");
            return com.Login(login, senha);
    }
    
    public ArrayList<UsuarioLogado> usuariosLogados() throws NotBoundException, MalformedURLException, RemoteException{
            com = (Comandos) Naming.lookup("//" + "192.168.0.14" + "/host");
            teste u = com.ListaDeClientesConectados();
            return u.lista;
    }
    
}
