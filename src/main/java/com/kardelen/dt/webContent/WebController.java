package com.kardelen.dt.webContent;

import com.kardelen.dt.constants.Command;
import com.kardelen.dt.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author Nursultan Abdrakypov
 * @email nuronjava@gmail.com
 */


@Controller
public class WebController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("/devices")
    public String devices(Model model) {

        model.addAttribute("totalDevice",deviceService.count());
        model.addAttribute("activeDevice", deviceService.countByStatus(Command.ACTIVE));
        model.addAttribute("passiveDevice", deviceService.countByStatus(Command.PASSIVE));
        model.addAttribute("r1Device", deviceService.countByStatus(Command.RESTRICTED1));
        model.addAttribute("r2Device", deviceService.countByStatus(Command.RESTRICTED2));
        model.addAttribute("r3Device", deviceService.countByStatus(Command.RESTRICTED3));

        return "devicelist";
    }

    @GetMapping("/activedevices")
    public String active(Model model) {
        model.addAttribute("totalDevice",deviceService.count());
        model.addAttribute("activeDevice", deviceService.countByStatus(Command.ACTIVE));
        model.addAttribute("passiveDevice", deviceService.countByStatus(Command.PASSIVE));
        model.addAttribute("r1Device", deviceService.countByStatus(Command.RESTRICTED1));
        model.addAttribute("r2Device", deviceService.countByStatus(Command.RESTRICTED2));
        model.addAttribute("r3Device", deviceService.countByStatus(Command.RESTRICTED3));

        return "devicelist";
    }

    @GetMapping("/passivedevices")
    public String passive(Model model) {
        model.addAttribute("totalDevice",deviceService.count());
        model.addAttribute("activeDevice", deviceService.countByStatus(Command.ACTIVE));
        model.addAttribute("passiveDevice", deviceService.countByStatus(Command.PASSIVE));
        model.addAttribute("r1Device", deviceService.countByStatus(Command.RESTRICTED1));
        model.addAttribute("r2Device", deviceService.countByStatus(Command.RESTRICTED2));
        model.addAttribute("r3Device", deviceService.countByStatus(Command.RESTRICTED3));

        return "devicelist";
    }

    @GetMapping("/restrictedone")
    public String restrictedone(Model model) {
        model.addAttribute("totalDevice",deviceService.count());
        model.addAttribute("activeDevice", deviceService.countByStatus(Command.ACTIVE));
        model.addAttribute("passiveDevice", deviceService.countByStatus(Command.PASSIVE));
        model.addAttribute("r1Device", deviceService.countByStatus(Command.RESTRICTED1));
        model.addAttribute("r2Device", deviceService.countByStatus(Command.RESTRICTED2));
        model.addAttribute("r3Device", deviceService.countByStatus(Command.RESTRICTED3));

        return "devicelist";
    }

    @GetMapping("/restrictedtwo")
    public String restrictedtwo(Model model) {
        model.addAttribute("totalDevice",deviceService.count());
        model.addAttribute("activeDevice", deviceService.countByStatus(Command.ACTIVE));
        model.addAttribute("passiveDevice", deviceService.countByStatus(Command.PASSIVE));
        model.addAttribute("r1Device", deviceService.countByStatus(Command.RESTRICTED1));
        model.addAttribute("r2Device", deviceService.countByStatus(Command.RESTRICTED2));
        model.addAttribute("r3Device", deviceService.countByStatus(Command.RESTRICTED3));

        return "devicelist";
    }

    @GetMapping("/restrictedthree")
    public String restrictedthree(Model model) {
        model.addAttribute("totalDevice",deviceService.count());
        model.addAttribute("activeDevice", deviceService.countByStatus(Command.ACTIVE));
        model.addAttribute("passiveDevice", deviceService.countByStatus(Command.PASSIVE));
        model.addAttribute("r1Device", deviceService.countByStatus(Command.RESTRICTED1));
        model.addAttribute("r2Device", deviceService.countByStatus(Command.RESTRICTED2));
        model.addAttribute("r3Device", deviceService.countByStatus(Command.RESTRICTED3));

        return "devicelist";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }

    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("/login")
    public String login() {

        return "login";
    }

}