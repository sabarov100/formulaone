package formulaone;

import java.time.LocalDateTime;

public class Racer {
    
    public String abbreviation;
    public String fullName;
    public String team;
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    public long resultTime;
    
    public Racer(String abbreviation, String fullName, String team, 
            LocalDateTime startTime, LocalDateTime endTime, long resultTime) {
        super();
        this.abbreviation = abbreviation;
        this.fullName = fullName;
        this.team = team;
        this.startTime = startTime;
        this.endTime = endTime;
        this.resultTime = resultTime;
    }

}
