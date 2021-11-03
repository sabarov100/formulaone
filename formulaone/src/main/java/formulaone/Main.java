package formulaone;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
    public static final DateTimeFormatter FORMATTER_TIME = DateTimeFormatter.ofPattern("mm:ss.SSS");

    public static void main(String[] args) {
        RasersData rasersData = new RasersData();
        Map<String, LocalDateTime> startData = rasersData.getData("C:\\repositoryfour\\formulaone\\src\\main\\resources\\start.log");
        Map<String, LocalDateTime> endData = rasersData.getData("C:\\repositoryfour\\formulaone\\src\\main\\resources\\end.log");
        Map<String, Long> resultData = new HashMap<>();
        for (Map.Entry<String, LocalDateTime> entry : startData.entrySet()) {
            String key = entry.getKey();
            LocalDateTime value = entry.getValue();
            long one = value.toLocalTime().toNanoOfDay();
            long two = endData.get(key).toLocalTime().toNanoOfDay();
            long three = Math.abs(one - two);
            resultData.put(key, three);
        }
        Map<String, String> rasers = rasersData.getDataRasers("C:\\repositoryfour\\formulaone\\src\\main\\resources\\abbreviations.txt");
        List<String[]> list = new ArrayList();
        resultData.entrySet().stream()
        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
        .forEach(s -> list.add(s.toString().split("="))); 
        
        StringBuilder sb = new StringBuilder();
        
        for(int j = list.size() - 1; j > - 1; j--) {
        sb.append(list.size() - j).append(".").append((j > 9 ? RasersData.spaces(2) : RasersData.spaces(1)))
        .append(rasers.get(list.get(j)[0])).append(LocalTime.ofNanoOfDay(resultData.get(list.get(j)[0])).format(FORMATTER_TIME)).append("\n");
        if(j == 4) sb.append(RasersData.dashs(61)).append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
     
}
