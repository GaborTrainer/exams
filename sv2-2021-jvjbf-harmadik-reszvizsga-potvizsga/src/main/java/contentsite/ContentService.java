package contentsite;

import java.util.HashSet;
import java.util.Set;

public class ContentService {

    private Set<User> allUsers = new HashSet<>();

    private Set<Content> allContent = new HashSet<>();

    public void registerUser(String name, String password) {
        if (allUsers.stream()
                .anyMatch(user -> user.getUserName().equals(name))) {
            throw new IllegalArgumentException("Username is already taken: " + name);
        } else {
            allUsers.add(new User(name, password));
        }
    }

    public void addContent(Content content) {
        if (allContent.stream()
                .anyMatch(content1 -> content1.getTitle().equals(content.getTitle()))) {
            throw new IllegalArgumentException("Content name is already taken: " + content.getTitle());
        } else {
            allContent.add(content);
        }
    }

    public void logIn(String userName, String password) {
        findUser(userName, password).setLogIn(true);
    }

    private User findUser(String userName, String password) {
        User user = allUsers.stream()
                .filter(u -> u.getUserName().equals(userName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Username is wrong!"));
        if ((userName + password).hashCode() == user.getPassword()) {
            return user;
        }
        throw new IllegalArgumentException("Password is Invalid!");
    }

    public void clickOnContent(User user, Content content) {
        if (user.isLogIn()) {
            if (content.isPremiumContent() && user.isPremiumMember()) {
                content.click(user);
            } else if (!content.isPremiumContent()) {
                content.click(user);
            } else {
                throw new IllegalStateException("Upgrade for Premium to watch this content!");
            }
        } else {
            throw new IllegalStateException("Log in to watch this content!");
        }
    }

    public Set<User> getAllUsers() {
        return allUsers;
    }

    public Set<Content> getAllContent() {
        return allContent;
    }
}
