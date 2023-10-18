package com.reader.article_analyzer.Notifier;
import com.reader.article_analyzer.Model.User;
import org.springframework.stereotype.Component;

@Component

public class EmailNotificationService implements UserNotificationService {

    @Override
    public void userNotifier(User user) {
        System.out.println("Dear," + user.getUsername() + "!" + " New categories were published. via Email");
    }
}
