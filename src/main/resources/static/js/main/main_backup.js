document.addEventListener('DOMContentLoaded', function () {

    $(function () {
        var request = $.ajax({
            url: "/main/getCalAll",
            method: "GET",
            dataType: "json"
        });

        request.done(function (data) {
            console.log(data);

            var calendarEl = document.getElementById('calendar');

            var calendar = new FullCalendar.Calendar(calendarEl, {

                headerToolbar: {
                    left: 'today',
                    center: 'title',
                    right: 'prev next'
                },
                initialView: 'dayGridMonth',
                locale: "ko",
                dayMaxEvents: true,
                events: data

            });

            calendar.render();

        })

        request.fail(function( jqXHR, textStatus ) {
            alert( "Request failed: " + textStatus );
        });

    })


});