package com.bridgelabz.empployeewage;

public class ArrayList implements InterfaceCompanyWage {
        // public static CompanyEmpWage1 companyEmpWage;
        int numOfCompanies = 0;
        //   CompanyEmpWage[] companyEmpWagesArray = new companyEmpWages[5];

        static java.util.ArrayList<CompanyEmpWage> companyEmpWagesArray = new java.util.ArrayList<CompanyEmpWage>();

        public static void main(String[] args) {
            InterfaceCompanyWage uc12 = new ArrayList();
            uc12.addCompanyEmpWage("Vodafone", 100, 30, 25);
            uc12.addCompanyEmpWage("Airtel", 90, 25, 30);
            uc12.calWageComputation();
            uc12.getTotalWage("jio");
        }

        public void addCompanyEmpWage(String companyName, int totalWorkingHr, int totalWorkingDays, int wagePerHr) {
            InterfaceCompanyWage.CompanyEmpWage companyEmpWage = new InterfaceCompanyWage.CompanyEmpWage(companyName, totalWorkingHr, totalWorkingDays, wagePerHr);
            companyEmpWagesArray.add(companyEmpWage);
        }

        public void calWageComputation() {
            for (int i = 0; i < companyEmpWagesArray.size(); i++) {
                InterfaceCompanyWage.CompanyEmpWage companyEmpWage = companyEmpWagesArray.get(i);
                companyEmpWage.setTotalEmpWage(this.calWageComputation(companyEmpWage));
                System.out.println(companyEmpWage);
            }
        }

    @Override
    public void getTotalWage(String companyName) {

    }

    public int calWageComputation(InterfaceCompanyWage.CompanyEmpWage companyEmpWage) {

            int empHr = 0, maxWorkingHr = 0, maxWorkingDays = 0;
            System.out.println("com.bridgelabz.empployeewage.Welcome to Employee Wage Computation Program");

            while (maxWorkingHr <= companyEmpWage.totalWorkingHr && maxWorkingDays < companyEmpWage.totalWorkingDays) {
                maxWorkingDays++;
                int empCheck = (int) Math.floor(Math.random() * 3);
                switch (empCheck) {
                    case 1:
                        empHr = 4;
                        break;
                    case 2:
                        empHr = 8;
                        break;
                    default:
                        empHr = 0;
                        break;
                }
                maxWorkingHr += empHr;

                int empWage = maxWorkingHr * companyEmpWage.wagePerHr;
                System.out.println(companyEmpWage.companyName + " Day#" + maxWorkingDays + " Employee wage " + empWage);
                companyEmpWage.totalEmpWage = companyEmpWage.totalEmpWage + empWage;

            }

            return companyEmpWage.totalEmpWage;
    }
}
