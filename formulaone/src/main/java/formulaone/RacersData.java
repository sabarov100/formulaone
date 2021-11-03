package formulaone;

import java.time.LocalDateTime;
import java.util.Map;

public class RacersData {
    
    private Map<String, LocalDateTime> startData;
    private Map<String, LocalDateTime> endData;
    
    public Map<String, LocalDateTime> getStartData() {
        return startData;
    }
    
    public void setStartData(Map<String, LocalDateTime> startData) {
        this.startData = startData;
    }
    
    public Map<String, LocalDateTime> getEndData() {
        return endData;
    }
    
    public void setEndData(Map<String, LocalDateTime> endData) {
        this.endData = endData;
    }  
    
}
