/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.chatservers.Chatservers;

import com.Binita.chatservers.listener.ClientHandler;
import com.Binita.chatservers.listener.ClientListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Bini
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int port=9000;
        try{
        ServerSocket server=new ServerSocket(port);
            System.out.println("server is running at"+port);
            ClientHandler handler=new ClientHandler();
            while(true){
            Socket client = server.accept();
                System.out.println("connection request from" + client.getInetAddress().getHostAddress());
                ClientListener listener=new ClientListener(client,handler);
                listener.start();
            
                
            }
           
            
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
                
        }
    
    } 
    }
    
