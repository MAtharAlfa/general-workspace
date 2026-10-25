package repository;

import entity.Room;

import java.util.Optional;

public interface RoomRepository {
    Optional<Room> findById(String id);
}
