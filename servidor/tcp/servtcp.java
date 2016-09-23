/*Este codigo do servidor foi passado pelo professor da disciplina, inicialmente ele faz a letra fica em caixa alta*/
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

class TCPServer{
    public static void main(String argv[]) throws Exception{
        String clienteSentence;
        String capitalizerSentence;
        /*Cria socket de apresentaçao na porta 6789*/
        ServerSocket welcomeSocket = new ServerSocket(6798);
        while (true){
        /*Espera no socket de apresentacao pelo contato do cliente*/
            Socket connectionSocket = welcomeSocket.accept();
            System.out.println("\n IP: " + connectionSocket.getInetAddress() + " - Conectado!\n");
        /*Cria cadeia de entrada, conectada ao socket*/
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        /*Cria cadeia de saida, conectada ao socket*/
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            InetAddress IPAddress = connectionSocket.getInetAddress();
            int port = connectionSocket.getPort();
            /*Le linha do socket*/
            clienteSentence = inFromClient.readLine();
        /*Coloca o que esta na linha do socket em caixa alta*/
            capitalizerSentence = clienteSentence.toUpperCase()+ "\n";
        /*Escreve linha no socket*/
            outToClient.writeBytes(capitalizerSentence);
        }
    }
}