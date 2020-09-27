package ru.sergst;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * ВУЗ
 */
@Data
public class EducationalInstitution {

    /**
     * Название ВУЗа
     */
    final String name;

    /**
     * Список специфльностей
     */
    List<Specialty> specialties = new LinkedList<>();
}
