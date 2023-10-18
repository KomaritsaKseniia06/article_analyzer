package com.reader.article_analyzer;

import org.springframework.stereotype.Component;
import com.reader.article_analyzer.Model.User;
import com.reader.article_analyzer.Notifier.EmailNotificationService;
import com.reader.article_analyzer.Notifier.SlackNotificationService;
import java.util.List;

@Component
public class UserNotifier {

    private final UserReader userReader;
    private final EmailNotificationService emailNotificationService;
    private final SlackNotificationService slackNotificationService;

    public UserNotifier(UserReader userReader, EmailNotificationService emailNotificationService, SlackNotificationService slackNotificationService) {
        this.userReader = userReader;
        this.emailNotificationService = emailNotificationService;
        this.slackNotificationService = slackNotificationService;
    }

    public void notifyUsersAboutCategoryChanges() {

        List<User> users = userReader.userReader().stream().toList();

        // Notify each user based on their notification preference
        for (User user : users) {
            switch (user.getNotificationType()) {
                case EMAIL -> emailNotificationService.userNotifier(user);
                case SLACK -> slackNotificationService.userNotifier(user);
            }
        }
    }
}
