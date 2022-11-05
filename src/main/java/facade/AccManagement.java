package facade;

import facade.operations.AccountNumberCheck;
import facade.operations.FundsCheck;
import facade.operations.SecurityCodeCheck;

public class AccManagement {
    private int securityCode;
    private String accountNumber;
    private AccountNumberCheck accNumberChecker;
    private SecurityCodeCheck securityCodeChecker;
    private FundsCheck fundsChecker;
    private boolean authorized = false;

    public AccManagement(String accountNumber, int securityCode) {
        this.securityCode = securityCode;
        this.accountNumber = accountNumber;
        this.accNumberChecker = new AccountNumberCheck(accountNumber);
        this.securityCodeChecker = new SecurityCodeCheck(securityCode);
        this.fundsChecker = new FundsCheck(securityCode, accountNumber);
        this.authorized = accNumberChecker.checkAccountNumber(accountNumber) &&
                securityCodeChecker.checkSecurityCode(securityCode);
    }

    public void retirarDinheiro(double quantity) {
        if (this.authorized) {
            fundsChecker.removeCash(quantity);
        } else {
            showUnauthorizedMessage();
        }
    }

    public void depositarDinheiro(double quantity) {
        if (this.authorized) {
            fundsChecker.addCash(quantity);
        } else {
            showUnauthorizedMessage();
        }
    }

    public void showUnauthorizedMessage() {
        System.out.println("Você não tem autorização para isso!");
    }

    public void verSaldo() {
        if (this.authorized) {
            fundsChecker.getSaldo();
        } else {
            showUnauthorizedMessage();
        }
    }

    public boolean isAuthorized() {
        return authorized;
    }
}
