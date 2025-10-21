package net.engineeringdigest.journalApp.Entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
@Builder
public class User {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    @NonNull
    private String userName;
    @NonNull
    private String password;
    @DBRef
    private List<JournalEntry> journalEntries = new ArrayList<>();
    private List<String> roles;
}
/*
private List<String> roles; in user we didnt used NoArgs Constructor,
 so what about this as even @Non Null is not used for this

What happens with journalEntries
Notice in your User class:
@DBRef
private List<JournalEntry> journalEntries = new ArrayList<>();
Here you explicitly initialized the list with new ArrayList<>().
So even without a constructor, when you create a new User(), journalEntries is not null, but an empty list.

3. Why no @NoArgsConstructor needed here
roles is optional (no @NonNull), so Lombok doesn’t enforce it in the constructor.
You didn’t initialize it like you did with journalEntries.
Therefore, it’s just null until you set it.

If later you try something like:
user.getRoles().add("ADMIN");
you’ll get a NullPointerException, because roles wasn’t initialized.

✅ Best practice
Either:
Initialize it inline:
private List<String> roles = new ArrayList<>();
Or ensure it’s always set before use (e.g., in your service when saving a user).*/
