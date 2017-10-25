package cn.zhku.waterfowl.modules.epidemic.service;

import cn.zhku.waterfowl.modules.epidemic.service.EpidemicService;
import cn.zhku.waterfowl.pojo.entity.Epidemic;
import cn.zhku.waterfowl.pojo.entity.Epidemic;
import cn.zhku.waterfowl.pojo.entity.EpidemicExample;
import cn.zhku.waterfowl.pojo.mapper.EpidemicMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

public class EpidemicService  implements IBaseService<Epidemic>  {
    @Autowired
    EpidemicService epidemicService;
    public  int add(Epidemic entity) {
    }

    public  int delete(Epidemic entity) {
    }

    public  int update(Epidemic entity) {

    }

    /**
     *  根据主键id删除
     * @param id
     *            主键ID
     * @return 状态码 1 成功， 0 失败
     * @throws Exception sql
     */
    public  int delete(Epidemic entity) {
        return EpidemicMapper.deleteByPrimaryKey(entity);
    }
    /**
     *  根据主键返回 epidemic
     * @param id
     *            主键ID
     * @return user
     * @throws Exception sql
     */
    public  Epidemic get(String id) {
        return EpidemicMapper.selectByPrimaryKey(id);
    }

    public  List<Epidemic> findList(Epidemic entity) {


    }
}
