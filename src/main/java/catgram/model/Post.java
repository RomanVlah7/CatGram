package catgram.model;

import lombok.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Getter
@Setter
public class Post {
    static int idMaker = 1000;
    @NonNull
    private int id;
    private String author;
    private final LocalDate creationDate = LocalDate.now();
    private String description;
    private String photoUrl;

    public Post(@NonNull int id, String author, String description, String photoUrl) {
        this.id = ++idMaker;
        this.author = author;
        this.description = description;
        this.photoUrl = photoUrl;
    }
}