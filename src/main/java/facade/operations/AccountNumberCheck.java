package facade.operations;

public class AccountNumberCheck {
    private String accountNumber = "123456";
    private String insertedAccountNumber;

    public String getAccountNumber() {
        return accountNumber;
    }

    public AccountNumberCheck(String accountNumber) {
        this.insertedAccountNumber = accountNumber;
    }

    public boolean checkAccountNumber(String insertedAccountNumber) {
        if (this.accountNumber.equals(insertedAccountNumber)) {
            return true;
        }
        return false;
    }
}
