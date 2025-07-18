package test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import sqa.main.Ranking;

public class RankingTest {

    @ParameterizedTest(name = "Normal Test Case {index}: ({0}, {1}, {2}) => {3}")
    @CsvSource({
        "50000, 4, 500, Gold",      
        "99999, 4, 500, Gold",      
        "100000, 4, 500, Gold",     
        "100001, 4, 500, Gold",     
        "50000, 1, 500, Silver",    
        "50000, 6, 500, Gold",      
        "50000, 7, 500, Gold",      
        "50000, 8, 500, Gold",      
        "50000, 4, 0, Standard",    
        "50000, 4, 1, Standard",    
        "50000, 4, 999, Gold",      
        "50000, 4, 1000, Gold",     
        "50000, 4, 1001, Gold"      
    })
    public void normalTestCases(int purchaseTotal, int frequency, int pointCollected, String expectedRank) {
        Ranking ranking = new Ranking();
        String actualRank = ranking.CalculateMembershipRank(purchaseTotal, frequency, pointCollected);
        assertEquals(expectedRank, actualRank);
    }

    @ParameterizedTest(name = "Robust Test Case {index}: ({0}, {1}, {2}) => {3}")
    @CsvSource({
        "-1, 4, 500, Standard",     
        "0, 4, 500, Standard",      
        "1, 4, 500, Standard",      
        "50000, -1, 500, Standard", 
        "50000, 0, 500, Standard",  
        "50000, 4, -1, Standard"    
    })
    public void robustTestCases(int purchaseTotal, int frequency, int pointCollected, String expectedRank) {
        Ranking ranking = new Ranking();
        String actualRank = ranking.CalculateMembershipRank(purchaseTotal, frequency, pointCollected);
        assertEquals(expectedRank, actualRank);
    }
}
