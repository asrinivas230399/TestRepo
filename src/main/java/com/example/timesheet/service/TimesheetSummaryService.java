package com.example.timesheet.service;

import com.example.timesheet.repository.TimesheetRepository;
import com.example.timesheet.model.Timesheet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class responsible for generating summaries of timesheet data.
 * Provides methods to retrieve and process timesheet information from the repository.
 */
@Service
public class TimesheetSummaryService {

    private static final Logger logger = LogManager.getLogger(TimesheetSummaryService.class);

    @Autowired
    private TimesheetRepository timesheetRepository;

    /**
     * Retrieves a summary of all timesheets.
     * Currently, the summary consists of the total count of timesheets in the repository.
     *
     * @return a String representing the summary of timesheets
     */
    public String retrieveSummary() {
        logger.info("Retrieving timesheet summary");
        
        // Fetch all timesheets from the repository
        List<Timesheet> timesheets = timesheetRepository.findAll();
        
        // Process the timesheets to create a summary
        // For simplicity, let's just return the count of timesheets
        String summary = "Total timesheets: " + timesheets.size();
        
        logger.info("Timesheet summary: " + summary);
        return summary;
    }
}
