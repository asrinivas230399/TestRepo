package com.example.timesheet.controller;

import com.example.timesheet.service.TimesheetSummaryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test class for {@link TimesheetSummaryController}.
 * <p>
 * This class contains unit tests for the TimesheetSummaryController, verifying the behavior of the
 * /api/timesheet/summary endpoint. It uses Mockito to mock dependencies and MockMvc to simulate HTTP requests.
 */
@WebMvcTest(TimesheetSummaryController.class)
public class TimesheetSummaryControllerTests {

    private MockMvc mockMvc;

    @Mock
    private TimesheetSummaryService timesheetSummaryService;

    @InjectMocks
    private TimesheetSummaryController timesheetSummaryController;

    /**
     * Initializes mocks and sets up MockMvc before each test.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(timesheetSummaryController).build();
    }

    /**
     * Tests the GET /api/timesheet/summary endpoint.
     * <p>
     * This test verifies that when the TimesheetSummaryService returns a summary string, the controller
     * responds with HTTP 200 OK and the expected content.
     *
     * @throws Exception if the request processing fails
     */
    @Test
    public void testGetTimesheetSummary() throws Exception {
        // Arrange: Set up the mock service to return a predefined summary
        when(timesheetSummaryService.retrieveSummary()).thenReturn("Total timesheets: 2");

        // Act & Assert: Perform the GET request and verify the response status and content
        mockMvc.perform(get("/api/timesheet/summary"))
                .andExpect(status().isOk())
                .andExpect(content().string("Total timesheets: 2"));
    }
}
