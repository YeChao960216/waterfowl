/**
 * 伟龙 - qq:1061258787
 * 分页缓冲技术，
 * 使用说明：var tplPage = new Page(dom,tpl).getPage(num);
 */
var Page = function(dom,tpl){
	if(dom&&tpl){
		var cache = {};//数据缓存区，也可以放到cookie，localStorage
		return{
			getPage:function(num){
				if(cache[num]){
					console.log("从缓冲区取出，第"+num+"页数据");
					this.displayPage(num);
				}else{                     //没有缓存,就进行请求；
					// $.post{
					// 	url:'http://....',
					// 	dataType:'json',
					// 	data:{'page':num},
					// 	success:function(data){
					// 		cache[num] = data;
					// 		this.displayPage(num);
					// 	},function(xhrError){
					// 		console.err('获取分页数据失败');
					// 	}
					// }

					this.displayPage(num);
				}

			},
			displayPage:function(num){
				//调用命令模式，把请求过来的数据显示在试图上；
				console.log(tpl,num,cache[num]);
				// new ViewCommand({
				// 	tpl:tpl,
				// 	bind:dom,
				// 	data:cache[num]
				// });
				viewCommand({
					command:'display',
					param:[dom,cache[num],tpl]
				});

			},
			getCache:function(){		//遍历缓存对象
				console.log('临时缓冲区中的所有数据如下');
				for(var i in cache){
					console.log(i+'->'+cache[i]);
				}
			}

		}
	}else{
		console.error('创建的模板类型需要以字符串格式传入');
	}
};


