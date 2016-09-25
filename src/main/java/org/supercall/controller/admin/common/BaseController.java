package org.supercall.controller.admin.common;

import com.google.common.base.Strings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.ui.Model;

import javax.persistence.criteria.Predicate;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by kira on 2016/9/25.
 */
public class BaseController {
    protected Sort buildSort(String sortType, String sortfields) {
        Sort sort;
        if (sortType.equals("desc")) {
            sort = new Sort(Sort.Direction.DESC, sortfields);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortfields);
        }
        return sort;
    }

    protected void initListData(Page result, Model model) {
        model.addAttribute("list", result.getContent());
        model.addAttribute("_totalPages", result.getTotalPages());
        model.addAttribute("_totalRecord", result.getTotalElements());
        model.addAttribute("_size", result.getSize());
        model.addAttribute("_number", result.getNumber());
    }

    protected Specification buildSpecification(HttpServletRequest request) {
        HashMap<String, String> map = getParameterMap(request);

        Specification specifications = (root, criteriaQuery, criteriaBuilder) -> {
            final Predicate[] predicate = {null};
            map.forEach((k, v) -> {
                try {
                    predicate[0] = criteriaBuilder.like(root.get(k).as(String.class), "%" + v + "%");
                } catch (Exception e) {

                }

            });

            return predicate[0];
        };
        return specifications;
    }

    private static HashMap<String, String> getParameterMap(
            HttpServletRequest request) {
        // 参数Map
        Map properties = request.getParameterMap();
        // 返回值Map
        Map returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            } else {
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        return (HashMap<String, String>) returnMap;
    }
}
