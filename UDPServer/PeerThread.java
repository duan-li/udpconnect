
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
   // ArrayList<Peer> peerList;
     private UDPServer uServer;
   // public PeerThread(UDPServer uServer){
     // this.uServer=uServer;
   // }
     public void run()
    {
        
         try
        {
         DatagramSocket serverSocket = new DatagramSocket(4000);
         System.out.println("Server started on port 4000");
         byte[] receiveData = new byte[1024];
         byte[] sendData = new byte[1024];
         while(true)
         {   
              //peerList= new ArrayList<Peer>();
              //byte[] receiveData = new byte[1024];
             // byte[] sendData = new byte[1024];
              DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
              serverSocket.receive(receivePacket);
              InetAddress IPAddress = receivePacket.getAddress();
              int port = receivePacket.getPort();
              LocalDateTime loggedin= LocalDateTime.now();
              System.out.println("Handling client at"+IPAddress+"and log in at"+ loggedin);
              String message = (new String( receivePacket.getData())).trim();
              System.out.println("Message received from peer: " + message);
              System.out.println("Yes");
-------------------------------------------------这以上的功能都可以运行-----------------------------------------------------------
-------------------------------------------------下面就直接到exception 的部分了-------------------------------------------------------------
              //String response = "I don't know what to say";

              //Peer myPeer = new Peer(IPAddress);
              boolean peerInlist = false;
              Peer currentPeer= null;
              ArrayList<Peer> peerList = uServer.listPeer(); 
              
              for(Peer p: peerList)
                {
                     if(IPAddress.equals(p.getAddress()))
                     {
                          peerInlist = true;
                          currentPeer = p;
                          break;
                     }
                }
              System.out.println("Client says "+message);
              if(message.startsWith("H")&&(!peerInlist)){
                 //response = "Hi There";
                 System.out.println("Client says Hi, Peer Not Found in list, creating a new peer");
                 Peer np = new Peer(IPAddress,loggedin);
                 peerList.add(np); 
                 System.out.println("Peer list size"+peerList.size());
               }
                else if(message.startsWith("T")&&peerInlist){
                String[] results= message.split(",");
                String Name = results[1];
               //response = "I will look  "+Name+"for you";
                System.out.println("Client says T, wants song "+ Name+", searching for song in peer list");
                Peer hasSong=null;
                for(Peer sp: peerList){
                 if(sp.hasSong(Name)) {
                    hasSong=sp;
                    break;
                    }
                }
                if(hasSong!=null){
                System.out.println("Peer with Ip address "+hasSong.getAddress()+" has the requested song");
                }
                else{
                 System.out.println("Song not found within peers");
                }
              }
               else if(message.startsWith("L")&&peerInlist)
               {
                //response = "Thanks for these, I will add them to your list";
                System.out.println("Client says L, Peer Found in list, ading song list to peer");
                String[] mySong= message.split(",");
                int i;
                if(currentPeer!=null){
                for( i =0;i<=mySong.length;i++){
                 currentPeer.addSong(mySong[i]);
                }
                }
                else{
                  System.out.println("Peer Not Found thers some unknown error");
                }
              }
               else if(message.startsWith("G")&&peerInlist){
                System.out.println("Client says Good bye, removing peer from list");
                //response = "See you later";
                peerList.remove(currentPeer);
                System.out.println("Peer list size"+peerList.size());
               }
              // sendData = response.getBytes();
              //DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
              //serverSocket.send(sendPacket);
             //  System.out.println("Message sent to peer: " + response);
          }
        }
        catch(Exception ex)
        {
            System.out.println("Error starting server");
        }
    
    }
}
      
}