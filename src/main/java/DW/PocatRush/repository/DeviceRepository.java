package DW.PocatRush.repository;

import DW.PocatRush.model.Device;
import DW.PocatRush.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeviceRepository extends JpaRepository<Device, String> {

    Optional<Device> findByUser(User user);
}
