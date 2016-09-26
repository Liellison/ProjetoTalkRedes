package com.liellison.projetotalkredes;

/**
 * Created by liellison on 22/09/16.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;


public class Fragment2 extends Fragment implements View.OnClickListener {
    EditText etTCP1;
    Button btsendTCP;
    TextView tvTCP1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.frag2,container,false);
    }

    @Override
    public void onClick(View v) {
        btsendTCP.findViewById(R.id.btsendTCP);
        tvTCP1.findViewById(R.id.tvTCP1);
        if (v == btsendTCP){
            conectarSocket();
        }
    }

    private void conectarSocket() {
        try {
            String sentence;
            String modifiedSentence;

            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            Socket clientSocket = new Socket("192.168.25.16", 6789);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            sentence = inFromUser.readLine();
            outToServer.writeBytes(sentence + '\n');
            modifiedSentence = inFromServer.readLine();

            tvTCP1.setText(modifiedSentence.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

