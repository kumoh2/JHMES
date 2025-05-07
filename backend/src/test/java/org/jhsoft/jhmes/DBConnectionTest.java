package org.jhsoft.jhmes;

import java.sql.Connection;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class DBConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @DisplayName("1. 데이터소스 커넥션 확보 테스트")
    void testConnectionIsNotNull() throws Exception {
        try (Connection conn = dataSource.getConnection()) {
            assertNotNull(conn, "Connection은 null이 아니어야 합니다");
        }
    }

    @Test
    @DisplayName("2. SELECT 1 쿼리 실행 테스트")
    void testSelectOne() {
        Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
        assertEquals(1, result, "SELECT 1 결과가 1이어야 합니다");
    }
}
