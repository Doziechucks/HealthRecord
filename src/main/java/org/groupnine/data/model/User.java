package org.groupnine.data.model;
import lombok.Getter;
import lombok.Setter;
import org.groupnine.security.PasswordHash;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
public class User {
    @BsonId
    @BsonProperty("user_id")
    private String userId;
    @Setter
    @Indexed(unique = true)
    @BsonProperty("username")
    private String username;
    @Setter
    private String password;
    @Setter
    private Profile profile;

    public User(String username, String password) {
        this.username = username;
        this.password = PasswordHash.hashPassword(password);
    }
    public User(String username, String password, Profile profile) {
        this(username, password);
        this.profile = profile;
    }
    public void changePassword(String password) {
        if (PasswordHash.hashPassword(password).equals(this.password)) {
            this.password = PasswordHash.hashPassword(password);
        }
    }
}


