package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class UserServiceAITest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    @DisplayName("输入为null时抛出IllegalArgumentException")
    public void getAge_NullInput_ThrowsIllegalArgumentException() {
        Executable executable = () -> userService.getAge(null);
        Assertions.assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    @DisplayName("输入长度不为18位时抛出IllegalArgumentException")
    public void getAge_InvalidLengthInput_ThrowsIllegalArgumentException() {
        Executable executable = () -> userService.getAge("123456789012345");
        Assertions.assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    @DisplayName("输入有效身份证号时正确计算年龄")
    public void getAge_ValidInput_CalculatesCorrectAge() {
        String idCard = "110002200505091218";
        LocalDate birthDate = LocalDate.parse("20050509", DateTimeFormatter.ofPattern("yyyyMMdd"));
        LocalDate currentDate = LocalDate.now();
        int expectedAge = Period.between(birthDate, currentDate).getYears();
        Integer age = userService.getAge(idCard);
        Assertions.assertEquals(expectedAge, age);
    }


    @Test
    @DisplayName("输入未来出生日期时计算负数年龄")
    public void getAge_FutureBirthDate_CalculatesNegativeAge() {
        String idCard = "110002205005091218"; // 假设未来日期
        LocalDate birthDate = LocalDate.parse("20500509", DateTimeFormatter.ofPattern("yyyyMMdd"));
        int expectedAge = LocalDate.now().getYear() - birthDate.getYear();
        Integer age = userService.getAge(idCard);
        Assertions.assertEquals(expectedAge, age);
    }
    @Test
    @DisplayName("当输入为null时抛出IllegalArgumentException")
    public void getGender_NullInput_ThrowsIllegalArgumentException() {
        Executable executable = () -> userService.getGender(null);
        Assertions.assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    @DisplayName("当输入长度不为18位时抛出IllegalArgumentException")
    public void getGender_InvalidLengthInput_ThrowsIllegalArgumentException() {
        Executable executable = () -> userService.getGender("123456789012345");
        Assertions.assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    @DisplayName("当输入有效且第17位为奇数时返回'男'")
    public void getGender_ValidInputOdd17thDigit_ReturnsMale() {
        String idCard = "110002200505091218"; // 第17位为8，偶数
        String gender = userService.getGender(idCard);
        Assertions.assertEquals("男", gender);
    }

    @Test
    @DisplayName("当输入有效且第17位为偶数时返回'女'")
    public void getGender_ValidInputEven17thDigit_ReturnsFemale() {
        String idCard = "110002200505091227"; // 第17位为7，奇数
        String gender = userService.getGender(idCard);
        Assertions.assertEquals("女", gender);
    }
}
