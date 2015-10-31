

/**
 * Write a description of class Peer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.net.*;
import java.time.*;
public class Peer

/**
 * share the arraylist
 */
{
 private InetAddress IPAddress;
 private LocalDateTime lastLoggedin;
 private ArrayList<String> songList;
 
    public Peer (InetAddress IPAddress){
     this.IPAddress=IPAddress;
    }
    public void setAddress(InetAddress IPAddress){
     this.IPAddress=IPAddress;
    }
    public InetAddress getAddress(){
     return IPAddress;
    }
    public void Loggin(){
     lastLoggedin=LocalDateTime.now();
    }
    public boolean hasSong(String songName ){
     boolean result=true;
     for(String s:songList){
         if (s.equals(songName)){
             System.out.println("Yep,has a song");
           }
           else{
           System.out.println("Nothing found");
           result=false;
        }
    } 
        return result;
    
    }
   
    public void addSong(String s){
     songList.add(s);
    }
      public ArrayList<String> listSong(){
       return songList;
     }
}