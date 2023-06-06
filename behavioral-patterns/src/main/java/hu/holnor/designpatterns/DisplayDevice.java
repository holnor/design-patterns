package hu.holnor.designpatterns;

public class DisplayDevice implements Observer {
    private String id;
    private WeatherStation weatherStation;

    public DisplayDevice(String id, WeatherStation weatherStation) {
        this.id = id;
        this.weatherStation = weatherStation;
    }

    public void display() {
        System.out.println("<" + id + ">\n" + "Temperature: " + weatherStation.getTemperature() + "\nHumidity: " + weatherStation.getHumidity() + "\n" +"-".repeat(30) + "\n");
    }

    public void update() {
        display();
    }
}
