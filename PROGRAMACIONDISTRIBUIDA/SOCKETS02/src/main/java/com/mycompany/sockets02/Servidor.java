/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sockets02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Servidor {

    public static void main(String[] args) {
        ServerSocket servidor=null;
        Socket sc= null;
        DataInputStream in;
        DataOutputStream out;
        
        final int PUERTO=5000;
   
        
        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("SERVIDOR INICIADO");
            
            
            while (true) {                
                sc=servidor.accept();
                
                in = new DataInputStream(sc.getInputStream());
                out= new DataOutputStream(sc.getOutputStream());
                
                String mensaje=in.readUTF();
                
                System.out.println(mensaje);
                
                out.writeUTF("HOLA MUNDO DEL SERVIDOR");
                
                sc.close();
                System.out.println("CLIENTE DESCONECTADO");
                
                        
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
