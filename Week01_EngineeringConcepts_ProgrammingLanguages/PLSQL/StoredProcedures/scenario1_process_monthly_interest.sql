CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
    CURSOR savings_cursor IS
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'Savings';
BEGIN
    FOR acc_rec IN savings_cursor LOOP
        UPDATE Accounts
        SET Balance = Balance + (Balance * 0.01),
            LastModified = SYSDATE
        WHERE AccountID = acc_rec.AccountID;

        DBMS_OUTPUT.PUT_LINE(
            'Interest applied to Account ID: ' || acc_rec.AccountID ||
            ' | Old Balance: ' || acc_rec.Balance ||
            ' | New Balance: ' || (acc_rec.Balance * 1.01)
        );
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest processing completed.');
END;
/

BEGIN
    ProcessMonthlyInterest;
END;
/