package com.kardelen.dt.controllers;

import com.kardelen.dt.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import com.kardelen.dt.model.Device;


/**
 * @author Nursultan Abdrakypov
 * @email nuronjava@gmail.com
 */



@Controller
@CrossOrigin(origins = "http://localhost:8080/")
@RequestMapping("/api")
public class CommandController {

    @Autowired
    private DeviceService deviceService;

    @PostMapping(path="/updateResponseMSG")
    public @ResponseBody
    String updateResponseMSG (@RequestParam String deviceId, @RequestParam String msg) {



        if (deviceService.isExists(deviceId)){

            deviceService.updateResponseMSG(deviceId, msg);

            return "response msg updated for "+deviceService.getDevice(deviceId).get().getId();
        }
        else{
            return "There is no such device";
        }
    }

    @PostMapping(path="/mltpl")
    public @ResponseBody
    String updateMultipleDeviceResponseMSG (@RequestParam String[] deviceIds, @RequestParam String msg) {
        for (String deviceId:deviceIds
             ) {
            if (deviceService.isExists(deviceId)){

                deviceService.updateResponseMSG(deviceId, msg);

                System.out.println("response msg updated for "+deviceService.getDevice(deviceId).get().getId());
            }
            else{
                return "There is no such device" + deviceService.getDevice(deviceId).get().getId();
            }
        }

        return "multiple update";
    }



    @GetMapping(path="/all")
    public @ResponseBody Iterable<Device> getAllDevices() {
        // This returns a JSON or XML with the devices
        return deviceService.getDeviceList();
    }

    @GetMapping(path="/status")
    public @ResponseBody Iterable<Device> getDevicesByStatus(@RequestParam String status) {
        // This returns a JSON or XML with the active devices
        Iterable<Device> deviceListByStatus = deviceService.getDeviceListByStatus(status);

        if (deviceListByStatus != null){
            System.out.println("There is devices with the status: "+ status.toString());
            return deviceService.getDeviceListByStatus(status);
        }else {
            System.out.println("There is no status with the status: "+ status.toString());
            return null;

        }

    }

}
