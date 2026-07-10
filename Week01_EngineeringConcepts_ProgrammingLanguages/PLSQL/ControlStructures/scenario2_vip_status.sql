DECLARE
    CURSOR customer_cursor IS
        SELECT CustomerID, Name, Balance
        FROM Customers;
BEGIN
    FOR cust_rec IN customer_cursor LOOP
        IF cust_rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = cust_rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE(
                'Customer: ' || cust_rec.Name ||
                ' (ID: ' || cust_rec.CustomerID || ')' ||
                ' promoted to VIP status.'
            );
        END IF;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP status update process completed.');
END;
/