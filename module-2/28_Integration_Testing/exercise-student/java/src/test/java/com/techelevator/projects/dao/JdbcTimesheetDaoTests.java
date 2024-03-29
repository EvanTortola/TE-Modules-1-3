package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public class JdbcTimesheetDaoTests extends EmployeeProjectsDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1L, 1L, 1L, 
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2L, 1L, 1L,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3L, 2L, 1L,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4L, 2L, 2L,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao sut;
    private Timesheet testTS;


    @Before
    public void setup() {

        sut = new JdbcTimesheetDao(dataSource);
        testTS = new Timesheet(0L, 0L, 0L, LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 0");
    }

    @Test
    public void getTimesheet_returns_correct_timesheet_for_id() {
        Timesheet actualTimesheet = sut.getTimesheet(1L);
        Assert.assertNotNull("Timesheet not returned", actualTimesheet);
        assertTimesheetsMatch(TIMESHEET_1, actualTimesheet);

    }

    @Test
    public void getTimesheet_returns_null_when_id_not_found() {
        Timesheet actualTimesheet = sut.getTimesheet(8L);
        Assert.assertNull(actualTimesheet);

    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
        Assert.fail();
    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        Assert.fail();
    }

    @Test
    public void createTimesheet_returns_timesheet_with_id_and_expected_values() {
        Timesheet createdTimesheet = sut.createTimesheet(testTS);

        long newId = createdTimesheet.getTimesheetId();
        Assert.assertTrue(newId > 0L);

        testTS.setTimesheetId(newId);
        assertTimesheetsMatch(testTS, createdTimesheet);
    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {

        Timesheet timesheet = sut.createTimesheet(testTS);

        long newId = timesheet.getTimesheetId();

        Timesheet retrievedTS = sut.getTimesheet(newId);


        assertTimesheetsMatch(timesheet, retrievedTS);





    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        Timesheet tsUpdate = sut.getTimesheet(4L);

        tsUpdate.setEmployeeId(2L);
        tsUpdate.setProjectId(1L);
        tsUpdate.setDateWorked(LocalDate.parse("2021-01-02"));
        tsUpdate.setHoursWorked(1.0);
        tsUpdate.setBillable(false);
        tsUpdate.setDescription("Timesheet 5");


        sut.updateTimesheet(tsUpdate);

        Timesheet retrievedTS = sut.getTimesheet(4L);
        assertTimesheetsMatch(tsUpdate, retrievedTS);


    }

    @Test
    public void deleted_timesheet_cant_be_retrieved() {
        sut.deleteTimesheet(1L);

        Timesheet retrievedSheet = sut.getTimesheet(1L);
        Assert.assertNull(retrievedSheet);


    }

    @Test
    public void getBillableHours_returns_correct_total() {
        Assert.fail();
    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
