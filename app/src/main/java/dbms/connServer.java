package dbms;

import org.json.JSONArray;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import model.clsEvent;
import model.clsPerson;

public class connServer {

    public static final String servidor = "http://192.168.1.200";
    //public final String servidor = "http://asd.hol.es";

    public static JSONArray readData(String pagePHP){
        String queryURL = "/amigo/" + pagePHP;
        JSONArray arr = null;
        try {
            URL url = new URL(servidor + queryURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            String response = org.apache.commons.io.IOUtils.toString(new BufferedInputStream(conn.getInputStream()), "UTF-8");
            arr = new JSONArray(response);
        } catch (Exception e) {
            System.out.println("\nFALLO DESDE LA BASE DE DATOS ---> " + e.toString());
        }
        return arr;
    }


}