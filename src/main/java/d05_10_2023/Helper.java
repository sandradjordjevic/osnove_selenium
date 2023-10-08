package d05_10_2023;

import java.io.IOException;
import java.net.*;

public class Helper {
    public static int getHTTPResponseStatusCode(String u) throws IOException {
        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
        URL url = new URL(u);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        return http.getResponseCode();
    }
}
