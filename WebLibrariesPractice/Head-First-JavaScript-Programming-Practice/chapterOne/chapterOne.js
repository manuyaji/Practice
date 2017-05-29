var times=10;
var loopIndex=0;

while(loopIndex < times){
    if(loopIndex % 2 == 0){
        console.log(loopIndex+" is an even number.")
    }
    else if(loopIndex % 2 != 0){
        console.log(loopIndex+" is an odd number.")
    }
    loopIndex++;
}