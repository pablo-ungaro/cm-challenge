import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SingleDigitTest {

    @Test
    public void sequenceRepetitionTest(){
        assertEquals("ABCABCABCABC",SingleDigit.repeatSequence("ABC",4));
        assertEquals("ABC",SingleDigit.repeatSequence("ABC",1));
        assertEquals("ABC",SingleDigit.repeatSequence("ABC",0));
    }

    @Test
    public void singleDigitTest(){
        assertEquals(8 ,SingleDigit.generate("9875",4));
        assertEquals(2 ,SingleDigit.generate("9875",1));
        assertEquals(2 ,SingleDigit.generate("9875",0));
        assertEquals(2 ,SingleDigit.generate("9875",-1));
    }
}
