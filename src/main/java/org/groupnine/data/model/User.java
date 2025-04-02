package org.groupnine.data.model;
import lombok.Getter;
import lombok.Setter;
import org.groupnine.security.PasswordHash;

@Getter
public class User {
    private final int userId;
    @Setter
    private String username;
    @Setter
    private String password;
    @Setter
    private Profile profile;

    public User(int userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = PasswordHash.hashPassword(password);
    }
    public User(int userId, String username, String password, Profile profile) {
        this(userId, username, password);
        this.profile = profile;
    }
    public void changePassword(String password) {
        if (PasswordHash.hashPassword(password).equals(this.password)) {
            this.password = PasswordHash.hashPassword(password);
        }
    }
}


