package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestDoubleDispatch.class, TestHabitaciones.class, TestPersona.class,
		TestPrestaciones.class })
public class TestSuitUnitarios {

}
