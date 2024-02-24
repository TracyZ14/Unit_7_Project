public class Address
{
    private String houseNumber;
    private String streetName;
    private String apartmentNumber;
    private String city;
    private String state;
    private String zipCode;

    public Address(String houseNumber, String streetName, String apartmentNumber, String city, String state, String zipCode)
    {
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.apartmentNumber = apartmentNumber;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Address(Address address)
    {
        this.houseNumber = address.getHouseNumber();
        this.streetName = address.getStreetName();
        this.apartmentNumber = address.getApartmentNumber();
        this.city = address.getCity();
        this.state = address.getState();
        this.zipCode = address.getZipCode();
    }

    public Address(String address)
    {
        int firstSpaceIndex = address.indexOf(" ");
        this.houseNumber = address.substring(0, firstSpaceIndex);
        address = address.substring(firstSpaceIndex + 1);
        int aptIndex = address.indexOf("Apt");
        int firstCommaIndex = address.indexOf(",");
        if(aptIndex == -1)
        {
            this.streetName = address.substring(0, firstCommaIndex);
            this.apartmentNumber = "";
        }
        else
        {
            this.streetName = address.substring(0, (aptIndex - 1));
            this.apartmentNumber = address.substring((aptIndex + 4), firstCommaIndex);
        }
        address = address.substring(firstCommaIndex + 2);
        int secondCommaIndex = address.indexOf(",");
        this.city = address.substring(0, secondCommaIndex);
        address = address.substring(secondCommaIndex + 2);
        int lastSpaceIndex = address.indexOf(" ");
        this.state = address.substring(0, lastSpaceIndex);
        address = address.substring(lastSpaceIndex + 1);
        this.zipCode = address.substring(0, 5);
    }

    public String getHouseNumber()
    {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber)
    {
        this.houseNumber = houseNumber;
    }

    public String getStreetName()
    {
        return streetName;
    }

    public void setStreetName(String streetName)
    {
        this.streetName = streetName;
    }

    public String getApartmentNumber()
    {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber)
    {
        this.apartmentNumber = apartmentNumber;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    public String toString()
    {
        String address = "";
        address += houseNumber;
        address += (" " + streetName);
        if(!apartmentNumber.equals(""))
        {
            address += (" Apt " + apartmentNumber);
        }
        address += (", " + city);
        address += (", " + state);
        address += (" " + zipCode);
        return address;
    }
}