var can = document.getElementById('canvas');
can.style.cssText="position:absolute;left:0px;top:0px;z-index:-1;";
console.log(can);
var W = window.innerWidth,
    H = window.innerHeight;
    can.style.width = W+'px';
    can.style.width = H+'px';
    window.onresize = function(){
        W = window.innerWidth;
        H = window.innerHeight;
        can.style.width = W +'px';
        can.style.width = H +'px';
    }
    //var imgArr = ['1.jpg','2.jpg','3.jpg','4.jpg','5.jpg','6.jpg'];
    console.log(W,H,document.body.width,document.body.height);
    var Box = function(){
        this.w = Math.floor(Math.random()*30);
        this.h = this.w;
        this.x = Math.random()*W;
        this.y = Math.random()*H;
        this.vx = -10+Math.random()*20;
        this.vy = -10+Math.random()*20;
        this.color = '#f0f0f0';
        //this.img = randomImg();
    }
    Box.prototype.init = function(){
        var oBox = document.createElement('div'),
            unit = 'px';
            oBox.className = 'box';
            oBox.style.width = this.w+unit;
            oBox.style.height = this.h+unit;
            oBox.style.top = this.y+unit;
            oBox.style.left = this.x+unit;
            oBox.style.backgroundColor = this.color;
            //oBox.style.backgroundImage = "url('"+this.img+"')";
            can.appendChild(oBox);
            this.move();
    }
    Box.prototype.move = function(){
        if(this.x<=0||this.x>=W){
            this.vx = -this.vx;
        }
        if(this.y<=0||this.y>=H){
            this.vy = -this.vy;
        }
        this.x +=this.vx;
        this.y +=this.vy;
        
    }
    var num = 500;
    var oBoxArr = [];
    for(var i=0;i<num;i++){
        oBoxArr.push(new Box());
    }
    var timer = setInterval(function(){
        can.innerHTML = '';
        for(var i=0,len=oBoxArr.length;i<len;i++){
            oBoxArr[i].init();
        }
    },1000/60);