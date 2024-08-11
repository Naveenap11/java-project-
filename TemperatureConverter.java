import java.util.Scanner;

public class TemperatureConverter {
    
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }
    
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();
        
        System.out.print("Enter the unit of measurement (C for Celsius, F for Fahrenheit): ");
        String unit = scanner.next().toUpperCase();
        
        if (unit.equals("C")) {
            double convertedTemp = celsiusToFahrenheit(temperature);
            System.out.printf("%.2f°C is equal to %.2f°F%n", temperature, convertedTemp);
        } else if (unit.equals("F")) {
            double convertedTemp = fahrenheitToCelsius(temperature);
            System.out.printf("%.2f°F is equal to %.2f°C%n", temperature, convertedTemp);
        } else {
            System.out.println("Invalid unit of measurement. Please use C for Celsius or F for Fahrenheit.");
        }
        scanner.close();
    }
}