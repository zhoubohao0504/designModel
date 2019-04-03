package com.zbh.Template.jdbc.dao;

import com.zbh.Template.jdbc.JdbcTemplate;
import com.zbh.Template.jdbc.RowMapper;
import com.zbh.Template.jdbc.entity.Member;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

public class MemberDao extends JdbcTemplate {

    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> selectAll(){
        String sql = "select * FROM t_member";
        return super.executeQuery(sql, new RowMapper<Member>() {
            public Member mapRow(ResultSet rs, int rowNum) throws Exception {
                Member member = new Member();
                member.setUserName(rs.getString("username"));
                member.setPassword(rs.getString("password"));
                member.setAddr(rs.getString("addrss"));
                member.setAge(rs.getInt("age"));
                return member;
            }
        },null);
    }
}
