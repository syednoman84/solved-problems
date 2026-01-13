package problems.Intervals;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    InsertIntervalTest.class,
    MergeIntervalTest.class,
    NonOverlappingIntervalsTest.class,
    MeetingRoomsTest.class,
    MeetingRoomsIITest.class,
    MinimumIntervalToIncludeEachQueryTest.class
})
public class IntervalsTestSuite {
}