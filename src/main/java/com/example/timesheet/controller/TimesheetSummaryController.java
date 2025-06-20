package com.example.timesheet.controller;

import com.example.timesheet.service.TimesheetSummaryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Controller responsible for handling API requests related to timesheet summaries.
 * Provides endpoints for retrieving summary information about timesheets.
 */
@RestController
@RequestMapping("/api/timesheet")
public class TimesheetSummaryController {

    // Logger instance for logging informational and error messages within this controller.
    private static final Logger logger = LogManager.getLogger(TimesheetSummaryController.class);

    @Autowired
    private TimesheetSummaryService timesheetSummaryService;

    /**
     * Handles GET requests to retrieve the timesheet summary.
     * Logs the request and delegates the summary retrieval to the service layer.
     *
     * @return A string containing the timesheet summary.
     */
    @GetMapping("/summary")
    public String getTimesheetSummary() {
        logger.info("Fetching timesheet summary"); // Log the summary fetch request
        return timesheetSummaryService.retrieveSummary();
    }
}
