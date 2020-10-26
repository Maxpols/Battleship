class Phone {

    String ownerName;
    String countryCode;
    String cityCode;
    String number;

    public Phone(String owner, String number) {
        this.ownerName = owner;
        this.number = number;
    }

    public Phone(String owner, String country, String city, String number) {
        this.ownerName = owner;
        this.countryCode = country;
        this.cityCode = city;
        this.number = number;
    }
}