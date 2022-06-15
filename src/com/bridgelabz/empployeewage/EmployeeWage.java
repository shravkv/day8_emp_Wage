package com.bridgelabz.empployeewage;

public class EmployeeWage implements InterfaceCompanyWage {

    int numberOfCompanies = 0;
    InterfaceCompanyWage.CompanyEmpWage[] companyEmpWagesArray = new InterfaceCompanyWage.CompanyEmpWage[5];
    private String totalEmpWage;

    public static void main(String[] args)  {
        EmployeeWage employeeWage = new EmployeeWage();
        employeeWage.addCompanyEmpWage("Vodafone",100, 30, 25);
        employeeWage.addCompanyEmpWage("Airtel", 90, 25, 30);
        employeeWage.calWageComputation();
    }

    public void addCompanyEmpWage(String companyName, int totalWorkingHr , int totalWorkingDays, int wagePerHr) {
        companyEmpWagesArray[numberOfCompanies] = new InterfaceCompanyWage.CompanyEmpWage(companyName, totalWorkingHr, totalWorkingDays, wagePerHr);
        numberOfCompanies++;
    }

    public void calWageComputation() {
        for (int i = 0; i < numberOfCompanies; i++) {
            companyEmpWagesArray[i].setTotalEmpWage(this.calWageComputation(companyEmpWagesArray[i]));
            System.out.println(companyEmpWagesArray[i]);
        }
    }

    public void getTotalWage(String companyName) {

    }

    public int calWageComputation(InterfaceCompanyWage.CompanyEmpWage companyEmpWage) {

        int empHrs = 0, maxWorkingHr = 0, maxWorkingDays = 0;
        System.out.println("com.bridgelabz.empployeewage.Welcome to Employee Wage Computation Program");

        while (maxWorkingHr <= companyEmpWage.totalWorkingHr && maxWorkingDays < companyEmpWage.totalWorkingDays) {
            maxWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 3);
            switch (empCheck) {
                case 1:
                    empHrs = 4;
                    break;
                case 2:
                    empHrs = 8;
                    break;
                default:
                    empHrs = 0;
                    break;
        }
        maxWorkingHr += empHrs;

        int empWage = maxWorkingHr * companyEmpWage.wagePerHr;
        companyEmpWage.totalEmpWage = companyEmpWage.totalEmpWage + empWage;
        System.out.println( companyEmpWage.companyName +" ---> Company Total Employee wage is : " + totalEmpWage);
    }

        return companyEmpWage.totalEmpWage;
    }

}
