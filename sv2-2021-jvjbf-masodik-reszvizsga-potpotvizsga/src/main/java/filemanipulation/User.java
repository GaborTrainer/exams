package filemanipulation;

public class User {

    private String userName;

    private int yearOfBirth;

    private String email;

    public User(String userName, int yearOfBirth, String email) {
        this.userName = userName;
        this.yearOfBirth = yearOfBirth;
        this.email = email;
    }

    public boolean isEmailAndUserMatches(){
        return userName.equalsIgnoreCase(email.split("@")[0]);
    }

    public String getUserName() {
        return userName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getEmail() {
        return email;
    }
}
