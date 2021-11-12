package ua.goIt.services;

import ua.goIt.dao.SkillDao;
import ua.goIt.model.Skill;

import static ua.goIt.services.Validate.*;
import static ua.goIt.services.ValidatePattern.*;

public class SkillsService implements Crud {
    private final Skill skill;
    private static SkillDao skillDao;

    public SkillsService() {
        skill = new Skill();
        skillDao = new SkillDao();
    }

    @Override
    public boolean isValid(String param) {
        if (!isValidByPattern(NAME_PATTERN,param)) {
            System.out.printf((NAME_ERROR) + "%n", param);
            return false;
        }
        return true;
    }

    @Override
    public void save(String arg) {
        if (isValid(arg)) {
            prepareInstance(arg);
            skill.setLevel("Junior");
            getDao().create(skill);
            skill.setLevel("Middle");
            getDao().create(skill);
            skill.setLevel("Senior");
            getDao().create(skill);
            System.out.println("Skills '" + skill.getLanguage() + "' was added.");
        }
    }

    @Override
    public void update(String arg) {
        if (!isValidByPattern(SKILLS_UPDATE_PATTERN, arg)) {
            System.out.println(TEMPLATE_ERROR);
            return;
        }
        if (!isValidByPattern(DIGITAL_PATTERN, arg.split(",")[1])) {
            System.out.printf((DIGITAL_ERROR) + "%n",arg);
            return;
        }
        String[] arrayParam = arg.split(",");
        prepareInstance(arg);
        getDao().getById(Long.parseLong(arrayParam[1])).ifPresentOrElse(lang -> {
            getDao().findByName(lang.getLanguage()).forEach(sk -> {
                skill.setId(sk.getId());
                getDao().update(skill);
            });
            System.out.println("Skills '" + skill.getLanguage() + "' was updated.");
        }, () -> System.out.println("Not Found '" + skill + "' by id = " + arrayParam[1]));

    }

    @Override
    public void delete(String arg) {
        if (!isValidByPattern(DIGITAL_PATTERN, arg)) {
            System.out.printf((DIGITAL_ERROR) + "%n",arg);
        } else {
            getDao().getById(Long.parseLong(arg)).ifPresentOrElse(sk -> {
                getDao().findByName(sk.getLanguage()).forEach(lang -> {
                    skill.setId(lang.getId());
                    getDao().delete(skill);
                });
                System.out.println("Skills  was deleted.");
            }, () -> System.out.println("Not Found skills by id = " + arg));
        }
    }


    @Override
    public void getAll() {
        getDao().getAll().forEach(System.out::println);
    }

    @Override
    public void findById(Long id) {
        getDao().getById(id).ifPresent(System.out::println);
    }

    public static SkillDao getDao() {
        if (skillDao == null) {
            skillDao = new SkillDao();
        }
        return skillDao;
    }

    private void prepareInstance(String data) {
        String[] fields = data.split(",");
        skill.setLanguage(fields[0]);
        if (fields.length == 2) {
            skill.setId(Long.parseLong(fields[1]));
        }
    }
}
