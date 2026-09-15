class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int totalDays = 0;
        
        // 1. Add days for all past years since 1971
        for (int i = 1971; i < year; i++) {
            if (isLeapYear(i)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }
        
        // 2. Add days for past months in the current year
        for (int i = 0; i < month - 1; i++) {
            if (i == 1 && isLeapYear(year)) {
                totalDays += 29;
            } else {
                totalDays += months[i];
            }
        }
        
        // 3. Add days in the current month
        totalDays += (day - 1);
        
        // Modulo 7 maps directly to the days array starting at Friday (index 0)
        return days[totalDays % 7];
    }
    
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}