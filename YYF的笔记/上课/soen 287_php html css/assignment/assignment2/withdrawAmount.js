    var bankcharge=500;	
    function withdraw(){	
	var inputnumber=parseInt(document.Bank.withdrawMoney.value);	    
		if (numeric==true&&inputnumber%20!=0){
		alert("Incorrect withdrawal amount");
		}
        else if (numeric==true&&bankcharge-inputnumber-0.5<0){
		alert("Insufficient funds");
        }
        else if(numeric==true){				
	    bankcharge=bankcharge-inputnumber-0.5
		alert("Successful transaction! \n Current Balance is: " + bankcharge);		
		}
	}

