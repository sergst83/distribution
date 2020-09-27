package ru.sergst;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Заявление на поступление в ВУЗ
 */
@Data
public class Claim {
    /**
     * Студент, подавший заявку
     */
    final Student student;

    final int priority;
}
