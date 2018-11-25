package net.itjsz.shirojwt.controller.sys;


import io.swagger.annotations.Api;
import net.itjsz.shirojwt.common.bean.PageRequestBean;
import net.itjsz.shirojwt.common.bean.PageResponseBean;
import net.itjsz.shirojwt.common.bean.Result;
import net.itjsz.shirojwt.entity.SysUser;
import net.itjsz.shirojwt.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 系统用户
 *
 * @author Mr.Lee
 * @email lmy@mydkj.net
 * @date 2018-11-14 17:11:06
 */
@Api(description ="系统用户")
@RestController
@RequestMapping("sys/user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 列表
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public Result<PageResponseBean> list(@RequestBody PageRequestBean pageRequestBean){
        PageResponseBean page = sysUserService.queryPage(pageRequestBean);

        return new Result(page);
    }


    /**
     * 详细信息
     */
    @GetMapping("/info/{userId}")
    public Result<SysUser> info(@PathVariable("userId") Long userId){
			SysUser sysUser = sysUserService.findById(userId);

        return new Result<SysUser>("请求成功",200,sysUser);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(@RequestBody SysUser sysUser){
//			sysUserService.insert(sysUser);

        return new Result();
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public Result edit(@RequestBody SysUser sysUser){
//			sysUserService.update(sysUser);

        return new Result();
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result delete(@RequestBody SysUser sysUser){
//			sysUserService.delete(sysUser));

        return new Result();
    }

}
