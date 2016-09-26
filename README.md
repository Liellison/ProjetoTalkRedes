[![API](https://img.shields.io/badge/API-14%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=14)


# Talk Simple

O app tem como objetivo realizar a troca de strings entre dois telefones com o sistema operacional Android.

Inicialmente o projeto saiu de um trabalho na disciplina de Redes de Computadores no semestre 2016.1 na UERN-Natal.

O objetivo do projeto da disciplina era de usar tanto um servidor TCP como um UDP para realizar calculos numericos, onde o usuario iria dar valores e o servidor iria retornar com o calculo. Porem, me senti mais motivado a realizar a troca de strings.

## Descrição
O professor da disciplina passou um *servidor* na qual tinha a função de pegar uma string e colocar em caixa alta, como podemos ver no codigo abaixo:
```java
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
```
E os alunos iriam mudar o servidor para ele retorna a soma de numeros.

![Image of homescreen](https://github.com/Liellison/ProjetoTalkRedes/blob/master/screenshot/Screenshot_1474719408.png)
