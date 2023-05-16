/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.socket03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Servidor {

    public static void main(String[] args) {
        final int PUERTO=5000;
        byte [] buffer = new byte[1024];
        
        try {
            System.out.println("INICIADO EL SERVIDOR UDP");
            
            DatagramSocket socketUDP= new DatagramSocket(PUERTO);
            
            while (true) {                
                DatagramPacket peticion= new DatagramPacket(buffer, buffer.length);
            
           
            
            socketUDP.receive(peticion);
            System.out.println("RECIBO INFORMACION DEL CLIENTE");
            String mensaje= new String(peticion.getData());
            System.out.println(mensaje);
            
            int puertoCliente=peticion.getPort();
            InetAddress direccion= peticion.getAddress();
            
            mensaje="HOLA MUNDO DESDE SERVIDOR";
            buffer=mensaje.getBytes();
            
            DatagramPacket respuesta= new DatagramPacket(buffer, buffer.length , direccion ,puertoCliente );
            System.out.println("ENVIO INFORMACION DEL CLIENTE");
            socketUDP.send(respuesta);
            
            
            
            }
            
            
        } catch (SocketException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
         catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
