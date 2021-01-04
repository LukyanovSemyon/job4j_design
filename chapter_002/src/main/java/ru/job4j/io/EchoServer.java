package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean x = true;
            while (x) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while ((str = in.readLine()) != null && !str.isEmpty()) {
                        if (str.contains("/?msg=")) {
                            String line = str.split("=")[1];
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            if (line.contains("Exit")) {
                                x = false;
                                out.write("Bye".getBytes());
                            } else if (line.contains("Hello")) {
                                out.write("Hello, dear friend".getBytes());
                            } else {
                                out.write("What?".getBytes());
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            LOG.error("Exception", e);
        }
    }
}
