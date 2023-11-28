package com.ficticiusclean.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PagebleUtil {

    public static List<?> pagebleList(List<?> pagebleList, int page, int pageSize) {
        if (page >= 0 && pageSize >= 0) {
            Pageable pageRequest = createPageRequestUsing(page, pageSize);
            int start = (int) pageRequest.getOffset();
            int end = Math.min((start + pageRequest.getPageSize()), pagebleList.size());
            return pagebleList.subList(start , end);
        }

        return pagebleList;
    }

    private static Pageable createPageRequestUsing(int page, int size) {
        return PageRequest.of(page, size);
    }
}
