/*Este codigo do servidor foi passado pelo professor da disciplina, inicialmente ele faz a letra fica em caixa alta*/
import java.io.*;
import java.net.*;

class TCPServer{
    public static void main(String argv[]) throws Exception{
        String clienteSentence;
        String capitalizerSentence;

        ServerSocket welcomeSocket = new ServerSocket(6798);
        while (true){
            Socket connectionSocket = welcomeSocket.accept();

            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            clienteSentence = inFromClient.readLine();
            capitalizerSentence = clienteSentence.toUpperCase()+ "\n";

            outToClient.writeBytes(capitalizerSentence);
        }
    }
}