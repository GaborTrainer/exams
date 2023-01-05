package emailservice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class User {

    private String emailAddress;

    private List<Email> incoming = new ArrayList<>();

    private List<Email> sent = new ArrayList<>();

    private boolean hasSpamFilter;

    public User(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void getEmail(Email email) {
        if (hasSpamFilter && email.getFrom().getEmailAddress().contains("spam")) {
            throw new IllegalStateException("Be careful, this is a spam!");
        }
        incoming.add(email);
    }

    public void sendEmail(String subject, String content, User to) {
        Email toSend = new Normal(this, to, subject, content);
        sent.add(toSend);
        to.getEmail(toSend);
    }

    public void spamFilterChange() {
        hasSpamFilter = !hasSpamFilter;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public List<Email> getIncoming() {
        return incoming.stream()
                .sorted(Comparator.comparing(Email::isImportant).reversed())
                .toList();
    }

    public List<Email> getSent() {
        return sent;
    }

    public boolean hasSpamFilter() {
        return hasSpamFilter;
    }
}