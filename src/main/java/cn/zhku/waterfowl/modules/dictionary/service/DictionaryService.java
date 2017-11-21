package cn.zhku.waterfowl.modules.dictionary.service;

import cn.zhku.waterfowl.pojo.entity.Dictionary;
import cn.zhku.waterfowl.pojo.entity.DictionaryExample;
import cn.zhku.waterfowl.pojo.mapper.DictionaryMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2017/11/13 23:12.
 * 说明：
 */
@Service
public class DictionaryService  implements IBaseService<Dictionary> {

    @Autowired
    DictionaryMapper dictionaryMapper;

    @Override
    public int add(Dictionary entity) throws Exception {
        return dictionaryMapper.insert(entity);
    }

    @Override
    public int update(Dictionary entity) throws Exception {
        return dictionaryMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int delete(Dictionary entity) throws Exception {
        return dictionaryMapper.deleteByPrimaryKey(entity.getId());
    }

    @Override
    public Dictionary get(String id) throws Exception {
        return dictionaryMapper.selectByPrimaryKey(id);
    }

    @Override
    public Dictionary get(Dictionary entity) throws Exception {
        return null;
    }

    @Override
    public List<Dictionary> findList(Dictionary entity) throws Exception {
        DictionaryExample dictionaryExample = new DictionaryExample();
        DictionaryExample.Criteria criteria = dictionaryExample.createCriteria();
        if (entity.getPid() == null)
            criteria.andPidEqualTo(entity.getPid());
        return dictionaryMapper.selectByExample(dictionaryExample);
    }
}
