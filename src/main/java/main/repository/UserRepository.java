package main.repository;

import main.dto.UserDto;
import main.dto.UserDtoWithPhoto;
import main.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("select new main.dto.UserDto(u.id, u.name) from User u where u.id = :id")
    List<UserDto> findById(@Param("id") int id);

    @Query("select new main.dto.UserDtoWithPhoto(u.id, u.name, u.photo) from User u where u.id = :id")
    List<UserDtoWithPhoto> findByIdWithPhoto(@Param("id") int id);
}