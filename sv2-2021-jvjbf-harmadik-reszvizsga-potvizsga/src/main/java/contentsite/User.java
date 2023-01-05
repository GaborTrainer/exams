package contentsite;

public class User {

    private String userName;

    private int password;

    private boolean isPremiumMember;

    private boolean isLogin;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = (userName + password).hashCode();
    }

    public void upgradeForPremium() {
        isPremiumMember = true;
    }

    public void setLogIn(boolean value) {
        isLogin = value;
    }

    public String getUserName() {
        return userName;
    }

    public int getPassword() {
        return password;
    }

    public boolean isPremiumMember() {
        return isPremiumMember;
    }

    public boolean isLogIn() {
        return isLogin;
    }
}
