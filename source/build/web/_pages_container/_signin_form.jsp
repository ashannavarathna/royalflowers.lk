<style type="text/css">
    .err-text{

    }
    .invalid_input{
        padding-left: 2px;
        color: #e9322d; 
        font-size: 11px;  
    }
    .err_visible{
        display: inline-block;
        visibility:visible;
    }
    .err_hidden{
        display: none;
        visibility: hidden;
    }
</style>
<script type="text/javascript">
    function usrLogValidation() {
        var usrform = document.getElementById("usr-log-form");
        var flag = [false, false];
        var input = usrform.getElementsByTagName("input");
        var err_field = document.getElementsByClassName("err-fld");
        for (var i = 0; i < 2; i++) {
            if (input[i].value === "") {
                input[i].style.border = "1px dotted red";
                err_field[i].innerHTML = "This Field is Required";
                flag[i] = false;
            } else {
                input[i].style.border = "1px solid #CCC";
                err_field[i].innerHTML = "";
                flag[i] = true;
            }
        }
        var valid = true;
        for (var j = 0; j < flag.length; j++) {
            if (flag[j] === false) {
                valid = false;
            }
        }
        return valid;

    }
</script>

<div class="signup_form_wrapper">
    <div class="signup_form_container">
        
        <div class="signin_form">
            <form action="user_login?usrxttp=101" method="POST" id="usr-log-form" onsubmit="return usrLogValidation()">
                <div style="margin-bottom: 10px;"> Sign in...</div>
                <label class="data-field">Your Email</label>
                <input type="text" name="usr_email" placeholder="Email Address" id="usr-log-mail" class="usr1"/>
                <div class="err-fld" style="font-size: 10px;color: red;"></div>
                <label class="data-field" >Your Password</label>
                <input type="password" name="usr_psw" placeholder="password" id="usr-log-psw" class="usr2"/>
                <div class="err-fld" style="font-size: 10px;color: red;"></div>
                <input type="submit" value="sign in" class="sin_submit" >
            </form>

            <div class="loing_forgot_password" style="float: left;position: relative; margin-top: 50px;font-size: 12px;"><a href="req_fgps_code.jsp" style="color: #0480be;text-decoration: none;">forgot password | </a></div>
            <div class="loing_forgot_password" style="float: left;position: relative; margin-top: 50px;font-size: 12px;"><a href="signup.jsp" style="color: #0480be;text-decoration: none;">create a account</a></div>
        </div>



    </div>
</div>
