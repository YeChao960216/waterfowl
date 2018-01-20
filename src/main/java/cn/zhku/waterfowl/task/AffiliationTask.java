package cn.zhku.waterfowl.task;

import cn.zhku.waterfowl.pojo.entity.Affiliation;
import cn.zhku.waterfowl.pojo.entity.AffiliationExample;
import cn.zhku.waterfowl.pojo.entity.Fowlery;
import cn.zhku.waterfowl.pojo.entity.FowleryExample;
import cn.zhku.waterfowl.pojo.mapper.AffiliationMapper;
import cn.zhku.waterfowl.pojo.mapper.FowleryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jin on 2017/11/30.
 * 大禽舍的定时器，定时更改状态
 */
@Service
@EnableScheduling
public class AffiliationTask {
    @Autowired
    private AffiliationMapper affiliationMapper ;
    @Autowired
    private FowleryMapper fowleryMapper ;

    @Scheduled(cron = "0 0 0/6 * * ?")    //每6个小时触发一次
    public void addAffiliationTask(){
        AffiliationExample affiliationExample=new AffiliationExample();
        FowleryExample fowleryExample =new FowleryExample();
        List<Affiliation> affiliationList=new ArrayList<Affiliation>(affiliationMapper.selectByExample(affiliationExample));
        Iterator<Affiliation> iterator=affiliationList.iterator();
        while(iterator.hasNext()){
            Affiliation affiliation=iterator.next();   //生成实体类，并填充，找到一个affiliation
            String id=affiliation.getId();
            affiliation.setId(id);
            FowleryExample.Criteria criteria=fowleryExample.createCriteria();
            criteria.andAffiliationEqualTo(id).andStatusEqualTo("可使用");    //查找该affiliation且状态为0的小禽舍
            List<Fowlery> list=fowleryMapper.selectByExample(fowleryExample);
            fowleryExample.clear();       //防止循环过程中条件的叠加
            if(list.size()==0){
                //不能找到一间为空的,修改状态
                affiliation.setStatus("满员");
                affiliationMapper.updateByPrimaryKeySelective(affiliation);
            }else {
                //能够找到为空的禽舍
                affiliation.setStatus("未满员");
                affiliationMapper.updateByPrimaryKeySelective(affiliation);
            }
        }
    }
}
