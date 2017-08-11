(function($) {
    $(document).ready(function() {
        var url = window.location.href;
        if (url.indexOf("#") <= 0)
            window.location.href = window.location.href.concat("#summary");
        else {
            option = url.match(/#(.*)/)[1];
            var tab = getTab(option);
            $('#productsTabs a[href="#'+option+'"]').tab('show');
        }

        $("#tab1").click(function() {
            var newURLString = addTabID(window.location.href, "#summary");
            window.location.href = newURLString;
        });

        $("#tab2").click(function() {
            var newURLString = addTabID(window.location.href, "#reviews");
            window.location.href = newURLString;
        });

        $("#tab3").click(function() {
            var newURLString = addTabID(window.location.href, "#media");
            window.location.href = newURLString;
        });

        $("#tab4").click(function() {
            var newURLString = addTabID(window.location.href, "#statistics");
            location.reload();
            window.location.href = newURLString;
        });
    });

    function addTabID(url, id) {
        if (url.indexOf("#") >= 0) {
            var pos = url.indexOf("#");
            var res = url.replace(url.substr(pos, url.length - pos), id);
            console.log("REPLACING");
            console.log(res);
            return res;
        }
        var res = url.concat(id);
        return res;
    }

    function getTab(option) {
        switch (option) {
            case "summary":
                return "tab1";
            case "reviews":
                return "tab2";
            case "media":
                return "tab3";
            case "statistics":
                return "tab4";
        }
    }
})(jQuery);
