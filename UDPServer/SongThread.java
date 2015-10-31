import java.io.*; 
import java.net.*;
import java.time.*;
import java.util.*;
import java.lang.*;
/**
 * Write a description of class SongThread here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SongThread implements Runnable 
{
    ArrayList<Peer> myPeers= new ArrayList<Peer>();
    public void run()
    {
        while(true){
         try
        {
         DatagramSocket serverSocket = new DatagramSocket(4002);
         System.out.println("Server started on port 4002");
         byte[] receiveData = new byte[1024];
         byte[] sendData = new byte[1024];
         while(true)
         {   
              ArrayList<Peer> peerList= new ArrayList<Peer>();
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
              if(message.startsWith("F")){
                String[] results= message.split(",");
                String Name = results[1];
                
                response = "I will look  "+Name+"for you";
                
               }
              else if(message.startsWith("M")){
                response = "Thanks for these, I will add them to your list";
                String[] mySong= message.split(",");
                int i;
                for( i =0;i<=mySong.length;i++){
                 myPeer.addSong(mySong[i]);
                }
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
    public InetAddress findAsong(String name)
    {
         InetAddress found=null ;
         for(Peer p:myPeers){
            if(p.hasSong(name)){
              found =p.getAddress();
            
            }
            else{
            System.out.println("Nothing");
            }
            
            }
            return found;
    
    }
}
