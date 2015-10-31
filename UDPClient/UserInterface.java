
import java.util.*;
import java.io.*;
import java.net.*;

import java.net.*;
import java.io.*;
public class UserInterface
{
    // instance variables - replace the example below with your own
       private static  UserInterface thisUserInterface=new UserInterface();
       public static void main(String[] args) throws IOException {  
          // thisUserInterface.menu();
           thisUserInterface.createThread();
           new UserInterface().go();  
          // createThread();
       }  
     
       private void go() {  
           ClientThread ct = new ClientThread();  
           new Thread(ct).run(); 
           Songserver ss=new Songserver();
           new Thread(ss).run();
          // thisUserInterface.menu();
           //ClientRecvThread recv = new ClientRecvThread();  
           //new Thread(recv).start();  
       } 
      
       private int menu()
       {   
            System.out.println 
            ("1) add songs\n2) delete songs \n3) find songs\n4)Play songs\n5)Quit\n " );
            return KeyBoard.getInteger("Select Option: ");
            
        }
       
        public void run()
       {
        while(true)
            switch (menu() ) 
            {
                    case 1:
                        addSong();
                        break;
                    case 2:
                        deleteSongs();
                        break;
                    case 3:
                        fingSong();
                        break;
                    case 4:
                        playSong();
                    case 5:
                      
                        return;
                      
                     default:
                        System.out.println ( "Unrecognized option" );
                        break;
            }
       }
       
       public void createThread(){
          
          
        
            try {
                 InetAddress SERVER_IP=InetAddress.getByName("115.64.109.50");;
                 Socket client =new Socket(SERVER_IP, 4004);
                  File file =new File("c:/test.txt");
                 // FileInputStream fis
                  FileInputStream fis= new FileInputStream(file);
                  DataOutputStream dos=new DataOutputStream(client.getOutputStream());
                 fis =new FileInputStream(file);
                 dos =new DataOutputStream(client.getOutputStream());
                 dos.writeUTF(file.getName());
                 dos.flush();

                byte[] sendBytes =new byte[1024];
                int length =0;
                while((length = fis.read(sendBytes,0, sendBytes.length)) >0){
                    dos.write(sendBytes,0, length);
                    dos.flush();
                }
            }catch (Exception e) {
                e.printStackTrace();
   
        }
        
        }
    
    public void addSong(){
    }
    
    public void deleteSongs(){
    }
    
    public void  fingSong(){
    }
    
    public void  playSong(){
    }
}
        