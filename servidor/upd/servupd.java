/*Este codigo do servidor foi passado pelo professor da disciplina, inicialmente ele faz a letra fica em caixa alta*/
class UDPServer{
    public static void main(String args[]) throws Exception{
        /*Cria socket de datagram na porta 9876*/
        DatagramSocket serverSocket = new DatagramSOcket(9876);

        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        while (true){
        /*Cria espaço para datagrama recebido*/
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        /*Recebe datagrama*/
            serverSocket.receive(receivePacket);

            String sentence = new String(receivePacket.getData());
        /*Obtem endereço IP # porta de emissor*/
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
                String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();
        /*Cria datagrama para enviar ao cliente*/
            DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, IPAddress, port);
        /*Escreve datagrama no socket*/
            serverSocket.send(sendPacket);
        }
    }
}