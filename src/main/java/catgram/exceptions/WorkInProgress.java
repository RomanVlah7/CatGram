package catgram.exceptions;

import org.springframework.stereotype.Component;

@Component
public class WorkInProgress extends Exception{
    public WorkInProgress(){
        super("This feature will be ready soon");
    }
}
