class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        if (null != this.firstName) {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (null != this.lastName) {
            this.lastName = lastName;
        }

    }


    public String getFullName() {
        if (lastName == null && firstName == null) {
            return "Unknown";
        } else if (firstName == null) {
            return lastName;
        } else if (lastName == null) {
            return firstName;
        } else {
            return String.format("%s %s", firstName, lastName); // write your code here
        }
    }
}