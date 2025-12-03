package com.anoystick.repository;

import com.anoystick.entity.user.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@RepositoryDefinition(domainClass = UserEntity.class, idClass = Long.class)
public interface UserRepository
        extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity>
{
    Page<UserEntity> findByUserName(String name, Pageable pageable);
    //find username and userEmail

    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);

    List<UserEntity> findByUserEmail(String userEmail);
    /**
     * Where userName Like %?
     * */
    List<UserEntity> findByUserNameStartingWith(String userName);

    /**
     * Where userName Like ?%
    * */

    List<UserEntity> findByUserNameEndingWith(String userName);

    /**
     * Where id < 1
     * */
    List<UserEntity> findByIdLessThan(Long id);

    /**
     * RAW SQL
     * **/

    @Query("select u from UserEntity u where u.id = (select max(p.id) from UserEntity p)")
    UserEntity findMaxIdUser();

    @Query("select u from UserEntity u where u.userName = ?1 and u.userEmail = ?2")
    List<UserEntity> getUserEntitiesBy(String userName, String userEmail);

    @Query("select u from UserEntity u where u.userName = :userName and u.userEmail = :userEmail")
    List<UserEntity> getUserEntitiesByTwo(@Param("userName") String userName, @Param("userEmail") String userEmail);

    /**
     * Update Delete
     */
    @Modifying
    @Query("UPDATE UserEntity u set  u.userName = :userName")
    @Transactional
    int updateUserName(@Param("userName") String userName);

    /**
     * get count user use native query
     */

    @Query(value = "select count (id) from users", nativeQuery = true)
    long getTotalUsers();
}
