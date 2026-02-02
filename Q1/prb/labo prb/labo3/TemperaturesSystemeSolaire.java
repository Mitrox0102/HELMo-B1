package labo3;

public class TemperaturesSystemeSolaire{
	
	/**
	 * Convertit en degrés Celsius une température exprimée en degrés Kelvin
	 * @param tKelvin La température exprimée en degrés Kelvin à convertir.
	 * @return la température spécifiée convertie en degrés Celsius.
	 */
	public static double enCelsius(double tKelvin) {
		return tKelvin - 273.15;
	}
	/**
	 * Cette fonction donne en Kelvin la température théorique d'une planète
	 * @param distAu distance par rapport au soleil
	 * @param albedo Température spécifiée convertie en celsuis
	 * @return la température théorique d'une planète en Kelvin
	 */
	public static double temperatureTheorique(double distAu, double albedo) {
		double tKelvin = 280.0 * Math.pow((1 - albedo) / Math.pow(distAu, 2), .25);
		return tKelvin;
	}
	
	public static void main(String[] args) {
		
		final double DIST_MERCURE = 0.38, ALBEDO_MERCURE = 0.068; 
		final double DIST_VENUS = 0.72, ALBEDO_VENUS = 0.770; 
		final double DIST_TERRE = 1.00, ALBEDO_TERRE = 0.294; 
		final double DIST_MARS = 1.52, ALBEDO_MARS = 0.250;
		final double DIST_JUPITER = 5.21, ALBEDO_JUPITER = 0.343; 
		final double DIST_SATURNE = 9.54, ALBEDO_SATURNE = 0.342; 
		final double DIST_URANUS = 19.18, ALBEDO_URANUS = 0.300; 
		final double DIST_NEPTUNE = 30.11, ALBEDO_NEPTUNE = 0.290;
		
		
		
		
		
	}
	
	
	
}