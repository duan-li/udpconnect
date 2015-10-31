
/**
 * Write a description of class UDPServer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*; 
import java.net.*;
import java.time.*;
import java.util.*;
class UDPServer
{
   private static ArrayList<Peer> peers= new ArrayList<Peer>();
   private static UDPServer thisServer= new UDPServer();
   public  static PeerThread pt;
   public static SongThread st ;
   public static void main(String[] args) throws IOException {  
          
           pt = new PeerThread();  
           new Thread(pt).start();  
            st = new SongThread();
           new Thread(st).start();
           //ClientRecvThread recv = new ClientRecvThread();  
           //new Thread(recv).start();  
          thisServer.menu();

        }
        
        private int menu()
    {   
            System.out.println 
            ("1) List all Peer\n2) List all songs \n3) update details\n4)Quit\n " );
            return KeyBoard.getInteger("Select Option: ");
            
     }
      public void run()
    {
        while(true)
            switch (menu() ) 
            {
                    case 1:
                        listPeer();
                        break;
                    case 2:
                        listSongs();
                        break;
                    case 3:
                        update();
                        break;
                    case 4:
                      
                        return;
                      
                     default:
                        System.out.println ( "Unrecognized option" );
                        break;
            }
    }
    
    public void listPeer(){
        pt.getAllPeer();
    }
    
    public void listSongs(){
        for(Peer p:peers){
        p.listSong();
    }
    }
    
    public void update(){
    
    }
 
}

