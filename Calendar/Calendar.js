function getDate(){
    return new Date(Date.now());
}
function invisible(){
    document.querySelectorAll(".previous-month").forEach(e =>{
        e.style.display = "none";
    })
    chooseStartDate();
}
function chooseStartDate(){
    let date = getDate();
    console.log(date);
    let startDate = new Date(date.getFullYear(),getMonth(date),date.getDay());
    console.log(startDate);
    console.log(startDate.getDay());
    document.querySelectorAll(".day")[startDate.getDay()].style.color = "red";
    }
    document.querySelectorAll()

function getMonth(date){
return date.getMonth() + 1;
}

