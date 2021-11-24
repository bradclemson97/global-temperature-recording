import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ET
 * @version 2019-08-23 13:09
 */
public class Session12Exercises {
    @Test
    public void testValidation() {
        assertEquals("The number 101 is not between 0 and 100", rangeValidation(101));
        assertEquals("The number -1 is not between 0 and 100", rangeValidation(-1));
        assertEquals("The number 100 is valid", rangeValidation(100));
        assertEquals("The number 0 is valid", rangeValidation(0));
    }

    private String rangeValidation(int value) {
        return value >= 0 && value <= 100 ? "The number " + value + " is valid" :
                "The number " + value + " is not between 0 and 100";
    }

    @Test
    public void shouldReturnMonthNameSwitchStatement() {
        assertEquals("January", getMonthName(1));
        assertEquals("February", getMonthName(2));
        assertEquals("March", getMonthName(3));
        assertEquals("April", getMonthName(4));
        assertEquals("May", getMonthName(5));
        assertEquals("June", getMonthName(6));
        assertEquals("July", getMonthName(7));
        assertEquals("August", getMonthName(8));
        assertEquals("September", getMonthName(9));
        assertEquals("October", getMonthName(10));
        assertEquals("November", getMonthName(11));
        assertEquals("December", getMonthName(12));
        assertEquals("Invalid", getMonthName(13));
    }

    private String getMonthName(int monthNumber) {
        switch (monthNumber) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "Invalid";
        }
    }

    @Test
    public void shouldReturnMonthNameSwitchExpression() {
        assertEquals("January", getMonthNameE(1));
        assertEquals("February", getMonthNameE(2));
        assertEquals("March", getMonthNameE(3));
        assertEquals("April", getMonthNameE(4));
        assertEquals("May", getMonthNameE(5));
        assertEquals("June", getMonthNameE(6));
        assertEquals("July", getMonthNameE(7));
        assertEquals("August", getMonthNameE(8));
        assertEquals("September", getMonthNameE(9));
        assertEquals("October", getMonthNameE(10));
        assertEquals("November", getMonthNameE(11));
        assertEquals("December", getMonthNameE(12));
        assertEquals("Invalid", getMonthNameE(13));
    }

    private String getMonthNameE(int monthNumber) {
        return switch (monthNumber) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "Invalid";
        };
    }


    @Test
    public void shouldReturnMonthNameArray() {
        assertEquals("January", getMonthNameA(1));
        assertEquals("February", getMonthNameA(2));
        assertEquals("March", getMonthNameA(3));
        assertEquals("April", getMonthNameA(4));
        assertEquals("May", getMonthNameA(5));
        assertEquals("June", getMonthNameA(6));
        assertEquals("July", getMonthNameA(7));
        assertEquals("August", getMonthNameA(8));
        assertEquals("September", getMonthNameA(9));
        assertEquals("October", getMonthNameA(10));
        assertEquals("November", getMonthNameA(11));
        assertEquals("December", getMonthNameA(12));
        assertEquals("Invalid", getMonthNameA(13));
    }

    private String[] monthName = {"Invalid", "January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December"};

    private String getMonthNameA(int monthNumber) {
        return monthNumber < 1 || monthNumber > 12 ? monthName[0] : monthName[monthNumber];
    }

    @Test
    public void shouldReturnMonthNumber() {
        assertEquals(1, getMonthNumber("January"));
        assertEquals(2, getMonthNumber("February"));
        assertEquals(3, getMonthNumber("March"));
        assertEquals(-1, getMonthNumber("Month"));
    }

    private int getMonthNumber(String monthName) {
        for (int index = 1; index < 13; index++) {
           if (this.monthName[index].equals(monthName)) {
               return index;
           }
        }
        return -1;
    }
}
