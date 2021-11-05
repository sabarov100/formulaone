package formulaone;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class RacerParser {
    
    Map<String, LocalDateTime> startData;
    Map<String, LocalDateTime> endData;
    Map<String, String[]> fullNameAndTeam;
    Map<String, Racer> racers;
    
    public Map<String, Racer> initializationRacers(String fileNameAndTeam, 
            String fileStartTime, String fileEndTime, FileReader fileReader) {
        fullNameAndTeam = fileReader.getDataRacersAndTeams(fileNameAndTeam);
        startData = fileReader.getData(fileStartTime);
        endData = fileReader.getData(fileEndTime);
        Map<String, Racer> racers = new HashMap<String, Racer>();
        for (Map.Entry<String, String[]> entry : fullNameAndTeam.entrySet()) {
            String key = entry.getKey();
            String[] value = entry.getValue();
            long resultTime =  Math.abs(startData.get(key).toLocalTime().toNanoOfDay() - endData.get(key).toLocalTime().toNanoOfDay());
           racers.put(key, new Racer(key, value[0], value[1], startData.get(key), endData.get(key), resultTime));
        }
        return racers;
    }
    
}
