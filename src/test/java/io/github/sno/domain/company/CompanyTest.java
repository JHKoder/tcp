package io.github.sno.domain.company;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompanyTest {

    @Test
    void 생성한다(){
        //given
        String name="정훈 컴퍼니";
        String host="127.0.0.1";
        String port = "";

        //when
        Company company = Company.of(name,host,port);

        //then
        Assertions.assertThat(company).isNotNull();
    }

}