<div>
    <noscript>
    <style type="text/css">
        .main-wrapper {          
            pointer-events: none;
            display: none;
        }
        .noscriptmsg{
            font-family: "Trebuchet MS",Arial,Helvetica,sans-serif;
            position: relative;
            top: 50px;
            background-color: #FFF;
            margin: 0 auto;
            height: 200px;
            width: 500px;
            margin-bottom: 200px;
            border-radius: 3px;
            border: 1px solid #064E5A;
            padding: 30px 20px;
            font-size: 13px;
        }
        .noscriptingmsghead{
            margin-bottom: 10px;
            border-bottom: 1px solid #777;
            padding-bottom: 5px;
            font-size: 16px;
            font-weight: 800;
        }
        #relaod-btn{
            float: right;
            margin-top: 20px;
            display: inline-block;
            width: 100px;
            height: 20px;
            color: #777;
            border: 1px solid #ccc;
            text-align: center;
            padding: 3px 10px;
            text-decoration: none;
            border-radius: 2px;
        }
        #relaod-btn:hover{
            background-color:  #dff0d8;
        }
    </style>

    <div class="noscriptmsg">
        <div class="noscriptingmsghead">
            Java Script Required
        </div>
        We're sorry, but 
        <span style="font-weight: 800;color: #449d44;" >Royal Flowers</span>
        does not  work properly without Java Script enabled or with java script unsupported browsers.<br/>enable <span style="color: #777;"> java script </span> and <span style="text-decoration: underline;">reload</span> the page or try java Script supported browser 

        <a href="_page_reloader?uri_this=<%=request.getRequestURI()%>" id="relaod-btn">Reload Page</a>
    </div>
    </noscript>
</div>