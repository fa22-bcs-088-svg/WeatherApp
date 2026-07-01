import Entities.Weather;
import Services.Service;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the name of the City to find its weather conditions");
        Scanner city = new Scanner(System.in);
        String cityName = city.nextLine();
        Weather weather= Service.CallApi(cityName);
        System.out.println(weather);
    }
}