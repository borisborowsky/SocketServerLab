class Mortgage {
	private double annualInterestRate = 6.5;
	private double principleAmount;
	private double durationYears;
	private double monthlyInterestRate;
	
	public Mortgage(double annualInterestRate, double principleAmount, double durationYears) {
		this.annualInterestRate = annualInterestRate;
		this.principleAmount = principleAmount;
		this.durationYears = durationYears;
		this.monthlyInterestRate = (this.annualInterestRate/(12))/100;
	}
	
	double monthlyPayments() {
		double monthlyRepaiment;
		errorChecking("MIR", this.monthlyInterestRate);
		errorChecking("Dur", this.durationYears);
		double numerator = this.monthlyInterestRate * Math.pow(((1 + this.monthlyInterestRate)), (this.durationYears *12));
		errorChecking("Numerator", numerator);
		double denominator = Math.pow((1 + this.monthlyInterestRate), (this.durationYears*12))-1;
		errorChecking("Denominator", denominator);
		monthlyRepaiment = this.principleAmount * (numerator / denominator);
		return Math.round(monthlyRepaiment*100.0)/100.0;
	}
	
	void errorChecking(String label, double v) {
		System.out.println(label + ": " + v);
	}
	
	void displayRates() {
		System.out.println("Annual interest rate: " + annualInterestRate);
		System.out.println("Duration Years: " + durationYears);
		System.out.println("Monthly Interest rate: " + monthlyInterestRate);
		System.out.println("Principle Amount: " + principleAmount);
	}
}
