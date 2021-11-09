package formulaone;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacerParser {
    
    private static final DateTimeFormatter FORMATTER = 
            DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
    private static final String UNDERLINE = "_";
    private static final String EXCEPTION_MESSAGE = "Argument cannot be NULL";
    
    public Map<String, Racer> initializationRacers(List<String> fullNameAndTeam, 
            List<String> startData, List<String> endData) {
        if (fullNameAndTeam == null || startData == null || endData == null) { 
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        Stream<String> streamFromCollection = fullNameAndTeam.stream();
        Map<String, String[]> mapInfo = streamFromCollection
                .collect(Collectors.toMap(s -> s.substring(0, 3), 
                        s ->  s.substring(4, s.length()).split(UNDERLINE)));
        streamFromCollection = startData.stream();
        Map<String, LocalDateTime> mapStartTime = streamFromCollection
                .collect(Collectors.toMap(s -> s.substring(0, 3), 
                        s -> LocalDateTime.parse(s.substring(3), FORMATTER)));
        streamFromCollection = endData.stream();
        Map<String, LocalDateTime> mapEndTime = streamFromCollection
                .collect(Collectors.toMap(s -> s.substring(0, 3), 
                        s -> LocalDateTime.parse(s.substring(3), FORMATTER)));
        Map<String, Racer> racers = new HashMap<String, Racer>();
        mapInfo.keySet().stream().forEach(s -> racers.put(s, 
                new Racer(s, mapInfo.get(s)[0], mapInfo.get(s)[1],
                mapStartTime.get(s), mapEndTime.get(s),
                Math.abs(mapStartTime.get(s).toLocalTime().toNanoOfDay()
                - mapEndTime.get(s).toLocalTime().toNanoOfDay()))));
        return racers;
    }
    
}
