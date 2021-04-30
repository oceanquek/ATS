package model.airports;

public class Country {
    private int CountryID;
    private String CountryName;
    private String CountryCity;
    private String CountryState;

    public Country() {
    }

    public Country(int countryID, String countryName, String countryCity, String countryState) {
        CountryID = countryID;
        CountryName = countryName;
        CountryCity = countryCity;
        CountryState = countryState;
    }

    public int getCountryID() {
        return CountryID;
    }

    public void setCountryID(int countryID) {
        CountryID = countryID;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public String getCountryCity() {
        return CountryCity;
    }

    public void setCountryCity(String countryCity) {
        CountryCity = countryCity;
    }

    public String getCountryState() {
        return CountryState;
    }

    public void setCountryState(String countryState) {
        CountryState = countryState;
    }
}
