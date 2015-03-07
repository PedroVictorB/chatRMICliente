/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import Conn.Comandos;
import Entidades.UsuarioLogado;
import Entidades.ListaUsuariosLogados;
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
    
    private static final String SERVER_IP = "192.168.0.14";
    
    Comandos com;
    
    public boolean cadastrar(String nome, String login, String senha) throws NotBoundException, MalformedURLException, RemoteException{
                com = (Comandos) Naming.lookup("//" + SERVER_IP + "/host");
                System.out.println(""+nome+" "+login+" "+senha);
                return com.Cadastrar(nome, login, senha);
    }
    
    public boolean login(String login, String senha) throws NotBoundException, MalformedURLException, RemoteException{
            com = (Comandos) Naming.lookup("//" + SERVER_IP + "/host");
            return com.Login(login, senha);
    }
    
    public ArrayList<UsuarioLogado> usuariosLogados() throws NotBoundException, MalformedURLException, RemoteException{
            com = (Comandos) Naming.lookup("//" + SERVER_IP + "/host");
            ListaUsuariosLogados u = com.ListaDeClientesConectados();
            return u.lista;
    }
    
    public void enviarMensagem(String msg) throws NotBoundException, MalformedURLException, RemoteException{
        com = (Comandos) Naming.lookup("//" + SERVER_IP + "/host");
        com.SendMessage(msg);
    }
    
    public void deslogar(String login) throws NotBoundException, MalformedURLException, RemoteException{
        com = (Comandos) Naming.lookup("//" + SERVER_IP + "/host");
        com.Deslogar(login); 
    }
    
    public UsuarioLogado buscarUsuario(String login) throws NotBoundException, MalformedURLException, RemoteException{
        com = (Comandos) Naming.lookup("//" + SERVER_IP + "/host");
        return com.BuscarUsuario(login);
    }
    
}
