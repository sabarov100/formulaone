package formulaone;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class RacerParserTest {
    
    private static final List<String> ACTUAL_NULL = null;
    private static final String EXPECTED_EXCEPTION_MESSAGE = "Argument cannot be NULL";
    private static final String EXPECTED = ""
            + "{VBM=VBM Valtteri Bottas MERCEDES 2018-05-24T12:00 2018-05-24T12:01:12.434 72434000000,"
            + " SVF=SVF Sebastian Vettel FERRARI 2018-05-24T12:02:58.917 2018-05-24T12:04:03.332 64415000000,"
            + " CSR=CSR Carlos Sainz RENAULT 2018-05-24T12:03:15.145 2018-05-24T12:04:28.095 72950000000,"
            + " DRR=DRR Daniel Ricciardo RED BULL RACING TAG HEUER 2018-05-24T12:14:12.054 2018-05-24T12:15:24.067 72013000000,"
            + " KMH=KMH Kevin Magnussen HAAS FERRARI 2018-05-24T12:02:51.003 2018-05-24T12:04:04.396 73393000000,"
            + " SPF=SPF Sergio Perez FORCE INDIA MERCEDES 2018-05-24T12:12:01.035 2018-05-24T12:13:13.883 72848000000,"
            + " SVM=SVM Stoffel Vandoorne MCLAREN RENAULT 2018-05-24T12:18:37.735 2018-05-24T12:19:50.198 72463000000,"
            + " CLS=CLS Charles Leclerc SAUBER FERRARI 2018-05-24T12:09:41.921 2018-05-24T12:10:54.750 72829000000,"
            + " BHS=BHS Brendon Hartley SCUDERIA TORO ROSSO HONDA 2018-05-24T12:14:51.985 2018-05-24T12:16:05.164 73179000000,"
            + " LHM=LHM Lewis Hamilton MERCEDES 2018-05-24T12:18:20.125 2018-05-24T12:19:32.585 72460000000,"
            + " LSW=LSW Lance Stroll WILLIAMS MERCEDES 2018-05-24T12:06:13.511 2018-05-24T12:07:26.834 73323000000,"
            + " RGH=RGH Romain Grosjean HAAS FERRARI 2018-05-24T12:05:14.511 2018-05-24T12:06:27.441 72930000000,"
            + " FAM=FAM Fernando Alonso MCLAREN RENAULT 2018-05-24T12:13:04.512 2018-05-24T12:14:17.169 72657000000,"
            + " SSW=SSW Sergey Sirotkin WILLIAMS MERCEDES 2018-05-24T12:16:11.648 2018-05-24T12:17:24.354 72706000000,"
            + " NHR=NHR Nico Hulkenberg RENAULT 2018-05-24T12:02:49.914 2018-05-24T12:04:02.979 73065000000,"
            + " MES=MES Marcus Ericsson SAUBER FERRARI 2018-05-24T12:04:45.513 2018-05-24T12:05:58.778 73265000000,"
            + " EOF=EOF Esteban Ocon FORCE INDIA MERCEDES 2018-05-24T12:17:58.810 2018-05-24T12:19:11.838 73028000000,"
            + " PGS=PGS Pierre Gasly SCUDERIA TORO ROSSO HONDA 2018-05-24T12:07:23.645 2018-05-24T12:08:36.586 72941000000,"
            + " KRF=KRF Kimi Raikkonen FERRARI 2018-05-24T12:03:01.250 2018-05-24T12:04:13.889 72639000000}";

    @Before
    RacerParser setUp() {
        return new RacerParser();
    }
    
    @Before
    FileReader setUpFileReader() {
        return new FileReader();
    }

    @Test
    void testInitializationRacers() {
        assertEquals(EXPECTED, setUp().initializationRacers(setUpFileReader().getListData(Main.fileNameRacersInfo),
                setUpFileReader().getListData(Main.fileNameStartTime), 
                setUpFileReader().getListData(Main.fileNameEndTime)).toString());
    }
    
    @Test
    void testMessageIllegalArgumentExceptionInitializationRacers() {
        try {
            setUp().initializationRacers(ACTUAL_NULL,
                    setUpFileReader().getListData(Main.fileNameStartTime), 
                    setUpFileReader().getListData(Main.fileNameEndTime));
        }
        catch(IllegalArgumentException exception) {
            assertEquals(EXPECTED_EXCEPTION_MESSAGE, exception.getMessage());
        }
    }
}
