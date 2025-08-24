package com.sigwarthsoftware.net;

//=================================-Imports-==================================
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

@Getter
@Setter
@Slf4j
public class ApiDataRetriever {
    //============================-Variables-=================================
    private String url;
    private String response;
    //============================-Constants-=================================
    public static final String NO_DATA_ERROR_MESSAGE = "Error: No data received " +
            "from API";
    //===========================-Constructors-===============================
    public ApiDataRetriever(String url) {
        this.url = url;
        this.response = "";
        this.fetchResponse();
    }
    //=============================-Methods-==================================

    //---------------------------Fetch-Response-------------------------------
    public void fetchResponse() {
        StringBuilder responseJson = new StringBuilder();
        HttpsURLConnection urlConnection = null;
        BufferedReader apiReader = null;
        try {
            URI uri = new URI(this.url);
            urlConnection = (HttpsURLConnection) uri.toURL().openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream urlStream = urlConnection.getInputStream();
            InputStreamReader urlStreamReader = new InputStreamReader(urlStream);
            apiReader = new BufferedReader(urlStreamReader);
            String jsonLine;
            while ((jsonLine = apiReader.readLine()) != null) {
                responseJson.append(jsonLine);
            }
        } catch (URISyntaxException | IOException ex) {
            log.error("Error fetching API data: {}", ex.getMessage());
        } finally {
            if (responseJson.isEmpty()) {
                this.response = NO_DATA_ERROR_MESSAGE;
                System.out.println(NO_DATA_ERROR_MESSAGE);
            } else {
                this.response = responseJson.toString();
            }
            shutDownConnections(urlConnection, apiReader);
        }
    }
    //-----------------------Shut-Down-Connections----------------------------
    public static void shutDownConnections(HttpsURLConnection urlConnection,
                                           BufferedReader apiReader) {
        if (apiReader != null) {
            try {
                apiReader.close();
            } catch (IOException ex) {
                log.error("Error closing API reader: {}", ex.getMessage());
            }
        }
        if (urlConnection != null) {
            urlConnection.disconnect();
        }
    }
    //============================-Overrides-=================================

    //------------------------------Equals------------------------------------

    //------------------------------Hash-Code---------------------------------

    //------------------------------To-String---------------------------------

}