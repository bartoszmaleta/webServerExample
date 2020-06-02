package com.company;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class Hello implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response = "Hello World!";
        String response2 = "\nOne more time";
        String responseAdded = response + response2;

        httpExchange.sendResponseHeaders(200, responseAdded.length());
        OutputStream os = httpExchange.getResponseBody();

//        os.write(response2.getBytes());
//        os.write(response.getBytes());
        os.write(responseAdded.getBytes());
        os.close();
    }
}
