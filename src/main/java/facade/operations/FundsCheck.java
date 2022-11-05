package facade.operations;

public class FundsCheck {
    private double funds = 4000;
    private int securityCode;
    private String accountNumber;

    public FundsCheck(int securityCode, String accountNumber) {
        this.securityCode = securityCode;
        this.accountNumber = accountNumber;
    }

    public void getSaldo() {
        System.out.println("Saldo atual: R$" + this.funds);
    }

    public double getFunds() {
        return this.funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }

    public void addCash(double quantity) {
        setFunds(getFunds() + quantity);
        System.out.println("Foi feito um depósito de R$" + quantity);
    }

    public void removeCash(double quantity) {
        if (saldoSuficiente(quantity)) {
            setFunds(getFunds() - quantity);
            System.out.println("Foi sacada uma quantia de R$" + quantity);
        } else {
            System.out.println("Você não tem saldo suficiente para completar a operação.");
        }
    }

    private boolean saldoSuficiente(double quantity) {
        if (getFunds() < quantity) {
            return false;
        }
        return true;
    }
}
