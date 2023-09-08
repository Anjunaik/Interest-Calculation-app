package com.acoder.compoundinterest;

import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

import com.acoder.allpojoclass.CompoundReqPojo;
import com.acoder.allpojoclass.CompoundResPojo;
import com.acoder.allpojoclass.DatePojo;

@Service
public class CompundInterest implements CompoundInterestInf {

	@Override
	public void compoundInterestCal(CompoundReqPojo reqPojo, DatePojo date, CompoundResPojo respPojo) {

		//dates setting 
		respPojo.setDays(date.getDays());
		respPojo.setMonths(date.getMonths());
		respPojo.setYears(date.getYears());
      
		//this for handle zeros
		DecimalFormat decimalFormat = new DecimalFormat("0.##");
		Double interest = 0.0;
		Double temp = 0.0;
		
		// Interest rate Yearly Calculation
		if (reqPojo.getRatetype().equals("yearly")) {

			//annually interest calculation
			 if (reqPojo.getCompoundInterval().equals("annually")) {
					
					if (date.getYears() != null && date.getYears() != 0) {
						interest = reqPojo.getPrincipal()
								* (Math.pow((1 + reqPojo.getInterestRate() / 100), (date.getYears() * 1)))
								- reqPojo.getPrincipal();
						respPojo.setPerMonth((Double.parseDouble(decimalFormat.format(interest / 12))));
						if (date.getMonths() != null && date.getMonths() != 0) {

							Double months = 0.0;

							Double temp2 = interest + reqPojo.getPrincipal();
							months = temp2 * (Math.pow((1 + reqPojo.getInterestRate() / 100), (1 * 1))) - temp2;
							respPojo.setPerMonth((Double.parseDouble(decimalFormat.format(months / 12))));
						}
					} else {
						interest = reqPojo.getPrincipal() * (Math.pow((1 + reqPojo.getInterestRate() / 100), (1 * 1)))
								- reqPojo.getPrincipal();
						respPojo.setPerMonth((Double.parseDouble(decimalFormat.format(interest / 12))));
					}
					respPojo.setPerYear((Double.parseDouble(decimalFormat.format(interest))));

					respPojo.setPerDay((Double.parseDouble(decimalFormat.format(respPojo.getPerMonth() / 30))));

					if (date.getMonths() != null && date.getMonths() != 0)
						temp += respPojo.getPerMonth() * date.getMonths();
					if (date.getDays() != null && date.getDays() != 0)
						temp += respPojo.getPerDay() * date.getDays();

					if (date.getYears() != null && date.getYears() != 0)
						respPojo.setInterestTotalAmount(
								(Double.parseDouble(decimalFormat.format(temp + respPojo.getPerYear()))));
					else
						respPojo.setInterestTotalAmount((Double.parseDouble(decimalFormat.format(temp))));

					respPojo.setTotalAmount((Double.parseDouble(
							decimalFormat.format(respPojo.getInterestTotalAmount() + reqPojo.getPrincipal()))));

				}
			 //semi annually interest calculation with interest rate yearly
			else if (reqPojo.getCompoundInterval().equals("semiannually")) {
				System.out.println("Yearlysemiannually");
				if (date.getYears() != null && date.getYears() != 0) {
					interest = reqPojo.getPrincipal()
							* (Math.pow((1 + reqPojo.getInterestRate() / 200), (date.getYears() * 2)))
							- reqPojo.getPrincipal();
					respPojo.setPerMonth((Double.parseDouble(decimalFormat.format(interest / 12))));
					if (date.getMonths() != null && date.getMonths() != 0) {

						Double months = 0.0;

						Double temp2 = interest + reqPojo.getPrincipal();
						months = temp2 * (Math.pow((1 + reqPojo.getInterestRate() / 200), (1 * 2))) - temp2;
						respPojo.setPerMonth(months / 12);
					}
				} else {
					interest = reqPojo.getPrincipal() * (Math.pow((1 + reqPojo.getInterestRate() / 200), (1 * 2)))
							- reqPojo.getPrincipal();
					respPojo.setPerMonth((Double.parseDouble(decimalFormat.format(interest / 12))));
				}
				respPojo.setPerYear((Double.parseDouble(decimalFormat.format(interest))));

				respPojo.setPerDay((Double.parseDouble(decimalFormat.format(respPojo.getPerMonth() / 30))));

				if (date.getMonths() != null && date.getMonths() != 0)
					temp += respPojo.getPerMonth() * date.getMonths();
				if (date.getDays() != null && date.getDays() != 0)
					temp += respPojo.getPerDay() * date.getDays();

				if (date.getYears() != null && date.getYears() != 0)
					respPojo.setInterestTotalAmount(
							(Double.parseDouble(decimalFormat.format(temp + respPojo.getPerYear()))));
				else
					respPojo.setInterestTotalAmount((Double.parseDouble(decimalFormat.format(temp))));

				respPojo.setTotalAmount((Double.parseDouble(
						decimalFormat.format(respPojo.getInterestTotalAmount() + reqPojo.getPrincipal()))));

			}

			// Quarterly interest calculation with interest rate yearly
			else if (reqPojo.getCompoundInterval().equals("quarterly")) {

				
				if (date.getYears() != null && date.getYears() != 0) {
					interest = reqPojo.getPrincipal()
							* (Math.pow((1 + reqPojo.getInterestRate() / 400), (date.getYears() * 4)))
							- reqPojo.getPrincipal();
					respPojo.setPerMonth((Double.parseDouble(decimalFormat.format(interest / 12))));
					if (date.getMonths() != null && date.getMonths() != 0) {
						Double months = 0.0;

						Double temp2 = interest + reqPojo.getPrincipal();
						months = temp2 * (Math.pow((1 + reqPojo.getInterestRate() / 400), (1 * 4))) - temp2;

						respPojo.setPerMonth((Double.parseDouble(decimalFormat.format(months / 12))));
					}
				} else {
					interest = reqPojo.getPrincipal() * (Math.pow((1 + reqPojo.getInterestRate() / 400), (1 * 4)))
							- reqPojo.getPrincipal();
					respPojo.setPerMonth((Double.parseDouble(decimalFormat.format(interest / 12))));
				}

				respPojo.setPerYear((Double.parseDouble(decimalFormat.format(interest))));

				respPojo.setPerDay((Double.parseDouble(decimalFormat.format(respPojo.getPerMonth() / 30))));

				if (date.getMonths() != null && date.getMonths() != 0)

					temp += respPojo.getPerMonth() * date.getMonths();

				if (date.getDays() != null && date.getDays() != 0)
					temp += respPojo.getPerDay() * date.getDays();

				if (date.getYears() != null && date.getYears() != 0)
					respPojo.setInterestTotalAmount(
							(Double.parseDouble(decimalFormat.format(temp + respPojo.getPerYear()))));
				else
					respPojo.setInterestTotalAmount((Double.parseDouble(decimalFormat.format(temp))));

				respPojo.setTotalAmount((Double.parseDouble(
						decimalFormat.format(respPojo.getInterestTotalAmount() + reqPojo.getPrincipal()))));

				
				//monthly  interest calculation with interest rate yearly
			} else if (reqPojo.getCompoundInterval().equals("monthly")) {

				if (date.getYears() != null && date.getYears() != 0) {
					interest = reqPojo.getPrincipal() * (Math.pow((1 + (reqPojo.getInterestRate()) / (100 * 12)),
							(date.getYears() * 12 + date.getMonths()))) - reqPojo.getPrincipal();

					// total amount
					respPojo.setPerYear((Double.parseDouble(decimalFormat.format(interest))));

					respPojo.setPerMonth((Double.parseDouble(decimalFormat.format(interest / 12))));

					respPojo.setPerDay((Double.parseDouble(decimalFormat.format(respPojo.getPerMonth() / 30))));

					if (date.getDays() != null && date.getDays() != 0)
						temp += respPojo.getPerDay() * date.getDays();

					respPojo.setInterestTotalAmount((Double.parseDouble(decimalFormat.format(temp + interest))));

					respPojo.setTotalAmount(respPojo.getInterestTotalAmount() + reqPojo.getPrincipal());

				} else if (date.getMonths() != null && date.getMonths() != 0) {
					interest = reqPojo.getPrincipal()
							* (Math.pow((1 + (reqPojo.getInterestRate()) / (100 * 12)), (date.getMonths())))
							- reqPojo.getPrincipal();

					respPojo.setPerYear((Double.parseDouble(decimalFormat.format((interest / date.getMonths()) * 12))));
					respPojo.setPerMonth((Double.parseDouble(decimalFormat.format(interest / date.getMonths()))));
					respPojo.setPerDay((Double.parseDouble(decimalFormat.format(respPojo.getPerMonth() / 30))));

					if (date.getDays() != null && date.getDays() != 0)
						temp += respPojo.getPerDay() * date.getDays();

					respPojo.setInterestTotalAmount((Double.parseDouble(decimalFormat.format(temp + interest))));

					respPojo.setTotalAmount(respPojo.getInterestTotalAmount() + reqPojo.getPrincipal());

				}

				else {
					interest = reqPojo.getPrincipal() * (Math.pow((1 + (reqPojo.getInterestRate()) / (100 * 12)), (12)))
							- reqPojo.getPrincipal();

					respPojo.setPerYear((Double.parseDouble(decimalFormat.format(interest))));
					respPojo.setPerMonth((Double.parseDouble(decimalFormat.format(interest / 12))));
					respPojo.setPerDay((Double.parseDouble(decimalFormat.format(respPojo.getPerMonth() / 30))));

					if (date.getDays() != null && date.getDays() != 0)
						temp += respPojo.getPerDay() * date.getDays();
					
					respPojo.setInterestTotalAmount((Double.parseDouble(decimalFormat.format(temp))));

					respPojo.setTotalAmount(respPojo.getInterestTotalAmount() + reqPojo.getPrincipal());

				}

			}
		}

		// Interest Rate monthly calculation
		else if (reqPojo.getRatetype().equals("monthly")) {

			//annually interest calculation with interest rate monthly
			if (reqPojo.getCompoundInterval().equals("annually")) {

				if (date.getYears() != null && date.getYears() != 0) {
					interest = reqPojo.getPrincipal()
							* (Math.pow((1 + reqPojo.getInterestRate() * 12 / 100), (date.getYears())))
							- reqPojo.getPrincipal();
					respPojo.setPerMonth((Double.parseDouble(decimalFormat.format(interest / 12))));
					if (date.getMonths() != null && date.getMonths() != 0) {
						Double months = 0.0;

						Double temp2 = interest + reqPojo.getPrincipal();
						months = temp2 * (Math.pow((1 + reqPojo.getInterestRate() * 12 / 100), (1))) - temp2;

						respPojo.setPerMonth((Double.parseDouble(decimalFormat.format(months / 12))));
					}
				}

				else {
					interest = reqPojo.getPrincipal() * (Math.pow((1 + reqPojo.getInterestRate() * 12 / 100), (1)))
							- reqPojo.getPrincipal();
					respPojo.setPerMonth((Double.parseDouble(decimalFormat.format(interest / 12))));
				}
				respPojo.setPerYear((Double.parseDouble(decimalFormat.format(interest))));

				respPojo.setPerDay((Double.parseDouble(decimalFormat.format(respPojo.getPerMonth() / 30))));

				if (date.getMonths() != null && date.getMonths() != 0)
					temp += respPojo.getPerMonth() * date.getMonths();
				if (date.getDays() != null && date.getDays() != 0)
					temp += respPojo.getPerDay() * date.getDays();

				if (date.getYears() != null && date.getYears() != 0)
					respPojo.setInterestTotalAmount(
							(Double.parseDouble(decimalFormat.format(temp + respPojo.getPerYear()))));
				else
					respPojo.setInterestTotalAmount((Double.parseDouble(decimalFormat.format(temp))));

				respPojo.setTotalAmount((Double.parseDouble(
						decimalFormat.format(respPojo.getInterestTotalAmount() + reqPojo.getPrincipal()))));
			}

			//semi-annually interest calculation with interest rate monthly
			else if (reqPojo.getCompoundInterval().equals("semiannually")) {
			
				if (date.getYears() != null && date.getYears() != 0) {
					interest = reqPojo.getPrincipal()
							* (Math.pow((1 + reqPojo.getInterestRate() * 12 / 200), (date.getYears() * 2)))
							- reqPojo.getPrincipal();
					respPojo.setPerMonth((Double.parseDouble(decimalFormat.format(interest / 12))));
					if (date.getMonths() != null && date.getMonths() != 0) {

						Double months = 0.0;

						Double temp2 = interest + reqPojo.getPrincipal();
						months = temp2 * (Math.pow((1 + reqPojo.getInterestRate() * 12 / 200), (1 * 2))) - temp2;
						respPojo.setPerMonth((Double.parseDouble(decimalFormat.format(months / 12))));
					}
				} else {
					interest = reqPojo.getPrincipal() * (Math.pow((1 + reqPojo.getInterestRate() * 12 / 200), (1 * 2)))
							- reqPojo.getPrincipal();
					respPojo.setPerMonth((Double.parseDouble(decimalFormat.format(interest / 12))));
				}

				respPojo.setPerYear((Double.parseDouble(decimalFormat.format(interest))));

				respPojo.setPerDay((Double.parseDouble(decimalFormat.format(respPojo.getPerMonth() / 30))));

				if (date.getMonths() != null && date.getMonths() != 0)
					temp += respPojo.getPerMonth() * date.getMonths();
				if (date.getDays() != null && date.getDays() != 0)
					temp += respPojo.getPerDay() * date.getDays();

				if (date.getYears() != null && date.getYears() != 0)
					respPojo.setInterestTotalAmount(
							(Double.parseDouble(decimalFormat.format(temp + respPojo.getPerYear()))));
				else
					respPojo.setInterestTotalAmount((Double.parseDouble(decimalFormat.format(temp))));

				respPojo.setTotalAmount((Double.parseDouble(
						decimalFormat.format(respPojo.getInterestTotalAmount() + reqPojo.getPrincipal()))));

			}

			//quarterly interest calculation with interest rate monthly
			else if (reqPojo.getCompoundInterval().equals("quarterly")) {

				if (date.getYears() != null && date.getYears() != 0) {
					interest = reqPojo.getPrincipal()
							* (Math.pow((1 + reqPojo.getInterestRate() * 12 / 400), (date.getYears() * 4)))
							- reqPojo.getPrincipal();
					respPojo.setPerMonth((Double.parseDouble(decimalFormat.format(interest / 12))));
					if (date.getMonths() != null && date.getMonths() != 0) {
						Double months = 0.0;

						Double temp2 = interest + reqPojo.getPrincipal();
						months = temp2 * (Math.pow((1 + reqPojo.getInterestRate() * 12 / 400), (1 * 4))) - temp2;

						respPojo.setPerMonth((Double.parseDouble(decimalFormat.format(months / 12))));
					}
				} else {
					interest = reqPojo.getPrincipal() * (Math.pow((1 + reqPojo.getInterestRate() * 12 / 400), (1 * 4)))
							- reqPojo.getPrincipal();
					respPojo.setPerMonth((Double.parseDouble(decimalFormat.format(interest / 12))));
				}

				respPojo.setPerYear((Double.parseDouble(decimalFormat.format(interest))));

				respPojo.setPerDay((Double.parseDouble(decimalFormat.format(respPojo.getPerMonth() / 30))));

				if (date.getMonths() != null && date.getMonths() != 0)

					temp += respPojo.getPerMonth() * date.getMonths();

				if (date.getDays() != null && date.getDays() != 0)
					temp += respPojo.getPerDay() * date.getDays();

				if (date.getYears() != null && date.getYears() != 0)
					respPojo.setInterestTotalAmount(
							(Double.parseDouble(decimalFormat.format(temp + respPojo.getPerYear()))));
				else
					respPojo.setInterestTotalAmount((Double.parseDouble(decimalFormat.format(temp))));

				respPojo.setTotalAmount((Double.parseDouble(
						decimalFormat.format(respPojo.getInterestTotalAmount() + reqPojo.getPrincipal()))));

			}

			//monthly interest calculation with interest rate monthly
			else if (reqPojo.getCompoundInterval().equals("monthly")) {
				if (date.getYears() != null && date.getYears() != 0) {
					interest = reqPojo.getPrincipal() * (Math.pow((1 + (reqPojo.getInterestRate() * 12) / (100 * 12)),
							(date.getYears() * 12 + date.getMonths()))) - reqPojo.getPrincipal();

					// total amount
					respPojo.setPerYear((Double.parseDouble(decimalFormat.format(interest))));

					respPojo.setPerMonth((Double.parseDouble(decimalFormat.format(interest / 12))));

					respPojo.setPerDay((Double.parseDouble(decimalFormat.format(respPojo.getPerMonth() / 30))));

					if (date.getDays() != null && date.getDays() != 0)
						temp += respPojo.getPerDay() * date.getDays();

					respPojo.setInterestTotalAmount((Double.parseDouble(decimalFormat.format(temp + interest))));
					respPojo.setTotalAmount(respPojo.getInterestTotalAmount() + reqPojo.getPrincipal());

				} else if (date.getMonths() != null && date.getMonths() != 0) {
					interest = reqPojo.getPrincipal()
							* (Math.pow((1 + (reqPojo.getInterestRate() * 12) / (100 * 12)), (date.getMonths())))
							- reqPojo.getPrincipal();

					respPojo.setPerYear((Double.parseDouble(decimalFormat.format((interest / date.getMonths()) * 12))));
					respPojo.setPerMonth((Double.parseDouble(decimalFormat.format(interest / date.getMonths()))));
					respPojo.setPerDay((Double.parseDouble(decimalFormat.format(respPojo.getPerMonth() / 30))));

					if (date.getDays() != null && date.getDays() != 0)
						temp += respPojo.getPerDay() * date.getDays();

					respPojo.setInterestTotalAmount((Double.parseDouble(decimalFormat.format(temp + interest))));

					respPojo.setTotalAmount(respPojo.getInterestTotalAmount() + reqPojo.getPrincipal());

				}

				else {
					interest = reqPojo.getPrincipal()
							* (Math.pow((1 + (reqPojo.getInterestRate() * 12) / (100 * 12)), (12)))
							- reqPojo.getPrincipal();

					respPojo.setPerYear((Double.parseDouble(decimalFormat.format(interest))));
					respPojo.setPerMonth((Double.parseDouble(decimalFormat.format(interest / 12))));
					respPojo.setPerDay((Double.parseDouble(decimalFormat.format(respPojo.getPerMonth() / 30))));

					if (date.getDays() != null && date.getDays() != 0)
						temp += respPojo.getPerDay() * date.getDays();
					
					respPojo.setInterestTotalAmount((Double.parseDouble(decimalFormat.format(temp ))));

					respPojo.setTotalAmount(respPojo.getInterestTotalAmount() + reqPojo.getPrincipal());

				}

			}

		}

	}
}
