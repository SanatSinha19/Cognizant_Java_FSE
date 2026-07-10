DECLARE
    CURSOR loan_cursor IS
        SELECT l.LoanID, l.InterestRate, c.CustomerID, c.Name, c.DOB,
               TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) AS Age
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID;
BEGIN
    FOR loan_rec IN loan_cursor LOOP
        IF loan_rec.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - (InterestRate * 0.01)
            WHERE LoanID = loan_rec.LoanID;

            DBMS_OUTPUT.PUT_LINE(
                'Discount applied to Loan ID: ' || loan_rec.LoanID ||
                ' for Customer: ' || loan_rec.Name ||
                ' (Age: ' || loan_rec.Age || ')'
            );
        END IF;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Loan interest discount process completed.');
END;
/