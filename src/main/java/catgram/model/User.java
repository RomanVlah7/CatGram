package catgram.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;

@Data
@Builder

public class User {
    public LocalDate birthDate;
    private String email;
    private String nickname;

}
