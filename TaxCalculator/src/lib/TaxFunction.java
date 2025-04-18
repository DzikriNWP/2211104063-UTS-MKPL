package lib;

public class TaxFunction {

    /**
     * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus
     * dibayarkan setahun.
     */
    public static int calculateTax(TaxInfo taxInfo) {

        int tax = 0;

        if (taxInfo.getNumberOfMonthWorking() > 12) {
            System.err.println("More than 12 month working per year");
        }

        int numberOfChildren = taxInfo.getNumberOfChildren();
        if (numberOfChildren > 3) {
            numberOfChildren = 3;
        }

        int nonTaxableIncome = 54000000;
        if (taxInfo.isMarried()) {
            nonTaxableIncome += 4500000 + (numberOfChildren * 1500000);
        }

        int netIncome = ((taxInfo.getMonthlySalary() + taxInfo.getOtherMonthlyIncome()) * taxInfo.getNumberOfMonthWorking()) - taxInfo.getDeductible() - nonTaxableIncome;
        tax = (int) Math.round(0.05 * netIncome);

        return Math.max(tax, 0);
    }
}
