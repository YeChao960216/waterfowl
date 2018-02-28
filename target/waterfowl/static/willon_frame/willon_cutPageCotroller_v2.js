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
   * 2、多个视图切换 (暂时没加入豪华套餐)
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
     self.subUrl = obj.url;


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
      *数据过滤模板
      */
     self.filterTpl = obj.dataFilter ? obj.dataFilter.tpl : '';
     // try{
     //     self.filterTpl = obj.dataFilter.tpl || '';
     // }catch (err){
     //    console.log(err);
     // }


     /**
      * 数据缓存区
      */
     self.cache = {};

  }

  PageController.prototype = {
      next:function(){
          var self = this;
          self.nowPage = self.nowPage+1<self.allPage?self.nowPage +=1:self.allPage;
          self.url = self.subUrl + '?' + self.countDescription + '=' + self.count + '&' + self.pageDescription + '=' + self.nowPage + self.other;
          if(!self.cache[self.nowPage]){
            $.get(self.url,function(res){
                if(res[self.dataDescription].length>0){
                    var list = res[self.dataDescription];
                    if(self.filterTpl){
                        list = new DataFilter({
                            data:list,
                            type:self.filterTpl
                        });
                    }
                    self.cache[self.nowPage] = list;
                    viewCommand({
                        command:'display',
                        param:[self.container,list,self.tpl]
                    });

                }else{
                    viewCommand({
                        command:'display',
                        param:[self.container,[],'blank']
                    });
                    console.error('下一页数据为空');
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
          self.url = self.subUrl + '?' + self.countDescription + '=' + self.count + '&' + self.pageDescription + '=' + self.nowPage + self.other;
          if(!self.cache[self.nowPage]){
            $.get(self.url,function(res){
                if(res[self.dataDescription].length>0){

                    var list = res[self.dataDescription];
                    if(self.filterTpl){
                        list = new DataFilter({
                            data:list,
                            type:self.filterTpl
                        });
                    }
                    self.cache[self.nowPage] = list;
                    viewCommand({
                        command:'display',
                        param:[self.container,list,self.tpl]
                    });

                }else{
                    viewCommand({
                        command:'display',
                        param:[self.container,[],'blank']
                    });
                    console.error('上一页数据为空');
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
          if(/[0-9]*/.test(target)){
              if(target > self.allPage || target < 1 ){
                  alert('你输入页数为非法值');
                  self.jumpVal.value = '';
                  return;
              }
          }else{
              alert('请输入数字');
              self.jumpVal.value = '';
              return;
          }
          self.nowPage = target;
          self.url = self.subUrl + '?' + self.countDescription + '=' + self.count + '&' + self.pageDescription + '=' + self.nowPage + self.other;
          if(!self.cache[self.nowPage]){
            $.get(self.url,function(res){
                if(res[self.dataDescription].length>0){
                    var list = res[self.dataDescription];
                    if(self.filterTpl){
                        list = new DataFilter({
                            data:list,
                            type:self.filterTpl
                        });
                    }
                    self.cache[self.nowPage] = list;
                    viewCommand({
                        command:'display',
                        param:[self.container,list,self.tpl]
                    });

                }else{
                    viewCommand({
                        command:'display',
                        param:[self.container,[],'blank']
                    });
                    console.log('获取跳转页数据为空');
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
        self.nowPage = 1;
        self.url = self.subUrl + '?' + self.countDescription + '=' + self.count + '&' + self.pageDescription + '=' + self.nowPage + self.other;
        $.get(self.url,function(res){
            if(res[self.dataDescription].length>0){
                self.allPage = res[self.totalDescription];
                self.showNowPage();
                self.showAllPage();
                var list = res[self.dataDescription];
                if(self.filterTpl){
                    list = new DataFilter({
                        data:list,
                        type:self.filterTpl
                    });
                }
                self.cache[self.nowPage] = list;
                viewCommand({
                    command:'display',
                    param:[self.container,list,self.tpl]
                });
            }else{
                viewCommand({
                    command:'display',
                    param:[self.container,[],'blank']
                });
                console.log('页面数据为空');
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

