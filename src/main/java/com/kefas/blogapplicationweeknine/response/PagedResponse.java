package com.kefas.blogapplicationweeknine.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class PagedResponse<T> {

    private List<T> content;

    private int page;

    private int size;

    private long totalElement;

    private int totalPages;

    private boolean last;

    public List<T> getContent(){
        return content == null ? null : new ArrayList<>(content);
    }

    public final void setContent(List<T> content){
        if (content == null)
                this.content = null;
    }

    public boolean isLast(){
        return last;
    }
}
