package cn.org.faster.framework.web.model;

import lombok.Data;

import javax.validation.Valid;
import java.util.List;

/**
 * @author zhangbowen
 */
@Data
public class ListWrapper<T> {
    @Valid
    private List<T> list;
}
