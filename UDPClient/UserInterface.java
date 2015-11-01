
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
           new UserInterface().go();  
           
       }  
     
       private void go() {  
           ClientThread ct = new ClientThread();  
           new Thread(ct).run();  
           
           //ClientRecvThread recv = new ClientRecvThread();  
           //new Thread(recv).start();  
       }  
    

    
}// end of class
