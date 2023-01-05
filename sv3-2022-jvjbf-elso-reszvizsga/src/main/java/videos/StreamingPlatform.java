package videos;

import java.util.ArrayList;
import java.util.List;

public class StreamingPlatform {

    private List<User> users = new ArrayList<>();

    public void addUser(User user){
        users.add(user);
    }

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    public int findMaxViews(){
//        int maxViews = 0;
//        for(User user : users){
//            int actualSum = user.sumOfViews();
//            if(actualSum>maxViews){
//                maxViews = actualSum;
//            }
//        }
//        return maxViews;
        if (users.isEmpty()) {
            return 0;
        }
        return users.stream()
                .mapToInt(User::sumOfViews)
                .max().getAsInt();
    }
}
