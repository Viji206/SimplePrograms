package main;

import java.util.Scanner;

import util.IncomeTaxSlabs;

public class BudgetComparison {
	
	static long deductedTax = 0L;
	private static long FIVE_LAKH = 500000;
	private static long SEVEN_FIVE_LAKH = 750000;
	private static long TEN_LAKH = 1000000;
	private static long TWELVE_FIVE_LAKH = 1250000;
	private static long FIFTEEN_LAKH = 1500000;
	
	public static void main(String args[])
	{
		userInputIncomeDetails();
		listOfIncomes();		
	}
	
	private static void userInputIncomeDetails(){
		Scanner inputReader = new Scanner(System.in);
		System.out.println("Enter Income :");   
		long income = Long.parseLong(inputReader.nextLine());
		System.out.println("Enter Deductions :");
		long totalDeductions = Long.parseLong(inputReader.nextLine());
		System.out.println("Income :"+ income);
		System.out.println("Taxable Income :"+ (income - totalDeductions));
		deductedTax = 0L;
		long oldRegimeTaxPayable = oldRegime(income - totalDeductions);
		System.out.println("Tax Payable Old Regime:" + oldRegimeTaxPayable);
		deductedTax = 0L;
		long newRegimeTaxPayable = newRegime(income);
		System.out.println("Tax Payable New Regime:" + newRegimeTaxPayable);
		System.out.println("Effective:" + (oldRegimeTaxPayable < newRegimeTaxPayable ? "Old Regime" : "New Regime")+"\n");
		
		inputReader.close();
	}
	
	private static void listOfIncomes(){
		long incomes[] = {200000,500000, 750000, 1000000, 1500000, 2000000, 3000000};
		long hraDeduction = 100000, pfDeduction = 30000, stdDedcution = 50000;
		long totalDedcution = hraDeduction+pfDeduction+stdDedcution;
		for(long income : incomes){
			System.out.println("Income :"+ income);
			//income = income - totalDedcution;
			System.out.println("Taxable Income :"+ (income - totalDedcution));
			deductedTax = 0L;
			long oldRegimeTaxPayable = oldRegime(income - totalDedcution);
			System.out.println("Tax Payable Old Regime:" + oldRegimeTaxPayable);
			deductedTax = 0L;
			long newRegimeTaxPayable = newRegime(income);
			System.out.println("Tax Payable New Regime:" + newRegimeTaxPayable);
			System.out.println("Effective:" + (oldRegimeTaxPayable < newRegimeTaxPayable ? "Old Regime" : "New Regime")+"\n");
		}
	}
	private static long oldRegime(long income)	{		
		
		
		if(IncomeTaxSlabs.BW0TO5LAKH.getMinVaue() <= income && IncomeTaxSlabs.BW0TO5LAKH.getMaxValue() >= income && deductedTax == 0)
		{
			deductedTax = 0;
			
		}else if(IncomeTaxSlabs.BW2TO5LAKH.getMinVaue() <= income && IncomeTaxSlabs.BW2TO5LAKH.getMaxValue() >= income)
		{
			income = income -250000;
			deductedTax += (income * 0.05);
			
			
		}else if(IncomeTaxSlabs.BW5TO10LAKH.getMinVaue() <= income && IncomeTaxSlabs.BW5TO10LAKH.getMaxValue() >= income){
			income = income - 500000;
			deductedTax += (income * 0.20);
			oldRegime(FIVE_LAKH);
			
		}else if(IncomeTaxSlabs.ABOVE10LAKH.getMinVaue() <= income && IncomeTaxSlabs.ABOVE10LAKH.getMaxValue() >= income){
			income = income - 1000000;
			deductedTax += (income * 0.30);
			oldRegime(TEN_LAKH);
			
		}
		
		return deductedTax;
		
	}
	
	private static long newRegime(long income){
		
		if(IncomeTaxSlabs.BW0TO5LAKH.getMinVaue() <= income && IncomeTaxSlabs.BW0TO5LAKH.getMaxValue() >= income && deductedTax == 0)
		{
			deductedTax = 0;
			
		}else if(IncomeTaxSlabs.BW2TO5LAKH.getMinVaue() <= income && IncomeTaxSlabs.BW2TO5LAKH.getMaxValue() >= income)
		{
			income = income -250000;
			deductedTax += (income * 0.05);				
		}else if(IncomeTaxSlabs.BW5TO7_5LAKH.getMinVaue() <= income && IncomeTaxSlabs.BW5TO7_5LAKH.getMaxValue() >= income)
		{
			income = income -500000;
			deductedTax += (income * 0.10);	
			newRegime(FIVE_LAKH);
		}else if(IncomeTaxSlabs.BW7_5TO10LAKH.getMinVaue() <= income && IncomeTaxSlabs.BW7_5TO10LAKH.getMaxValue() >= income)
		{
			income = income -750000;
			deductedTax += (income * 0.15);		
			newRegime(SEVEN_FIVE_LAKH);
		}else if(IncomeTaxSlabs.BW10TO12_5LAKH.getMinVaue() <= income && IncomeTaxSlabs.BW10TO12_5LAKH.getMaxValue() >= income)
		{
			income = income -1000000;
			deductedTax += (income * 0.20);	
			newRegime(TEN_LAKH);
		}else if(IncomeTaxSlabs.BW12_5TO15LAKH.getMinVaue() <= income && IncomeTaxSlabs.BW12_5TO15LAKH.getMaxValue() >= income)
		{
			income = income -1250000;
			deductedTax += (income * 0.25);
			newRegime(TWELVE_FIVE_LAKH);
		}else if(IncomeTaxSlabs.ABOVE15LAKH.getMinVaue() <= income && IncomeTaxSlabs.ABOVE15LAKH.getMaxValue() >= income)
		{
			income = income -1500000;
			deductedTax += (income * 0.30);	
			newRegime(FIFTEEN_LAKH);
		}
			
		return deductedTax;
		
	}

}
