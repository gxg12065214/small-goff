package club.banyuan.mall.controller;

import club.banyuan.mall.common.mapper.UmsAdminMapper;
import club.banyuan.mall.dto.UmsAdminCreateParam;
import club.banyuan.mall.dto.UmsAdminLoginParam;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

public class AdminController {
    @RestController
    @RequestMapping(value = "/api/admin")
    public class AdminController {

        @Value("${jwt.tokenHead}")
        private String tokenHead;

        @Autowired
        private UmsAdminService adminService;

        @Autowired
        private UmsAdminMapper adminMapper;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @RequestMapping(value = "/login", method = RequestMethod.POST)
        @ResponseBody
        public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {
            String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
            if (token == null) {
                return CommonResult.validateFailed("用户名或密码错误");
            }
            Map<String, String> tokenMap = new HashMap<>();
            tokenMap.put("token", token);
            tokenMap.put("tokenHead", tokenHead);
            return CommonResult.success(tokenMap);
        }

        @PostMapping(value = "/create")
        @ResponseBody
        public CommonResult create(@RequestBody     UmsAdminCreateParam param) {
            try {
                adminService.createUser(param);
                return CommonResult.success("OK");
            } catch (CommonException e) {
                // e.printStackTrace();
                return CommonResult.failed(ResultCode.BUSINESS_FAILED, e.getMessage());
            }
        }
}
