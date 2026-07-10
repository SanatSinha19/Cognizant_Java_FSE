CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department    IN VARCHAR2,
    p_bonus_percent IN NUMBER
)
IS
    CURSOR emp_cursor IS
        SELECT EmployeeID, Name, Salary
        FROM Employees
        WHERE Department = p_department;
BEGIN
    FOR emp_rec IN emp_cursor LOOP
        UPDATE Employees
        SET Salary = Salary + (Salary * p_bonus_percent / 100)
        WHERE EmployeeID = emp_rec.EmployeeID;

        DBMS_OUTPUT.PUT_LINE(
            'Bonus applied to ' || emp_rec.Name ||
            ' (ID: ' || emp_rec.EmployeeID || ')' ||
            ' | Old Salary: ' || emp_rec.Salary ||
            ' | New Salary: ' || (emp_rec.Salary + (emp_rec.Salary * p_bonus_percent / 100))
        );
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus update completed for department: ' || p_department);
END;
/

BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
/