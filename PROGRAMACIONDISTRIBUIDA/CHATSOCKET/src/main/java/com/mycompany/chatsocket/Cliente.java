/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatsocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Usuario
 */
public class Cliente implements Runnable {

    private int puerto;
    private String mensaje;

    public Cliente(int puerto, String mensaje) {
        this.puerto = puerto;
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        final String HOST = "127.0.0.1";
 
        DataInputStream in;
        DataOutputStream out;

        try {
            
            // creo el socket para contacto con el cliente
            Socket sc = new Socket(HOST, puerto);
        
            out = new DataOutputStream(sc.getOutputStream());

            out.writeUTF(mensaje);

       

            sc.close();

        } catch (IOException ex) {
        }
    }
}
