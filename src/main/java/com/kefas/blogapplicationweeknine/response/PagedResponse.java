package com.kefas.blogapplicationweeknine.response;

import com.kefas.blogapplicationweeknine.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PagedResponse<T> {

    private List<T> content;
    private Long pageNumber;
    private Long pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;

    public List<T> getContent() {
        return content == null ? null : new ArrayList<>(content);
    }

    public final void setContent(List<T> content) {
        if (content == null) {
            this.content = null;
        } else {
            this.content = Collections.unmodifiableList(content);
        }
    }

    public boolean isLast() {
        return last;
    }
}
