package cm.mz.easytasks.api.util;

import cm.mz.easytasks.api.dto.ApiResponse;
import cm.mz.easytasks.api.dto.Meta;
import cm.mz.easytasks.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Response {

    public static <T> ApiResponse<List<T>> buildResponse(Page<T> page) {
        ApiResponse<List<T>> apiResponse = new ApiResponse<>();
        Meta meta = new Meta();
        meta.setTotal(page.getTotalElements());
        meta.setPage(page.getNumber() + 1);
        meta.setPerPage(page.getSize());
        meta.setLastPage(page.getTotalPages());
        apiResponse.setMeta(meta);
        apiResponse.setData(page.getContent());
        return apiResponse;
    }

}
