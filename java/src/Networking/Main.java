package Networking;

import java.net.*;
import java.io.*;
import java.net.InetAddress;

public class Main {
    public static void main(String[] args) throws Exception {
        InetAddress localhost = InetAddress.getLocalHost();
        System.out.println("My System's IP Address: " + (localhost.getHostAddress()).trim());

        String systemipaddress = "";
        try {
            URL url_name = new URL("http://bot.whatismyipaddress.com");
            BufferedReader sc = new BufferedReader(new InputStreamReader(url_name.openStream()));

            systemipaddress = sc.readLine().trim();
        } catch (Exception e) {
            systemipaddress = "Can't get Public IP Address";
        }
        System.out.println("My Public IP Address: " + systemipaddress + "\n");
    }
}