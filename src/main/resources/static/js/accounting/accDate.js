let startDate = new Date();
let endDate = new Date();
let syear = startDate.getFullYear();
let smonth = startDate.getMonth() + 1;
let sdate = startDate.getDate() - 7;
let eyear = endDate.getFullYear();
let emonth = endDate.getMonth() + 1;
let edate = endDate.getDate();

function dateSearch() {

    startDate = document.getElementById("startDate").value;
    endDate = document.getElementById("endDate").value;

}