package formulaone;

import java.time.LocalDateTime;

public class Racer {
    
    private String abbreviation;
    private String fullName;
    private String team;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private long resultTime;
    
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

    public String getFullName() {
        return fullName;
    }

    public String getTeam() {
        return team;
    }

    public long getResultTime() {
        return resultTime;
    }

}
