package ljtao.book_study.JavaConcurrencyInPractice.my_code;

import ljtao.book_study.mybatisSourceCode.my.User;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    User queryUserBySchoolName(@Param("userName") String userName);
}
