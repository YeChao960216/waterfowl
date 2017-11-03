package cn.zhku.waterfowl.modules.user.controller;


import cn.zhku.waterfowl.modules.user.service.UserService;
import cn.zhku.waterfowl.pojo.entity.User;
import cn.zhku.waterfowl.util.modle.CommonQo;
import cn.zhku.waterfowl.util.modle.Message;
import cn.zhku.waterfowl.web.BaseController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @author  : 钱伟健 gonefutre
 *  date    : 2017/10/14 20:51.
 *  E-mail  : gonefuture@qq.com
 */

/**
 * 对用户user状态操作的controller,继承BaseController以便使用全局变量和参数绑定
 */
@Controller
public class UserController extends BaseController {
    //  注入user表的服务
    @Autowired
    UserService userService;

    //增加用户

    /** 增加用户
     *
     * @param user user实体类的各种字段，如
     * @return User
     * @throws Exception sql
     */
    @ResponseBody
    @RequestMapping("{adminPath}/user/new")
    public Message addUser(User user) throws Exception {
        user.setId(UUID.randomUUID().toString().replace("-","").toUpperCase());   //用32位长度的UUID来设置用户id
        if(userService.add(user) == 1)
            return new Message("1","增加用户成功");
        else
            return new Message("2","增加用户失败");
    }

    //删除用户

    /** 根据用户id删除对象
     *
     * @param id   只需id字段
     * @return 状态码  0 为失败， 1为成功
     * @throws Exception sql
     */
    @ResponseBody
    @RequestMapping("{adminPath}/user/delete/{id}")
    public Message deleteUser(@PathVariable String id) throws Exception {
        User user = new User();
        user.setId(id);
        if(userService.delete(user) == 1)
            return new Message("1","删除用户成功");
        else
            return new Message("2","删除用户失败");
    }


    //修改用户

    /** 根据id修改用户
     *
     * @param   id 包括用户id的各个user实体类字段
     * @return  状态码  0 为失败， 1为成功
     * @throws Exception    sql
     */
    @ResponseBody
    @RequestMapping("{adminPath}/user/edit/{id}")
    public Message editUser(@PathVariable String id,User user) throws Exception {
        user.setId(id);
        if(userService.update(user) == 1)
            return new Message("1","修改用户成功");
        else
            return new Message("2","修改用户成失败");
    }

    //展示用户

    /** 根据id展示用户信息
     *
     * @param id   只需用户id字段
     * @return user实体
     * @throws Exception    sql
     */
    @ResponseBody
    @RequestMapping("{adminPath}/user/show/{id}")
    public User showUser(@PathVariable String id) throws Exception {
        return userService.get(id);
    }
    //展示所有用户

    /**
     *  根据多个添加添加展示一列用户 => 多条件查询分页
     * @param user   user实体的各个字段
     * @param commonQo   通用查询类，拥有pageSize,pageNum
     * @return  PageInfo<User> 一个带有List<User>的pageBean
     * @throws Exception    sql
     */
    @ResponseBody
    @RequestMapping("{adminPath}/user/list")
    public PageInfo<User> listUser(User user, CommonQo commonQo) throws Exception {
        //  设置页码，页面大小，排序方式,此处的sql相当于 limit pageNum ,pageSize orderBy id desc
        PageHelper.startPage(commonQo.getPageNum(), commonQo.getPageSize(), "id desc");
        //  通过服务层获取查询后的用户列表
        List<User> userList =  userService.findList(user);
        //  返回 pageBean
        return new PageInfo<User>(userList);
    }

    // 接受一个新Excel
    /**
     *  导入用excel
     * @param request      请求域
     * @param excelFile excel文件，前端用multipart/form-data类型上传
     * @return Message
     */
    @RequestMapping(value = "{adminPath}/user/excel/new")
    @ResponseBody
    public Message uploadUserExcel(HttpServletRequest request,MultipartFile excelFile)  {
        try {
            if(excelFile != null){
                //List<UserModel> models=userService.insertUserByExcel(excelFile);
                    //  储存图片的物理路径
                    String realPath = request.getServletContext().getRealPath("/WEB-INF/excel/user");
                    //  获取上传文件的文件类型名
                    String originalFileName = excelFile.getOriginalFilename();
                    //  新的的图片名称,用UUID做文件名防止重复
                    String newFileName = UUID.randomUUID().toString().replace("-","").toUpperCase()+originalFileName.substring(originalFileName.lastIndexOf("."));
                    //新图片文件
                    File newFile = new File(realPath+newFileName);
                    //将内存中的数据写入磁盘
                    excelFile.transferTo(newFile);
                    //将新图片名称写到repair中
                    //repair.setRepairPic(newFileName);
                if(true){
                    return new Message("1","名单导入成功");
                }else{
                    return new Message("2","名单导入失败");
                }
            }else{
                return new Message("2","上传失败");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }



}
