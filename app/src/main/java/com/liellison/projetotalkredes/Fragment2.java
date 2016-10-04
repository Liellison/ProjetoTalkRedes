package com.liellison.projetotalkredes;

/**
 * Created by liellison on 22/09/16.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Fragment2 extends Fragment implements View.OnClickListener {
    private Socket socket;
    EditText etTCP1;
    Button btsendTCP;
    TextView tvTCP1;
    private static final int SERVERPORT = 6798;
    private static final String SERVER_IP = "192.168.25.19";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag2, container, false);
        etTCP1 = (EditText) rootView.findViewById(R.id.etTCP1);
        btsendTCP = (Button) rootView.findViewById(R.id.btsendTCP);
        btsendTCP.setOnClickListener(this);
        new Thread(new ClientThread()).start();
        return  inflater.inflate(R.layout.frag2,container,false);
    }

    @Override
    public void onClick(View v) {
        try {
            String modifiedSentence;
            String string = etTCP1.getText().toString();
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            out.println(string);
            out.flush();

            BufferedReader  inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Socket clientSocket = new Socket("192.168.25.19", 6798);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            string = inFromClient.readLine();
            outToServer.writeBytes(string + '\n');
            modifiedSentence = inFromServer.readLine();
            tvTCP1.setText(modifiedSentence.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    class ClientThread implements Runnable {

        @Override
        public void run() {

            try {
                InetAddress serverAddr = InetAddress.getByName(SERVER_IP);
                socket = new Socket(serverAddr, SERVERPORT);

            } catch (UnknownHostException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }

    }
}

