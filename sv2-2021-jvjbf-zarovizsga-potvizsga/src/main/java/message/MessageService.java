package message;

import java.util.Optional;

public class MessageService {

    private UserRepository userRepository;

    private MessageRepository messageRepository;

    public MessageService(UserRepository userRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    public void registerUser(String username) {
        if (userRepository.findUserByName(username).equals(Optional.empty())) {
            userRepository.insertUser(username);
        } else {
            throw new IllegalArgumentException("Username is already taken: " + username);
        }
    }

    public void sendMessage(User sender, User receiver, String message) {
        Optional<User> actualSender = userRepository.findUserByName(sender.getUsername());
        Optional<User> actualReceiver = userRepository.findUserByName(receiver.getUsername());

        if (actualReceiver.isPresent() && actualReceiver.isPresent()) {
            messageRepository.saveMessage(actualSender.get().getId(), actualReceiver.get().getId(), message);
        } else {
            throw new IllegalArgumentException("Sender or receiver not found!");
        }
    }
}
