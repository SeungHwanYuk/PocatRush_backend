package DW.PocatRush.service;

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
}
