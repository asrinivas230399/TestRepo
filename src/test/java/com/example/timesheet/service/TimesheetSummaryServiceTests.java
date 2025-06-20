/****
 * Unit tests for the TimesheetSummaryService class.
 * <p>
 * This test class verifies the behavior of the TimesheetSummaryService, particularly the retrieval of timesheet summaries.
 * It uses Mockito to mock dependencies and JUnit 5 for test structure.
 */
public class TimesheetSummaryServiceTests {

    @Mock
    private TimesheetRepository timesheetRepository;

    @InjectMocks
    private TimesheetSummaryService timesheetSummaryService;

    /**
     * Initializes mocks before each test execution.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Tests the retrieveSummary() method of TimesheetSummaryService.
     * <p>
     * Verifies that the summary string correctly reflects the total number of timesheets returned by the repository.
     */
    @Test
    public void testRetrieveSummary() {
        // Arrange: Set up mock timesheet data and repository behavior
        Timesheet timesheet1 = new Timesheet();
        Timesheet timesheet2 = new Timesheet();
        List<Timesheet> timesheets = Arrays.asList(timesheet1, timesheet2);

        when(timesheetRepository.findAll()).thenReturn(timesheets);

        // Act: Call the method under test
        String summary = timesheetSummaryService.retrieveSummary();

        // Assert: Verify the summary output
        assertEquals("Total timesheets: 2", summary);
    }
}
