package com.kardelen.dt.controllers;


import com.kardelen.dt.constants.Command;
import com.kardelen.dt.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import com.kardelen.dt.repositroy.DeviceRepository;
import com.kardelen.dt.model.Device;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * @author Nursultan Abdrakypov
 * @email nuronjava@gmail.com
 */



@Controller
@CrossOrigin(origins = "http://kardelenmuhendislik.net:80/")
@RequestMapping("/ecp")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping(path="/")
    public @ResponseBody
    String checkDevice (@RequestParam String phoneNumber, @RequestParam String deviceId) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        String currentTime = formatter.format(date);

        if (deviceService.isExists(deviceId)){

            //Manipulate Device
            Optional<Device> device = deviceService.getDevice(deviceId);

            String responseMSG = device.get().getResponseMsg();

            device.get().setCurrentStatus(responseMSG);
            device.get().setLastUpdate(currentTime);

            if(!device.get().getPhoneNumber().equals(phoneNumber)){
                device.get().setPhoneNumber(phoneNumber);
            }
            deviceService.saveDevice(device.get());


            return responseMSG;
        }
        else{

            // Add new device to DB
            Device device = new Device();

            device.setId(deviceId);
            device.setPhoneNumber(phoneNumber);
            device.setLastUpdate(currentTime);
            device.setCurrentStatus(Command.ACTIVE);
            device.setRegisterTime(currentTime);
            device.setResponseMsg(Command.ACTIVE);

            deviceService.saveDevice(device);
            return device.getResponseMsg();
        }
    }

}
