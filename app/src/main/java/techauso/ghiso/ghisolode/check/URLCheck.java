package techauso.ghiso.ghisolode.check;

import java.net.HttpURLConnection;
import java.net.URL;

public class URLCheck {
    public boolean isConnected(String url) {
        try{
            URL urls = new URL(url);
            HttpURLConnection connection = (HttpURLConnection)urls.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int code = connection.getResponseCode();
            if (code == 200){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
