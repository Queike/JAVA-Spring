package adbWholesaleSys.dto;

public class AddressDto {
    private int idAddress;
    private String street;
    private int streetNumber;
    private int apartmentNumber;
    private String postalCode;
    private String city;
    private String country;

    public AddressDto(){}

    public AddressDto(int idAddress, String street, int streetNumber, int apartmentNumber, String postalCode, String city, String country) {
        this.idAddress = idAddress;
        this.street = street;
        this.streetNumber = streetNumber;
        this.apartmentNumber = apartmentNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public String getStreet() {
        return street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
