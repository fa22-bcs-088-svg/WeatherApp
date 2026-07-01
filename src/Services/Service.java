package Services;

import Config.Config;
import Entities.Weather;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Service {

    static String apiKey = Config.getApiKey();

    public static Weather getApi(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q="
                + city
                + "&appid="
                + apiKey
                + "&units=metric";
    HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        String res = null;

        try {
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            res = response.body();

            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response: " + res);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        String cityName = res.split("\"name\":\"")[1].split("\"")[0];

        String tempString = res.split("\"temp\":")[1].split(",")[0];
        double temp = Double.parseDouble(tempString);

        String humidityString = res.split("\"humidity\":")[1].split(",")[0];
        int humidity = Integer.parseInt(humidityString);

        String condition = res.split("\"weather\":\\[\\{")[1]
                .split("\"main\":\"")[1]
                .split("\"")[0];

        System.out.println("\nParsed Weather:");
        System.out.println("City: " + cityName);
        System.out.println("Temp: " + temp);
        System.out.println("Humidity: " + humidity);
        System.out.println("Condition: " + condition);

        return new Weather(cityName,temp,humidity,condition);
    }
}