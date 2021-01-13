var length=0;
var odd=0;
var even=0;
var numberArray=new Array(0);
do{inputnumber = prompt("please enter some int number,end with -1");
    if(inputnumber==-1) {
       break;
    }
    if(parseFloat(inputnumber).toString() != "NaN"&&inputnumber%2==0){
        numberArray[length]=inputnumber;
        length++;
        even++;
    }
    if(inputnumber%2==1){
        numberArray[length]=inputnumber;
        length++;
        odd++;
    }
}
while(true);
function stats(){
    document.write("you have entered below mentioned numbers"+"<br/>");
		for(var a in numberArray){
        document.write(numberArray[a]+"<br/>")
    }
    document.write("you have entered "+odd+" odd numbers and "+even+" even numbers");
}





