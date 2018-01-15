/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2018-01-11 17:07:28 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2018-01-11 17:17:21
 */

 /**
  * 左右按键控制detail移动（一共有4份基本记录 /560px）
  * 
  */

    var detail_view_ctrl = (function () {
        var $shadow = null;
        return {
            show : function (global) {
                console.log(window.top.document);
                $shadow = window.top.document.getElementById('#shadow');
                $shadow.animate({width:'700px'},function () {
                    detail_view_ctrl.init(global);
                });
            },
            init:function (global) {
                var $pre = $(global.getElementById('#btn-pre')),
                    $next = $(global.getElementById('#btn-next')),
                    $detail = $(global.getElementById('#detail')),
                    close = global.getElementById('#close');
                var move = function(){
                    $detail.animate({left:detail_view_ctrl.left+'px'});
                }
                /**
                 *closeBtn点击hide()
                 */
                close.onclick  = function () {
                    $shadow.animate({width:0},function () {
                        this.hide();
                    });
                }
                /**
                 *前、后页按钮监听
                 */
                $pre.click(function () {
                    var that = detail_view_ctrl;
                    that.left += that.step;
                    if(that.left>=0){
                        that.left = 0;
                        $pre.hide();
                    }
                    $next.show();
                    move();
                });
                $next.click(function () {
                    var that = detail_view_ctrl;
                    that.left -= that.step;
                    if(that.left <= -that.step*(num-1)){
                        that.left = -that.step*(num-1);
                        $next.hide();
                    }
                    $pre.show();
                    move();
                });
            },
            left:0,
            num:4,
            step:631
        }
    })();


