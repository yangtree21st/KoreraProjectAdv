/**package com.itlize.koreraprojectadv.Exception;

import com.itlize.koreraprojectadv.Utility.GenerateId;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class BasicRuntimeException extends RuntimeException  {

    @Getter
    private GenerateId moduleName;
    @Getter
    private String code;
    @Getter
    private Object[] args;

    public BasicRuntimeException(GenerateId moduleName, String code) {

        super(moduleName + "_" + code);
        this.moduleName = moduleName;
        this.code = code;
    }

    public BasicRuntimeException(GenerateId moduleName, String code, Object[] args) {

        super(moduleName + "_" + code + "_" + Arrays.toString(args));
        this.moduleName = moduleName;
        this.code = code;
        this.args = args;
    }
}
**/