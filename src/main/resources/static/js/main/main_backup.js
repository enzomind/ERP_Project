document.addEventListener('DOMContentLoaded', function () {
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        titleFormat: function (date) {

            return `${date.date.year}년 ${date.date.month + 1}월`;

        },

        //상세 처리 부분 시작
        selectable: true,
        dateClick: function(info) {
            alert('clicked ' + info.dateStr);

        },
        //상세 처리 부분 끝

        dayMaxEvents: true, // allow "more" link when too many events



    });

    calendar.render();
});