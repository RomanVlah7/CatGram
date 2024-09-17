package catgram.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;


@Getter
@Setter
public class Post {
    private User author;
    private String id;
    private LocalDate creationDate;
    private String descripton;
    private String photoURL;

    public Post(User author, String id, LocalDate creationDate, String descripton, String photoURL) {
        this.author = author;
        this.id = id;
        this.creationDate = creationDate;
        this.descripton = descripton;
        this.photoURL = photoURL;
    }

    public Post(User author, String descripton, String photoURL) {
        this.author = author;
        this.descripton = descripton;
        this.photoURL = photoURL;
    }
}