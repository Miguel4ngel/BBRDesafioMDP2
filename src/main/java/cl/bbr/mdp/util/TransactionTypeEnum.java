package cl.bbr.mdp.util;

/**
 * @author Miguel Angel
 * @since v1.0.0
 */

public enum TransactionTypeEnum {

    DEBITO("DEBITO"),
    CREDITO("CREDITO"),
    CHEQUE("CHEQUE"),
    EFECTIVO("EFECTIVO");

    private String value;

    TransactionTypeEnum (String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
