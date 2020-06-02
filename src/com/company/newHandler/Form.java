package com.company.newHandler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Map;

public class Form implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response = "";
        String method = httpExchange.getRequestMethod();

        // Send a form if it wasn't submitted yet.
        if(method.equals("GET")) {
            response = "<html><body>"
                    + "<form method=\"POST\">\n"
                    + " First name:<br>\n"
                    + " <input type=\"text\" name=\"firstname\" value=\"Mickey\">\n"
                    + " <br>\n"
                    + " Last name:<br>\n"
                    + " input type=\"text\" name=\"lastname\" value=\"Mouse\">\n"
                    + " <br><br>\n"
                    + " <input type=\"submit\" value=\"Submit\">\n"
                    + "/form> "
                    + "</body></html>";
        }

        // If the form was submitted, retrieve it's content.
        if(method.equals("POST")) {
            InputStreamReader isr = new InputStreamReader(httpExchange.getRequestBody(), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String formData = br.readLine();

            System.out.println(formData);
            Map inputs = parseFormData(formData);

            response = "<html><body>"
                    + "<h1>Hello "
                    + inputs.get("firstname")
                    + " "
                    + inputs.get("lastname")
                    + "!</h1>"
                    + "</body></html>";
        }

        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private Map parseFormData(String formData) {

        return null;
    }
}
