package com.kardelen.dt.repositroy;

import com.kardelen.dt.model.Device;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Nursultan Abdrakypov
 * @email nuronjava@gmail.com
 */


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface DeviceRepository extends CrudRepository<Device, String> {
    long countByCurrentStatus(String status);
    List<Device> findByCurrentStatus(String status);
}