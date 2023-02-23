package com.the_mgi.wildapricot_wrapper.account;

import com.fasterxml.jackson.core.type.TypeReference;
import com.the_mgi.wildapricot_wrapper.ApplicationService;
import com.the_mgi.wildapricot_wrapper.WildApricot;
import com.the_mgi.wildapricot_wrapper.account.model.Account;
import com.the_mgi.wildapricot_wrapper.exception.HttpException;

import java.util.List;

public class AccountService {
    private final ApplicationService applicationService;

    public AccountService(WildApricot wildApricot) {
        this.applicationService = ApplicationService.getInstance(wildApricot);
    }

    /**
     * List of accounts available with current oAuth token. Typicaly here would be only one record in an array
     * @return An array of accounts
     * @throws HttpException provides exception descriptions
     *                       <ul>
     *                          <li>401 oAuth token was not provided, invalid or does not provide access to requested URL</li>
     *                          <li>429 Too many requests from same account. Wait for a minute and try again, however this exception is handled, will automatically wait for 1 minutes, and then do another call.</li>
     *                       </ul>
     */
    public List<Account> getAllAccounts() throws HttpException {
        return this.applicationService.execute(
            "accounts/",
            new TypeReference<>() {
            }
        );
    }

    /**
     * Details for specific account
     * @param accountId Your account identifier (pathVariable)
     * @return Account details
     * @throws HttpException provides exception descriptions
     *                       <ul>
     *                          <li>401 oAuth token was not provided, invalid or does not provide access to requested URL</li>
     *                          <li>404 Requested item not found</li>
     *                          <li>429 Too many requests from same account. Wait for a minute and try again, however this exception is handled, will automatically wait for 1 minutes, and then do another call.</li>
     *                       </ul>
     */
    public Account getAccountDetails(Integer accountId) throws HttpException {
        return this.applicationService.execute(
            "accounts/" + accountId,
            new TypeReference<>() {
            }
        );
    }
}
