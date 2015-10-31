import java.io.*;
import java.net.*;
import java.util.*;
/**
 * Write a description of class Thread here.
 * Timer;
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClientThread implements Runnable 
{
  
    public void run()
    {
        while(true)
            switch (menu() ) 
            {
                    case 1:
                         hello();
                        break;
                    case 2:
                        sendSongs();
                        break;
                    case 3:
                        findSong();
                        break;
                     case 4:
                        goodbye();
                        return;
                      
                     default:
                        System.out.println ( "Unrecognized option" );
                        break;
            }
    }
    
    private int menu()
    {   
            System.out.println 
            ("1) Say Hi\n2) Send Song List\n3) Find Song\n4) Say Goodbye\n " );
            return KeyBoard.getInteger("Select Option: ");
     }
    
    private void hello()
    {
        System.out.println("Server Response: " + sendMessage("Hi"));
    }
    
    private void goodbye()
    {
       System.out.println("Server Response: " + sendMessage("Bye"));
       
    }   
    
    private void sendSongs()
    {
       System.out.println("Server Response: " + sendMessage2("MySongs, Yes, Hello, Hey Jude, Imagine"));
    }
    
    private void findSong()
    {
        String findSongName = KeyBoard.getString("Please input the song Name");
        System.out.println("Server Response: " + sendMessage2("Find,"+findSongName));
    }
    
    private String sendMessage(String message)
    {
        String result = "No Reply Received";
        int timeOut=5000;
        try
        {
            
            
            DatagramSocket clientSocket = new DatagramSocket();
            clientSocket.setSoTimeout(timeOut); 
           // String IpAddress= KeyBoard.getString("Please input the service IP");
            InetAddress IPAddress = InetAddress.getByName("115.64.109.50");
            byte[] sendData = new byte[message.length()];
            byte[] receiveData = new byte[1024];
            sendData = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 4000);
            clientSocket.send(sendPacket);
            System.out.println("----------------------");
            System.out.println("Message sent to Server: " + message);
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            
            clientSocket.receive(receivePacket);
            result = new String(receivePacket.getData());
           
        }
        catch(Exception ex)
        {
            System.out.println("Error contacting server");
        }
        return result;
   }
     private String sendMessage2(String message)
    {
        String result = "No Reply Received";
        int timeOut=5000;
        try
        {
            

            DatagramSocket clientSocket = new DatagramSocket();
            clientSocket.setSoTimeout(timeOut); 
           // String IpAddress= KeyBoard.getString("Please input the service IP");
            InetAddress IPAddress = InetAddress.getByName("115.64.109.50");
            byte[] sendData = new byte[message.length()];
            byte[] receiveData = new byte[1024];
            sendData = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 4002);
            clientSocket.send(sendPacket);
            System.out.println("----------------------");
            System.out.println("Message sent to Server: " + message);
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            
            clientSocket.receive(receivePacket);
            result = new String(receivePacket.getData());
           
        }
        catch(Exception ex)
        {
            System.out.println("Error contacting server");
        }
        return result;
   }
    
    
}
