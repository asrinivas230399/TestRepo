package com.example.timesheet.repository;

import com.example.timesheet.model.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing Timesheet entities.
 * Provides CRUD operations and custom query methods for Timesheet data.
 */
@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {

    /**
     * Retrieves a list of Timesheet records for a specific user and period.
     *
     * @param userId the ID of the user whose timesheets are to be retrieved
     * @param period the period (e.g., month or week) for which timesheets are to be retrieved
     * @return a list of Timesheet objects matching the specified user ID and period
     */
    List<Timesheet> findByUserIdAndPeriod(Long userId, String period);
}
