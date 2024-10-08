package DW.PocatRush.service;

import DW.PocatRush.dto.DeviceDto;
import DW.PocatRush.exception.ResourceNotFoundException;
import DW.PocatRush.model.Device;
import DW.PocatRush.model.User;
import DW.PocatRush.repository.DeviceRepository;
import DW.PocatRush.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class DeviceService {

    DeviceRepository deviceRepository;
    UserRepository userRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository, UserRepository userRepository) {
        this.deviceRepository = deviceRepository;
        this.userRepository = userRepository;
    }

    public Device joinDeviceWithUserId(String userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            Device device = new Device();
            device.setKm(0);
            device.setKg(0);
            device.setMin(0);
            device.setUser(userOptional.get());
            return deviceRepository.save(device);
        } else {
            throw new ResourceNotFoundException("User", "ID", userId);
        }
    }

    public Device deviceCheck(String userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()) {
            Optional<Device> deviceOptional = deviceRepository.findByUser(userOptional.get());
            if (deviceOptional.isPresent()) {
                return deviceOptional.get();
            } else {
                throw new ResourceNotFoundException("Device", "ID", userId);
            }
        } else {
            throw new ResourceNotFoundException("User", "ID", userId);
        }
    }

    public HttpStatus kmUpdateByUserId(String userId, int km) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()) {
            Optional<Device> deviceOptional = deviceRepository.findByUser(userOptional.get());
            if (deviceOptional.isPresent()) {
                deviceOptional.get().setKm(km);
                deviceRepository.save(deviceOptional.get());
                return HttpStatus.OK;
            } else {
                throw new ResourceNotFoundException("Device", "ID", userId);
            }
        } else {
            throw new ResourceNotFoundException("User", "ID", userId);
        }
    }
    public HttpStatus kgUpdateByUserId(String userId, int kg) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()) {
            Optional<Device> deviceOptional = deviceRepository.findByUser(userOptional.get());
            if (deviceOptional.isPresent()) {
                deviceOptional.get().setKg(kg);
                deviceRepository.save(deviceOptional.get());
                return HttpStatus.OK;
            } else {
                throw new ResourceNotFoundException("Device", "ID", userId);
            }
        } else {
            throw new ResourceNotFoundException("User", "ID", userId);
        }
    }
    public HttpStatus minUpdateByUserId(String userId, int min) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()) {
            Optional<Device> deviceOptional = deviceRepository.findByUser(userOptional.get());
            if (deviceOptional.isPresent()) {
                deviceOptional.get().setMin(min);
                deviceRepository.save(deviceOptional.get());
                return HttpStatus.OK;
            } else {
                throw new ResourceNotFoundException("Device", "ID", userId);
            }
        } else {
            throw new ResourceNotFoundException("User", "ID", userId);
        }
    }

    public Device plusDeviceData(DeviceDto deviceDto){
        Optional<Device> deviceOptional = deviceRepository.findById(deviceDto.getDeviceId());
        if(deviceOptional.isPresent()){
            deviceOptional.get().setKm(deviceOptional.get().getKm()+deviceDto.getKm());
            deviceOptional.get().setKg(deviceOptional.get().getKg()+deviceDto.getKg());
            deviceOptional.get().setMin(deviceOptional.get().getMin()+deviceDto.getMin());
            deviceRepository.save(deviceOptional.get());
        return deviceOptional.get();
        }else {
            throw new ResourceNotFoundException("Device","Id",deviceDto.getDeviceId());
        }


    }


}
