package formulaone;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.jupiter.api.Test;


class FileReaderTest {
    
    private static final String ACTUAL_NULL = null;
    private static final String EXPECTED_EXCEPTION_MESSAGE = "File name cannot be NULL";
    private static List<String> EXPECTED_ONE = 
            Arrays.asList("DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER", 
                    "SVF_Sebastian Vettel_FERRARI",
                    "LHM_Lewis Hamilton_MERCEDES",
                    "KRF_Kimi Raikkonen_FERRARI",
                    "VBM_Valtteri Bottas_MERCEDES",
                    "EOF_Esteban Ocon_FORCE INDIA MERCEDES",
                    "FAM_Fernando Alonso_MCLAREN RENAULT",
                    "CSR_Carlos Sainz_RENAULT",
                    "SPF_Sergio Perez_FORCE INDIA MERCEDES",
                    "PGS_Pierre Gasly_SCUDERIA TORO ROSSO HONDA",
                    "NHR_Nico Hulkenberg_RENAULT",
                    "SVM_Stoffel Vandoorne_MCLAREN RENAULT",
                    "SSW_Sergey Sirotkin_WILLIAMS MERCEDES",
                    "CLS_Charles Leclerc_SAUBER FERRARI",
                    "RGH_Romain Grosjean_HAAS FERRARI",
                    "BHS_Brendon Hartley_SCUDERIA TORO ROSSO HONDA",
                    "MES_Marcus Ericsson_SAUBER FERRARI",
                    "LSW_Lance Stroll_WILLIAMS MERCEDES",
                    "KMH_Kevin Magnussen_HAAS FERRARI");
    
    @Before
    FileReader setUp() {
        return new FileReader();
    }

    @Test
    void testGetListData() {
       assertEquals(EXPECTED_ONE, setUp().getListData(Main.fileNameRacersInfo));
    }
    
    @Test
    void testThrowsIllegalArgumentExceptionGetData() {
        assertThrows(IllegalArgumentException.class, () -> setUp().getListData(ACTUAL_NULL));
    }
    
    
    @Test
    void testMessageIllegalArgumentExceptionGetListData() {
        try {
            setUp().getListData(ACTUAL_NULL);
        }
        catch(IllegalArgumentException exception) {
            assertEquals(EXPECTED_EXCEPTION_MESSAGE, exception.getMessage());
        }
    }

}
