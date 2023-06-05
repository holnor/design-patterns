package hu.holnor.designpatterns;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        WeatherStation weatherStation = new WeatherStation();
        DisplayDevice device1 = new DisplayDevice("device1", weatherStation);
        DisplayDevice device2 = new DisplayDevice("device2", weatherStation);
        DisplayDevice device3 = new DisplayDevice("device3", weatherStation);

        weatherStation.registerObserver(device1);
        weatherStation.registerObserver(device2);
        weatherStation.registerObserver(device3);

        weatherStation.startMeasure();
    }
}
