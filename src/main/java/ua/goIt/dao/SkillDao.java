package ua.goIt.dao;

import ua.goIt.DbStatement;
import ua.goIt.model.Company;
import ua.goIt.model.Skill;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SkillDao extends AbstractDao<Skill>{
    @Override
    String getTableName() {
        return "skills";
    }

    @Override
    Skill mapToEntity(ResultSet rs) throws SQLException {
        Skill skill = new Skill();
        skill.setId(rs.getLong("id"));
        skill.setLanguage(rs.getString("language"));
        skill.setLevel(rs.getString("level"));
        return skill;
    }

    @Override
    public void create(Skill entity) {
        String query = "insert into skills(language, level) values (?, ?)";
        DbStatement.executeStatementUpdate(query, ps -> {
            ps.setString(1, entity.getLanguage());
            ps.setString(2, entity.getLevel());
        });
    }

    @Override
    public void update(Skill entity) {
        String query = "update skills set language = ?, level = ? where id = ?";
        DbStatement.executeStatementUpdate(query, ps -> {
            ps.setString(1, entity.getLanguage());
            ps.setString(2, entity.getLevel());
            ps.setLong(3,entity.getId());
        });
    }
}
