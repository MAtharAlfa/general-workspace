package repository;

import entity.Room;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class RoomRepoImpl implements RoomRepository {
    private final List<Room> rooms;

    public RoomRepoImpl() {
        this.rooms = new ArrayList<>();
    }

    public RoomRepoImpl(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public Optional<Room> findById(String id) {
        return rooms.stream()
                .filter(room -> Objects.equals(room.getId(), id))
                .findFirst();
    }

    public List<Room> getRooms() {
        return Collections.unmodifiableList(rooms);
    }
}
