package formulaone;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)


class FacadeTest {
    
    @Mock
    private FileReader mockedFileReader;
    
    @Mock
    private RacerParser mockedRacerParser;
    
    @Mock
    private Formatter mockedFormatter;
    
    @InjectMocks
    private Facade facade;

   
    @Test
    void testFacade() {
        mockedFileReader = Mockito.mock(FileReader.class);
        mockedRacerParser = Mockito.mock(RacerParser.class);
        mockedFormatter = Mockito.mock(Formatter.class);
        facade = new Facade(mockedFileReader, mockedRacerParser, mockedFormatter);
    }

    @Test
    void testBestRacersResultsOfRing() {
        facade.bestRacersResultsOfRing(Main.fileNameStartTime, Main.fileNameEndTime, Main.fileNameRacersInfo);
    }

}
