package jiny.futurevia.service.modules.notification.domain.entity;

import jakarta.persistence.*;
import jiny.futurevia.service.modules.account.domain.entity.Account;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String link;

    private String message;

    private boolean checked;

    @ManyToOne
    private Account account;

    private LocalDateTime created;

    @Enumerated(EnumType.STRING)
    private NotificationType notificationType;

    public static Notification from(String title, String link, boolean checked, LocalDateTime created, String message, Account account, NotificationType notificationType) {
        Notification notification = new Notification();
        notification.title = title;
        notification.link = link;
        notification.checked = checked;
        notification.created = created;
        notification.message = message;
        notification.account = account;
        notification.notificationType = notificationType;
        return notification;
    }

    public void read() {
        this.checked = true;
    }
}