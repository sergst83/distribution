package ru.sergst;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Направление обучения или специальньность
 */
@Data
public class Specialty {

    /**
     * Название специальности
     */
     final String name;
    /**
     * Заявки на поступление
     */
    Collection<Claim> claims = new LinkedList<>();
}
