package Entities;

public class Weather {
    private String city;
    private double temp;
    private int humidity;
    private String condition;

    public Weather(String city, double temp, int humidity, String condition) {
        this.city = city;
        this.temp = temp;
        this.humidity = humidity;
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Entities.Weather{" +
                "city='" + city + '\'' +
                ", temp=" + temp +
                ", humidity=" + humidity +
                ", condition='" + condition + '\'' +
                '}';
    }
}
