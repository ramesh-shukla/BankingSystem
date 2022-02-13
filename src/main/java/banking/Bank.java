package banking;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Objects;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;

	public Bank() {
		// complete the function
		accounts = new LinkedHashMap<>();
	}

	private Account getAccount(Long accountNumber) {
		// complete the function
        return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function
		Long accountNumber = System.nanoTime();
		if(accounts.size() > 0) {
			accountNumber = accounts.keySet().stream().max(Comparator.naturalOrder()).get() + 1;
		}
		Account account = new CommercialAccount(company, accountNumber, pin, startingDeposit);
		accounts.put(accountNumber, account);
        return accountNumber;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		// complete the function
		Long accountNumber = System.nanoTime();
		if(accounts.size() > 0) {
			accountNumber = accounts.keySet().stream().max(Comparator.naturalOrder()).get() + 1;
		}
		Account account = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
		accounts.put(accountNumber, account);
		return accountNumber;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
		Account account = accounts.get(accountNumber);
		if (Objects.nonNull(account) && account.validatePin(pin)) {
			return true;
		}
        return false;
	}

	public double getBalance(Long accountNumber) {
		// complete the function
		Account account = accounts.get(accountNumber);
		if(Objects.nonNull(account)) {
			return account.getBalance();
		}
		return -1;
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		Account account = accounts.get(accountNumber);
		if(Objects.nonNull(account)) {
			account.creditAccount(amount);
		}
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
		Account account = accounts.get(accountNumber);
		if(Objects.nonNull(account)) {
			return account.debitAccount(amount);
		}
        return false;
	}
}
