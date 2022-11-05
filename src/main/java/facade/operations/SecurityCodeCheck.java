package facade.operations;

public class SecurityCodeCheck {
    private int securityCode = 123;
    private int insertedSecurityCode;

    public SecurityCodeCheck(int securityCode) {
        this.insertedSecurityCode = securityCode;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public boolean checkSecurityCode(int insertedSecurityCode) {
        if (insertedSecurityCode == this.securityCode) {
            return true;
        }
        return false;
    }


}
