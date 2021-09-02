/**
 *
 */
package com.students.domain;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @author B.Pirasanth
 *
 */
public class Phone implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @NotNull
    @Min(value = 100, message = "{error.prefixOrArea}")
    @Max(value = 999, message = "{error.prefixOrArea}")
    private Integer area;
    @NotNull
    @Min(value = 100, message = "{error.prefixOrArea}")
    @Max(value = 999, message = "{error.prefixOrArea}")
    private Integer prefix;
    @NotNull
    @Min(value = 1000, message = "{error.number}")
    @Max(value = 9999, message = "{error.number}")
    private Integer number;


    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrefix() {
        return prefix;
    }

    public void setPrefix(Integer prefix) {
        this.prefix = prefix;
    }
}
