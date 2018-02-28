package cn.zhku.waterfowl.task;

import cn.zhku.waterfowl.pojo.entity.Dictionary;
import cn.zhku.waterfowl.pojo.entity.DictionaryExample;
import cn.zhku.waterfowl.pojo.mapper.DictionaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2018/1/25 0025.
 */
@Service
@EnableScheduling
public class DictionaryTask {
    @Autowired
    private DictionaryMapper dictionaryMapper;
    @Scheduled(cron = "0 0 0/4 * * ?")  //    每4个小时触发任务
    public void addDictionaryTask() {
        /*检查数据库字典表是否插入正确，或者被sql注入；若有，删掉，保证系统的正常运行*/
        DictionaryExample dictionaryExample=new DictionaryExample();
        List<Dictionary> dictionaryList=new ArrayList<Dictionary>(dictionaryMapper.selectByExample(dictionaryExample));
        Iterator<Dictionary> iterator=dictionaryList.iterator();
        while (iterator.hasNext()){
            if (Integer.parseInt(iterator.next().getId())<10000||Integer.parseInt(iterator.next().getId())>100000||Integer.parseInt(iterator.next().getPid())>100000
            ||(Integer.parseInt(iterator.next().getPid())>0&&Integer.parseInt(iterator.next().getPid())<10000)){
                dictionaryMapper.deleteByPrimaryKey(iterator.next().getId());
            }
        }
    }
}
