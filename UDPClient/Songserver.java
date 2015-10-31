import java.io.*;
import java.net.*;
/**
 * Write a description of class Songserver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Songserver implements Runnable 
{
    private static final int PORT =4004;
    private ServerSocket server;
    private Socket client;
    private DataInputStream dis;
    private FileOutputStream fos;
    public void run(){
        
            try {
                server =new ServerSocket(PORT);
                  
                while(true){
                    client = server.accept();
                    dis =new DataInputStream(client.getInputStream());
                    String fileName = KeyBoard.getString("Please input name");
                    //found file name
                    fos =new FileOutputStream(new File("" + fileName));
                    byte[] sendBytes =new byte[1024];
                    
                    System.out.println("start receiveing " + fileName );
                    client.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
    }
}