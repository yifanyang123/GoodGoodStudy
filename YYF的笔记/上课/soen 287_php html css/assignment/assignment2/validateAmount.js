function valid(){
if (parseFloat(document.Bank.withdrawMoney.value).toString() == "NaN") {
	numeric=false;
    alert("Please enter a validate value")	
    return false;
} else {
	numeric=true;
    return true;
}
	
}