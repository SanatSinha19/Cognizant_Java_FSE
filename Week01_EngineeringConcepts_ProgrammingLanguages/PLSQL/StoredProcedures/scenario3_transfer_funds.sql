CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
)
IS
    v_source_balance NUMBER;
BEGIN
    SELECT Balance INTO v_source_balance
    FROM Accounts
    WHERE AccountID = p_from_account;

    IF v_source_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE(
            'Transfer failed: Insufficient balance in Account ID ' || p_from_account ||
            ' (Available: ' || v_source_balance || ', Required: ' || p_amount || ')'
        );
        RETURN;
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_amount, LastModified = SYSDATE
    WHERE AccountID = p_from_account;

    UPDATE Accounts
    SET Balance = Balance + p_amount, LastModified = SYSDATE
    WHERE AccountID = p_to_account;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Transfer successful: $' || p_amount ||
        ' transferred from Account ID ' || p_from_account ||
        ' to Account ID ' || p_to_account
    );

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: One or both account IDs do not exist.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed due to an unexpected error: ' || SQLERRM);
END;
/

BEGIN
    TransferFunds(3, 4, 2000);
END;
/

BEGIN
    TransferFunds(4, 3, 999999);
END;
/