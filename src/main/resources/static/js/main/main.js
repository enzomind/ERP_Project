document.addEventListener('DOMContentLoaded', function () {
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        titleFormat: function (date) {

            return `${date.date.year}년 ${date.date.month + 1}월`;

        },

        //날짜 클릭
        // navLinks: true,
        // navLinkDayClick: function (date, jsEvent) {
        //     console.log('day', date.toISOString());
        //     console.log('coodrs', jsEvent.pageX, jsEvent.pageY);
        // },

        selectable: true,
        dateClick: function(info) {
            alert('clicked ' + info.dateStr);
        },


    });

    calendar.render();
});