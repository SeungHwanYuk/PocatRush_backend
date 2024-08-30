package DW.PocatRush.controller;

import DW.PocatRush.model.Device;
import DW.PocatRush.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/device")
public class DeviceController {
    DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping("/join/{userId}")
    public ResponseEntity<Device> joinDeviceWithUserId(@PathVariable String userId) {
        return new ResponseEntity<>(deviceService.joinDeviceWithUserId(userId), HttpStatus.CREATED);
    }

    @GetMapping("/check/{userId}")
    public ResponseEntity<Device> deviceCheck(@PathVariable String userId) {
        return new ResponseEntity<>(deviceService.deviceCheck(userId),HttpStatus.OK);
    }
}
