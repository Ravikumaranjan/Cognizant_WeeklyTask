 
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN

    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully.');

END;
 
BEGIN
    ProcessMonthlyInterest;
END;
 

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus
(
    p_DepartmentID IN NUMBER,
    p_BonusPercent IN NUMBER
)
AS
BEGIN

    UPDATE Employees
    SET Salary = Salary + (Salary * p_BonusPercent / 100)
    WHERE DepartmentID = p_DepartmentID;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Employee bonus updated successfully.');

END;
 

BEGIN
    UpdateEmployeeBonus(101,10);
END;
 

CREATE OR REPLACE PROCEDURE TransferFunds
(
    p_FromAccount IN NUMBER,
    p_ToAccount   IN NUMBER,
    p_Amount      IN NUMBER
)
AS

    v_Balance NUMBER;

BEGIN

    -- Get balance of source account
    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_FromAccount;

    -- Check sufficient balance
    IF v_Balance >= p_Amount THEN

        -- Deduct amount
        UPDATE Accounts
        SET Balance = Balance - p_Amount
        WHERE AccountID = p_FromAccount;

        -- Add amount
        UPDATE Accounts
        SET Balance = Balance + p_Amount
        WHERE AccountID = p_ToAccount;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Fund transferred successfully.');

    ELSE

        DBMS_OUTPUT.PUT_LINE('Insufficient balance.');

    END IF;

END;
 
BEGIN
    TransferFunds(101,102,5000);
END;
/