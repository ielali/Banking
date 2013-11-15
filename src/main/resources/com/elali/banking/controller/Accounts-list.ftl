<!-- sidebar -->
<div id="sidebar-nav">
    <ul id="dashboard-menu">
        [#list banks as bank]
        <li
        [#if bank_index=2]class="active"[/#if]">
        <a class="dropdown-toggle" href="#">
            [#if bank_index=2]
            <div class="pointer">
                <div class="arrow"></div>
                <div class="arrow_border"></div>
            </div>
            [/#if]
            <i class="icon-money"></i>
            <span>${(bank.name?html)!}</span>
            <i class="icon-chevron-down"></i>
        </a>
        <ul class="submenu" [#if bank_index=2]style="display: block"[/#if]>
            [#list bank.accounts as account]
                <li class="list-group-item">
                    <span class="badge">${account.balance}</span>
                    <a>${(account.name?html)!}</a>
                </li>
            [/#list]
        </ul>
        </li>
        [/#list]
    </ul>
</div>
<!-- end sidebar -->


<!-- main container -->
<div class="content">
    <!-- settings changer -->
    <div class="skins-nav">
        <a href="#" class="skin first_nav selected">
            <span class="icon"></span><span class="text">Default skin</span>
        </a>
        <a href="#" class="skin second_nav" data-file="css/compiled/skins/dark.css">
            <span class="icon"></span><span class="text">Dark skin</span>
        </a>
    </div>

    <!-- upper main stats -->
    <div id="main-stats">
        <div class="row stats-row">
            <div class="col-md-3 col-sm-3 stat">
                <div class="data">
                    <span class="number">2457</span>
                    visits
                </div>
                <span class="date">Today</span>
            </div>
            <div class="col-md-3 col-sm-3 stat">
                <div class="data">
                    <span class="number">3240</span>
                    users
                </div>
                <span class="date">February 2013</span>
            </div>
            <div class="col-md-3 col-sm-3 stat">
                <div class="data">
                    <span class="number">322</span>
                    orders
                </div>
                <span class="date">This week</span>
            </div>
            <div class="col-md-3 col-sm-3 stat last">
                <div class="data">
                    <span class="number">$2,340</span>
                    sales
                </div>
                <span class="date">last 30 days</span>
            </div>
        </div>
    </div>
    <!-- end upper main stats -->
    [#assign account=banks[2].accounts[0]/]

    <div id="pad-wrapper" style="margin-top: 20px">
        <!-- table sample -->
        <!-- the script for the toggle all checkboxes from header is located in js/theme.js -->

            <div class="row">
                <table class="table table-hover">
                    <thead style="border: none">
                    <tr>
                        <th class="col-md-1"></th>
                        <th class="col-md-5">
                        </th>
                        <th class="col-md-3">
                        </th>
                        <th class="col-md-3">
                        </th>
                    </tr>
                    </thead>
                    <tbody>

                    [#list account.transactions as transaction]
                    <!-- row -->
                    <tr
                    [#if transaction_index=0]class="first"[/#if]>
                    <td>${transaction.creationDate?date}</td>
                    <td class="description">${transaction.name}</td>
                    <td>${transaction.subCategory.name}</td>
                    <td>${transaction.amount}</td>
                    </tr>
                    [/#list]
                    </tbody>
                </table>
            </div>
            <ul class="pagination pull-right">
                <li><a href="#">&laquo;</a></li>
                <li class="active"><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">&raquo;</a></li>
            </ul>
        </div>
        <!-- end table sample -->
    </div>
