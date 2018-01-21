package cn.zhku.waterfowl.modules.dictionary.service;

import cn.zhku.waterfowl.modules.dictionary.dao.DictionaryDao;
import cn.zhku.waterfowl.pojo.entity.Dictionary;
import cn.zhku.waterfowl.pojo.entity.DictionaryExample;
import cn.zhku.waterfowl.pojo.mapper.DictionaryMapper;
import cn.zhku.waterfowl.util.interfaceUtils.IBaseService;
import org.dozer.loader.xml.ELEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    DictionaryDao dictionaryDao;

    /**
     *  增加字典
     * @param entity
     *            映射数据库单表的实体类
     * @return  1 成功增加字典， 其他整型均为失败
     * @throws Exception    sql
     */
    @Override
    public int add(Dictionary entity) throws Exception {
        //  如果发现新增的字典与数据库中的字典同名，立刻返回一个500来使controller增加字典失败
        if (get(entity) != null)
            return 500;
        return dictionaryMapper.insert(entity);
    }

        //这是一个关于增加栏目的方法，即父栏目，下面的raise方法也差不多
    public String insert() throws Exception {
        //将返回结果用list包裹
        List<Dictionary> dictionaryList=new ArrayList<Dictionary>(dictionaryDao.addid(String.valueOf(0)));
        //赋i一个初始值100；为什么是以前呢，主要是为了当没有任何一个栏目时，给他一个编号
        int i=10000;
        //初始化r这个字符
        String r=null;
        //如果当前没有任何一个栏目，即父栏目
        if (dictionaryList.isEmpty()||dictionaryList==null){
            //返回i作为他的id
            return String.valueOf(i);
        }
        //当有栏目的时候，又分为两种情况
        else{
            //进行循环体，为什么是i+=1000呢，因为前两位表示父栏目
        for (i=10000;i<100000;i+=1000){
            //第一种情况是当当前的序列没有空值的时候，即都是按照顺序的，当然实际中这种情况会随着你的删除而变得可能性越来越低
            if (dictionaryList.size()==i/1000-9){
                //给值是下一个序列，即当前的最大值+1000
                r=String.valueOf(i+1000);
                break;
            }
            //第二种情况是当当前的序列是有空缺的，即被删除过
           else if(i<Integer.parseInt(dictionaryList.get(i/1000-10).getId())){
                //给值是当前序列
                r=String.valueOf(i);
                //有这两种情况的都break，跳出循环；两种情况都不满足就继续循环
                break;
            }
       }
            return r;
        }

    }


    public String raise(String pid) throws Exception {
        List<Dictionary> dictionaryList=new ArrayList<Dictionary>(dictionaryDao.addid(pid));
        int k=0;
        String r=null;
        if (dictionaryList.isEmpty()||dictionaryList==null){
            k = Integer.parseInt(pid)+1;
            return String.valueOf(k);
        }
        else {
            for (int i = 0; i < 1000; i++) {
                k = Integer.parseInt(pid) + i + 1;
                if (k - Integer.parseInt(pid) == dictionaryList.size()) {
                    r = String.valueOf(k + 1);
                    break;
                } else if (k < Integer.parseInt(dictionaryList.get(i).getId())) {
                    r = String.valueOf(k);
                    break;
                }
            }
        }
        return r;
        }


    @Override
    public int update(Dictionary entity) throws Exception {
        return dictionaryMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int delete(Dictionary entity) throws Exception {
        return dictionaryMapper.deleteByPrimaryKey(entity.getId());
    }

    public void deleteAll(String pid) throws Exception {
        dictionaryDao.deleteAll(pid);
    }

    /**
     *  通过字典id获取id
     * @param id
     *            主键ID
     * @return 字典
     * @throws Exception    sql
     */
    @Override
    public Dictionary get(String id) throws Exception {
        return dictionaryMapper.selectByPrimaryKey(id);
    }


    /**
     *  根据字典名称查找
     * @param entity
     *            映射数据库单表的实体类
     * @return  字典
     * @throws Exception    sql
     */
    @Override
    public Dictionary get(Dictionary entity) throws Exception {
        DictionaryExample dictionaryExample = new DictionaryExample();
        dictionaryExample.or().andNameEqualTo(entity.getName());
        //  通过名字查出是否有同名字典
        List<Dictionary> dictionaryList = dictionaryMapper.selectByExample(dictionaryExample);
        //  如果查出的列表存在相同名字的字典。则返回它
        if (dictionaryList.size() >= 1)
            return dictionaryList.get(0);
        else
            return null;
    }


    /**
     *  根据pid查找字典
     * @param entity    带有参数 pid
     *            映射数据库单表的实体类
     * @return  字典列表
     * @throws Exception    sql
     */
    @Override
    public List<Dictionary> findList(Dictionary entity) throws Exception {
        DictionaryExample dictionaryExample = new DictionaryExample();
        DictionaryExample.Criteria criteria = dictionaryExample.createCriteria();
        if (entity.getPid() != null)
            criteria.andPidEqualTo(entity.getPid());
        if (entity.getName() != null)
            criteria.andNameEqualTo(entity.getName());
        return dictionaryMapper.selectByExample(dictionaryExample);
    }
}
