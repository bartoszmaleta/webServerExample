package com.company.newHandler;

import com.company.Hello;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main2 {

    public static void main(String[] args) throws IOException {
        // write your code here
        // create a server on port 8000
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        // set routes
        server.createContext("/hello", new Form());
        server.setExecutor(null); // creates a default execturo

        // start listening
        server.start();
    }
}
