package base.repos;

import base.domain.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepo extends CrudRepository<Room, Long> {

    List<Room> findByAvailableAndSubject(boolean available, String subject);

}
