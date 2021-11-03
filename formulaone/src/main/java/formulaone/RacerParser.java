package formulaone;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class RacerParser {
    
    public Map<String, String> rasers;
    
    Map<String, String> getRasers() {
        return rasers;
    }

    void setRasers(Map<String, String> rasers) {
        this.rasers = rasers;
    }

    public Map<String, Long> setResultResers(Map<String, LocalDateTime> startData, Map<String, LocalDateTime> endData) {
        Map<String, Long> resultRacers = new HashMap<String, Long>();
        for (Map.Entry<String, LocalDateTime> entry : startData.entrySet()) {
            String key = entry.getKey();
            LocalDateTime value = entry.getValue();
            long one = value.toLocalTime().toNanoOfDay();
            long two = endData.get(key).toLocalTime().toNanoOfDay();
            long three = Math.abs(one - two);
            resultRacers.put(key, three);
        }
        return resultRacers;
    }
    

}
