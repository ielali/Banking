<!DOCTYPE html>
<html>
<head>
    <title>Banking</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- bootstrap -->
    <link href="${request.contextPath}/css/bootstrap/bootstrap.css" rel="stylesheet"/>
    <link href="${request.contextPath}/css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet"/>

    <!-- libraries -->
    <link href="${request.contextPath}/css/lib/jquery-ui-1.10.2.custom.css" rel="stylesheet" type="text/css"/>
    <link href="${request.contextPath}/css/lib/font-awesome.css" type="text/css" rel="stylesheet"/>

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="${request.contextPath}/css/compiled/layout.css">
    <link rel="stylesheet" type="text/css" href="${request.contextPath}/css/compiled/elements.css">
    <link rel="stylesheet" type="text/css" href="${request.contextPath}/css/compiled/icons.css">

    <!-- this page specific styles -->
    <link rel="stylesheet" href="${request.contextPath}/css/compiled/index.css" type="text/css" media="screen"/>

    <!-- open sans font -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
          rel='stylesheet' type='text/css'>

    <!-- lato font -->
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900,300italic,400italic,700italic,900italic'
          rel='stylesheet' type='text/css'>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="${request.contextPath}/js/html5shiv.js"></script>
    <script src="${request.contextPath}/js/respond.min.js"></script>
    <![endif]-->
    <style>
        #sidebar-nav {
            position: absolute;
            width: 290px;
            float: left;
            margin: 0em;
            padding-top: 5.8em;
        }
        .content {
            min-width: 510px;
            min-height: 620px;
            margin-bottom: 100px;
            padding-bottom: 50px;
            overflow: hidden;
            position: relative;
            background: #fff;
            margin-left: 287px;
            border-left: 1px solid #dae3e9;
            border-bottom: 1px solid #dae3e9;
            box-shadow: -3px 3px 3px -2px #f1f1f3;
            border-radius: 0px 0px 0px 5px;
            -webkit-transition: margin-left .3s ease;
            -moz-transition: margin-left .3s ease;
            -o-transition: margin-left .3s ease;
            -ms-transition: margin-left .3s ease;
            transition: margin-left .3s ease;
            /* starts skins changer */
            /* end skin changer*/
        }
    </style>
</head>
<body>
<!-- navbar -->
<header class="navbar navbar-inverse" role="banner">
    <div class="navbar-header">
        <button class="navbar-toggle" type="button" data-toggle="collapse" id="menu-toggler">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index.html">
            Banking
        </a>
    </div>
    <ul class="nav navbar-nav pull-right hidden-xs">
        <li class="notification-dropdown hidden-xs hidden-sm">
            <a href="#" class="trigger">
                <i class="icon-envelope"></i>
            </a>

            <div class="pop-dialog">
                <div class="pointer right">
                    <div class="arrow"></div>
                    <div class="arrow_border"></div>
                </div>
                <div class="body">
                    <a href="#" class="close-icon"><i class="icon-remove-sign"></i></a>

                    <div class="messages">
                        <a href="#" class="item">
                            <img src="${request.contextPath}/img/contact-img.png" class="display"/>

                            <div class="name">Alejandra Galván</div>
                            <div class="msg">
                                There are many variations of available, but the majority have suffered alterations.
                            </div>
                            <span class="time"><i class="icon-time"></i> 13 min.</span>
                        </a>
                        <a href="#" class="item">
                            <img src="${request.contextPath}/img/contact-img2.png" class="display"/>

                            <div class="name">Alejandra Galván</div>
                            <div class="msg">
                                There are many variations of available, have suffered alterations.
                            </div>
                            <span class="time"><i class="icon-time"></i> 26 min.</span>
                        </a>
                        <a href="#" class="item last">
                            <img src="${request.contextPath}/img/contact-img.png" class="display"/>

                            <div class="name">Alejandra Galván</div>
                            <div class="msg">
                                There are many variations of available, but the majority have suffered alterations.
                            </div>
                            <span class="time"><i class="icon-time"></i> 48 min.</span>
                        </a>

                        <div class="footer">
                            <a href="#" class="logout">View all messages</a>
                        </div>
                    </div>
                </div>
            </div>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle hidden-xs hidden-sm" data-toggle="dropdown">
                Your account
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
                <li><a href="personal-info.html">Personal info</a></li>
                <li><a href="#">Account settings</a></li>
                <li><a href="#">Billing</a></li>
                <li><a href="#">Export your data</a></li>
                <li><a href="#">Send feedback</a></li>
            </ul>
        </li>
        <li class="settings hidden-xs hidden-sm">
            <a href="personal-info.html" role="button">
                <i class="icon-cog"></i>
            </a>
        </li>
        <li class="settings hidden-xs hidden-sm">
            <a href="signin.html" role="button">
                <i class="icon-share-alt"></i>
            </a>
        </li>
    </ul>
</header>
<!-- end navbar -->

<sitemesh:write property='body'/>

<!-- scripts -->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${request.contextPath}/js/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${request.contextPath}/js/bootstrap.min.js"></script>
<script src="${request.contextPath}/js/jquery-ui-1.10.2.custom.min.js"></script>
<!-- knob -->
<script src="${request.contextPath}/js/jquery.knob.js"></script>
<!-- flot charts -->
<script src="${request.contextPath}/js/jquery.flot.js"></script>
<script src="${request.contextPath}/js/jquery.flot.stack.js"></script>
<script src="${request.contextPath}/js/jquery.flot.resize.js"></script>
<script src="${request.contextPath}/js/theme.js"></script>
</body>
</html>
