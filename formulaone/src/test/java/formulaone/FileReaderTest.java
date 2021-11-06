package formulaone;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.jupiter.api.Test;


class FileReaderTest {
    
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";
    private static final String ACTUAL_NULL = null;
    private static final String EXPECTED_EXCEPTION_MESSAGE = "File name cannot be NULL";
    private static Map<String, LocalDateTime> EXPECTED_ONE;
    static {
        EXPECTED_ONE = new HashMap<String, LocalDateTime>();
        EXPECTED_ONE.put("VBM", LocalDateTime.of(2018, 5, 24, 12, 0, 0, 0));
        EXPECTED_ONE.put("SVF", LocalDateTime.of(2018, 5, 24, 12, 2, 58, 917000000));
        EXPECTED_ONE.put("CSR", LocalDateTime.of(2018, 5, 24, 12, 3, 15, 145000000));
        EXPECTED_ONE.put("DRR", LocalDateTime.of(2018, 5, 24, 12, 14, 12, 54000000));
        EXPECTED_ONE.put("KMH", LocalDateTime.of(2018, 5, 24, 12, 2, 51, 3000000));
        EXPECTED_ONE.put("SPF", LocalDateTime.of(2018, 5, 24, 12, 12, 1, 35000000));
        EXPECTED_ONE.put("SVM", LocalDateTime.of(2018, 5, 24, 12, 18, 37, 735000000));
        EXPECTED_ONE.put("CLS", LocalDateTime.of(2018, 5, 24, 12, 9, 41, 921000000));
        EXPECTED_ONE.put("BHS", LocalDateTime.of(2018, 5, 24, 12, 14, 51, 985000000));
        EXPECTED_ONE.put("LHM", LocalDateTime.of(2018, 5, 24, 12, 18, 20, 125000000));
        EXPECTED_ONE.put("LSW", LocalDateTime.of(2018, 5, 24, 12, 6, 13, 511000000));
        EXPECTED_ONE.put("RGH", LocalDateTime.of(2018, 5, 24, 12, 5, 14, 511000000));
        EXPECTED_ONE.put("FAM", LocalDateTime.of(2018, 5, 24, 12, 13, 04, 512000000));
        EXPECTED_ONE.put("SSW", LocalDateTime.of(2018, 5, 24, 12, 16, 11, 648000000));
        EXPECTED_ONE.put("NHR", LocalDateTime.of(2018, 5, 24, 12, 2, 49, 914000000));
        EXPECTED_ONE.put("MES", LocalDateTime.of(2018, 5, 24, 12, 4, 45, 513000000));
        EXPECTED_ONE.put("EOF", LocalDateTime.of(2018, 5, 24, 12, 17, 58, 810000000));
        EXPECTED_ONE.put("PGS", LocalDateTime.of(2018, 5, 24, 12, 7, 23, 645000000));
        EXPECTED_ONE.put("KRF", LocalDateTime.of(2018, 5, 24, 12, 3, 01, 250000000));
        }
    
    private static Map<String, String[]> EXPECTED_TWO;
    static {
        EXPECTED_TWO = new HashMap<String, String[]>();
        EXPECTED_TWO.put("VBM", new String[]{"Valtteri Bottas", "MERCEDES"});
        EXPECTED_TWO.put("SVF", new String[]{"Sebastian Vettel", "FERRARI"});
        EXPECTED_TWO.put("CSR", new String[]{"Carlos Sainz", "RENAULT"});
        EXPECTED_TWO.put("DRR", new String[]{"Daniel Ricciardo", "RED BULL RACING TAG HEUER"});
        EXPECTED_TWO.put("KMH", new String[]{"Kevin Magnussen", "HAAS FERRARI"});
        EXPECTED_TWO.put("SPF", new String[]{"Sergio Perez", "FORCE INDIA MERCEDES"});
        EXPECTED_TWO.put("SVM", new String[]{"Stoffel Vandoorne", "MCLAREN RENAULT"});
        EXPECTED_TWO.put("CLS", new String[]{"Charles Leclerc", "SAUBER FERRARI"});
        EXPECTED_TWO.put("BHS", new String[]{"Brendon Hartley", "SCUDERIA TORO ROSSO HONDA"});
        EXPECTED_TWO.put("LHM", new String[]{"Lewis Hamilton", "MERCEDES"});
        EXPECTED_TWO.put("LSW", new String[]{"Lance Stroll", "WILLIAMS MERCEDES"});
        EXPECTED_TWO.put("RGH", new String[]{"Romain Grosjean", "HAAS FERRARI"});
        EXPECTED_TWO.put("FAM", new String[]{"Fernando Alonso", "MCLAREN RENAULT"});
        EXPECTED_TWO.put("SSW", new String[]{"Sergey Sirotkin", "WILLIAMS MERCEDES"});
        EXPECTED_TWO.put("NHR", new String[]{"Nico Hulkenberg", "RENAULT"});
        EXPECTED_TWO.put("MES", new String[]{"Marcus Ericsson", "SAUBER FERRARI"});
        EXPECTED_TWO.put("EOF", new String[]{"Esteban Ocon", "FORCE INDIA MERCEDES"});
        EXPECTED_TWO.put("PGS", new String[]{"Pierre Gasly", "SCUDERIA TORO ROSSO HONDA"});
        EXPECTED_TWO.put("KRF", new String[]{"Kimi Raikkonen", "FERRARI"});
        }


    @Before
    FileReader setUp() {
        return new FileReader();
    }

    @Test
    void testGetData() {
       assertEquals(EXPECTED_ONE, setUp().getData(Main.fileNameStartTime));
    }

    @Test
    void testgetDataRacersAndTeams() {
        Map<String, String[]> ACTUAL = setUp().getDataRacersAndTeams(Main.fileNameRacersInfo);
        assertEquals(toString(EXPECTED_TWO), toString(ACTUAL));
    }
    
    @Test
    void testThrowsIllegalArgumentExceptionGetData() {
        assertThrows(IllegalArgumentException.class, () -> setUp().getData(ACTUAL_NULL));
    }
    
    @Test
    void testThrowsIllegalArgumentExceptionGetDataRacersAndTeams() {
        assertThrows(IllegalArgumentException.class, () -> setUp().getDataRacersAndTeams(ACTUAL_NULL));
    }
    
    @Test
    void testMessageIllegalArgumentExceptionGetData() {
        try {
            setUp().getData(ACTUAL_NULL);
        }
        catch(IllegalArgumentException exception) {
            assertEquals(EXPECTED_EXCEPTION_MESSAGE, exception.getMessage());
        }
    }
    
    @Test
    void testMessageIllegalArgumentExceptionGetDataRacersAndTeams() {
        try {
            setUp().getDataRacersAndTeams(ACTUAL_NULL);
        }
        catch(IllegalArgumentException exception) {
            assertEquals(EXPECTED_EXCEPTION_MESSAGE, exception.getMessage());
        }
    }
    
    private String toString(Map<String, String[]> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            String key = entry.getKey();
            String[] value = entry.getValue();
            sb.append(key).append(SPACE).append(Arrays.deepToString(value)).append(NEW_LINE);
        }
        return sb.toString();
    }

}
