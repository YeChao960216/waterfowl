var can = document.getElementById('canvas');
    can.style.cssText="position:absolute;left:0px;top:0px;z-index:-1;";
var w = can.width = window.innerWidth;
var h = can.height = window.innerHeight;
window.onresize = function(){
    w = can.width = window.innerWidth;
    h = can.height = window.innerHeight;
}
var ctx = can.getContext('2d');
/*canvas基本使用方法*/
/*ctx.beginPath();
ctx.arc(200,200,50,0,Math.PI*2,false);
ctx.fillStyle='red';
ctx.fill();*/
var centerX = w/2;
var centerY = h/2;
can.addEventListener('mousemove',function(ev){
    var even = ev || window.event;
    centerX = even.pageX;
    centerY = even.pageY;
});
can.addEventListener('mouseout',function(ev){
    centerX = w/2;
    centerY = h/2;
});
function Dot(){
    this.x = Math.random()*w;
    this.y = Math.random()*h;
    this.r = Math.random()*5;
    this.vx = -0.5 + Math.random()*0.8;
    this.vy = -0.5 + Math.random()*0.8;
    this.color = "#f0f0f0";
    //this.color = randomColor();
}
function randomColor(){
    var r = Math.floor(Math.random()*256);
    var g = Math.floor(Math.random()*256);
    var b = Math.floor(Math.random()*256);
    return "rgb("+r+","+g+","+b+")";
}
Dot.prototype.draw = function(){
    ctx.beginPath();
    ctx.fillStyle = this.color;
    ctx.arc(this.x,this.y,this.r,0,Math.PI*2,false);
    ctx.fill();
    this.line();
    this.update();
}
Dot.prototype.update = function(){
      
    this.x += this.vx;
    this.y += this.vy;
    if(this.x<0||this.x>w)
        this.vx = -this.vx;
    if(this.y<0||this.y>h)
        this.vy = -this.vy;
    
}
Dot.prototype.line = function(){
    var statie = 50;
    var round = 60;
    var lineRound = 60;
    ctx.beginPath();
    ctx.strokeStyle = '#f0f0f0';
    
    if(Math.abs(this.x-(centerX+statie))<round&&Math.abs(this.y-centerY)<round){
        ctx.moveTo(this.x,this.y);//落笔
        ctx.lineTo(centerX+lineRound,centerY);
        ctx.stroke();

    }
    if(Math.abs(this.x-(centerX-statie))<round&&Math.abs(this.y-centerY)<round){
        ctx.moveTo(this.x,this.y);//落笔
        ctx.lineTo(centerX-lineRound,centerY);
        ctx.stroke();
    }
    if(Math.abs(this.x-centerX)<round&&Math.abs(this.y-(centerY+statie))<round){
        ctx.moveTo(this.x,this.y);//落笔
        ctx.lineTo(centerX,centerY+lineRound);
        ctx.stroke();
    }
    if(Math.abs(this.x-centerX)<round&&Math.abs(this.y-(centerY-statie))<round){
        ctx.moveTo(this.x,this.y);//落笔
        ctx.lineTo(centerX,centerY-lineRound);
        ctx.stroke();
    }
    if(Math.abs(this.x-(centerX-statie))<round&&Math.abs(this.y-(centerY-statie))<round){
        ctx.moveTo(this.x,this.y);//落笔
        ctx.lineTo(centerX-lineRound,centerY-lineRound);
        ctx.stroke();
    }
    if(Math.abs(this.x-(centerX+statie))<round&&Math.abs(this.y-(centerY+statie))<round){
        ctx.moveTo(this.x,this.y);//落笔
        ctx.lineTo(centerX+lineRound,centerY+lineRound);
        ctx.stroke();
    }
    if(Math.abs(this.x-(centerX+statie))<round&&Math.abs(this.y-(centerY-statie))<round){
        ctx.moveTo(this.x,this.y);//落笔
        ctx.lineTo(centerX+lineRound,centerY-lineRound);
        ctx.stroke();
    }
    if(Math.abs(this.x-(centerX-statie))<round&&Math.abs(this.y-(centerY+statie))<round){
        ctx.moveTo(this.x,this.y);//落笔
        ctx.lineTo(centerX-lineRound,centerY+lineRound);
        ctx.stroke();
    }
    
}
var dots = [];
var num = 500;
for(var i = 0 ; i<num ; i++){
    var oDot = new Dot();
    dots.push(oDot);
}
setInterval(function(){
    ctx.clearRect(0,0,w,h);
    for(var i = 0 , len = dots.length ; i<len ; i++){
        dots[i].draw();
    }

},1000/60);