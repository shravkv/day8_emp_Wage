package com.bridgelabz.empployeewage;

import com.bridgelabz.empployeewage.java.InterfaceCompanyWage;

public class StoreDailyWage implements InterfaceCompanyWage {
        //   CompanyEmpWage[] companyEmpWagesArray = new companyEmpWages[5];

        static java.util.ArrayList<CompanyEmpWage> companyEmpWagesArray = new java.util.ArrayList<CompanyEmpWage>();

        int numberOfCompanies = 0;

        public static void main(String[] args) {
            InterfaceCompanyWage storeDailyWage = new StoreDailyWage();
            storeDailyWage.addCompanyEmpWage("Vodafone", 100, 30, 25);
            storeDailyWage.addCompanyEmpWage("Airtel", 90, 25, 30);
            ((StoreDailyWage) storeDailyWage).calWageComputation();
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

        public int calWageComputation(CompanyEmpWage companyEmpWage) {

            int empHr = 0, maxWorkingHr = 0, maxWorkingDays = 0;
            System.out.println("Welcome to Employee Wage Computation Program");

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

