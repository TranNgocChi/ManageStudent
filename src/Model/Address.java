
package Model;


public class Address {
    private String country;
    private String city;
    private String distinct;
    private String street;

    public Address() {
    }

    public Address(String country, String city, String distinct, String street) {
        this.country = country;
        this.city = city;
        this.distinct = distinct;
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getDistinct() {
        return distinct;
    }

    public String getStreet() {
        return street;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistinct(String distinct) {
        this.distinct = distinct;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    
    

    @Override
    public String toString() {
        return "Country: " + country + " - City: " + city + " - Distinct: " + distinct + " - Street: " + street ;
    }

    
    
}
