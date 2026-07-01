package Services;

import Config.Config;
import Entities.Weather;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Service {
    static String baseURL = Config.getBaseUrl();
    static String apiKey = Config.getAPI();
    static String units = Config.getUnits();

    private static String getApi(String city) {
        String url = baseURL + "?q=" + city + "&appid=" + apiKey + "&units=" + units;

        return url;
//            Formatter(res);
//            String cityName = res.split("\"name\":\"")[1].split("\"")[0];
//            String tempString = res.split("\"temp\":")[1].split(",")[0];
//            double temp = Double.parseDouble(tempString);
//            String humidityString=res.split("\"humidity\":")[1].split(",")[0];
//            int humidity = Integer.parseInt(humidityString);
//            String condition= res.split("\"weather\":\\[\\{")[1]
//                    .split("\"main\":\"")[1]
//                    .split("\"")[0];

        //  return new Weather(cityName, temp, humidity, condition);

    }

    private static Entities.Weather Formatter(String res){
        String cityName = res.split("\"name\":\"")[1].split("\"")[0];
        String tempString = res.split("\"temp\":")[1].split(",")[0];
        double temp = Double.parseDouble(tempString);
        String humidityString=res.split("\"humidity\":")[1].split(",")[0];
        int humidity = Integer.parseInt(humidityString);
        String condition= res.split("\"weather\":\\[\\{")[1]
                .split("\"main\":\"")[1]
                .split("\"")[0];

        return new Entities.Weather(cityName, temp, humidity, condition);
    }

    public static Weather CallApi(String city) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(getApi(city)))
                .GET()
                .build();

        String res = null;
        try {
            //  Receive response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            res = response.body();
            // Print results
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response: " + res);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return Formatter(res);
    }

}