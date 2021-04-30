package model.airports;

public class Airport {
    private int AirportID;
    private String AirportCode;
    private String AirportName;
    private int CountryID;
    public Airport() {
    }

    public Airport(int airportID) {
        AirportID = airportID;
    }

    public Airport(String airportCode, String airportName, int countryID) {
        AirportCode = airportCode;
        AirportName = airportName;
        CountryID = countryID;
    }

    public Airport(int airportID, String airportCode, String airportName, int countryID) {
        AirportID = airportID;
        AirportCode = airportCode;
        AirportName = airportName;
        CountryID = countryID;
    }

    public int getAirportID() {
        return AirportID;
    }

    public void setAirportID(int airportID) {
        AirportID = airportID;
    }

    public String getAirportCode() {
        return AirportCode;
    }

    public void setAirportCode(String airportCode) {
        AirportCode = airportCode;
    }

    public String getAirportName() {
        return AirportName;
    }

    public void setAirportName(String airportName) {
        AirportName = airportName;
    }

    public int getCountryID() {
        return CountryID;
    }

    public void setCountryID(int countryID) {
        CountryID = countryID;
    }


    @Override
    public String toString() {
        return "Airport{" +
                "AirportID=" + AirportID +
                ", AirportCode='" + AirportCode + '\'' +
                ", AirportName='" + AirportName + '\'' +
                ", CountryID=" + CountryID +
                '}';
    }
}
