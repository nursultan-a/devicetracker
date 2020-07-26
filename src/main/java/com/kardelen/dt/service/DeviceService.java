package com.kardelen.dt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kardelen.dt.model.Device;
import com.kardelen.dt.repositroy.DeviceRepository;


/**
 * @author Nursultan Abdrakypov
 * @email nuronjava@gmail.com
 */

@Service
public class DeviceService {
    @Autowired
    DeviceRepository deviceRepository;

    public void saveDevice(Device device){
        deviceRepository.save(device);
    }

    public Iterable<Device> getDeviceList(){
        return deviceRepository.findAll();
    }
    public Iterable<Device> getDeviceListByStatus(String currentStatus){
        return deviceRepository.findByCurrentStatus(currentStatus);
    }

    public Optional<Device> getDevice(String deviceID){
        return deviceRepository.findById(deviceID);
    }

    public boolean isExists(String deviceID){
        return deviceRepository.existsById(deviceID);
    }

    public  Optional<Device> updateResponseMSG(String id, String msg){
        return deviceRepository.findById(id).map(target ->{
            target.setResponseMsg(msg);

            deviceRepository.save(target);
            return target;
        });
    }

    public  Optional<Device> updatePhoneNumber(String id, String phoneNumber){
        return deviceRepository.findById(id).map(target ->{
            target.setPhoneNumber(phoneNumber);
            return target;
        });
    }

    public long count(){
        return deviceRepository.count();
    }

    public long countByStatus(String status){
        return deviceRepository.countByCurrentStatus(status);
    }
}
