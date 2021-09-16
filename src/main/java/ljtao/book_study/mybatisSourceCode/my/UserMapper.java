package ljtao.book_study.mybatisSourceCode.my;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User queryUserBySchoolName (@Param("userName") String userName);

    int addUser (User user);

    int addUser_b (User user);
}
