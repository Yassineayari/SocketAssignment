import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.*;

public class Server {

    static final int port = 1200;

    public static void main(String[] args) throws Exception {

        

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Waiting for connection");
        Socket socClient = serverSocket.accept(); // Accept a client socket
        System.out.println("Connection established");

        
        BufferedReader inServer = new BufferedReader(new InputStreamReader(socClient.getInputStream()));
        PrintWriter outServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socClient.getOutputStream())), true);

   
        String mymsg = inServer.readLine();
        StringBuffer sbf = new StringBuffer(mymsg);
        for (int i=0 ; i< sbf.length();i++){

            if (sbf.charAt(i) =='a' || sbf.charAt(i) == 'e'||sbf.charAt(i) =='i' ||sbf.charAt(i) =='o'||sbf.charAt(i) =='u'||sbf.charAt(i) =='y'|| sbf.charAt(i) =='A' || sbf.charAt(i) == 'E'||sbf.charAt(i) =='I' ||sbf.charAt(i) =='O'||sbf.charAt(i) =='U'||sbf.charAt(i) =='Y'){
                sbf.deleteCharAt(i);
                i--;
            }
        }
        mymsg= sbf.toString();
        outServer.println(mymsg);

        
        inServer.close();
        outServer.close();

        
        socClient.close();
        serverSocket.close();
    }
}
