public class UC5_MonthWages {
    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;
    public static final int EMP_RATE_PER_HOUR = 20;
    public static final int WORKING_DAYS = 20;

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        int empDailyWage = 0;
        int empHours = 0;
        int empWageMonth = 0;

        for (int day = 0; day < WORKING_DAYS; day++) {
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            switch (empCheck) {
                case IS_FULL_TIME:
                    empHours = 8;
                    break;
                case IS_PART_TIME:
                    empHours = 4;
                    break;
                default:
                    empHours = 0;
            }
            empDailyWage = empHours * EMP_RATE_PER_HOUR;

            System.out.println("EMPLOYEE DAILY WAGE IS:" + empDailyWage);
            empWageMonth += empDailyWage * WORKING_DAYS;
        }
        System.out.println("Employee's Monthly Wage is:" + empWageMonth);
    }

}
