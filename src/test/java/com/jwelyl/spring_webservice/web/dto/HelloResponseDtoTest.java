package com.jwelyl.spring_webservice.web.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void lombok_test() {
        //  given
        String name = "test";
        int amount = 1000;

        //  when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //  then
        assertThat(dto.getName()).isEqualTo(name);      //  assertThat : assertj의 검증메소드
        assertThat(dto.getAmount()).isEqualTo(amount);  //  isEqualTo : assertj의 동등 비교 메소드

    }
}
