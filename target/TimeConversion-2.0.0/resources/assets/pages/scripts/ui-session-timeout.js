var SessionTimeout = function () {

    var handlesessionTimeout = function () {
        $.sessionTimeout({
            title: 'Session Timeout Notification bye',
            message: 'Your session is about to expire.',
            keepAliveUrl: '../demo/timeout-keep-alive.php',
            redirUrl: 'logout.aspx',
            logoutUrl: 'logout.aspx',
            warnAfter: 5000, //warn after 5 seconds
            redirAfter: 15000, //redirect after 10 secons,
            ignoreUserActivity: true,
            countdownMessage: 'Redirecting in {timer} seconds.',
            countdownBar: true
        });
    }

    return {
        //main function to initiate the module
        init: function () {
            handlesessionTimeout();
        }
    };

}();

jQuery(document).ready(function() {    
   SessionTimeout.init();
});