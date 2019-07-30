package com.example.controller;

import com.pty4j.PtyProcess;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Terminal {

    public static void main(String[] args) {
        PtyProcess pty = null;
        String[] cmd = {"/bin/bash", "-i"};
        Map<String, String> envs = new HashMap<String, String>(System.getenv());

        try {
            pty = PtyProcess.exec(cmd, envs, System.getProperty("user.home"));
            assert pty != null;
            OutputStream os = pty.getOutputStream();
            InputStream is = pty.getInputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            String red = bufferedReader.readLine();
            System.out.println(red);
            PrintStream printStream = new PrintStream(os, true);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
