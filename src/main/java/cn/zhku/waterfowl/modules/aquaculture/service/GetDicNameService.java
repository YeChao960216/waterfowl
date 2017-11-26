package cn.zhku.waterfowl.modules.aquaculture.service;

import cn.zhku.waterfowl.modules.aquaculture.dao.GetDicNameDao;
import cn.zhku.waterfowl.pojo.entity.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 成君
 * @date 2017/11/21 0021 21:34
 * @E-mail 943193747@qq.com
 */
@Service
public class GetDicNameService {
    @Autowired
    private GetDicNameDao dao;

    /**
     * 在字典中获取name
     * @return
     */
    public List<Dictionary> getNameFromDictionary(String pid) {
        return dao.getStatus(pid);
    }
}
