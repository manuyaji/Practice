var ship = setShip();
var hit = [];
var guesses = 0;

function getConsecutiveRandomNumbers(begin, end, numberOfConsecutiveRandomNumbers){
    var firstNum = begin+Math.floor(Math.random()*(end-begin+1));
    var ret = [firstNum];
    var i = 1;
    for(i=1; i<numberOfConsecutiveRandomNumbers; i++){
        ret.push(firstNum+i);
    }
    return ret;
}

function setShip(){
    ret = getConsecutiveRandomNumbers(0,4,3);
    //console.log("Testing i: "+i);
    return ret;
}

function notEnded(){
    return hit.length < 3;
}

function checkAndSetHit(gridNum){
    if(ship.indexOf(gridNum)>-1 && hit.indexOf(gridNum)==-1 ){
        hit.push(gridNum);
        return "Ship is hit!";
    }
    else{
        return "Miss!!";
    }
}

function isValidInputOld(userInput){
    var guessNumber = parseInt(userInput);
    if(!isNaN(guessNumber)){
        return (guessNumber>=0 && guessNumber<=6);
    }
    return false;
}

function isValidInput(userInput){
    /*hit.indexOf(userInput) below is not working as expected. userInput is being taken as a string
    and not as a number probably.*/
    //return (userInput>=0 && userInput<=6 && hit.indexOf(userInput)==-1); 
    return (userInput>=0 && userInput<=6);
}

alert("We are starting a game now!");

while(notEnded()){
    var userInput = prompt("Enter a number between 0 & 6", "-1");
    console.log("Input="+userInput);
    if(isValidInput(userInput)){
        guesses++;
        alert(checkAndSetHit(parseInt(userInput)));
    }
    else{
        alert("Please enter a valid input.");
    }
}
alert("Congratulations!! Ship is destroyed! You took "+guesses+" number of guesses");

