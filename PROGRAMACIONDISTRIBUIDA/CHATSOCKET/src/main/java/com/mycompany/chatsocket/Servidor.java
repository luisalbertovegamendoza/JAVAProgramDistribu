/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatsocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Servidor extends Observable implements Runnable{
   private  int puerto;
   
   public Servidor(int puerto){
     this.puerto=puerto;
   }
    

    @Override
    public void run() {
        ServerSocket servidor=null;
        Socket sc= null;
        DataInputStream in;
        DataOutputStream out;
        
     
   
        
        try {
            // creamos socket servidor
            servidor = new ServerSocket(puerto);
            System.out.println("SERVIDOR INICIADO");
            
            // siempre escucha peticiones
            while (true) {  
                // espero que un cliente se conecte
                sc=servidor.accept();
                
                in = new DataInputStream(sc.getInputStream());
               
                
                String mensaje=in.readUTF();
                
                System.out.println(mensaje);
                
                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();
                //cierro el socket
                sc.close();
                System.out.println("CLIENTE DESCONECTADO");
                
                        
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    }

