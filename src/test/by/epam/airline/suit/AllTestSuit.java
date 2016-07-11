package test.by.epam.airline.suit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.by.epam.airline.action.RangeComparatorTest;
import test.by.epam.airline.util.JsonParserTest;

@Suite.SuiteClasses( { JsonParserTest.class, RangeComparatorTest.class } )
@RunWith(Suite.class)
public final class AllTestSuit {
}
