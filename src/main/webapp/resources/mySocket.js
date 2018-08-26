var url="ws://127.0.0.1:8080/myWebSocket";
var socket=new WebSocket(url);
socket.onopen=function(){
    console.log("connected");
    sendInfo();
}
socket.onmessage=function(e){
    console.log("received_data: "+e.data);
    setTimeout(function(){sendInfo()},1000)
    sendInfo();
}
socket.onclose=function(){
    console.log("closed");
}
function sendInfo(){
    socket.send("hello");
}