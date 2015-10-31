
/**
 * Write a description of class Thread here.
 * 4003
 * just waiting 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*; 
import java.net.*;
import java.time.*;
import java.util.*;
public class PeerThread implements Runnable
{
    ArrayList<Peer> peerList;
     public void run()
    {
        while(true){
         try
        {
         DatagramSocket serverSocket = new DatagramSocket(4000);
         System.out.println("Server started on port 4000");
         byte[] receiveData = new byte[1024];
         byte[] sendData = new byte[1024];
         while(true)
         {   
              peerList= new ArrayList<Peer>();
              DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
              serverSocket.receive(receivePacket);
              InetAddress IPAddress = receivePacket.getAddress();
              int port = receivePacket.getPort();
              LocalDateTime loggedin= LocalDateTime.now();
              System.out.println("Handling client at"+IPAddress+"and log in at"+ loggedin);
              String message = (new String( receivePacket.getData())).trim();
              System.out.println("Message received from peer: " + message);
              String response = "I don't know what to say";
              Peer myPeer = new Peer(IPAddress);
              if(message.startsWith("H")){
                response = "Hi There";
                if( peerList.contains(myPeer)){
                  myPeer.Loggin();
                }
                else{
                    peerList.add(myPeer);
                }
               }
              else if(message.startsWith("B")){
                response = "See you later";
                peerList.remove(myPeer);
               }
             
     
              sendData = response.getBytes();
              DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
              serverSocket.send(sendPacket);
              System.out.println("Message sent to peer: " + response);
          }
        }
        catch(Exception ex)
        {
            System.out.println("Error starting server");
        }
       }
    }
    public ArrayList<Peer> getAllPeer(){
    return peerList;
    }
      
}
