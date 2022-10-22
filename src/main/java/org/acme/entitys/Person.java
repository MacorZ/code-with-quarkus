package org.acme.entitys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ToanNT
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private String name;
    private int age;
    private boolean sex;
}
