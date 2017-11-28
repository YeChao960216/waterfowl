/*
 * @Author: 伟龙-Willon qq:1061258787 
 * @Date: 2017-11-27 19:07:22 
 * @Last Modified by: 伟龙-Willon
 * @Last Modified time: 2017-11-27 22:57:47
 */

 /**
   * 分页控制者
   * 基本功能
   * 1、绑定操作区
   * 2、多个视图切换
   * 3、可加入缓存功能
   */
  
 /**
  * 分页控制者_v2
  * 使用方法有点恶心
  * var pageController = new PageController({

      url:'',

      view:{
          container : '',
          tpl : '',
          nowView:'',
          allView:'',
      },
      pageBean:{
          pageDescription:'',
          countDescription:'',
          dataDescription:'',
          totalDescription:'',
          count:'',
      },
      dom:{
          nextBtn :'',
          preBtn:'',
          jumpBtn:'',
          jumpVal:'',
      },
      
  });
  */

  var PageController  = function(obj) {
      var self = this;
     /**
      * 视图绑定区
      */
     var view = obj.view;
     self.tpl = view.tpl;//模板名称
     self.container = view.container;
     self.nowView = view.nowView;
     self.allView = view.allView;
     /**
      * pageBean
      *每次要修改的一套规则
      */
     var pageBean = obj.pageBean;
     self.pageDescription = pageBean.pageDescription || 'pageNum';//这几个描述相当重要十分关键
     self.countDescription = pageBean.countDescription || 'pageSize';
     self.dataDescription = pageBean.dataDescription || 'list';
     self.totalDescription = pageBean.totalDescription || 'total';
     self.other = pageBean.other || '';//其他补充的描述
     self.count = pageBean.count || 10;
     self.nowPage = 1;//当前页
     self.allPage = -1;//总页数

     self.url = obj.url + '?' + self.countDescription + '=' + self.count + '&' + self.pageDescription + '=' + self.nowPage + self.other;

     /**
      * 按钮操作
      * DOM绑定
      */
     var dom = obj.dom;
     self.nextBtn = dom.nextBtn || null;//下一页按钮
     self.preBtn = dom.preBtn || null;//上一页按钮
     self.jumpBtn = dom.jumpBtn || null;//页数跳转按钮
     self.jumpVal = dom.jumpVal || 1;//获取页数值

     /**
      * 数据缓存
      */
     self.cache = {};

  }

  PageController.prototype = {
      next:function(){
          var self = this;
          self.nowPage = self.nowPage+1<self.nowPage?self.nowPage +=1:self.allPage;
          if(!self.cache[self.nowPage]){
            $.get(self.url,function(res){
                if(res){

                    self.cache[self.nowPage] = res[self.dataDescription];
                    viewCommand({
                        command:'display',
                        param:[self.container,res[self.dataDescription],self.tpl]
                    });

                }else{
                    console.error('获取下一页数据失败');
                }
            });
          }else{
            viewCommand({
                command:'display',
                param:[self.container,self.cache[self.nowPage],self.tpl]
            });
          }
          self.showNowPage();
      },
      pre:function(){
          var self = this;
          self.nowPage = self.nowPage-1>1?self.nowPage -=1:1;
          if(!self.cache[self.nowPage]){
            $.get(self.url,function(res){
                if(res){

                    self.cache[self.nowPage] = res[self.dataDescription];
                    viewCommand({
                        command:'display',
                        param:[self.container,res[self.dataDescription],self.tpl]
                    });

                }else{
                    console.error('获取上一页数据失败');
                }
            });
          }else{
            viewCommand({
                command:'display',
                param:[self.container,self.cache[self.nowPage],self.tpl]
            });
          }
          self.showNowPage();
      },
      jump:function(){
          var self = this;
          var target = self.jumpVal.value;
          if(/[^0-9]*/.test(target)){
              if(target > self.allPage || target < 1 ){
                  alert('你输入页数为非法值');
                  self.jumpVal.value = '';
                  return;
              }
              alert('请输入数字');
              self.jumpVal.value = '';
              return;
          }
          self.nowPage = target;
          if(!self.cache[self.nowPage]){
            $.get(self.url,function(res){
                if(res){

                    self.cache[self.nowPage] = res[self.dataDescription];
                    viewCommand({
                        command:'display',
                        param:[self.container,res[self.dataDescription],self.tpl]
                    });

                }else{
                    console.error('获取跳转页数据失败');
                }
            });
          }else{
            viewCommand({
                command:'display',
                param:[self.container,self.cache[self.nowPage],self.tpl]
            });
          }
          self.showNowPage();
      },
      showNowPage : function(){
        this.nowView.innerHTML = this.nowPage;
      },
      showAllPage : function(){
        this.allView.innerHTML = this.allPage;
      },
      bindEvent : function(dom,type,fn,flag){
          var self = this;
          if(dom.addEventListener){//dom2事件
              dom.addEventListener(type,fn.bind(self),flag);
          }else if(dom.attachEvent){
              dom.attachEvent('on'+type,fn.bind(self));
          }else{//dom0事件
              dom['on'+type] = fn.bind(self);
          }
      },
      init:function(){

        /**
         * 视图初始化
         */
        var self = this;
        $.get(self.url,function(res){
            if(res){
                self.allPage = res[self.totalDescription];
                self.showNowPage();
                self.showAllPage();
                self.cache[self.nowPage] = res[self.dataDescription];
                viewCommand({
                    command:'display',
                    param:[self.container,res[self.dataDescription],self.tpl]
                });
            }else{
                console.error('页面数据初始化失败');
            }
        });

        /**
         * 按钮事件绑定
         */
        self.bindEvent(self.nextBtn,'click',self.next,false);
        self.bindEvent(self.preBtn,'click',self.pre,false);
        self.bindEvent(self.jumpBtn,'click',self.jump,false);
      },

  }

