package com.example.ComplaintSytem.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);
@Modifying
@Query("update User set role= :role where username= :username")
    void UpdateUserRole(@Param("username")String username, @Param("role")Role role);
    List<User> findByRole(Role role);
}
