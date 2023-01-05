package emailservice;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class EmailService {

    private Set<User> users = new LinkedHashSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public void registerUser(String emailAddress) {
        int index = emailAddress.indexOf("@");
        if (!Objects.equals(emailAddress, emailAddress.toLowerCase()) || !emailAddress.contains("@") || 1 > index || !emailAddress.contains(".") || emailAddress.indexOf(".") <= index + 1) {
            throw new IllegalArgumentException("Email address is not valid: " + emailAddress);
        }
        if (users.stream()
                .anyMatch(user -> user.getEmailAddress().equals(emailAddress))) {
            throw new IllegalArgumentException("Email address is already taken!");
        }
        users.add(new User(emailAddress));
    }

    public void sendEmail(String from, String to, String subject, String content) {
        User sender = null;
        User receiver = null;
        for (User user : users) {
            if (user.getEmailAddress().equals(from)) {
                sender = user;
            }
            if (user.getEmailAddress().equals(to)) {
                receiver = user;
            }
        }
        sender.sendEmail(subject, content, receiver);
    }

    public void sendSpam(String subject, String content) {
        for (User user : users) {
            user.getEmail(new Spam(user, subject, content));
        }
    }
}