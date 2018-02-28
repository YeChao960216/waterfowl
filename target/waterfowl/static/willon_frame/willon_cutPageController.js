/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-10-26 23:13:48 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-10-27 13:49:18
 */
/**
 * 分页操作者
 */
 var Page_controller = function(dom,tpl){
    this.nowPage = 1;
    this.allPage = '';
    this.count = 10;//默认15条一页；
    this.page_officer = new Page(dom,tpl);
    this.next = function(){
        this.nowPage = Math.min(this.nowPage+1,this.allPage);
        this.page_officer.getPage(this.nowPage);
    };
    this.pre = function(){
        this.nowPage = Math.max(this.nowPage-1,0);
        this.page_officer.getPage(this.nowPage);
    };
    this.jeepTo = function(num){
        if(num<=0||num>this.allPage){
            alert('你输入的页码不正确');
            return;
        }
        this.nowPage = num;
        this.page_officer.getPage(this.nowPage);
    }
    
 }
 Page_controller.prototype.setCount = function(count){
     this.count = count;
 }
 Page_controller.prototype.getCount = function(){
    return this.count;
 }
 Page_controller.prototype.setAllPage = function(dom,all){
    this.allPgae = all;
    dom.innerHTML = this.allPage;
 }
 Page_controller.prototype.getAllPage = function(){
   return this.allPage;
 }
 Page_controller.prototype.setNowPage = function(dom){
    dom.innerHTML = this.nowPage;
 }
 
/**
 * 这个因为放Cache层
 */
 var pageUrl = {

    common:{
        data:''            //要求每个请求返回都要有allPage属性，还有要设置当前页和总页
    },

    findByname:{
        data:''
    },
    findByPhone:{
        data:'',
    }

 }

//  var getAllPage = function(){
//     var all = '';
//      $.get(pageUrl.common,function(data){
//         all = data.allPage;
//      });
//      return all;
//  }
 /**
  * 使用方法与绑定
  */
 (function(){
    var get = function(id){
        return document.getElementById(id);
    }
    var content = get('content'),
        nextBtn = get('next'),
        preBtn = get('pre'),
        jeepToBtn = get('jeepTo'),
        pController = new Page_controller(content,'tplName');//绑定视图模板
        nextBtn.onclick = pController.next;
        preBtn.onclick = pController.pre;
        jeepToBtn.onclick = function(){
            var val = parseInt(get('jeepToInput').value);
            pController.jeepTo(val);
        }
 })();