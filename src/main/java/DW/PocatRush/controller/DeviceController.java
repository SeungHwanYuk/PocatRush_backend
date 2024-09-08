package DW.PocatRush.controller;

import DW.PocatRush.dto.DeviceDto;
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

    @PostMapping("/updatekm/{userId}/{km}")
    public HttpStatus kmUpdateByUserId(@PathVariable String userId ,@PathVariable int km ) {
        return deviceService.kmUpdateByUserId(userId,km);
    }
    @PostMapping("/updatekg/{userId}/{kg}")
    public HttpStatus kgUpdateByUserId(@PathVariable String userId ,@PathVariable int kg ) {
        return deviceService.kgUpdateByUserId(userId,kg);
    }
    @PostMapping("/updatemin/{userId}/{min}")
    public HttpStatus minUpdateByUserId(@PathVariable String userId ,@PathVariable int min ) {
        return deviceService.minUpdateByUserId(userId,min);
    }

    @PostMapping("/plusdata")
    public ResponseEntity<Device> plusDeviceData(@RequestBody DeviceDto deviceDto){
        return new ResponseEntity<>(deviceService.plusDeviceData(deviceDto), HttpStatus.OK);
    }


}
