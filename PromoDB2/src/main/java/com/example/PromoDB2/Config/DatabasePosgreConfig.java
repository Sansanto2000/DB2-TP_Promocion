package sb;

import org.springframework.boot.autoconfigure.jdbc.TomcatDataSourceConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(name = "spring.ds_posgre")
public class DatabasePosgreConfig extends TomcatDataSourceConfiguration

        @Bean(name = "dsItems")
        public DataSource dataSource()
        return super.dataSource();


    @Bean(name = "jdbcItems")
    public JdbcTemplate jdbcTemplate(DataSource dsItems)
            return new JdbcTemplate(dsItems);