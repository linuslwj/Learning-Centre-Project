package CompanyStructure;

import static org.junit.jupiter.api.Assertions.*;

class SoftwareEngineerTest {
    SoftwareEngineer sw;
    TechnicalLead tl;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        sw = new SoftwareEngineer("Bob");
        tl = new TechnicalLead("Peter");
        tl.addReport(sw);
        sw.setCodeAccess(true);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        sw = null;
    }

    @org.junit.jupiter.api.Test
    void checkInCode() {
        boolean hasCheckIn;
        hasCheckIn = sw.checkInCode();
        assertTrue(hasCheckIn);
    }
}