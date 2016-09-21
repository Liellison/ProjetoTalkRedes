/*Este codigo do servidor foi passado pelo professor da disciplina, inicialmente ele faz a letra fica em caixa alta*/
class TCPServer{
    public static void main(String argv[]) throws Exception{
        String clienteSentence;
        String capitalizerSentence;
        /*Cria socket de apresentaçao na porta 6789*/
        ServerSocket welcomeSocket = new ServerSocket(6798);
        while (true){
        /*Espera no socket de apresentacao pelo contato do cliente*/
            Socket connectionSocket = welcomeSocket.accept();
        /*Cria cadeia de entrada, conectada ao socket*/
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        /*Cria cadeia de saida, conectada ao socket*/
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        /*Le linha do socket*/
            clienteSentence = inFromClient.readLine();
        /*Coloca o que esta na linha do socket em caixa alta*/
            capitalizerSentence = clienteSentence.toUpperCase()+ "\n";
        /*Escreve linha no socket*/
            outToClient.writeBytes(capitalizerSentence);
        }
    }
}