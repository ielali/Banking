<!-- Tables
      ================================================== -->
<div class="row bs-docs-section">
    <div class="col-md-4">
        <div class="well well-lg">
            <div class="panel-group" id="bank_list">
                [#list banks as bank]
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#bank_list" href="#bank_${bank.id}">
                            ${(bank.name?html)!}
                            </a>
                        </h4>
                    </div>
                    <div id="bank_${bank.id}" class="panel-collapse collapse [#if bank_index=2]in[/#if]">
                        <div class="panel-body">
                            <ul class="list-group">
                                [#list bank.accounts as account]
                                <li class="list-group-item">
                                    <span class="badge">${account.balance}</span>
                                    <a>${(account.name?html)!}</a>
                                </li>
                                [/#list]
                            </ul>
                        </div>
                    </div>
                </div>
                [/#list]
            </div>
        </div>
    </div>
    [#assign account=banks[2].accounts[0]/]
    <div class="col-md-8">
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading">
                <h3 id="account_name">${account.name}</h3>
            </div>
            <div class="panel-body">

            </div>

            <!-- Table -->
            <table class="table">
                <tbody>
                [#list account.transactions as transaction]
                <tr [#if transaction.amount>0]class="text-success"[/#if]>
                    <td>${transaction.creationDate?date}</td>
                    <td>${transaction.name}</td>
                    <td>${transaction.subCategory.name}</td>
                    <td>${transaction.amount}</td>
                </tr>
                [/#list]
                </tbody>
            </table>
        </div>
    </div>
</div>