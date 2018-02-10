public with sharing class ProcessDdpsExt {
    public Loop__DDP__c ddp { get; set; }
    public Loop__DDP_Integration_Option__c deliveryOption { get; set; }
    public List<Loop.ProcessDdpParameters> parameters { get; set; }
    public List<Account> Accounts { get; set; }
    public List<AccountInfo> Infos { get; set; }
    
    public ProcessDdpsExt() {
        string accountIdsStr = ApexPages.currentPage().getParameters().get('ids');
        string ddpId = ApexPages.currentPage().getParameters().get('ddpId');
        string deliveryOptionId = ApexPages.currentPage().getParameters().get('deliveryOptionId');

        Infos = new List<AccountInfo>();
        Accounts = new List<Account>();
        parameters = new List<Loop.ProcessDdpParameters>();
        if (!String.isBlank(accountIdsStr)) {
            List<Id> accountIds = accountIdsStr.split(',');
            Accounts = [ SELECT Id, Name FROM Account WHERE Id IN :accountIds ];
            
            for (Account acct : Accounts) {
                Loop.ProcessDdpParameters params = new Loop.ProcessDdpParameters(ddpId, deliveryOptionId, acct.Id, new List<Id>());
                params.theme = Loop.ProcessDdpParameters.ThemeStyle.Bootstrap_3_2;
                
                Infos.add(new AccountInfo(acct, params));
            }
        }
        
        if (Accounts.size() == 0) {
            ApexPages.addMessage(new ApexPages.Message(ApexPages.Severity.ERROR, 'You must specify at least one Account Id via the "ids" query string parameter.'));
        }
    }
    
    public class AccountInfo {
        public Account Account { get; set; }
        public Loop.ProcessDdpParameters Parameters { get; set; }
        public AccountInfo(Account acct, Loop.ProcessDdpParameters parameters) {
            this.Account = acct;
            this.Parameters = parameters;
        }
    }
}