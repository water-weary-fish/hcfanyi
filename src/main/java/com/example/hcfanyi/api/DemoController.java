package com.example.hcfanyi.api;
import com.alibaba.fastjson.JSON;
import com.example.hcfanyi.domain.resp.CheckOrderResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.lang.reflect.Method;

@Slf4j
@ResponseBody
@RestController
public class DemoController {
    // 增加拦截器 ip不在白名单，不让访问

    @RequestMapping(value = "/demo/test", method = RequestMethod.GET)
    public Integer saveTest() throws IOException {
        //todo 记录客户端ip
        return 1;
    }


    @GetMapping(value = "/checkOrder")
    public CheckOrderResp checkOrder(@RequestParam("orderId") String orderId) {
        CheckOrderResp checkOrderResp = new CheckOrderResp();
        checkOrderResp.setPaid(true);
        checkOrderResp.setEndTime(4102415999000L);
        checkOrderResp.setIsOpened(true);
        checkOrderResp.setForever(true);

        CheckOrderResp.UserDTO userDTO = new CheckOrderResp.UserDTO();
        userDTO.setPoints(0);
        userDTO.setId("62f0d11f650b74cd5f0d94ee");
        userDTO.setEmail("c18601974321@gmail.com");
        userDTO.setVipActivated(true);
        userDTO.setRebatePoints(0);
        userDTO.setForever(true);
        userDTO.setEndTime(4102415999000L);
        userDTO.setIsOpened(true);
        checkOrderResp.setUser(userDTO);

        log.info("checkOrder orderId = {}", orderId);
        return checkOrderResp;
    }

    @RequestMapping(value = "/getPayQR", method = {RequestMethod.GET, RequestMethod.POST})
    public Object getPayQR() {
        String s = "{\"orderId\":\"62f0d4fe650b743aa40d95b7\",\"qrUrl\":\"data:image/png;base64,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\"}";
        log.info("getPayQR");
        return JSON.parse(s);
    }








}
