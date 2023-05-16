/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socket03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Cliente {
    
        
    public static void main(String[] args) {
        
        final int PUERTO_SERVIDOR=5000;
        byte [] buffer = new byte[1024];
        
        
        try {
            
            InetAddress direccionServidor= InetAddress.getByName("localhost");
            
            DatagramSocket socketUDP= new DatagramSocket();
            
            String mensaje="HOLA MUNDO DESDE EL CLIENTE";
            
            buffer=mensaje.getBytes();
            
            DatagramPacket pregunta= new DatagramPacket(buffer, buffer.length , direccionServidor ,PUERTO_SERVIDOR );
             
            System.out.println("ENVIO EL DATAGRAMA");
            socketUDP.send(pregunta);
            
            
            DatagramPacket peticion= new DatagramPacket(buffer, buffer.length , direccionServidor ,PUERTO_SERVIDOR );
            
            socketUDP.receive(peticion);
            System.out.println("RECIBO PETICION");
            mensaje= new String(peticion.getData());
            
            System.out.println(mensaje);
            
            socketUDP.close();
            
            
        } catch (SocketException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        catch (UnknownHostException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
}
