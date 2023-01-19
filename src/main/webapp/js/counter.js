/**
 * 
 */
 var count=0;
$("#counting").text(count);
function increment(){
count = count+1;
$("#counting").text(count);
}
function reset(){
count=0;
$("#counting").text(count);
}
function decrement(){
count=count-1;
$("#counting").text(count);
}