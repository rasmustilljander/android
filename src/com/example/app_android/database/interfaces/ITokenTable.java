package com.example.app_android.database.interfaces;

import com.example.app_android.database.DBException;
import com.example.app_android.database.NoRowsAffectedDBException;

public interface ITokenTable {
	
	enum TransactionFlag {
		Success,
		Pending,
		Failed,
		Unknown
	}
	
	// There should only be possible to have one entry of a token at any given time.
	// This returns the value of the token
	public String getTokenValue();
	
	// Returns expiredate of the token
	public long getExpireDate();
	
	// Updates token with new tokenvalue, expiredate and sets the new transaction_flag.
	public void updateToken(String tokenValue, long expireDate, TransactionFlag transaction_flag) throws DBException, NoRowsAffectedDBException;
	
	// Update transaction_flag. If it returns 
	public void updateTransactionFlag(TransactionFlag transaction_flag) throws DBException, NoRowsAffectedDBException;
	
	// Returns current transactionFlag on the token. There can only be one
	public TransactionFlag getTransactionFlag();	
	
	public void PrintEntireToken();
}