package labo1;

public class ConversionsTemperature {
	
	public static void main(String[] args) {
		double tCelsius = 25.0;
		double tKelvin;
		double tFarhenheit = 0.0;
		
		//tKelvin = tCelsius + 273.15;
		//tFarhenheit = 9.0 / 5.0 * tCelsius + 32.0;

		tCelsius = (tFarhenheit - 32.0) * 5.0 / 9.0;
		tFarhenheit = tCelsius + 273.15;

		System.out.print(tCelsius);
		System.out.println("°C");
		//System.out.print(tKelvin);
		//System.out.println("K");
		System.out.print(tFarhenheit);
		System.out.println("°F");
	}
}