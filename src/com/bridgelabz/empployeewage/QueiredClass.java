package com.bridgelabz.empployeewage;

import java.util.ArrayList;

public class QueiredClass implements InterfaceCompanyWage {
    //   CompanyEmpWage[] companyEmpWagesArray = new companyEmpWages[5];

    static ArrayList<InterfaceCompanyWage.CompanyEmpWage> companyEmpWagesArray = new ArrayList<InterfaceCompanyWage.CompanyEmpWage>();
    //   public static CompanyEmpWage1 companyEmpWage;
    int numberOfCompanies = 0;
    private boolean companyName;

    public static void main(String[] args) {
        InterfaceCompanyWage queiredClass = new QueiredClass();
        queiredClass.addCompanyEmpWage("Vodafone", 100, 30, 25);
        queiredClass.addCompanyEmpWage("Airtel", 90, 25, 30);
        queiredClass.calWageComputation();
        queiredClass.getTotalWage("jio");
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
        public void getTotalWage (String companyName){
            for (int i = 0; i < companyEmpWagesArray.size(); i++) {
                String name = companyEmpWagesArray.get(i).companyName;
                if (name.equals(companyName)) {
                    int totalWage = companyEmpWagesArray.get(i).totalEmpWage;
                    System.out.println(companyName + " Total Employee Wage is :" + totalWage);
                    break;
                } else {
                    continue;
                }
            }
        }
    }
