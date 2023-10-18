package com.reader.article_analyzer.Notifier;
import com.reader.article_analyzer.Model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserNotificationService {

     void userNotifier(User user);
}
